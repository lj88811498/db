/**
 * 初始化企业信息表详情对话框
 */
var EnterpriseInfoDlg = {
    enterpriseInfoData : {}
};

/**
 * 清除数据
 */
EnterpriseInfoDlg.clearData = function() {
    this.enterpriseInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
EnterpriseInfoDlg.set = function(key, val) {
    this.enterpriseInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
EnterpriseInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
EnterpriseInfoDlg.close = function() {
    parent.layer.close(window.parent.Enterprise.layerIndex);
}

/**
 * 收集数据
 */
EnterpriseInfoDlg.collectData = function() {
    this
}

/**
 * 提交添加
 */
EnterpriseInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/enterprise/add", function(data){
        Feng.success("添加成功!");
        window.parent.Enterprise.table.refresh();
        EnterpriseInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.enterpriseInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
EnterpriseInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/enterprise/update", function(data){
        Feng.success("修改成功!");
        window.parent.Enterprise.table.refresh();
        EnterpriseInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.enterpriseInfoData);
    ajax.start();
}

$(function() {

});
