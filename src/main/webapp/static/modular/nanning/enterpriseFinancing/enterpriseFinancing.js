/**
 * 企业融资信息管理初始化
 */
var EnterpriseFinancing = {
    id: "EnterpriseFinancingTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
EnterpriseFinancing.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
    ];
};

/**
 * 检查是否选中
 */
EnterpriseFinancing.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        EnterpriseFinancing.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加企业融资信息
 */
EnterpriseFinancing.openAddEnterpriseFinancing = function () {
    var index = layer.open({
        type: 2,
        title: '添加企业融资信息',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/enterpriseFinancing/enterpriseFinancing_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看企业融资信息详情
 */
EnterpriseFinancing.openEnterpriseFinancingDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '企业融资信息详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/enterpriseFinancing/enterpriseFinancing_update/' + EnterpriseFinancing.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除企业融资信息
 */
EnterpriseFinancing.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/enterpriseFinancing/delete", function (data) {
            Feng.success("删除成功!");
            EnterpriseFinancing.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("enterpriseFinancingId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询企业融资信息列表
 */
EnterpriseFinancing.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    EnterpriseFinancing.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = EnterpriseFinancing.initColumn();
    var table = new BSTable(EnterpriseFinancing.id, "/enterpriseFinancing/list", defaultColunms);
    table.setPaginationType("client");
    EnterpriseFinancing.table = table.init();
});
