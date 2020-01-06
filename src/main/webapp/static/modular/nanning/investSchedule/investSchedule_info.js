/**
 * 初始化pro投融资项目余额表附表(用于拆分存储到期时间)详情对话框
 */
var InvestScheduleInfoDlg = {
    investScheduleInfoData : {}
};

/**
 * 清除数据
 */
InvestScheduleInfoDlg.clearData = function() {
    this.investScheduleInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
InvestScheduleInfoDlg.set = function(key, val) {
    this.investScheduleInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
InvestScheduleInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
InvestScheduleInfoDlg.close = function() {
    parent.layer.close(window.parent.InvestSchedule.layerIndex);
}

/**
 * 收集数据
 */
InvestScheduleInfoDlg.collectData = function() {
    this
}

/**
 * 提交添加
 */
InvestScheduleInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/investSchedule/add", function(data){
        Feng.success("添加成功!");
        window.parent.InvestSchedule.table.refresh();
        InvestScheduleInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.investScheduleInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
InvestScheduleInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/investSchedule/update", function(data){
        Feng.success("修改成功!");
        window.parent.InvestSchedule.table.refresh();
        InvestScheduleInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.investScheduleInfoData);
    ajax.start();
}

$(function() {

});
