/**
 * 敏感词管理初始化
 */
var SensitiveWords = {
    id: "SensitiveWordsTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
SensitiveWords.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
    ];
};

/**
 * 检查是否选中
 */
SensitiveWords.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        SensitiveWords.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加敏感词
 */
SensitiveWords.openAddSensitiveWords = function () {
    var index = layer.open({
        type: 2,
        title: '添加敏感词',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/sensitiveWords/sensitiveWords_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看敏感词详情
 */
SensitiveWords.openSensitiveWordsDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '敏感词详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/sensitiveWords/sensitiveWords_update/' + SensitiveWords.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除敏感词
 */
SensitiveWords.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/sensitiveWords/delete", function (data) {
            Feng.success("删除成功!");
            SensitiveWords.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("sensitiveWordsId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询敏感词列表
 */
SensitiveWords.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    SensitiveWords.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = SensitiveWords.initColumn();
    var table = new BSTable(SensitiveWords.id, "/sensitiveWords/list", defaultColunms);
    table.setPaginationType("client");
    SensitiveWords.table = table.init();
});
