package com.youedata.nncloud.modular.nanning.model.vo;

import java.util.Objects;

public class IntellectualPropertyVo {
    private String name;
    private String image;
    private String audit_comment;
    private String id;
    private String patent_no;
    private String audit_status;
    private String IPC;
    private String content;
    private String status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAudit_comment() {
        return audit_comment;
    }

    public void setAudit_comment(String audit_comment) {
        this.audit_comment = audit_comment;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPatent_no() {
        return patent_no;
    }

    public void setPatent_no(String patent_no) {
        this.patent_no = patent_no;
    }

    public String getAudit_status() {
        return audit_status;
    }

    public void setAudit_status(String audit_status) {
        this.audit_status = audit_status;
    }

    public String getIPC() {
        return IPC;
    }

    public void setIPC(String IPC) {
        this.IPC = IPC;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "IntellectualPropertyVo{" +
                "name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", audit_comment='" + audit_comment + '\'' +
                ", id='" + id + '\'' +
                ", patent_no='" + patent_no + '\'' +
                ", audit_status='" + audit_status + '\'' +
                ", IPC='" + IPC + '\'' +
                ", content='" + content + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IntellectualPropertyVo)) return false;
        IntellectualPropertyVo that = (IntellectualPropertyVo) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(image, that.image) &&
                Objects.equals(audit_comment, that.audit_comment) &&
                Objects.equals(id, that.id) &&
                Objects.equals(patent_no, that.patent_no) &&
                Objects.equals(audit_status, that.audit_status) &&
                Objects.equals(IPC, that.IPC) &&
                Objects.equals(content, that.content) &&
                Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, image, audit_comment, id, patent_no, audit_status, IPC, content, status);
    }
}
