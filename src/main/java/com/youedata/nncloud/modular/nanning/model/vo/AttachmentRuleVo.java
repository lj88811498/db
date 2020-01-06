package com.youedata.nncloud.modular.nanning.model.vo;

import java.util.Objects;

public class AttachmentRuleVo {
    private String fileName;

    private String url;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AttachmentRuleVo)) return false;
        AttachmentRuleVo that = (AttachmentRuleVo) o;
        return Objects.equals(fileName, that.fileName) &&
                Objects.equals(url, that.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fileName, url);
    }

    @Override
    public String toString() {
        return "AttachmentRuleVo{" +
                "fileName='" + fileName + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
