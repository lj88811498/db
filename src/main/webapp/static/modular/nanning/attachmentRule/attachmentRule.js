/**
 * 项目类型附件规则管理初始化
 */
var AttachmentRule = {
    id: "AttachmentRuleTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
AttachmentRule.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
    ];
};

/**
 * 检查是否选中
 */
AttachmentRule.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        AttachmentRule.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加项目类型附件规则
 */
AttachmentRule.openAddAttachmentRule = function () {
    var index = layer.open({
        type: 2,
        title: '添加项目类型附件规则',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/attachmentRule/attachmentRule_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看项目类型附件规则详情
 */
AttachmentRule.openAttachmentRuleDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '项目类型附件规则详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/attachmentRule/attachmentRule_update/' + AttachmentRule.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除项目类型附件规则
 */
AttachmentRule.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/attachmentRule/delete", function (data) {
            Feng.success("删除成功!");
            AttachmentRule.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("attachmentRuleId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询项目类型附件规则列表
 */
AttachmentRule.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    AttachmentRule.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = AttachmentRule.initColumn();
    var table = new BSTable(AttachmentRule.id, "/attachmentRule/list", defaultColunms);
    table.setPaginationType("client");
    AttachmentRule.table = table.init();
});
