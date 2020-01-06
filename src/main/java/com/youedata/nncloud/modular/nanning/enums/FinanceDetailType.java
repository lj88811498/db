package com.youedata.nncloud.modular.nanning.enums;



public enum FinanceDetailType {


    /**
     * 子项-父项
     * 父项：
     *
     */

    NAME_1("一、年初存货","1"),
    NAME_2("二、期末资产负债","2"),
    NAME_3("流动资产合计","2"),
    NAME_4("其中：应收账款","2"),
    NAME_5("存货","2"),
    NAME_6("其中：产成品","2"),
    NAME_7("资产总计","2"),
    NAME_8("负债合计","2"),
    NAME_9("三、损益及分配","3"),
    NAME_10("营业收入","3"),
    NAME_11("其中：主营业务收入","3"),
    NAME_12("营业成本","3"),
    NAME_13("其中：主营业务成本","3"),
    NAME_14("营业税金及附加","3"),
    NAME_15("其中：主营业务税金及附加","3"),
    NAME_16("销售费用","3"),
    NAME_17("管理费用","3"),
    NAME_18("其中：税金","3"),
    NAME_19("财务费用","3"),
    NAME_20("其中：利息收入","3"),
    NAME_21("利息支出","3"),
    NAME_22("资产减值损失","3"),
    NAME_23("公允价值变动收益(损失以双引号记)","3"),
    NAME_24("投资收益(损失以双引号记)","3"),
    NAME_25("营业利润","3"),
    NAME_26("营业外收入","3"),
    NAME_27("其中：政府补助","3"),
    NAME_28("营业外支出","3"),
    NAME_29("利润总额","3"),
    NAME_30("四、应交增值税","4"),
    NAME_31("五、平均用工人数","5");





    private String code;
    private String desc;

    private FinanceDetailType(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static FinanceDetailType getByCode(String code) {
        FinanceDetailType[] values = values();
        for (FinanceDetailType sw : values) {
            if(code.equals(sw.code)) {
                return sw;
            }
        }

        return null;
    }


    public static Boolean isContainCode(String code) {
        FinanceDetailType[] values = values();
        for (FinanceDetailType sw : values) {
            if(code.equals(sw.code)) {
                return true;
            }
        }
        return false;
    }
}
