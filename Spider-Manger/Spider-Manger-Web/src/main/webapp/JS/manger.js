$(function() {
    url = "/page/list.action";
    table(url, params);
    $('#demo-table').bootstrapTable('refresh');
});
// 搜索处理
$(function() {
    // 搜索处理
    $("#ok").click(function() {
	var data = $(".form-control option:selected").val();
	var da = $("#search").val();
	if (da == "") {
	    var o = {
		url : "/page/list.action"
	    }
	    $('#demo-table').bootstrapTable('refresh', o); // 刷新表格
	} else {
	    var opt = {
		url : "/search.action?colum=" + data + "&data=" + da,
		silent : true
	    }
	    $('#demo-table').bootstrapTable('refresh', opt); // 刷新表格
	    $('#demo-table').bootstrapTable('refreshOptions', {
		pageNumber : 1
	    });
	}
    });

    $("#update").click(function() {
	var id = $("#id").val();
	var name = $("#name").val();
	var info = $("#info").val();
	var rate = $("#rate").val();
	var pls = $("#pls").val();
	var date = $("#date").val();
	$('#demo-table').bootstrapTable('updateByUniqueId', {
	    id : id,
	    row : {
		mname : name,
		minfo : info,
		mrate : rate,
		mpls : pls,
		mdate : date
	    }
	});
	$('#myModal').modal('hide');
    });
});
// 修改删除
window.operateEvents = {
    'click .like' : function(e, value, row) {
	console.log(row);
	$("#id").val(row.mid);
	$("#name").val(row.mname);
	$("#info").val(row.minfo);
	$("#rate").val(row.mrate);
	$("#pls").val(row.mpls);
	$("#date").val(row.mdate);
	$('#myModal').modal('show');

    },
    'click .remove' : function(e, value, row) {
	$(this).parent().parent().parent().remove();
    }
};

function table(url, param) {
    $('#demo-table').bootstrapTable({
	method : 'POST',
	dataType : 'json',
	contentType : "application/x-www-form-urlencoded",
	cache : false,
	striped : true, // 是否显示行间隔色
	sidePagination : "server", // 分页方式：client客户端分页，server服务端分页（*）
	url : url,
	uniqueId : 'mid',
	height : $(window).height() - 90,
	width : $(window).width(),
	queryParams : params,
	minimumCountColumns : 2,
	pageNumber : 1, // 初始化加载第一页，默认第一页
	pageSize : 20, // 每页的记录行数（*）
	pageList : [ 20, 25, 50, 100 ], // 可供选择的每页的行数（*）
	responseHandler : responseHandler,
	columns : [ {
	    field : 'mid',
	    title : 'ID',
	    align : 'center',
	}, {
	    field : 'mname',
	    title : '名称',
	    align : 'center',
	    width : 120
	}, {
	    field : 'minfo',
	    title : '详情',
	    width : 1000
	}, {
	    field : 'mrate',
	    title : '评分',
	    align : 'center'
	}, {
	    field : 'mpls',
	    title : '评论人数',
	    align : 'center'
	}, {
	    field : 'slink',
	    title : '链接',
	    align : 'center',
	    formatter : function(value, row, index) {
		value = "<a href=\"" + value + "\" target=\"_blank\">详情</a>"
		return value
	    }

	}, {
	    field : 'mdate',
	    title : '日期',
	    align : 'center'
	}, {
	    title : '操作',
	    width : 50,
	    formatter : operateFormatter,
	    events : operateEvents
	} ]
    });
}

function operateFormatter(value, row, index) {
    return [ '<div>',
	    '<a class="like" href="javascript:void(0)" title="Like">',
	    '<i class="glyphicon glyphicon-pencil"></i>', '</a>  ',
	    '<a class="remove" href="javascript:void(0)" title="Remove">',
	    '<i class="glyphicon glyphicon-remove"></i>', '</a>', '</div>' ]
	    .join('');
}
var params = function queryParams(params) {
    var param = {
	limit : this.limit, // 页面大小
	offset : this.offset, // 页码
	page : this.pageNumber,
	rows : this.pageSize
    }
    return param;
}

// 用于server 分页，表格数据量太大的话 不想一次查询所有数据，可以使用server分页查询，数据量小的话可以直接把sidePagination:
// "server" 改为 sidePagination: "client" ，同时去掉responseHandler:
// responseHandler就可以了，
function responseHandler(res) {
    if (res) {
	return {
	    "rows" : res.rows,
	    "total" : res.total
	};
    } else {
	return {
	    "rows" : [],
	    "total" : 0
	};
    }
}
