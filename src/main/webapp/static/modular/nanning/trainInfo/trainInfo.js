/**
 * 培训信息管理初始化
 */
var TrainInfo = {
    id: "TrainInfoTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
TrainInfo.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
    ];
};

/**
 * 检查是否选中
 */
TrainInfo.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        TrainInfo.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加培训信息
 */
TrainInfo.openAddTrainInfo = function () {
    var index = layer.open({
        type: 2,
        title: '添加培训信息',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/trainInfo/trainInfo_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看培训信息详情
 */
TrainInfo.openTrainInfoDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '培训信息详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/trainInfo/trainInfo_update/' + TrainInfo.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除培训信息
 */
TrainInfo.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/trainInfo/delete", function (data) {
            Feng.success("删除成功!");
            TrainInfo.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("trainInfoId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询培训信息列表
 */
TrainInfo.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    TrainInfo.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = TrainInfo.initColumn();
    var table = new BSTable(TrainInfo.id, "/trainInfo/list", defaultColunms);
    table.setPaginationType("client");
    TrainInfo.table = table.init();
});
