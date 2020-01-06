/**
 * 初始化两化公共资源信息详情对话框
 */
var PublicResourceInfoDlg = {
    publicResourceInfoData : {}
};

/**
 * 清除数据
 */
PublicResourceInfoDlg.clearData = function() {
    this.publicResourceInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
PublicResourceInfoDlg.set = function(key, val) {
    this.publicResourceInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
PublicResourceInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
PublicResourceInfoDlg.close = function() {
    parent.layer.close(window.parent.PublicResource.layerIndex);
}

/**
 * 收集数据
 */
PublicResourceInfoDlg.collectData = function() {
    this
}

/**
 * 提交添加
 */
PublicResourceInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/publicResource/add", function(data){
        Feng.success("添加成功!");
        window.parent.PublicResource.table.refresh();
        PublicResourceInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.publicResourceInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
PublicResourceInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/publicResource/update", function(data){
        Feng.success("修改成功!");
        window.parent.PublicResource.table.refresh();
        PublicResourceInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.publicResourceInfoData);
    ajax.start();
}

$(function() {

});
