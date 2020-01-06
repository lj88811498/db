/**
 * 初始化行业信息表详情对话框
 */
var IndustryInfoInfoDlg = {
    industryInfoInfoData : {}
};

/**
 * 清除数据
 */
IndustryInfoInfoDlg.clearData = function() {
    this.industryInfoInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
IndustryInfoInfoDlg.set = function(key, val) {
    this.industryInfoInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
IndustryInfoInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
IndustryInfoInfoDlg.close = function() {
    parent.layer.close(window.parent.IndustryInfo.layerIndex);
}

/**
 * 收集数据
 */
IndustryInfoInfoDlg.collectData = function() {
    this
}

/**
 * 提交添加
 */
IndustryInfoInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/industryInfo/add", function(data){
        Feng.success("添加成功!");
        window.parent.IndustryInfo.table.refresh();
        IndustryInfoInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.industryInfoInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
IndustryInfoInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/industryInfo/update", function(data){
        Feng.success("修改成功!");
        window.parent.IndustryInfo.table.refresh();
        IndustryInfoInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.industryInfoInfoData);
    ajax.start();
}

$(function() {

});
