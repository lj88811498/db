package com.youedata.nncloud.modular.nanning.model.vo;

import java.util.Objects;

public class CreationArticleVo {
    private String hits;
    private String image;
    private String category_name;
    private String id;
    private String title;
    private String content;

    @Override
    public String toString() {
        return "CreationArticleVo{" +
                "hits='" + hits + '\'' +
                ", image='" + image + '\'' +
                ", category_name='" + category_name + '\'' +
                ", id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CreationArticleVo)) return false;
        CreationArticleVo that = (CreationArticleVo) o;
        return Objects.equals(hits, that.hits) &&
                Objects.equals(image, that.image) &&
                Objects.equals(category_name, that.category_name) &&
                Objects.equals(id, that.id) &&
                Objects.equals(title, that.title) &&
                Objects.equals(content, that.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hits, image, category_name, id, title, content);
    }

    public String getHits() {
        return hits;
    }

    public void setHits(String hits) {
        this.hits = hits;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
