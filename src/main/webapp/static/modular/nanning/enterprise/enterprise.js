/**
 * 企业信息表管理初始化
 */
var Enterprise = {
    id: "EnterpriseTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Enterprise.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
    ];
};

/**
 * 检查是否选中
 */
Enterprise.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Enterprise.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加企业信息表
 */
Enterprise.openAddEnterprise = function () {
    var index = layer.open({
        type: 2,
        title: '添加企业信息表',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/enterprise/enterprise_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看企业信息表详情
 */
Enterprise.openEnterpriseDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '企业信息表详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/enterprise/enterprise_update/' + Enterprise.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除企业信息表
 */
Enterprise.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/enterprise/delete", function (data) {
            Feng.success("删除成功!");
            Enterprise.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("enterpriseId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询企业信息表列表
 */
Enterprise.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Enterprise.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Enterprise.initColumn();
    var table = new BSTable(Enterprise.id, "/enterprise/list", defaultColunms);
    table.setPaginationType("client");
    Enterprise.table = table.init();
});
