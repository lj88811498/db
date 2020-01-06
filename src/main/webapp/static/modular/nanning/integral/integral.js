/**
 * 积分排名表管理初始化
 */
var Integral = {
    id: "IntegralTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Integral.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
    ];
};

/**
 * 检查是否选中
 */
Integral.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Integral.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加积分排名表
 */
Integral.openAddIntegral = function () {
    var index = layer.open({
        type: 2,
        title: '添加积分排名表',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/integral/integral_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看积分排名表详情
 */
Integral.openIntegralDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '积分排名表详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/integral/integral_update/' + Integral.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除积分排名表
 */
Integral.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/integral/delete", function (data) {
            Feng.success("删除成功!");
            Integral.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("integralId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询积分排名表列表
 */
Integral.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Integral.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Integral.initColumn();
    var table = new BSTable(Integral.id, "/integral/list", defaultColunms);
    table.setPaginationType("client");
    Integral.table = table.init();
});
