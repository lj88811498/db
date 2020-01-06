/**
 * 初始化填报配置详情对话框
 */
var ReportConfigurationInfoDlg = {
    reportConfigurationInfoData : {}
};

/**
 * 清除数据
 */
ReportConfigurationInfoDlg.clearData = function() {
    this.reportConfigurationInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
ReportConfigurationInfoDlg.set = function(key, val) {
    this.reportConfigurationInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
ReportConfigurationInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
ReportConfigurationInfoDlg.close = function() {
    parent.layer.close(window.parent.ReportConfiguration.layerIndex);
}

/**
 * 收集数据
 */
ReportConfigurationInfoDlg.collectData = function() {
    this
}

/**
 * 提交添加
 */
ReportConfigurationInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/reportConfiguration/add", function(data){
        Feng.success("添加成功!");
        window.parent.ReportConfiguration.table.refresh();
        ReportConfigurationInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.reportConfigurationInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
ReportConfigurationInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/reportConfiguration/update", function(data){
        Feng.success("修改成功!");
        window.parent.ReportConfiguration.table.refresh();
        ReportConfigurationInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.reportConfigurationInfoData);
    ajax.start();
}

$(function() {

});
