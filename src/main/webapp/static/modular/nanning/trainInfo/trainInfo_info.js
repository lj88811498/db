/**
 * 初始化培训信息详情对话框
 */
var TrainInfoInfoDlg = {
    trainInfoInfoData : {}
};

/**
 * 清除数据
 */
TrainInfoInfoDlg.clearData = function() {
    this.trainInfoInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
TrainInfoInfoDlg.set = function(key, val) {
    this.trainInfoInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
TrainInfoInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
TrainInfoInfoDlg.close = function() {
    parent.layer.close(window.parent.TrainInfo.layerIndex);
}

/**
 * 收集数据
 */
TrainInfoInfoDlg.collectData = function() {
    this
}

/**
 * 提交添加
 */
TrainInfoInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/trainInfo/add", function(data){
        Feng.success("添加成功!");
        window.parent.TrainInfo.table.refresh();
        TrainInfoInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.trainInfoInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
TrainInfoInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/trainInfo/update", function(data){
        Feng.success("修改成功!");
        window.parent.TrainInfo.table.refresh();
        TrainInfoInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.trainInfoInfoData);
    ajax.start();
}

$(function() {

});
