/**
 * 初始化积分排名表详情对话框
 */
var IntegralInfoDlg = {
    integralInfoData : {}
};

/**
 * 清除数据
 */
IntegralInfoDlg.clearData = function() {
    this.integralInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
IntegralInfoDlg.set = function(key, val) {
    this.integralInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
IntegralInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
IntegralInfoDlg.close = function() {
    parent.layer.close(window.parent.Integral.layerIndex);
}

/**
 * 收集数据
 */
IntegralInfoDlg.collectData = function() {
    this
}

/**
 * 提交添加
 */
IntegralInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/integral/add", function(data){
        Feng.success("添加成功!");
        window.parent.Integral.table.refresh();
        IntegralInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.integralInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
IntegralInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/integral/update", function(data){
        Feng.success("修改成功!");
        window.parent.Integral.table.refresh();
        IntegralInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.integralInfoData);
    ajax.start();
}

$(function() {

});
