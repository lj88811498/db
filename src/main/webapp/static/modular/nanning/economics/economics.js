/**
 * 工业经济运行动态表管理初始化
 */
var Economics = {
    id: "EconomicsTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Economics.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
    ];
};

/**
 * 检查是否选中
 */
Economics.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Economics.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加工业经济运行动态表
 */
Economics.openAddEconomics = function () {
    var index = layer.open({
        type: 2,
        title: '添加工业经济运行动态表',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/economics/economics_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看工业经济运行动态表详情
 */
Economics.openEconomicsDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '工业经济运行动态表详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/economics/economics_update/' + Economics.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除工业经济运行动态表
 */
Economics.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/economics/delete", function (data) {
            Feng.success("删除成功!");
            Economics.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("economicsId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询工业经济运行动态表列表
 */
Economics.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Economics.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Economics.initColumn();
    var table = new BSTable(Economics.id, "/economics/list", defaultColunms);
    table.setPaginationType("client");
    Economics.table = table.init();
});
