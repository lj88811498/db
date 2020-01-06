/**
 * 行业信息表管理初始化
 */
var IndustryInfo = {
    id: "IndustryInfoTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
IndustryInfo.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
    ];
};

/**
 * 检查是否选中
 */
IndustryInfo.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        IndustryInfo.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加行业信息表
 */
IndustryInfo.openAddIndustryInfo = function () {
    var index = layer.open({
        type: 2,
        title: '添加行业信息表',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/industryInfo/industryInfo_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看行业信息表详情
 */
IndustryInfo.openIndustryInfoDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '行业信息表详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/industryInfo/industryInfo_update/' + IndustryInfo.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除行业信息表
 */
IndustryInfo.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/industryInfo/delete", function (data) {
            Feng.success("删除成功!");
            IndustryInfo.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("industryInfoId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询行业信息表列表
 */
IndustryInfo.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    IndustryInfo.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = IndustryInfo.initColumn();
    var table = new BSTable(IndustryInfo.id, "/industryInfo/list", defaultColunms);
    table.setPaginationType("client");
    IndustryInfo.table = table.init();
});
