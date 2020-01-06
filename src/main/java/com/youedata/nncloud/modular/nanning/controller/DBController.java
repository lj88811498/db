package com.youedata.nncloud.modular.nanning.controller;

import com.alibaba.fastjson.JSONObject;
import com.youedata.nncloud.core.base.controller.BaseController;
import com.youedata.nncloud.core.common.Base64;
import com.youedata.nncloud.core.util.JsonUtil;
import com.youedata.nncloud.core.util.RecordLogUtil;
import com.youedata.nncloud.modular.nanning.dao.FlagMapper;
import com.youedata.nncloud.modular.nanning.model.Flag;
import com.youedata.nncloud.modular.nanning.model.Log;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;


/**
 * @Author: Monkey
 * @Date: Created in 16:32  2019/12/3.
 * @Description:
 */
@Api(value = "DB Operation For Administrator", description = "DB Operation, 禁止乱用此操作")
@RequestMapping("/db")
@Controller
//关闭事务
//@Transactional(rollbackFor = java.lang.Exception.class)
public class DBController  extends BaseController {

    @Autowired
    private FlagMapper flagMapper;

    private String url = "jdbc:mysql://172.16.24.194:3306/";
    private String user = "eWFuZ21hbw==";
    private String password = "eWFuZ21hb0BBYmMxMjM0NTY=";

    @ResponseBody
    @ApiOperation(value = "注意使用多个脚本的时候，若有脚本执行失败，则前面的脚本不会回滚，请合理使用",
                  notes = "注意使用多个脚本的时候，若有脚本执行失败，则前面的脚本不会回滚，请合理使用<br/>" +
                          "脚本1-3一共可以执行3个脚本，使用一个验证码<br/>" +
                          "每一个脚本栏只能执行一个脚本。<br/>" +
                          "注意：最最最重要的是，这里DDL不支持事务回滚哦<br/>")
    @PostMapping("/execute")
    public Object test(@ApiParam(value = "数据库名字", name = "dbName", required = true)
                       @RequestParam(value = "dbName") String dbName,
                       @ApiParam(value = "脚本1 ", name = "sql1")
                       @RequestParam(value = "sql1", defaultValue = "") String sql1,
                       @ApiParam(value = "脚本2 ", name = "sql2")
                       @RequestParam(value = "sql2", defaultValue = "") String sql2,
                       @ApiParam(value = "脚本3 ", name = "sql3")
                       @RequestParam(value = "sql3", defaultValue = "") String sql3,
                       @ApiParam(value = "管理员提供的验证码", name = "code", required = true)
                       @RequestParam(value = "code") String code,
                       HttpServletRequest request) throws Exception {
        JSONObject js = null;
        if (StringUtils.isBlank(code) || !checkpwd(code)) {
            return JsonUtil.createFailJson("验证码错误，执行失败！");
        } else {
            js = JsonUtil.createOkJson();
            js.put("code", "验证码已刷新，下一次请联系管理员获取...");
        }
        if (StringUtils.isBlank((sql1+sql2+sql3).trim())) {
            return JsonUtil.createFailJson("至少需要一条执行脚本！");
        }
        String ip = request.getRemoteHost();
        js.put("操作ip", ip);

        PreparedStatement ps = null;
        Statement stmt = null;
        Connection conn = null;
        try {
            String user1 = new String(Base64.decode(user),"utf-8");
            String password1 = new String(Base64.decode(password),"utf-8");
            // 1.驱动注册程序
            Class.forName("com.mysql.jdbc.Driver");
            // 2.获取连接对象
            conn = DriverManager.getConnection(url + dbName.trim()
                    + "?useSSL=false&useUnicode=true&characterEncoding=utf-8", user1, password1);
        } catch (Exception e) {
            //关闭事务
            //conn.rollback();
            String msg = "操作失败！ip=" + ip + ",执行sql=" + sql1 + ",执行sql2=" + sql2+ ",执行sql3=" + sql3;
            Log log = new Log("1", ip + "数据库连接异常，dbName=" + dbName, sql1, sql2, sql3);
            log.insert();
            conn.close();
            RecordLogUtil.error(msg, e);
            js = JsonUtil.createFailJson("操作失败，数据库连接异常，请检查数据库名字是否正确或上报管理员...");
            return js;
        }
        try {
            // 3.创建Statement
            //关闭事务
            //conn.setAutoCommit(false);
            //stmt = conn.createStatement();

            sql1 = replaceSql(sql1);
            if (StringUtils.isNotBlank(sql1)) {
                ps = conn.prepareStatement(sql1);
                ps.executeUpdate();
            }

        } catch (Exception e) {
            //关闭事务
            //conn.rollback();
            String msg = "操作失败！ip=" + ip + ",执行sql=" + sql1 + ",执行sql2=" + sql2+ ",执行sql3=" + sql3;
            Log log = new Log("1", ip + "操作失败，请检查脚本sql1，或上报管理员...", sql1, sql2, sql3);
            log.insert();
            conn.close();
            RecordLogUtil.error(msg, e);
            js = JsonUtil.createFailJson("操作失败，请检查脚本sql1，或上报管理员...");
            return js;
        }
        try {
            sql2 = replaceSql(sql2);
            if (StringUtils.isNotBlank(sql2)) {
                ps = conn.prepareStatement(sql2);
                ps.executeUpdate();
            }
        } catch (Exception e) {
            //关闭事务
            //conn.rollback();
            String msg = "操作失败！ip=" + ip + ",执行sql=" + sql1 + ",执行sql2=" + sql2+ ",执行sql3=" + sql3;
            Log log = new Log("1", ip + "操作失败，请检查脚本sql2，或上报管理员...注意sql1已经执行成功，切勿重复操作！！！", sql1, sql2, sql3);
            log.insert();
            conn.close();
            RecordLogUtil.error(msg  , e);
            js = JsonUtil.createFailJson("操作失败，请检查脚本sql2，或上报管理员...注意sql1已经执行成功，切勿重复操作！！！");
            return js;
        }
        try{
            sql3 = replaceSql(sql3);
            if (StringUtils.isNotBlank(sql3)) {
                ps = conn.prepareStatement(sql3);
                ps.executeUpdate();
            }
            //关闭事务
            //conn.commit();
            //刷新验证码
            int count = flagMapper.updateAll();
            if (count < 1) {
                RecordLogUtil.error("验证码刷新失败!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" );
            }
            js.put("msg", "操作成功!请前往数据库查看...");
        } catch (Exception e) {
            //关闭事务
            //conn.rollback();
            String msg = "操作失败！ip=" + ip + ",执行sql=" + sql1 + ",执行sql2=" + sql2+ ",执行sql3=" + sql3;
            Log log = new Log("1", ip + "操作失败，请检查脚本sql3，或上报管理员...注意sql1,sql2已经执行成功，切勿重复操作！！！", sql1, sql2, sql3);
            log.insert();
            conn.close();
            RecordLogUtil.error(msg , e);
            js = JsonUtil.createFailJson("操作失败，请检查脚本sql3，或上报管理员...注意sql1,sql2已经执行成功，切勿重复操作！！！");
            return js;
        }
        String msg = "ip=" + ip + ",执行sql1=" + sql1+ ",执行sql2=" + sql2+ ",执行sql3=" + sql3;
        RecordLogUtil.info(msg);
        Log log = new Log("0", ip, sql1, sql2, sql3);
        log.insert();
        conn.close();
        return js;
    }

    private String replaceSql(String sql1) {
        if (StringUtils.isNotBlank(sql1)) {
            sql1 = sql1.replaceAll("& #41;", ")");
            sql1 = sql1.replaceAll("& #40;", "(");
            sql1 = sql1.replaceAll("& #39;", "'");
            if (sql1.endsWith(";")) {
                sql1 = sql1.substring(0, sql1.length() - 1);
            }
        }
        return sql1;
    }


    public boolean checkpwd(String code){
        List<Flag> flags = flagMapper.selectAll();
        if (flags.size() > 0) {
            Flag flag = flags.get(0);
            return code.equals(flag.getFlagPwd());
        }
        return false;
    }


    @ResponseBody
    @GetMapping("/admin/getCode")
    public Object getCode() throws Exception {
        try {
            List<Flag> flags = flagMapper.selectAll();
            if (flags.size() > 0) {
                Flag flag = flags.get(0);
                return flag.getFlagPwd();
            }
        } catch (Exception e) {
            return JsonUtil.createFailJson("获取管理员验证码异常！");
        }
        return "获取异常！";

    }


}
