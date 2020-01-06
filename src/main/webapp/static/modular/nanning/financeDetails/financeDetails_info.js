/**
 * 初始化财务报表详情表详情对话框
 */
var FinanceDetailsInfoDlg = {
    financeDetailsInfoData : {}
};

/**
 * 清除数据
 */
FinanceDetailsInfoDlg.clearData = function() {
    this.financeDetailsInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
FinanceDetailsInfoDlg.set = function(key, val) {
    this.financeDetailsInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
FinanceDetailsInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
FinanceDetailsInfoDlg.close = function() {
    parent.layer.close(window.parent.FinanceDetails.layerIndex);
}

/**
 * 收集数据
 */
FinanceDetailsInfoDlg.collectData = function() {
    this
}

/**
 * 提交添加
 */
FinanceDetailsInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/financeDetails/add", function(data){
        Feng.success("添加成功!");
        window.parent.FinanceDetails.table.refresh();
        FinanceDetailsInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.financeDetailsInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
FinanceDetailsInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/financeDetails/update", function(data){
        Feng.success("修改成功!");
        window.parent.FinanceDetails.table.refresh();
        FinanceDetailsInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.financeDetailsInfoData);
    ajax.start();
}

$(function() {

});
