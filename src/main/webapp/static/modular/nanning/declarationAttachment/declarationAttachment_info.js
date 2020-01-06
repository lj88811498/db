/**
 * 初始化申报附件详情对话框
 */
var DeclarationAttachmentInfoDlg = {
    declarationAttachmentInfoData : {}
};

/**
 * 清除数据
 */
DeclarationAttachmentInfoDlg.clearData = function() {
    this.declarationAttachmentInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
DeclarationAttachmentInfoDlg.set = function(key, val) {
    this.declarationAttachmentInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
DeclarationAttachmentInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
DeclarationAttachmentInfoDlg.close = function() {
    parent.layer.close(window.parent.DeclarationAttachment.layerIndex);
}

/**
 * 收集数据
 */
DeclarationAttachmentInfoDlg.collectData = function() {
    this
}

/**
 * 提交添加
 */
DeclarationAttachmentInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/declarationAttachment/add", function(data){
        Feng.success("添加成功!");
        window.parent.DeclarationAttachment.table.refresh();
        DeclarationAttachmentInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.declarationAttachmentInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
DeclarationAttachmentInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/declarationAttachment/update", function(data){
        Feng.success("修改成功!");
        window.parent.DeclarationAttachment.table.refresh();
        DeclarationAttachmentInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.declarationAttachmentInfoData);
    ajax.start();
}

$(function() {

});
