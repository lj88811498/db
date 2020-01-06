/**
 * 知识产权管理初始化
 */
var IntellectualProperty = {
    id: "IntellectualPropertyTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
IntellectualProperty.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
    ];
};

/**
 * 检查是否选中
 */
IntellectualProperty.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        IntellectualProperty.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加知识产权
 */
IntellectualProperty.openAddIntellectualProperty = function () {
    var index = layer.open({
        type: 2,
        title: '添加知识产权',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/intellectualProperty/intellectualProperty_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看知识产权详情
 */
IntellectualProperty.openIntellectualPropertyDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '知识产权详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/intellectualProperty/intellectualProperty_update/' + IntellectualProperty.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除知识产权
 */
IntellectualProperty.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/intellectualProperty/delete", function (data) {
            Feng.success("删除成功!");
            IntellectualProperty.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("intellectualPropertyId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询知识产权列表
 */
IntellectualProperty.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    IntellectualProperty.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = IntellectualProperty.initColumn();
    var table = new BSTable(IntellectualProperty.id, "/intellectualProperty/list", defaultColunms);
    table.setPaginationType("client");
    IntellectualProperty.table = table.init();
});
