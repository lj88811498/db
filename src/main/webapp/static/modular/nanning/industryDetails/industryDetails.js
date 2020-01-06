/**
 * 工业报表详情表管理初始化
 */
var IndustryDetails = {
    id: "IndustryDetailsTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
IndustryDetails.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
    ];
};

/**
 * 检查是否选中
 */
IndustryDetails.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        IndustryDetails.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加工业报表详情表
 */
IndustryDetails.openAddIndustryDetails = function () {
    var index = layer.open({
        type: 2,
        title: '添加工业报表详情表',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/industryDetails/industryDetails_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看工业报表详情表详情
 */
IndustryDetails.openIndustryDetailsDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '工业报表详情表详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/industryDetails/industryDetails_update/' + IndustryDetails.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除工业报表详情表
 */
IndustryDetails.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/industryDetails/delete", function (data) {
            Feng.success("删除成功!");
            IndustryDetails.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("industryDetailsId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询工业报表详情表列表
 */
IndustryDetails.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    IndustryDetails.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = IndustryDetails.initColumn();
    var table = new BSTable(IndustryDetails.id, "/industryDetails/list", defaultColunms);
    table.setPaginationType("client");
    IndustryDetails.table = table.init();
});
