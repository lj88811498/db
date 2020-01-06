package com.youedata.nncloud.modular.nanning.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.youedata.nncloud.modular.nanning.anno.Too;
import io.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 创新创业-技术前沿、产品推荐、项目申报
 * </p>
 *
 * @author Monkey
 * @since 2019-01-18
 */
@ApiModel
public class CreationArticle extends Model<CreationArticle> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @Too(value="id")
    private String creationArticleId;
    /**
     * 点击数
     */
    @Too(value="hits")
    private String creationArticleHits;
    /**
     * 图片
     */
    @Too(value="image")
    private String creationArticleImage;
    /**
     * 栏目名称
     */
    @Too(value="category_name")
    private String creationArticleCategoryname;
    /**
     * 标题
     */
    @Too(value="title")
    private String creationArticleTitle;
    /**
     * 内容
     */
    @Too(value="content")
    private String creationArticleContent;
    /**
     * 创建人
     */
    private Integer creationArticleCreateBy;
    /**
     * 修改人
     */
    private Integer creationArticleUpdateBy;
    /**
     * 修改时间
     */
    private Date creationArticleUpdateTime;
    /**
     * 创建时间
     */
    private Date creationArticleCreateTime;


    public String getCreationArticleId() {
        return creationArticleId;
    }

    public void setCreationArticleId(String creationArticleId) {
        this.creationArticleId = creationArticleId;
    }

    public String getCreationArticleHits() {
        return creationArticleHits;
    }

    public void setCreationArticleHits(String creationArticleHits) {
        this.creationArticleHits = creationArticleHits;
    }

    public String getCreationArticleImage() {
        return creationArticleImage;
    }

    public void setCreationArticleImage(String creationArticleImage) {
        this.creationArticleImage = creationArticleImage;
    }

    public String getCreationArticleCategoryname() {
        return creationArticleCategoryname;
    }

    public void setCreationArticleCategoryname(String creationArticleCategoryname) {
        this.creationArticleCategoryname = creationArticleCategoryname;
    }

    public String getCreationArticleTitle() {
        return creationArticleTitle;
    }

    public void setCreationArticleTitle(String creationArticleTitle) {
        this.creationArticleTitle = creationArticleTitle;
    }

    public String getCreationArticleContent() {
        return creationArticleContent;
    }

    public void setCreationArticleContent(String creationArticleContent) {
        this.creationArticleContent = creationArticleContent;
    }

    public Integer getCreationArticleCreateBy() {
        return creationArticleCreateBy;
    }

    public void setCreationArticleCreateBy(Integer creationArticleCreateBy) {
        this.creationArticleCreateBy = creationArticleCreateBy;
    }

    public Integer getCreationArticleUpdateBy() {
        return creationArticleUpdateBy;
    }

    public void setCreationArticleUpdateBy(Integer creationArticleUpdateBy) {
        this.creationArticleUpdateBy = creationArticleUpdateBy;
    }

    public Date getCreationArticleUpdateTime() {
        return creationArticleUpdateTime;
    }

    public void setCreationArticleUpdateTime(Date creationArticleUpdateTime) {
        this.creationArticleUpdateTime = creationArticleUpdateTime;
    }

    public Date getCreationArticleCreateTime() {
        return creationArticleCreateTime;
    }

    public void setCreationArticleCreateTime(Date creationArticleCreateTime) {
        this.creationArticleCreateTime = creationArticleCreateTime;
    }

    @Override
    protected Serializable pkVal() {
        return this.creationArticleId;
    }

    @Override
    public String toString() {
        return "CreationArticle{" +
        "creationArticleId=" + creationArticleId +
        ", creationArticleHits=" + creationArticleHits +
        ", creationArticleImage=" + creationArticleImage +
        ", creationArticleCategoryname=" + creationArticleCategoryname +
        ", creationArticleTitle=" + creationArticleTitle +
        ", creationArticleContent=" + creationArticleContent +
        ", creationArticleCreateBy=" + creationArticleCreateBy +
        ", creationArticleUpdateBy=" + creationArticleUpdateBy +
        ", creationArticleUpdateTime=" + creationArticleUpdateTime +
        ", creationArticleCreateTime=" + creationArticleCreateTime +
        "}";
    }
}
