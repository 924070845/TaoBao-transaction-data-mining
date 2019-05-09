<%@ taglib prefix="s" uri="/struts-tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>统计性别的饼图</title>
</head>
<script src="../js/echarts.min.js"></script>
<body>
<table border="1" width="100%">
	<tr>
		<th>性别</th>
		<th>人数</th>
	</tr>
	<%--从session中取出Map，并将其中的key和value遍历--%>
	<s:iterator value="#session.userGenderMap" var="q" status="st">
		<tr>
			<%--q.key可以直接取出Map一条信息中的key,value同理--%>
			<td style="width: 100px"><s:property value="#q.key"/></td>
			<td style="width: 100px"><s:property value="#q.value"/></td>
		</tr>
	</s:iterator>
</table>

<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
<div id="main" align="center" style="width: 600px;height:400px;"></div>
<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main'));

    //get data
    var data1 = '${sessionScope.userGenderMap}';//获取session中的Map集合
    data1 = data1.replace(/=/g, ":")//利用正则表达式，将Map集合中的“=”，换成“：”
    data1 = data1.replace(/(\w+):(\w+)/g, "\"$1\":\"$2\"")//定位到说要的内容
    console.log(data1)//将键值对数据转换成json格式


    datajson = JSON.parse(data1)
    // 指定图表的配置项和数据
    var option = {
        title: {
            text: '统计性别的饼图',
            x: 'center'
        },
        tooltip: {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        legend: {
            orient: 'vertical',
            left: 'left',
            data: ['女性', '男性', '未知']
        },
        series: [
            {
                name: '性别占比',
                type: 'pie',
                radius: '55%',
                center: ['50%', '60%'],
                data: [
                    {value: datajson.woman, name: '女性'},
                    {value: datajson.man, name: '男性'},
                    {value: datajson.unknown, name: '未知'}
                ],
                itemStyle: {
                    emphasis: {
                        shadowBlur: 10,
                        shadowOffsetX: 0,
                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                    }
                }
            }
        ]
    };


    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
</script>
</body>
</html>
