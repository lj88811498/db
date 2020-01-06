/**
 * 初始化工业主要产品产量表详情对话框
 */
var IndustrialOutputInfoDlg = {
    industrialOutputInfoData : {}
};

/**
 * 清除数据
 */
IndustrialOutputInfoDlg.clearData = function() {
    this.industrialOutputInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
IndustrialOutputInfoDlg.set = function(key, val) {
    this.industrialOutputInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
IndustrialOutputInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
IndustrialOutputInfoDlg.close = function() {
    parent.layer.close(window.parent.IndustrialOutput.layerIndex);
}

/**
 * 收集数据
 */
IndustrialOutputInfoDlg.collectData = function() {
    this
}

/**
 * 提交添加
 */
IndustrialOutputInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/industrialOutput/add", function(data){
        Feng.success("添加成功!");
        window.parent.IndustrialOutput.table.refresh();
        IndustrialOutputInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.industrialOutputInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
IndustrialOutputInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/industrialOutput/update", function(data){
        Feng.success("修改成功!");
        window.parent.IndustrialOutput.table.refresh();
        IndustrialOutputInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.industrialOutputInfoData);
    ajax.start();
}

$(function() {

});
