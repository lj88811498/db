/**
 * 申报附件管理初始化
 */
var DeclarationAttachment = {
    id: "DeclarationAttachmentTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
DeclarationAttachment.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
    ];
};

/**
 * 检查是否选中
 */
DeclarationAttachment.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        DeclarationAttachment.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加申报附件
 */
DeclarationAttachment.openAddDeclarationAttachment = function () {
    var index = layer.open({
        type: 2,
        title: '添加申报附件',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/declarationAttachment/declarationAttachment_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看申报附件详情
 */
DeclarationAttachment.openDeclarationAttachmentDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '申报附件详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/declarationAttachment/declarationAttachment_update/' + DeclarationAttachment.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除申报附件
 */
DeclarationAttachment.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/declarationAttachment/delete", function (data) {
            Feng.success("删除成功!");
            DeclarationAttachment.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("declarationAttachmentId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询申报附件列表
 */
DeclarationAttachment.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    DeclarationAttachment.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = DeclarationAttachment.initColumn();
    var table = new BSTable(DeclarationAttachment.id, "/declarationAttachment/list", defaultColunms);
    table.setPaginationType("client");
    DeclarationAttachment.table = table.init();
});
