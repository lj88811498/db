package com.youedata.nncloud.modular.nanning.model.vo;


/**
 * 验证码vo
 * Created by sky on 2018/11/15.
 */

public class CodeVo {

    private String url;

    private String key;

    public CodeVo(){}

    public CodeVo(String url, String key){
        this.url = url;
        this.key = key;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
