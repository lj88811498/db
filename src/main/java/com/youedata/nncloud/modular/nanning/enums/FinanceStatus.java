package com.youedata.nncloud.modular.nanning.enums;



public enum FinanceStatus {


    /**
     *
     * APP状态对应工信状态
     * 0:待提交  0 3
     * 1:待审核  1
     * 2:已审核  99
     * 3:已反审  2
     *
     *工信状态-APP状态
     */
    ZERO("0","0"),
    ONE("1","1"),
    TWO("2","3"),
    THREE("3","0"),
    NINE("99","2");


    private String code;
    private String desc;

    private FinanceStatus(String code,String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static FinanceStatus getByCode(String code) {
        FinanceStatus[] values = values();
        for (FinanceStatus sw : values) {
            if(code.equals(sw.code)) {
                return sw;
            }
        }

        return null;
    }


    public static Boolean isContainCode(String code) {
        FinanceStatus[] values = values();
        for (FinanceStatus sw : values) {
            if(code.equals(sw.code)) {
                return true;
            }
        }
        return false;
    }
}
