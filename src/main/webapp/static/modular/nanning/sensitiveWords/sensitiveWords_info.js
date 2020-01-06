/**
 * 初始化敏感词详情对话框
 */
var SensitiveWordsInfoDlg = {
    sensitiveWordsInfoData : {}
};

/**
 * 清除数据
 */
SensitiveWordsInfoDlg.clearData = function() {
    this.sensitiveWordsInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
SensitiveWordsInfoDlg.set = function(key, val) {
    this.sensitiveWordsInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
SensitiveWordsInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
SensitiveWordsInfoDlg.close = function() {
    parent.layer.close(window.parent.SensitiveWords.layerIndex);
}

/**
 * 收集数据
 */
SensitiveWordsInfoDlg.collectData = function() {
    this
}

/**
 * 提交添加
 */
SensitiveWordsInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/sensitiveWords/add", function(data){
        Feng.success("添加成功!");
        window.parent.SensitiveWords.table.refresh();
        SensitiveWordsInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.sensitiveWordsInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
SensitiveWordsInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/sensitiveWords/update", function(data){
        Feng.success("修改成功!");
        window.parent.SensitiveWords.table.refresh();
        SensitiveWordsInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.sensitiveWordsInfoData);
    ajax.start();
}

$(function() {

});
