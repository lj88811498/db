package com.youedata.nncloud.modular.nanning.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.youedata.nncloud.modular.nanning.anno.Too;
import io.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 两化公共资源信息
 * </p>
 *
 * @author Monkey
 * @since 2019-01-17
 */
@ApiModel
public class PublicResource extends Model<PublicResource> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "public_resource_id", type = IdType.AUTO)
    private Integer publicResourceId;
    /**
     * 公司名称
     */
    @Too(value="companyname")
    private String publicResourceCompanyname;
    /**
     * 产品
     */
    @Too(value="products")
    private String publicResourceProducts;
    /**
     * 工商注册类型
     */
    @Too(value="genre")
    private String publicResourceGenre;
    /**
     * 区域
     */
    @Too(value="areaname")
    private String publicResourceAreaname;
    /**
     * 地址
     */
    @Too(value="address")
    private String publicResourceAddress;
    /**
     * 状态
     */
    @Too(value="status")
    private String publicResourceStatus;
    /**
     * 联系人
     */
    @Too(value="linkman")
    private String publicResourceLinkman;
    /**
     * 联系电话
     */
    @Too(value="telephone")
    private String publicResourceTelephone;
    /**
     * 邮箱
     */
    @Too(value="email")
    private String publicResourceEmail;
    /**
     * 联系QQ
     */
    @Too(value="qq")
    private String publicResourceQq;
    /**
     * 公司网站地址
     */
    @Too(value="url")
    private String publicResourceUrl;
    /**
     * 创建人
     */
    private Integer publicResourceCreateBy;
    /**
     * 修改人
     */
    private Integer publicResourceUpdateBy;
    /**
     * 修改时间
     */
    private Date publicResourceUpdateTime;
    /**
     * 创建时间
     */
    private Date publicResourceCreateTime;


    public Integer getPublicResourceId() {
        return publicResourceId;
    }

    public void setPublicResourceId(Integer publicResourceId) {
        this.publicResourceId = publicResourceId;
    }

    public String getPublicResourceCompanyname() {
        return publicResourceCompanyname;
    }

    public void setPublicResourceCompanyname(String publicResourceCompanyname) {
        this.publicResourceCompanyname = publicResourceCompanyname;
    }

    public String getPublicResourceProducts() {
        return publicResourceProducts;
    }

    public void setPublicResourceProducts(String publicResourceProducts) {
        this.publicResourceProducts = publicResourceProducts;
    }

    public String getPublicResourceGenre() {
        return publicResourceGenre;
    }

    public void setPublicResourceGenre(String publicResourceGenre) {
        this.publicResourceGenre = publicResourceGenre;
    }

    public String getPublicResourceAreaname() {
        return publicResourceAreaname;
    }

    public void setPublicResourceAreaname(String publicResourceAreaname) {
        this.publicResourceAreaname = publicResourceAreaname;
    }

    public String getPublicResourceAddress() {
        return publicResourceAddress;
    }

    public void setPublicResourceAddress(String publicResourceAddress) {
        this.publicResourceAddress = publicResourceAddress;
    }

    public String getPublicResourceStatus() {
        return publicResourceStatus;
    }

    public void setPublicResourceStatus(String publicResourceStatus) {
        this.publicResourceStatus = publicResourceStatus;
    }

    public String getPublicResourceLinkman() {
        return publicResourceLinkman;
    }

    public void setPublicResourceLinkman(String publicResourceLinkman) {
        this.publicResourceLinkman = publicResourceLinkman;
    }

    public String getPublicResourceTelephone() {
        return publicResourceTelephone;
    }

    public void setPublicResourceTelephone(String publicResourceTelephone) {
        this.publicResourceTelephone = publicResourceTelephone;
    }

    public String getPublicResourceEmail() {
        return publicResourceEmail;
    }

    public void setPublicResourceEmail(String publicResourceEmail) {
        this.publicResourceEmail = publicResourceEmail;
    }

    public String getPublicResourceQq() {
        return publicResourceQq;
    }

    public void setPublicResourceQq(String publicResourceQq) {
        this.publicResourceQq = publicResourceQq;
    }

    public String getPublicResourceUrl() {
        return publicResourceUrl;
    }

    public void setPublicResourceUrl(String publicResourceUrl) {
        this.publicResourceUrl = publicResourceUrl;
    }

    public Integer getPublicResourceCreateBy() {
        return publicResourceCreateBy;
    }

    public void setPublicResourceCreateBy(Integer publicResourceCreateBy) {
        this.publicResourceCreateBy = publicResourceCreateBy;
    }

    public Integer getPublicResourceUpdateBy() {
        return publicResourceUpdateBy;
    }

    public void setPublicResourceUpdateBy(Integer publicResourceUpdateBy) {
        this.publicResourceUpdateBy = publicResourceUpdateBy;
    }

    public Date getPublicResourceUpdateTime() {
        return publicResourceUpdateTime;
    }

    public void setPublicResourceUpdateTime(Date publicResourceUpdateTime) {
        this.publicResourceUpdateTime = publicResourceUpdateTime;
    }

    public Date getPublicResourceCreateTime() {
        return publicResourceCreateTime;
    }

    public void setPublicResourceCreateTime(Date publicResourceCreateTime) {
        this.publicResourceCreateTime = publicResourceCreateTime;
    }

    @Override
    protected Serializable pkVal() {
        return this.publicResourceId;
    }

    @Override
    public String toString() {
        return "PublicResource{" +
        "publicResourceId=" + publicResourceId +
        ", publicResourceCompanyname=" + publicResourceCompanyname +
        ", publicResourceProducts=" + publicResourceProducts +
        ", publicResourceGenre=" + publicResourceGenre +
        ", publicResourceAreaname=" + publicResourceAreaname +
        ", publicResourceAddress=" + publicResourceAddress +
        ", publicResourceStatus=" + publicResourceStatus +
        ", publicResourceLinkman=" + publicResourceLinkman +
        ", publicResourceTelephone=" + publicResourceTelephone +
        ", publicResourceEmail=" + publicResourceEmail +
        ", publicResourceQq=" + publicResourceQq +
        ", publicResourceUrl=" + publicResourceUrl +
        ", publicResourceCreateBy=" + publicResourceCreateBy +
        ", publicResourceUpdateBy=" + publicResourceUpdateBy +
        ", publicResourceUpdateTime=" + publicResourceUpdateTime +
        ", publicResourceCreateTime=" + publicResourceCreateTime +
        "}";
    }
}
