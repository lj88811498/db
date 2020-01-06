/**
 * pro投融资项目余额表附表(用于拆分存储到期时间)管理初始化
 */
var InvestSchedule = {
    id: "InvestScheduleTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
InvestSchedule.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
    ];
};

/**
 * 检查是否选中
 */
InvestSchedule.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        InvestSchedule.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加pro投融资项目余额表附表(用于拆分存储到期时间)
 */
InvestSchedule.openAddInvestSchedule = function () {
    var index = layer.open({
        type: 2,
        title: '添加pro投融资项目余额表附表(用于拆分存储到期时间)',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/investSchedule/investSchedule_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看pro投融资项目余额表附表(用于拆分存储到期时间)详情
 */
InvestSchedule.openInvestScheduleDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: 'pro投融资项目余额表附表(用于拆分存储到期时间)详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/investSchedule/investSchedule_update/' + InvestSchedule.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除pro投融资项目余额表附表(用于拆分存储到期时间)
 */
InvestSchedule.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/investSchedule/delete", function (data) {
            Feng.success("删除成功!");
            InvestSchedule.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("investScheduleId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询pro投融资项目余额表附表(用于拆分存储到期时间)列表
 */
InvestSchedule.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    InvestSchedule.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = InvestSchedule.initColumn();
    var table = new BSTable(InvestSchedule.id, "/investSchedule/list", defaultColunms);
    table.setPaginationType("client");
    InvestSchedule.table = table.init();
});
