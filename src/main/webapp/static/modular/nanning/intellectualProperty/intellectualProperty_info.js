/**
 * 初始化知识产权详情对话框
 */
var IntellectualPropertyInfoDlg = {
    intellectualPropertyInfoData : {}
};

/**
 * 清除数据
 */
IntellectualPropertyInfoDlg.clearData = function() {
    this.intellectualPropertyInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
IntellectualPropertyInfoDlg.set = function(key, val) {
    this.intellectualPropertyInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
IntellectualPropertyInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
IntellectualPropertyInfoDlg.close = function() {
    parent.layer.close(window.parent.IntellectualProperty.layerIndex);
}

/**
 * 收集数据
 */
IntellectualPropertyInfoDlg.collectData = function() {
    this
}

/**
 * 提交添加
 */
IntellectualPropertyInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/intellectualProperty/add", function(data){
        Feng.success("添加成功!");
        window.parent.IntellectualProperty.table.refresh();
        IntellectualPropertyInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.intellectualPropertyInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
IntellectualPropertyInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/intellectualProperty/update", function(data){
        Feng.success("修改成功!");
        window.parent.IntellectualProperty.table.refresh();
        IntellectualPropertyInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.intellectualPropertyInfoData);
    ajax.start();
}

$(function() {

});
