package com.youedata.nncloud.modular.nanning.model;

import io.swagger.annotations.ApiModel;
import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 敏感词
 * </p>
 *
 * @author Monkey
 * @since 2018-12-29
 */
@ApiModel
public class SensitiveWords extends Model<SensitiveWords> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "sensitive_words_id", type = IdType.AUTO)
    private Integer sensitiveWordsId;
    /**
     * 敏感词名称
     */
    private String sensitiveWordsName;
    /**
     * 创建人
     */
    private Integer sensitiveWordsCreateBy;
    /**
     * 修改人
     */
    private Integer sensitiveWordsUpdateBy;
    /**
     * 修改时间
     */
    private Date sensitiveWordsUpdateTime;
    /**
     * 创建时间
     */
    private Date sensitiveWordsCreateTime;


    public Integer getSensitiveWordsId() {
        return sensitiveWordsId;
    }

    public void setSensitiveWordsId(Integer sensitiveWordsId) {
        this.sensitiveWordsId = sensitiveWordsId;
    }

    public String getSensitiveWordsName() {
        return sensitiveWordsName;
    }

    public void setSensitiveWordsName(String sensitiveWordsName) {
        this.sensitiveWordsName = sensitiveWordsName;
    }

    public Integer getSensitiveWordsCreateBy() {
        return sensitiveWordsCreateBy;
    }

    public void setSensitiveWordsCreateBy(Integer sensitiveWordsCreateBy) {
        this.sensitiveWordsCreateBy = sensitiveWordsCreateBy;
    }

    public Integer getSensitiveWordsUpdateBy() {
        return sensitiveWordsUpdateBy;
    }

    public void setSensitiveWordsUpdateBy(Integer sensitiveWordsUpdateBy) {
        this.sensitiveWordsUpdateBy = sensitiveWordsUpdateBy;
    }

    public Date getSensitiveWordsUpdateTime() {
        return sensitiveWordsUpdateTime;
    }

    public void setSensitiveWordsUpdateTime(Date sensitiveWordsUpdateTime) {
        this.sensitiveWordsUpdateTime = sensitiveWordsUpdateTime;
    }

    public Date getSensitiveWordsCreateTime() {
        return sensitiveWordsCreateTime;
    }

    public void setSensitiveWordsCreateTime(Date sensitiveWordsCreateTime) {
        this.sensitiveWordsCreateTime = sensitiveWordsCreateTime;
    }

    @Override
    protected Serializable pkVal() {
        return this.sensitiveWordsId;
    }

    @Override
    public String toString() {
        return "SensitiveWords{" +
        "sensitiveWordsId=" + sensitiveWordsId +
        ", sensitiveWordsName=" + sensitiveWordsName +
        ", sensitiveWordsCreateBy=" + sensitiveWordsCreateBy +
        ", sensitiveWordsUpdateBy=" + sensitiveWordsUpdateBy +
        ", sensitiveWordsUpdateTime=" + sensitiveWordsUpdateTime +
        ", sensitiveWordsCreateTime=" + sensitiveWordsCreateTime +
        "}";
    }
}
