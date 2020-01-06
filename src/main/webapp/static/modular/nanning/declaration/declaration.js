/**
 * 我的申报表管理初始化
 */
var Declaration = {
    id: "DeclarationTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Declaration.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
    ];
};

/**
 * 检查是否选中
 */
Declaration.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Declaration.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加我的申报表
 */
Declaration.openAddDeclaration = function () {
    var index = layer.open({
        type: 2,
        title: '添加我的申报表',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/declaration/declaration_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看我的申报表详情
 */
Declaration.openDeclarationDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '我的申报表详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/declaration/declaration_update/' + Declaration.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除我的申报表
 */
Declaration.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/declaration/delete", function (data) {
            Feng.success("删除成功!");
            Declaration.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("declarationId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询我的申报表列表
 */
Declaration.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Declaration.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Declaration.initColumn();
    var table = new BSTable(Declaration.id, "/declaration/list", defaultColunms);
    table.setPaginationType("client");
    Declaration.table = table.init();
});
