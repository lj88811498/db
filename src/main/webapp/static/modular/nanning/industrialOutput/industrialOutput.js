/**
 * 工业主要产品产量表管理初始化
 */
var IndustrialOutput = {
    id: "IndustrialOutputTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
IndustrialOutput.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
    ];
};

/**
 * 检查是否选中
 */
IndustrialOutput.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        IndustrialOutput.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加工业主要产品产量表
 */
IndustrialOutput.openAddIndustrialOutput = function () {
    var index = layer.open({
        type: 2,
        title: '添加工业主要产品产量表',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/industrialOutput/industrialOutput_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看工业主要产品产量表详情
 */
IndustrialOutput.openIndustrialOutputDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '工业主要产品产量表详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/industrialOutput/industrialOutput_update/' + IndustrialOutput.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除工业主要产品产量表
 */
IndustrialOutput.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/industrialOutput/delete", function (data) {
            Feng.success("删除成功!");
            IndustrialOutput.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("industrialOutputId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询工业主要产品产量表列表
 */
IndustrialOutput.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    IndustrialOutput.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = IndustrialOutput.initColumn();
    var table = new BSTable(IndustrialOutput.id, "/industrialOutput/list", defaultColunms);
    table.setPaginationType("client");
    IndustrialOutput.table = table.init();
});
