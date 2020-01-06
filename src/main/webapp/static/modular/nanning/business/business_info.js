/**
 * 初始化流转情况(业务流程表)详情对话框
 */
var BusinessInfoDlg = {
    businessInfoData : {}
};

/**
 * 清除数据
 */
BusinessInfoDlg.clearData = function() {
    this.businessInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
BusinessInfoDlg.set = function(key, val) {
    this.businessInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
BusinessInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
BusinessInfoDlg.close = function() {
    parent.layer.close(window.parent.Business.layerIndex);
}

/**
 * 收集数据
 */
BusinessInfoDlg.collectData = function() {
    this
}

/**
 * 提交添加
 */
BusinessInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/business/add", function(data){
        Feng.success("添加成功!");
        window.parent.Business.table.refresh();
        BusinessInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.businessInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
BusinessInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/business/update", function(data){
        Feng.success("修改成功!");
        window.parent.Business.table.refresh();
        BusinessInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.businessInfoData);
    ajax.start();
}

$(function() {

});
