/**
 * 初始化工业经济运行动态表详情对话框
 */
var EconomicsInfoDlg = {
    economicsInfoData : {}
};

/**
 * 清除数据
 */
EconomicsInfoDlg.clearData = function() {
    this.economicsInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
EconomicsInfoDlg.set = function(key, val) {
    this.economicsInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
EconomicsInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
EconomicsInfoDlg.close = function() {
    parent.layer.close(window.parent.Economics.layerIndex);
}

/**
 * 收集数据
 */
EconomicsInfoDlg.collectData = function() {
    this
}

/**
 * 提交添加
 */
EconomicsInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/economics/add", function(data){
        Feng.success("添加成功!");
        window.parent.Economics.table.refresh();
        EconomicsInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.economicsInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
EconomicsInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/economics/update", function(data){
        Feng.success("修改成功!");
        window.parent.Economics.table.refresh();
        EconomicsInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.economicsInfoData);
    ajax.start();
}

$(function() {

});
