package com.youedata.nncloud.core.log.factory;

import com.youedata.nncloud.core.common.constant.state.LogSucceed;
import com.youedata.nncloud.core.common.constant.state.LogType;
import com.youedata.nncloud.core.util.RecordLogUtil;
import com.youedata.nncloud.core.util.SpringContextHolder;
import com.youedata.nncloud.modular.nanning.model.Message;
import com.youedata.nncloud.modular.nanning.service.IMessageService;
import com.youedata.nncloud.modular.system.dao.LoginLogMapper;
import com.youedata.nncloud.modular.system.dao.OperationLogMapper;
import com.youedata.nncloud.modular.system.model.LoginLog;
import com.youedata.nncloud.modular.system.model.OperationLog;
import com.youedata.nncloud.core.db.Db;
import com.youedata.nncloud.core.log.LogManager;
import com.youedata.nncloud.core.util.ToolUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.TimerTask;

/**
 * 日志操作任务创建工厂
 *
 * @author fengshuonan
 * @date 2016年12月6日 下午9:18:27
 */
public class LogTaskFactory {

    private static Logger logger = LoggerFactory.getLogger(LogManager.class);
    private static LoginLogMapper loginLogMapper = Db.getMapper(LoginLogMapper.class);
    private static OperationLogMapper operationLogMapper = Db.getMapper(OperationLogMapper.class);

    public static TimerTask loginLog(final Integer userId, final String ip) {
        return new TimerTask() {
            @Override
            public void run() {
                try {
                    LoginLog loginLog = LogFactory.createLoginLog(LogType.LOGIN, userId, null, ip);
                    loginLogMapper.insert(loginLog);
                } catch (Exception e) {
                    logger.error("创建登录日志异常!", e);
                }
            }
        };
    }

    public static TimerTask loginLog(final String username, final String msg, final String ip) {
        return new TimerTask() {
            @Override
            public void run() {
                LoginLog loginLog = LogFactory.createLoginLog(
                        LogType.LOGIN_FAIL, null, "账号:" + username + "," + msg, ip);
                try {
                    loginLogMapper.insert(loginLog);
                } catch (Exception e) {
                    logger.error("创建登录失败异常!", e);
                }
            }
        };
    }

    public static TimerTask exitLog(final Integer userId, final String ip) {
        return new TimerTask() {
            @Override
            public void run() {
                LoginLog loginLog = LogFactory.createLoginLog(LogType.EXIT, userId, null,ip);
                try {
                    loginLogMapper.insert(loginLog);
                } catch (Exception e) {
                    logger.error("创建退出日志异常!", e);
                }
            }
        };
    }

    public static TimerTask bussinessLog(final Integer userId, final String bussinessName, final String clazzName, final String methodName,final String ip, final String msg) {
        return new TimerTask() {
            @Override
            public void run() {
                OperationLog operationLog = LogFactory.createOperationLog(
                        LogType.BUSSINESS, userId, bussinessName, clazzName, methodName,ip, msg, LogSucceed.SUCCESS);
                try {
                    operationLogMapper.insert(operationLog);
                } catch (Exception e) {
                    logger.error("创建业务日志异常!", e);
                }
            }
        };
    }

    public static TimerTask exceptionLog(final Integer userId, final Exception exception) {
        return new TimerTask() {
            @Override
            public void run() {
                String msg = ToolUtil.getExceptionMsg(exception);
                OperationLog operationLog = LogFactory.createOperationLog(
                        LogType.EXCEPTION, userId, "", null, null,null, msg, LogSucceed.FAIL);
                try {
//                    operationLogMapper.insert(operationLog);
                } catch (Exception e) {
                    logger.error("创建异常日志异常!", e);
                }
            }
        };
    }

    /**
     * 批量插入消息线程
     * @author Monkey
     * @param messages
     * @return
     */
    public static TimerTask batchInsertMessage(final List<Message> messages) {
        return new TimerTask() {
            @Override
            public void run() {
                RecordLogUtil.info("启动消息推送...start");
                if (!ObjectUtils.isEmpty(messages)) {
                    IMessageService messageService = SpringContextHolder.getBean(IMessageService.class);
                    messageService.insertBatch(messages);
                }
                RecordLogUtil.info("消息推送结束...end");
            }
        };
    }

}
