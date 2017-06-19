/**
 * 
 */
$(function() {

    var myChart = echarts.init(document.getElementById('main'));
    myChart.setOption({
	title : {
	    text : '电影分布'
	},
	tooltip : {},
	legend : {
	    data : [ '影片数量' ]
	},
	xAxis : {
	    data : []
	},
	yAxis : {},
	series : [ {
	    name : '影片数量',
	    type : 'bar',
	    data : []
	} ]
    });
    $.get("/chart.action?type=0", function(data, status) {
	var data = JSON.parse(data);
	// 填入数据
	myChart.setOption({
	    xAxis : {
		data : data.x
	    },
	    series : [ {
		// 根据名字对应到相应的系列
		name : '影片数量',
		data : data.y
	    } ]
	});
    });

    var chart1 = echarts.init(document.getElementById('chart1'));
    chart1.setOption({
	title : {
	    text : '影片评分趋势'
	},
	tooltip : {
	    trigger : 'axis',
	    axisPointer : {
		type : 'cross',
		label : {
		    backgroundColor : '#6a7985'
		}
	    }
	},
	legend : {
	    data : [ '神级(9-10分)', '优秀(8-9分)', '良好(7-8分)', '一般(6-7分)',
		    '较差(4-6分)', '烂片(0-4分)' ]
	},
	toolbox : {
	    feature : {
		saveAsImage : {}
	    }
	},
	grid : {
	    left : '3%',
	    right : '4%',
	    bottom : '3%',
	    containLabel : true
	},
	xAxis : [ {
	    type : 'category',
	    boundaryGap : false,
	    data : []
	} ],
	yAxis : [ {
	    type : 'value'
	} ],
	series : [ {
	    name : '烂片(0-4分)',
	    type : 'line',
	    stack : '总量',
	    areaStyle : {
		normal : {}
	    },
	    data : []
	}, {
	    name : '较差(4-6分)',
	    type : 'line',
	    stack : '总量',
	    areaStyle : {
		normal : {}
	    },
	    data : []
	}, {
	    name : '一般(6-7分)',
	    type : 'line',
	    stack : '总量',
	    areaStyle : {
		normal : {}
	    },
	    data : []
	}, {
	    name : '良好(7-8分)',
	    type : 'line',
	    stack : '总量',
	    areaStyle : {
		normal : {}
	    },
	    data : []
	}, {
	    name : '优秀(8-9分)',
	    type : 'line',
	    stack : '总量',
	    label : {
		normal : {}
	    },
	    areaStyle : {
		normal : {}
	    },
	    data : []
	}, {
	    name : '神级(9-10分)',
	    type : 'line',
	    stack : '总量',
	    label : {
		normal : {}
	    },
	    areaStyle : {
		normal : {}
	    },
	    data : []
	} ]
    });
    $.get("/chart.action?type=1", function(data, status) {
	var data = JSON.parse(data);
	// 填入数据
	chart1.setOption({
	    xAxis : {
		data : data.x
	    },
	    series : [ {
		// 根据名字对应到相应的系列
		name : '神级(9-10分)',
		data : data.y0
	    }, {
		name : '优秀(8-9分)',
		data : data.y1
	    }, {
		name : '良好(7-8分)',
		data : data.y2
	    }, {
		name : '一般(6-7分)',
		data : data.y3
	    }, {
		name : '较差(4-6分)',
		data : data.y4
	    }, {
		name : '烂片(0-4分)',
		data : data.y5
	    } ]
	});
    });
});