/**
 * 初始化系统通知详情对话框
 */
var WebMessageInfoDlg = {
    webMessageInfoData : {}
};

/**
 * 清除数据
 */
WebMessageInfoDlg.clearData = function() {
    this.webMessageInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
WebMessageInfoDlg.set = function(key, val) {
    this.webMessageInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
WebMessageInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
WebMessageInfoDlg.close = function() {
    parent.layer.close(window.parent.WebMessage.layerIndex);
}

/**
 * 收集数据
 */
WebMessageInfoDlg.collectData = function() {
    this
}

/**
 * 提交添加
 */
WebMessageInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/webMessage/add", function(data){
        Feng.success("添加成功!");
        window.parent.WebMessage.table.refresh();
        WebMessageInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.webMessageInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
WebMessageInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/webMessage/update", function(data){
        Feng.success("修改成功!");
        window.parent.WebMessage.table.refresh();
        WebMessageInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.webMessageInfoData);
    ajax.start();
}

$(function() {

});
