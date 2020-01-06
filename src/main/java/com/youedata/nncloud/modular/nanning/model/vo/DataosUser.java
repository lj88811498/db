package com.youedata.nncloud.modular.nanning.model.vo;

import com.youedata.nncloud.core.util.BeanUtil;
import com.youedata.nncloud.core.util.HttpClientUtil;
import net.sf.json.JSONObject;

/**
 * @Author: Monkey
 * @Date: Created in 13:54  2018/11/9.
 * @Description:
 */
public class DataosUser {
    /**
     * 账户id
     */
    private String accountId;
    /**
     * 帐号
     */
    private String accountName;

    /**
     * 加密后密码
     */
    private String accountPasswd;

    /**
     * 手机号
     */
    private String telephone;
    /**
     * 邮箱
      */
    private String email;
    /**
     * 扩展属性
     */
    private JSONObject extendedProperties;
    /**
     * 工程id
     */
    private String createTime;
    /**
     * 创建时间
     */
    private String projectId;
    /**
     * 租户id
     */
    private String tenantId;
    /**
     * token
     */
    private String accessToken;
    /**
     * 租户名
     */
    private String tenantName;
    /**
     * 修改时间
     */
    private String updateTime;

    private boolean bAdmin;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public JSONObject getExtendedProperties() {
        return extendedProperties;
    }

    public void setExtendedProperties(JSONObject extendedProperties) {
        this.extendedProperties = extendedProperties;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public boolean isbAdmin() {
        return bAdmin;
    }

    public void setbAdmin(boolean bAdmin) {
        this.bAdmin = bAdmin;
    }

    public String getAccountPasswd() {
        return accountPasswd;
    }

    public void setAccountPasswd(String accountPasswd) {
        this.accountPasswd = accountPasswd;
    }

    /**
     * 通过解析dataos平台返回参数
     * 得到DataosUser实例
     * @param json
     * @return
     */
    public static DataosUser getDataosUser(JSONObject json) {
        Object obj = json.get(HttpClientUtil.RESULT);
        if (obj instanceof net.sf.json.JSONObject) {
            JSONObject j1 = (net.sf.json.JSONObject) obj;
            Object obj2 = j1.get(HttpClientUtil.DATAS);
            if (obj2  instanceof net.sf.json.JSONObject) {
                JSONObject j2 = (net.sf.json.JSONObject) obj2;
                DataosUser user = new DataosUser();
                return (DataosUser) BeanUtil.copyProperties(j2, user);
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "DataosUser{" +
                "accountId='" + accountId + '\'' +
                ", accountName='" + accountName + '\'' +
                ", accountPasswd='" + accountPasswd + '\'' +
                ", accessToken='" + accessToken + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", extendedProperties=" + extendedProperties +
                ", createTime='" + createTime + '\'' +
                ", projectId='" + projectId + '\'' +
                ", tenantId='" + tenantId + '\'' +
                ", tenantName='" + tenantName + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", bAdmin='" + bAdmin + '\'' +
                '}';
    }
}
