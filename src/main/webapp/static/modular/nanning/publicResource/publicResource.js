/**
 * 两化公共资源信息管理初始化
 */
var PublicResource = {
    id: "PublicResourceTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
PublicResource.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
    ];
};

/**
 * 检查是否选中
 */
PublicResource.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        PublicResource.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加两化公共资源信息
 */
PublicResource.openAddPublicResource = function () {
    var index = layer.open({
        type: 2,
        title: '添加两化公共资源信息',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/publicResource/publicResource_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看两化公共资源信息详情
 */
PublicResource.openPublicResourceDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '两化公共资源信息详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/publicResource/publicResource_update/' + PublicResource.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除两化公共资源信息
 */
PublicResource.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/publicResource/delete", function (data) {
            Feng.success("删除成功!");
            PublicResource.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("publicResourceId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询两化公共资源信息列表
 */
PublicResource.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    PublicResource.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = PublicResource.initColumn();
    var table = new BSTable(PublicResource.id, "/publicResource/list", defaultColunms);
    table.setPaginationType("client");
    PublicResource.table = table.init();
});
