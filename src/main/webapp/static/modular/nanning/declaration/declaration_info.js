/**
 * 初始化我的申报表详情对话框
 */
var DeclarationInfoDlg = {
    declarationInfoData : {}
};

/**
 * 清除数据
 */
DeclarationInfoDlg.clearData = function() {
    this.declarationInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
DeclarationInfoDlg.set = function(key, val) {
    this.declarationInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
DeclarationInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
DeclarationInfoDlg.close = function() {
    parent.layer.close(window.parent.Declaration.layerIndex);
}

/**
 * 收集数据
 */
DeclarationInfoDlg.collectData = function() {
    this
}

/**
 * 提交添加
 */
DeclarationInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/declaration/add", function(data){
        Feng.success("添加成功!");
        window.parent.Declaration.table.refresh();
        DeclarationInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.declarationInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
DeclarationInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/declaration/update", function(data){
        Feng.success("修改成功!");
        window.parent.Declaration.table.refresh();
        DeclarationInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.declarationInfoData);
    ajax.start();
}

$(function() {

});
