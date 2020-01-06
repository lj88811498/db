/**
 * 初始化工业报表详情表详情对话框
 */
var IndustryDetailsInfoDlg = {
    industryDetailsInfoData : {}
};

/**
 * 清除数据
 */
IndustryDetailsInfoDlg.clearData = function() {
    this.industryDetailsInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
IndustryDetailsInfoDlg.set = function(key, val) {
    this.industryDetailsInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
IndustryDetailsInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
IndustryDetailsInfoDlg.close = function() {
    parent.layer.close(window.parent.IndustryDetails.layerIndex);
}

/**
 * 收集数据
 */
IndustryDetailsInfoDlg.collectData = function() {
    this
}

/**
 * 提交添加
 */
IndustryDetailsInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/industryDetails/add", function(data){
        Feng.success("添加成功!");
        window.parent.IndustryDetails.table.refresh();
        IndustryDetailsInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.industryDetailsInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
IndustryDetailsInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/industryDetails/update", function(data){
        Feng.success("修改成功!");
        window.parent.IndustryDetails.table.refresh();
        IndustryDetailsInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.industryDetailsInfoData);
    ajax.start();
}

$(function() {

});
