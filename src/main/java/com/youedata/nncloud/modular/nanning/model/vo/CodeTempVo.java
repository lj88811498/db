package com.youedata.nncloud.modular.nanning.model.vo;


import groovyjarjarantlr.actions.python.CodeLexer;

/**
 * 验证码的过期对象
 * @Author: Monkey
 * @Date: Created in 15:16  2018/11/16.
 * @Description:
 */
public class CodeTempVo {

    private String code;

    private Long expires;

    public CodeTempVo(){}

    public CodeTempVo(String code){
        this.code = code;
        this.expires = System.currentTimeMillis();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getExpires() {
        return expires;
    }

    public void setExpires(Long expires) {
        this.expires = expires;
    }
}
