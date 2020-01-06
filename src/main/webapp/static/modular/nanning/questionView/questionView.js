/**
 * 问题浏览管理初始化
 */
var QuestionView = {
    id: "QuestionViewTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
QuestionView.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
    ];
};

/**
 * 检查是否选中
 */
QuestionView.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        QuestionView.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加问题浏览
 */
QuestionView.openAddQuestionView = function () {
    var index = layer.open({
        type: 2,
        title: '添加问题浏览',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/questionView/questionView_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看问题浏览详情
 */
QuestionView.openQuestionViewDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '问题浏览详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/questionView/questionView_update/' + QuestionView.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除问题浏览
 */
QuestionView.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/questionView/delete", function (data) {
            Feng.success("删除成功!");
            QuestionView.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("questionViewId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询问题浏览列表
 */
QuestionView.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    QuestionView.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = QuestionView.initColumn();
    var table = new BSTable(QuestionView.id, "/questionView/list", defaultColunms);
    table.setPaginationType("client");
    QuestionView.table = table.init();
});
