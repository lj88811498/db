/**
 * 项目申报表管理初始化
 */
var ProjectDeclaration = {
    id: "ProjectDeclarationTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
ProjectDeclaration.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
    ];
};

/**
 * 检查是否选中
 */
ProjectDeclaration.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        ProjectDeclaration.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加项目申报表
 */
ProjectDeclaration.openAddProjectDeclaration = function () {
    var index = layer.open({
        type: 2,
        title: '添加项目申报表',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/projectDeclaration/projectDeclaration_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看项目申报表详情
 */
ProjectDeclaration.openProjectDeclarationDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '项目申报表详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/projectDeclaration/projectDeclaration_update/' + ProjectDeclaration.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除项目申报表
 */
ProjectDeclaration.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/projectDeclaration/delete", function (data) {
            Feng.success("删除成功!");
            ProjectDeclaration.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("projectDeclarationId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询项目申报表列表
 */
ProjectDeclaration.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    ProjectDeclaration.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = ProjectDeclaration.initColumn();
    var table = new BSTable(ProjectDeclaration.id, "/projectDeclaration/list", defaultColunms);
    table.setPaginationType("client");
    ProjectDeclaration.table = table.init();
});
