/*
 * 获取数据列表
 */

$(function() {
    page();
});

function page() {
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
// 分页按钮事件触发后处理函数
function getpage(page) {
    $("tbody").html("");
    $
	    .post(
		    "/page/list.action",
		    {
			page : page,
			rows : "10"
		    },
		    function(data, status) {
			if (status == 'success') {
			    var json = JSON.parse(data);
			    $
				    .each(
					    json.rows,
					    function(selector, context) {
						var date = "<tr class=\"minfo\"><td class=\"ninfo\">"
							+ context.mname
							+ "</td><td class=\"tinfo\">"
							+ context.minfo
							+ "</td><td style=\"text-align: center;\">"
							+ context.mrate
							+ "</td><td style=\"text-align: center;\">"
							+ context.mpls
							+ "</td><td ><a style=\"text-align: center;\" target=\"_blank\" href=\""
							+ context.slink
							+ "\">"
							+ "查看详情"
							+ "</a></td><td style=\"text-align: center;\"> "
							+ context.mdate
							+ "</td></tr>";
						$("tbody").append(date);
					    });
			}
		    });
}
// 处理函数(依照需求)
var deal = function(data) {
    $("tbody").html("");
    var json = JSON.parse(data);
    $
	    .each(
		    json.rows,
		    function(selector, context) {
			var date = "<tr class=\"minfo\"><td class=\"ninfo\">"
				+ context.mname
				+ "</td><td class=\"tinfo\">"
				+ context.minfo
				+ "</td><td style=\"text-align: center;\">"
				+ context.mrate
				+ "</td><td style=\"text-align: center;\">"
				+ context.mpls
				+ "</td><td ><a style=\"text-align: center;\" target=\"_blank\" href=\""
				+ context.slink
				+ "\">"
				+ "查看详情"
				+ "</a></td><td style=\"text-align: center;\"> "
				+ context.mdate + "</td></tr>";
			$("tbody").append(date);
		    });
    $('#pagination-demo').twbsPagination({
	totalPages : json.total,
	visiblePages : 7,
	onPageClick : function(event, page) {
	    sortdeal(page);
	}
    });
}

$(function() {
    $(".listtitle span").addClass("glyphicon glyphicon-sort");
});

$(function() {
    var count = 0;
    // 按键触发函数
    $(".listtitle button")
	    .click(
		    function() {
			$("tbody").html("");
			$("#pagination").html("");
			$("#pagination")
				.append(
					"<ul id=\"pagination-demo\" class=\"pagination-sm\"></ul>")
			param.colum = $(this).attr("id");
			count++;
			if (count % 2 == 0)
			    param.sort = "0";
			else {
			    param.sort = "1";
			}
			var page = 1;
			sortdeal(page);
		    });
});
