/**
 * 流转情况(业务流程表)管理初始化
 */
var Business = {
    id: "BusinessTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Business.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
    ];
};

/**
 * 检查是否选中
 */
Business.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Business.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加流转情况(业务流程表)
 */
Business.openAddBusiness = function () {
    var index = layer.open({
        type: 2,
        title: '添加流转情况(业务流程表)',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/business/business_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看流转情况(业务流程表)详情
 */
Business.openBusinessDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '流转情况(业务流程表)详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/business/business_update/' + Business.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除流转情况(业务流程表)
 */
Business.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/business/delete", function (data) {
            Feng.success("删除成功!");
            Business.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("businessId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询流转情况(业务流程表)列表
 */
Business.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Business.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Business.initColumn();
    var table = new BSTable(Business.id, "/business/list", defaultColunms);
    table.setPaginationType("client");
    Business.table = table.init();
});
