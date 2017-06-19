function lists() {
    $("#list").load("list.html");
    $.post("/page/list.action", {
	page : "1",
	rows : "10"
    }, function(data, status) {
	if (status == 'success') {
	    var json = JSON.parse(data);
	    $.each(json.rows, function(selector, context) {
		var date = "<tr class=\"minfo\"><td>" + context.mname
			+ "</td><td class=\"tinfo\">" + context.minfo
			+ "</td><td >" + context.mrate + "</td><td>"
			+ context.mpls
			+ "</td><td><a target=\"_blank\" href=\""
			+ context.slink + "\">" + "查看详情" + "</a></td><td>"
			+ context.mdate + "</td></tr>";
		$("tbody").append(date);
	    });
	    $('#pagination-demo').twbsPagination({
		totalPages : json.total,
		visiblePages : 7,
		onPageClick : function(event, page) {
		    // 分页按钮触发事件
		    getpage(page);
		}
	    });
	}
    });
}
var url = "/page/ratesort.action";
var param = {
    page : "1",
    rows : "10",
    sort : "1",
    colum : "mrate"
};
function sortdeal(page) {
    param.page = page + "";
    getdata(url, param, deal);
}
function getdata(url, param, deal) {
    var datas = $.post(url, {
	param : JSON.stringify(param)
    }, function(data, status) {
	if (status == 'success')
	    deal(data);
    });
}
function slide(target) {
    $("#" + target).slideToggle();
}