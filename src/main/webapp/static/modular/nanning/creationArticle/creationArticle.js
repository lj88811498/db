/**
 * 创新创业-技术前沿、产品推荐、项目申报管理初始化
 */
var CreationArticle = {
    id: "CreationArticleTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
CreationArticle.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
    ];
};

/**
 * 检查是否选中
 */
CreationArticle.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        CreationArticle.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加创新创业-技术前沿、产品推荐、项目申报
 */
CreationArticle.openAddCreationArticle = function () {
    var index = layer.open({
        type: 2,
        title: '添加创新创业-技术前沿、产品推荐、项目申报',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/creationArticle/creationArticle_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看创新创业-技术前沿、产品推荐、项目申报详情
 */
CreationArticle.openCreationArticleDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '创新创业-技术前沿、产品推荐、项目申报详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/creationArticle/creationArticle_update/' + CreationArticle.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除创新创业-技术前沿、产品推荐、项目申报
 */
CreationArticle.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/creationArticle/delete", function (data) {
            Feng.success("删除成功!");
            CreationArticle.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("creationArticleId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询创新创业-技术前沿、产品推荐、项目申报列表
 */
CreationArticle.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    CreationArticle.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = CreationArticle.initColumn();
    var table = new BSTable(CreationArticle.id, "/creationArticle/list", defaultColunms);
    table.setPaginationType("client");
    CreationArticle.table = table.init();
});
