/**
 * 初始化企业融资信息详情对话框
 */
var EnterpriseFinancingInfoDlg = {
    enterpriseFinancingInfoData : {}
};

/**
 * 清除数据
 */
EnterpriseFinancingInfoDlg.clearData = function() {
    this.enterpriseFinancingInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
EnterpriseFinancingInfoDlg.set = function(key, val) {
    this.enterpriseFinancingInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
EnterpriseFinancingInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
EnterpriseFinancingInfoDlg.close = function() {
    parent.layer.close(window.parent.EnterpriseFinancing.layerIndex);
}

/**
 * 收集数据
 */
EnterpriseFinancingInfoDlg.collectData = function() {
    this
}

/**
 * 提交添加
 */
EnterpriseFinancingInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/enterpriseFinancing/add", function(data){
        Feng.success("添加成功!");
        window.parent.EnterpriseFinancing.table.refresh();
        EnterpriseFinancingInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.enterpriseFinancingInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
EnterpriseFinancingInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/enterpriseFinancing/update", function(data){
        Feng.success("修改成功!");
        window.parent.EnterpriseFinancing.table.refresh();
        EnterpriseFinancingInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.enterpriseFinancingInfoData);
    ajax.start();
}

$(function() {

});
