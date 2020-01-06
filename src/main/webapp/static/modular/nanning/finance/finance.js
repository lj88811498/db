/**
 * 财务报表管理初始化
 */
var Finance = {
    id: "FinanceTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Finance.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
    ];
};

/**
 * 检查是否选中
 */
Finance.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Finance.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加财务报表
 */
Finance.openAddFinance = function () {
    var index = layer.open({
        type: 2,
        title: '添加财务报表',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/finance/finance_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看财务报表详情
 */
Finance.openFinanceDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '财务报表详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/finance/finance_update/' + Finance.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除财务报表
 */
Finance.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/finance/delete", function (data) {
            Feng.success("删除成功!");
            Finance.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("financeId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询财务报表列表
 */
Finance.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Finance.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Finance.initColumn();
    var table = new BSTable(Finance.id, "/finance/list", defaultColunms);
    table.setPaginationType("client");
    Finance.table = table.init();
});
