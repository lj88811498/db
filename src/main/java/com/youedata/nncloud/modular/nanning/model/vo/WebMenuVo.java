package com.youedata.nncloud.modular.nanning.model.vo;

import java.util.List;

public class WebMenuVo {
    /**
     * 节点id
     */
    private int id;
    /**
     * 父节点id
     */
    private int pId;
    /**
     * 节点名称
     */
    private String title;
    /**
     * url
     */
    private String url;
    /**
     * 图标
     */
    private String icon;
    /**
     * 是否展开
     */
    private Boolean expand;
    /**
     * 是否被选中
     */
    private Boolean checked;

    private List<WebMenuVo> children;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getExpand() {
        return expand;
    }

    public void setExpand(Boolean expand) {
        this.expand = expand;
    }

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    public List<WebMenuVo> getChildren() {
        return children;
    }

    public void setChildren(List<WebMenuVo> children) {
        this.children = children;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
