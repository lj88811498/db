package com.youedata.nncloud.modular.nanning.model.vo;

import java.util.Objects;

public class TrainInfoVo {
    private String end_date;
    private String module;
    private String name;
    private String id;
    private String credit;
    private String content;
    private String start_date;

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TrainInfoVo)) return false;
        TrainInfoVo that = (TrainInfoVo) o;
        return Objects.equals(end_date, that.end_date) &&
                Objects.equals(module, that.module) &&
                Objects.equals(name, that.name) &&
                Objects.equals(id, that.id) &&
                Objects.equals(credit, that.credit) &&
                Objects.equals(content, that.content) &&
                Objects.equals(start_date, that.start_date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(end_date, module, name, id, credit, content, start_date);
    }

    @Override
    public String toString() {
        return "TrainInfoVo{" +
                "end_date='" + end_date + '\'' +
                ", module='" + module + '\'' +
                ", name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", credit='" + credit + '\'' +
                ", content='" + content + '\'' +
                ", start_date='" + start_date + '\'' +
                '}';
    }
}
