/**
 * 工业运行走势分析管理初始化
 */
var IndustrialStatistics = {
    id: "IndustrialStatisticsTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
IndustrialStatistics.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
    ];
};

/**
 * 检查是否选中
 */
IndustrialStatistics.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        IndustrialStatistics.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加工业运行走势分析
 */
IndustrialStatistics.openAddIndustrialStatistics = function () {
    var index = layer.open({
        type: 2,
        title: '添加工业运行走势分析',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/industrialStatistics/industrialStatistics_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看工业运行走势分析详情
 */
IndustrialStatistics.openIndustrialStatisticsDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '工业运行走势分析详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/industrialStatistics/industrialStatistics_update/' + IndustrialStatistics.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除工业运行走势分析
 */
IndustrialStatistics.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/industrialStatistics/delete", function (data) {
            Feng.success("删除成功!");
            IndustrialStatistics.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("industrialStatisticsId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询工业运行走势分析列表
 */
IndustrialStatistics.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    IndustrialStatistics.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = IndustrialStatistics.initColumn();
    var table = new BSTable(IndustrialStatistics.id, "/industrialStatistics/list", defaultColunms);
    table.setPaginationType("client");
    IndustrialStatistics.table = table.init();
});
