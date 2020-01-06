/**
 * 初始化问题浏览详情对话框
 */
var QuestionViewInfoDlg = {
    questionViewInfoData : {}
};

/**
 * 清除数据
 */
QuestionViewInfoDlg.clearData = function() {
    this.questionViewInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
QuestionViewInfoDlg.set = function(key, val) {
    this.questionViewInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
QuestionViewInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
QuestionViewInfoDlg.close = function() {
    parent.layer.close(window.parent.QuestionView.layerIndex);
}

/**
 * 收集数据
 */
QuestionViewInfoDlg.collectData = function() {
    this
}

/**
 * 提交添加
 */
QuestionViewInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/questionView/add", function(data){
        Feng.success("添加成功!");
        window.parent.QuestionView.table.refresh();
        QuestionViewInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.questionViewInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
QuestionViewInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/questionView/update", function(data){
        Feng.success("修改成功!");
        window.parent.QuestionView.table.refresh();
        QuestionViewInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.questionViewInfoData);
    ajax.start();
}

$(function() {

});
