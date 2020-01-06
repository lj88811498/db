/**
 * 初始化项目申报表详情对话框
 */
var ProjectDeclarationInfoDlg = {
    projectDeclarationInfoData : {}
};

/**
 * 清除数据
 */
ProjectDeclarationInfoDlg.clearData = function() {
    this.projectDeclarationInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
ProjectDeclarationInfoDlg.set = function(key, val) {
    this.projectDeclarationInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
ProjectDeclarationInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
ProjectDeclarationInfoDlg.close = function() {
    parent.layer.close(window.parent.ProjectDeclaration.layerIndex);
}

/**
 * 收集数据
 */
ProjectDeclarationInfoDlg.collectData = function() {
    this
}

/**
 * 提交添加
 */
ProjectDeclarationInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/projectDeclaration/add", function(data){
        Feng.success("添加成功!");
        window.parent.ProjectDeclaration.table.refresh();
        ProjectDeclarationInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.projectDeclarationInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
ProjectDeclarationInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/projectDeclaration/update", function(data){
        Feng.success("修改成功!");
        window.parent.ProjectDeclaration.table.refresh();
        ProjectDeclarationInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.projectDeclarationInfoData);
    ajax.start();
}

$(function() {

});
