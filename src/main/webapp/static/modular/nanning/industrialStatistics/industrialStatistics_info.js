/**
 * 初始化工业运行走势分析详情对话框
 */
var IndustrialStatisticsInfoDlg = {
    industrialStatisticsInfoData : {}
};

/**
 * 清除数据
 */
IndustrialStatisticsInfoDlg.clearData = function() {
    this.industrialStatisticsInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
IndustrialStatisticsInfoDlg.set = function(key, val) {
    this.industrialStatisticsInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
IndustrialStatisticsInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
IndustrialStatisticsInfoDlg.close = function() {
    parent.layer.close(window.parent.IndustrialStatistics.layerIndex);
}

/**
 * 收集数据
 */
IndustrialStatisticsInfoDlg.collectData = function() {
    this
}

/**
 * 提交添加
 */
IndustrialStatisticsInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/industrialStatistics/add", function(data){
        Feng.success("添加成功!");
        window.parent.IndustrialStatistics.table.refresh();
        IndustrialStatisticsInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.industrialStatisticsInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
IndustrialStatisticsInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/industrialStatistics/update", function(data){
        Feng.success("修改成功!");
        window.parent.IndustrialStatistics.table.refresh();
        IndustrialStatisticsInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.industrialStatisticsInfoData);
    ajax.start();
}

$(function() {

});
