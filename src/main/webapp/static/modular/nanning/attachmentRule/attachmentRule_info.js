/**
 * 初始化项目类型附件规则详情对话框
 */
var AttachmentRuleInfoDlg = {
    attachmentRuleInfoData : {}
};

/**
 * 清除数据
 */
AttachmentRuleInfoDlg.clearData = function() {
    this.attachmentRuleInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
AttachmentRuleInfoDlg.set = function(key, val) {
    this.attachmentRuleInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
AttachmentRuleInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
AttachmentRuleInfoDlg.close = function() {
    parent.layer.close(window.parent.AttachmentRule.layerIndex);
}

/**
 * 收集数据
 */
AttachmentRuleInfoDlg.collectData = function() {
    this
}

/**
 * 提交添加
 */
AttachmentRuleInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/attachmentRule/add", function(data){
        Feng.success("添加成功!");
        window.parent.AttachmentRule.table.refresh();
        AttachmentRuleInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.attachmentRuleInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
AttachmentRuleInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/attachmentRule/update", function(data){
        Feng.success("修改成功!");
        window.parent.AttachmentRule.table.refresh();
        AttachmentRuleInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.attachmentRuleInfoData);
    ajax.start();
}

$(function() {

});
