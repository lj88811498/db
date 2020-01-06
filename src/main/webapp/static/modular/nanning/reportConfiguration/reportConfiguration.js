/**
 * 填报配置管理初始化
 */
var ReportConfiguration = {
    id: "ReportConfigurationTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
ReportConfiguration.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
    ];
};

/**
 * 检查是否选中
 */
ReportConfiguration.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        ReportConfiguration.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加填报配置
 */
ReportConfiguration.openAddReportConfiguration = function () {
    var index = layer.open({
        type: 2,
        title: '添加填报配置',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/reportConfiguration/reportConfiguration_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看填报配置详情
 */
ReportConfiguration.openReportConfigurationDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '填报配置详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/reportConfiguration/reportConfiguration_update/' + ReportConfiguration.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除填报配置
 */
ReportConfiguration.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/reportConfiguration/delete", function (data) {
            Feng.success("删除成功!");
            ReportConfiguration.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("reportConfigurationId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询填报配置列表
 */
ReportConfiguration.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    ReportConfiguration.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = ReportConfiguration.initColumn();
    var table = new BSTable(ReportConfiguration.id, "/reportConfiguration/list", defaultColunms);
    table.setPaginationType("client");
    ReportConfiguration.table = table.init();
});
