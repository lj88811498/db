package com.youedata.nncloud.modular.nanning.model;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;

/**
 * <p>
 * 营商web菜单表
 * </p>
 *
 * @author Monkey
 * @since 2018-11-19
 */
@ApiModel
public class WebMenu extends Model<WebMenu> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "web_menu_id", type = IdType.AUTO)
    private Integer webMenuId;
    /**
     * 菜单父id
     */
    private Integer webMenuPid;
    /**
     * 菜单名称
     */
    private String webMenuName;
    /**
     * 菜单图标
     */
    private String webMenuIcon;
    /**
     * url地址
     */
    private String webMenuUrl;
    /**
     * 菜单状态：1：启用  0不启用
     */
    private Integer webMenuStatus;
    /**
     * 菜单排序号
     */
    private Integer webMenuNum;
    /**
     * 备注
     */
    private String webMenuTips;
    /**
     * 树节点
     */
    private String webMenuCode;
    /**
     * 是否菜单：0否1是
     */
    private String webMenuIsmenu;

    /**
     * 子节点
     */
    private List<WebMenu> Children;


    public Integer getWebMenuId() {
        return webMenuId;
    }

    public void setWebMenuId(Integer webMenuId) {
        this.webMenuId = webMenuId;
    }

    public Integer getWebMenuPid() {
        return webMenuPid;
    }

    public void setWebMenuPid(Integer webMenuPid) {
        this.webMenuPid = webMenuPid;
    }

    public String getWebMenuName() {
        return webMenuName;
    }

    public void setWebMenuName(String webMenuName) {
        this.webMenuName = webMenuName;
    }

    public String getWebMenuIcon() {
        return webMenuIcon;
    }

    public void setWebMenuIcon(String webMenuIcon) {
        this.webMenuIcon = webMenuIcon;
    }

    public String getWebMenuUrl() {
        return webMenuUrl;
    }

    public void setWebMenuUrl(String webMenuUrl) {
        this.webMenuUrl = webMenuUrl;
    }

    public Integer getWebMenuStatus() {
        return webMenuStatus;
    }

    public void setWebMenuStatus(Integer webMenuStatus) {
        this.webMenuStatus = webMenuStatus;
    }

    public Integer getWebMenuNum() {
        return webMenuNum;
    }

    public void setWebMenuNum(Integer webMenuNum) {
        this.webMenuNum = webMenuNum;
    }

    public String getWebMenuTips() {
        return webMenuTips;
    }

    public void setWebMenuTips(String webMenuTips) {
        this.webMenuTips = webMenuTips;
    }

    public String getWebMenuCode() {
        return webMenuCode;
    }

    public void setWebMenuCode(String webMenuCode) {
        this.webMenuCode = webMenuCode;
    }

    public String getWebMenuIsmenu() {
        return webMenuIsmenu;
    }

    public void setWebMenuIsmenu(String webMenuIsmenu) {
        this.webMenuIsmenu = webMenuIsmenu;
    }

    public List<WebMenu> getChildren() {
        return Children;
    }

    public void setChildren(List<WebMenu> children) {
        Children = children;
    }

    @Override
    protected Serializable pkVal() {
        return this.webMenuId;
    }

    @Override
    public String toString() {
        return "WebMenu{" +
        "webMenuId=" + webMenuId +
        ", webMenuPid=" + webMenuPid +
        ", webMenuName=" + webMenuName +
        ", webMenuIcon=" + webMenuIcon +
        ", webMenuUrl=" + webMenuUrl +
        ", webMenuStatus=" + webMenuStatus +
        ", webMenuNum=" + webMenuNum +
        ", webMenuTips=" + webMenuTips +
        ", webMenuCode=" + webMenuCode +
        ", webMenuIsmenu=" + webMenuIsmenu +
        "}";
    }
}
