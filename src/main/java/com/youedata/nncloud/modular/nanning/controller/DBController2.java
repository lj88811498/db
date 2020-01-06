package com.youedata.nncloud.modular.nanning.controller;

import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;
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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: Monkey
 * @Date: Created in 16:32  2019/12/3.
 * @Description:
 */
@Api(value = "DB Operation For Administrator", description = "DB Operation, 禁止乱用此操作")
@RequestMapping("/db2")
@Controller
//关闭事务
@Transactional(rollbackFor = java.lang.Exception.class)
public class DBController2 extends BaseController {

    @Autowired
    private FlagMapper flagMapper;

    private String url = "jdbc:mysql://172.16.0.181:3306/information_schema";
    private String user = "eWFuZ21hbw==";
    private String password = "eWFuZ21hb0BBYmMxMjM0NTY=";


    private String mysql_script = "mysqldump -h172.16.24.176 -uroot -pAdmin_2018 --databases daas authcenter commucation  dataos dataos_app dataos_log dataos_msg dataos_operation driver metadata > /opt/mysql/dataos`date +-%Y-%m-%d%H%M%S`.sql; SqlFileNumber=`ls /opt/mysql/*.sql|wc -l`; while (( $SqlFileNumber > 70 )); do OldFile=`ls -rt /opt/mysql/*.sql|head -1`; rm -f $OldFile; SqlFileNumber=`ls /opt/mysql/*.sql|wc -l`; done ";

    //181
    private DBUtil db_181 = DBUtil.getInstance();

    //176
    private DBUtil2 db2_176 = DBUtil2.getInstance();

    @ResponseBody
    @ApiOperation(value = "租户数据迁移脚本生成器", notes = "租户数据迁移脚本生成器")
    @PostMapping("/execute")
    public Object test(@ApiParam(value = "租户id ", name = "tenant_id", required = true)
                       @RequestParam(value = "tenant_id", defaultValue = "") String tenant_id ,
                       @ApiParam(value = "服务器地址,默认是172.16.240.17:9005 ", name = "serverPath")
                       @RequestParam(value = "serverPath", defaultValue = "") String serverPath, HttpServletRequest request) throws Exception {

        String sql = "select table_schema,table_name,column_name,COLUMN_COMMENT from information_schema.columns " +
                "where (column_name regexp 'tenant_id'or column_name regexp 'tenantid' or column_name regexp 'tenlentId') and (table_schema not regexp 'datapaas')" +
                "  and instr(table_schema,'2')";

        JSONObject js = JsonUtil.createOkJson();
        RecordLogUtil.info("=======================开始清空脏数据=============================");
        //清空数据
        clearData();
        RecordLogUtil.info("=======================开始查询数据=============================");
        try {
            PreparedStatement pstatement = db_181.getPrepareStatement(sql);
            ResultSet rs = db_181.executeQuery(pstatement);
            List<TabInfo> tabs =  new ArrayList<>();
            while (rs.next()) {
                TabInfo tab = new TabInfo();
                tab.setTableSchema(rs.getString("table_schema"));
                tab.setTableName(rs.getString("table_name"));
                tab.setColumnName(rs.getString("column_name"));
                tabs.add(tab);
            }
            db_181.closeConn();

            RecordLogUtil.info("=======================开始插入数据=============================");
            //循环插入
            for (TabInfo t : tabs) {
                String dbName = t.getTableSchema();
                String tabName = t.getTableName();
                String columnName = t.getColumnName();

                String createSql = "create table " + dbName.replace("2", "") +
                        "." + tabName + " like " +    dbName + "." + tabName;
                PreparedStatement ps_ = db_181.getPrepareStatement(createSql);
                db_181.executeUpdate(ps_);
                db_181.closeConn();

                String addData = "insert into " + dbName.replace("2", "") +
                        "." + tabName + " select * from " +  dbName + "." + tabName
                        + " where " + columnName + "='" + tenant_id + "'";
                RecordLogUtil.info(addData);
                PreparedStatement ps2 = db_181.getPrepareStatement(addData);
                db_181.executeUpdate(ps2);
                db_181.closeConn();
            }

            RecordLogUtil.info("===============================添加默认的数据===================================");

            //服务器信息，根据生成的服务器环境来进行修改
            String service = "172.16.240.17:9005";
            String owner = "17";
            if (StringUtils.isNotBlank(serverPath) && serverPath.contains(":")) {
                service = serverPath;
                String ip = serverPath.split(":")[0];
                owner = ip.substring(ip.lastIndexOf(".") + 1, ip.length());
            }


            //特定加入默认体系

            String intiSql1[] = new String[] {
                    //方便每次生成的脚本都自动激活系统，小灰说的
                    "update authcenter.tb_global_config set code = 123, name=321 where id = 1",
                    "INSERT INTO `authcenter`.`tb_account_system` (`id`, `system_name`, `driver_id`, `sync_conf`, `sync_time`, `create_by`, `create_time`, `update_by`, `update_time`, `tenant_id`, `sync_status`, `delTag`, `instanceId`) VALUES ('1', '默认账户体系', NULL, NULL, NULL, 'wly', '2019-10-23 14:39:10', NULL, NULL, '0', '2', '0', NULL)",
                    "INSERT INTO `dataos_app`.`dataos_application_info` (`id`, `insertType`, `appName`, `addDemoEnv`, `appId`, `appDemoUser`, `appDemoPwd`, `appDesc`, `explanFile`, `appIcon`, `linkAddress`, `accessType`, `appStatus`, `createBy`, `createTime`, `updateBy`, `updateTime`, `tenantId`, `fileName`, `appVersion`, `appDefault`, `appOrder`, `isOpenEnter`, `paasAppId`, `paasAppStatus`, `shelvesTime`, `openWith`, `sourceAppName`, `sourceAppId`, `systemAccountId`, `createByName`, `updateByName`, `putawayTime`, `appUseStatus`, `appStopUseTime`, `flag`) VALUES ('11d914e15aab11e98185fab59b5f6811', NULL, '域管理', NULL, '000001b023124106b2ffbfc5eac00001', NULL, NULL, '域管理', NULL, 'images/domainManagerMenu.png', 'http://"+service+ "/regionManager/', NULL, '1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '1', '4', '0', NULL, '0', NULL, '0', NULL, NULL, NULL, NULL, '', NULL, '1', NULL, '1')",
                    "INSERT INTO `dataos_app`.`dataos_application_info` (`id`, `insertType`, `appName`, `addDemoEnv`, `appId`, `appDemoUser`, `appDemoPwd`, `appDesc`, `explanFile`, `appIcon`, `linkAddress`, `accessType`, `appStatus`, `createBy`, `createTime`, `updateBy`, `updateTime`, `tenantId`, `fileName`, `appVersion`, `appDefault`, `appOrder`, `isOpenEnter`, `paasAppId`, `paasAppStatus`, `shelvesTime`, `openWith`, `sourceAppName`, `sourceAppId`, `systemAccountId`, `createByName`, `updateByName`, `putawayTime`, `appUseStatus`, `appStopUseTime`, `flag`) VALUES ('294245030dbc43e2a2935e4bfe4d0d6b', NULL, '开发者平台', NULL, 'datapaas', NULL, NULL, '提供开放API的平台', NULL, 'images/1553243632647DC1WXQ29.png', 'http://"+service+ "/#/front', NULL, '2', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '1', '1', '0', NULL, '0', NULL, '0', NULL, NULL, NULL, NULL, NULL, NULL, '1', NULL, '1')" ,
                    "INSERT INTO `dataos_app`.`dataos_application_info` (`id`, `insertType`, `appName`, `addDemoEnv`, `appId`, `appDemoUser`, `appDemoPwd`, `appDesc`, `explanFile`, `appIcon`, `linkAddress`, `accessType`, `appStatus`, `createBy`, `createTime`, `updateBy`, `updateTime`, `tenantId`, `fileName`, `appVersion`, `appDefault`, `appOrder`, `isOpenEnter`, `paasAppId`, `paasAppStatus`, `shelvesTime`, `openWith`, `sourceAppName`, `sourceAppId`, `systemAccountId`, `createByName`, `updateByName`, `putawayTime`, `appUseStatus`, `appStopUseTime`, `flag`) VALUES ('37d914d15aab11e98185fab59b5f6811', NULL, '应用市场', NULL, '999992b023124106b2ffbfc5eac99999', NULL, NULL, '应用市场', NULL, 'images/appMarket.png', 'http://"+service+ "/appMarket/', NULL, '1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '1', '4', '0', NULL, '0', NULL, '0', NULL, NULL, NULL, NULL, NULL, NULL, '1', NULL, '1')" ,
                    "INSERT INTO `dataos_app`.`dataos_application_info` (`id`, `insertType`, `appName`, `addDemoEnv`, `appId`, `appDemoUser`, `appDemoPwd`, `appDesc`, `explanFile`, `appIcon`, `linkAddress`, `accessType`, `appStatus`, `createBy`, `createTime`, `updateBy`, `updateTime`, `tenantId`, `fileName`, `appVersion`, `appDefault`, `appOrder`, `isOpenEnter`, `paasAppId`, `paasAppStatus`, `shelvesTime`, `openWith`, `sourceAppName`, `sourceAppId`, `systemAccountId`, `createByName`, `updateByName`, `putawayTime`, `appUseStatus`, `appStopUseTime`, `flag`) VALUES ('37d914de5aab11e98185fab59b5f6800', NULL, '应用管理', NULL, '666662b023124106b2ffbfc5eac66666', NULL, NULL, '用于实现对应用的管理，主要功能有创建应用，编辑应用，下架应用等', NULL, 'images/yygl001.png', 'http://"+service+ "/appManager/', NULL, '1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '1', '4', '0', NULL, '0', NULL, '0', NULL, NULL, NULL, NULL, NULL, NULL, '1', NULL, '1')" ,
                    "INSERT INTO `dataos_app`.`dataos_application_info` (`id`, `insertType`, `appName`, `addDemoEnv`, `appId`, `appDemoUser`, `appDemoPwd`, `appDesc`, `explanFile`, `appIcon`, `linkAddress`, `accessType`, `appStatus`, `createBy`, `createTime`, `updateBy`, `updateTime`, `tenantId`, `fileName`, `appVersion`, `appDefault`, `appOrder`, `isOpenEnter`, `paasAppId`, `paasAppStatus`, `shelvesTime`, `openWith`, `sourceAppName`, `sourceAppId`, `systemAccountId`, `createByName`, `updateByName`, `putawayTime`, `appUseStatus`, `appStopUseTime`, `flag`) VALUES ('545671d65b3611e98185fab59b5f6800', NULL, '安全中心', NULL, '64809cb55b3611e98185fab59b5f6800', NULL, NULL, '安全中心', NULL, 'images/aqzx003.png', NULL, NULL, '1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '1', '6', '0', NULL, '0', NULL, '0', NULL, NULL, NULL, NULL, NULL, NULL, '1', NULL, '1')" ,
                    "INSERT INTO `dataos_app`.`dataos_application_info` (`id`, `insertType`, `appName`, `addDemoEnv`, `appId`, `appDemoUser`, `appDemoPwd`, `appDesc`, `explanFile`, `appIcon`, `linkAddress`, `accessType`, `appStatus`, `createBy`, `createTime`, `updateBy`, `updateTime`, `tenantId`, `fileName`, `appVersion`, `appDefault`, `appOrder`, `isOpenEnter`, `paasAppId`, `paasAppStatus`, `shelvesTime`, `openWith`, `sourceAppName`, `sourceAppId`, `systemAccountId`, `createByName`, `updateByName`, `putawayTime`, `appUseStatus`, `appStopUseTime`, `flag`) VALUES ('d00053ab5aac11e98185fab59b5f6800', NULL, '认证中心', NULL, 'e293c4de5aac11e98185fab59b5f6800', NULL, NULL, '用于实现对用户，角色，组织的管理', NULL, 'images/zzzx002.png', NULL, NULL, '1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '1', '5', '0', NULL, '0', NULL, '0', NULL, NULL, NULL, NULL, NULL, NULL, '1', NULL, '1')" ,
                    "INSERT INTO `dataos_app`.`dataos_application_info` (`id`, `insertType`, `appName`, `addDemoEnv`, `appId`, `appDemoUser`, `appDemoPwd`, `appDesc`, `explanFile`, `appIcon`, `linkAddress`, `accessType`, `appStatus`, `createBy`, `createTime`, `updateBy`, `updateTime`, `tenantId`, `fileName`, `appVersion`, `appDefault`, `appOrder`, `isOpenEnter`, `paasAppId`, `paasAppStatus`, `shelvesTime`, `openWith`, `sourceAppName`, `sourceAppId`, `systemAccountId`, `createByName`, `updateByName`, `putawayTime`, `appUseStatus`, `appStopUseTime`, `flag`) VALUES ('d00053ab5aac11e98185fab59b5f6802', NULL, '系统设置', NULL, 'd00053ab5aac11e98185fab59b5f6802', NULL, NULL, '系统设置', NULL, 'images/xtsz004.png', NULL, NULL, '1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '1', '100', '0', '', '0', NULL, '0', NULL, NULL, NULL, NULL, NULL, NULL, '1', NULL, '1')" ,
                    "INSERT INTO `dataos_app`.`dataos_application_info` (`id`, `insertType`, `appName`, `addDemoEnv`, `appId`, `appDemoUser`, `appDemoPwd`, `appDesc`, `explanFile`, `appIcon`, `linkAddress`, `accessType`, `appStatus`, `createBy`, `createTime`, `updateBy`, `updateTime`, `tenantId`, `fileName`, `appVersion`, `appDefault`, `appOrder`, `isOpenEnter`, `paasAppId`, `paasAppStatus`, `shelvesTime`, `openWith`, `sourceAppName`, `sourceAppId`, `systemAccountId`, `createByName`, `updateByName`, `putawayTime`, `appUseStatus`, `appStopUseTime`, `flag`) VALUES ('xxxxx2b023124106b2ffbfc5eac33de8', NULL, '数据中心', NULL, '777772b023124106b2ffbfc5eac77777', NULL, NULL, '数据中心', NULL, 'images/datacenter.png', 'http://"+service+ "/daas', NULL, '1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '1', '3', '0', NULL, '0', NULL, '0', NULL, NULL, NULL, NULL, NULL, NULL, '1', NULL, '1')" ,
                    "INSERT INTO `dataos_app`.`dataos_application_info` (`id`, `insertType`, `appName`, `addDemoEnv`, `appId`, `appDemoUser`, `appDemoPwd`, `appDesc`, `explanFile`, `appIcon`, `linkAddress`, `accessType`, `appStatus`, `createBy`, `createTime`, `updateBy`, `updateTime`, `tenantId`, `fileName`, `appVersion`, `appDefault`, `appOrder`, `isOpenEnter`, `paasAppId`, `paasAppStatus`, `shelvesTime`, `openWith`, `sourceAppName`, `sourceAppId`, `systemAccountId`, `createByName`, `updateByName`, `putawayTime`, `appUseStatus`, `appStopUseTime`, `flag`) VALUES ('yyyyy2b023124106b2ffbfc5eac33de8', NULL, '服务中心', NULL, '888882b023124106b2ffbfc5eac88888', NULL, NULL, '服务中心', NULL, 'images/servicecenter.png', 'http://"+service+ "/daas?from=serviceCenter', NULL, '1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '1', '3', '0', NULL, '0', NULL, '0', NULL, NULL, NULL, NULL, NULL, NULL, '1', NULL, '1')" ,
                    "INSERT INTO `dataos_app`.`dataos_application_info` (`id`, `insertType`, `appName`, `addDemoEnv`, `appId`, `appDemoUser`, `appDemoPwd`, `appDesc`, `explanFile`, `appIcon`, `linkAddress`, `accessType`, `appStatus`, `createBy`, `createTime`, `updateBy`, `updateTime`, `tenantId`, `fileName`, `appVersion`, `appDefault`, `appOrder`, `isOpenEnter`, `paasAppId`, `paasAppStatus`, `shelvesTime`, `openWith`, `sourceAppName`, `sourceAppId`, `systemAccountId`, `createByName`, `updateByName`, `putawayTime`, `appUseStatus`, `appStopUseTime`, `flag`) VALUES ('zzzzz2b023124106b2ffbfc5eac33de8', NULL, '运维管理', NULL, '999992b023124106b2ffbfc5eac88888', NULL, NULL, '运维管理', NULL, 'images/operationManager.png', 'http://"+service+ "/operationManager', NULL, '1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '1', '3', '0', NULL, '0', NULL, '0', NULL, NULL, NULL, NULL, NULL, NULL, '1', NULL, '1')"

            };

            if (intiSql1.length > 0) {
                for (String s1 : intiSql1) {
                    RecordLogUtil.info("sql1=" + s1);
                    PreparedStatement ps0 = db_181.getPrepareStatement(s1);
                    db_181.executeUpdate(ps0);
                    db_181.closeConn();
                }

            }
            RecordLogUtil.info("===============================更新域信息============================================");
            String accountSql = "SELECT account_id,account_name FROM `authcenter`.`tb_user_account` where tenant_id = ? and parent_id = ''";
            PreparedStatement p0 = db_181.getPrepareStatement(accountSql);
            p0.setString(1, tenant_id);
            ResultSet rs0 = db_181.executeQuery(p0);
            String region = null;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-DD 24HH:mm:ss");
            String d1 = sdf.format(new Date());


            while (rs0.next()) {
                //修改配置中心域信息
                region = "{\n" +
                        "    \"regionInfoAccount\":\"" + rs0.getString("account_name") + "\",\n" +
                        "    \"regionInfoAddress\":\"" + service + "/DataOS/\",\n" +
                        "    \"regionInfoCreatedBy\":\"" + rs0.getString("account_name") + "\",\n" +
                        "    \"regionInfoCreatime\":\"" + d1 + "\",\n" +
                        "    \"regionInfoDescribe\":\"" + owner + "域信息\",\n" +
                        "    \"regionInfoName\":\"root\",\n" +
                        "    \"regionInfoRegionId\":\"" + rs0.getString("account_id") + "\",\n" +
                        "    \"regionInfoUpdatedBy\":\"\",\n" +
                        "    \"regionInfoUpdatedtime\":\"" + d1 + "\"\n" +
                        "}";
                break;
            }
            RecordLogUtil.info(region);
            db_181.closeConn();

            if (StringUtils.isNotBlank(region)) {
                String updateRegionSql = "update  dataos.dataos_properties set value= ? where `key` = 'region_info'" ;
                PreparedStatement ps3 = db_181.getPrepareStatement(updateRegionSql);
                ps3.setString(1, region);
                db_181.executeUpdate(ps3);
                db_181.closeConn();
            }




////////--------------------* *************************************升级脚本已经去掉字段************************************************/
            String[] scripts = new String[]{
                    "alter table authcenter.tb_role drop column tenant_id",
                    "alter table authcenter.tb_user_account drop column tenant_id",
                    "alter table dataos_app.dataos_label_manager drop column tenantId",
                    "alter table dataos_app.dataos_app_label_relation drop column tenlentId",
                    "alter table dataos_app.dataos_application_info drop column tenantId"
            };
            RecordLogUtil.info("=======================开始去租户字段，兼容1.4.2版本=============================");
            //去租户字段
            for (String str : scripts) {
                RecordLogUtil.info("sql=" + str);
                PreparedStatement ps3 = db_181.getPrepareStatement(str);
                db_181.executeUpdate(ps3);
                db_181.closeConn();
            }

            RecordLogUtil.info("=======================开始导出数据库脚本=========================================");
            //导出数据
            String mysql_script = "mysqldump -h172.16.0.181 -uyangmao -pyangmao@Abc123456 " +
                    "--databases daas authcenter commucation  dataos dataos_app dataos_log dataos_msg dataos_operation driver metadata " +
                    "> /opt/mysql2/"+tenant_id+"_dataos`date +-%Y-%m-%d%H%M%S`.sql; " +
                    "SqlFileNumber=`ls /opt/mysql2/*.sql|wc -l`; " +
                    "while (( $SqlFileNumber > 70 )); " +
                    "do OldFile=`ls -rt /opt/mysql/*.sql|head -1`; " +
                    "rm -f $OldFile; SqlFileNumber=`ls /opt/mysql/*.sql|wc -l`; done ";

            runSSH("172.16.0.181", "root", "1qaz@WSX2019", mysql_script);

            RecordLogUtil.info("=======================开始清空租户数据库=========================================");
            //清空数据
            clearData();
            RecordLogUtil.info("==================================结束=============================================");
        } catch (Exception e) {
            RecordLogUtil.error("数据迁移失败！tenant_id = " + tenant_id);
            return JsonUtil.createFailJson();
        }


        return js;
    }


    public int check(String ...param) {
        try {
            String sql = null;
            if (param.length == 0) {
                return 0;
            }
            if (param.length > 0) {
                sql = "select count(1) from information_schema.`COLUMNS` where TABLE_SCHEMA = '"+param[0]+"'";
            }
            if (param.length > 1) {
                sql += " and table_name='"+param[1]+"'";
            }


            PreparedStatement pstatement = db_181.getPrepareStatement(sql);
            ResultSet rs = db_181.executeQuery(pstatement);
            while (rs.next()) {
                int i = rs.getInt(1);
                db_181.closeConn();
                return i;
            }
        } catch (Exception e) {
            RecordLogUtil.error("统计错误："+ param);
        }
       return 0;
    }


    @ResponseBody
    @ApiOperation(value = "", notes = "")
    @PostMapping("/clearData")
    public void clearData() {
        RecordLogUtil.info("=======================开始清空数据=============================");
        String sql = "select table_schema,table_name,column_name,COLUMN_COMMENT from information_schema.columns \n" +
                "where (column_name regexp 'tenant_id' or column_name regexp 'tenantid'  or column_name regexp 'tenlentId')\n" +
                " and (table_schema not regexp 'datapaas') and instr(table_schema,'2')";

        try {
            PreparedStatement pstatement = db_181.getPrepareStatement(sql);
            ResultSet rs = db_181.executeQuery(pstatement);
            while (rs.next()) {
                String dbName = rs.getString("table_schema").replace("2", "");
                String tabName = rs.getString("table_name");
                String t_sql = "drop table if exists  " + dbName + "." + tabName;
                RecordLogUtil.info(t_sql);
                PreparedStatement ps2 = db_181.getPrepareStatement(t_sql);
                db_181.executeUpdate(ps2);
                db_181.closeConn();
            }
            db_181.closeConn();
            RecordLogUtil.info("=======================清空完毕！=============================");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * Run SSH command.
     * @param host
     * @param username
     * @param password
     * @param cmd
     * @return exit status
     * @throws IOException
     */
    public static int runSSH(String host, String username, String password,
                             String cmd) throws IOException {
        RecordLogUtil.info("running SSH cmd [" + cmd + "]");

        ch.ethz.ssh2.Connection conn = getOpenedConnection(host, username, password);
        Session sess = conn.openSession();
        sess.execCommand(cmd);

        InputStream stdout = new StreamGobbler(sess.getStdout());
        BufferedReader br = new BufferedReader(new InputStreamReader(stdout));

        while (true) {
            String line = br.readLine();
            if (line == null){
                break;
            }
            System.out.println(line);
        }

        sess.close();
        conn.close();
        return sess.getExitStatus().intValue();
    }

    /**
     * return a opened Connection
     * @param host
     * @param username
     * @param password
     * @return
     * @throws IOException
     */
    private static ch.ethz.ssh2.Connection getOpenedConnection(String host, String username,
                                                  String password) throws IOException {

        System.out.println("connecting to " + host + " with user " + username
                + " and pwd " + password);
        //添加SSH连接端口，默认22
        ch.ethz.ssh2.Connection conn = new ch.ethz.ssh2.Connection(host, 22);
        conn.connect(); // make sure the connection is opened
        boolean isAuthenticated = conn.authenticateWithPassword(username,
                password);
        if (isAuthenticated == false) {
            throw new IOException("Authentication failed.");
        }
        return conn;
    }


}
