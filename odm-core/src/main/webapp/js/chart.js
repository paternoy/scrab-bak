var margin = {
	top : 20,
	right : 20,
	bottom : 30,
	left : 50
}, width = 460 - margin.left - margin.right, height = 200 - margin.top
		- margin.bottom;

var parseDate = d3.time.format("%d-%b-%y").parse;

var x = d3.time.scale().range([ 0, width ]);

var y = d3.scale.linear().range([ height, 0 ]);

var xAxis = d3.svg.axis().scale(x).orient("bottom");

var yAxis = d3.svg.axis().scale(y).orient("left");

var line = d3.svg.line().x(function(d) {
	return x(d.dateTime);
}).y(function(d) {
	return y(d.value);
});

var svg = d3.select("#chart").append("svg").attr("width",
		width + margin.left + margin.right).attr("height",
		height + margin.top + margin.bottom).append("g").attr("transform",
		"translate(" + margin.left + "," + margin.top + ")");
var datavalues;
d3.json("/odm-core/api/datavalues/series?variableCode=VAR02&beginDateTime=2013-07-20",function(data){
	data.forEach(function(d) {
		d.dateTime = new Date(d.dateTime);
		d.value = +d.value;
	});
//	alert(data.length);
	datavalues=data;
	x.domain(d3.extent(data, function(d) {
		return d.dateTime;
	}));
	y.domain(d3.extent(data, function(d) {
		return d.value;
	}));
	svg.append("path").datum(data).attr("class", "line").attr("d", line);
});



svg.append("g").attr("class", "x axis").attr("transform",
		"translate(0," + height + ")").call(xAxis);

svg.append("g").attr("class", "y axis").call(yAxis).append("text").attr("y", 6).attr("dy", ".71em").style(
		"text-anchor", "end");


