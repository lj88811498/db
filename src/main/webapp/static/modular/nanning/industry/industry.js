/**
 * 工业报表管理初始化
 */
var Industry = {
    id: "IndustryTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Industry.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
    ];
};

/**
 * 检查是否选中
 */
Industry.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Industry.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加工业报表
 */
Industry.openAddIndustry = function () {
    var index = layer.open({
        type: 2,
        title: '添加工业报表',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/industry/industry_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看工业报表详情
 */
Industry.openIndustryDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '工业报表详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/industry/industry_update/' + Industry.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除工业报表
 */
Industry.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/industry/delete", function (data) {
            Feng.success("删除成功!");
            Industry.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("industryId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询工业报表列表
 */
Industry.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Industry.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Industry.initColumn();
    var table = new BSTable(Industry.id, "/industry/list", defaultColunms);
    table.setPaginationType("client");
    Industry.table = table.init();
});
