<%@ taglib prefix="s" uri="/struts-tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>统计行为的饼图</title>
</head>
<script src="../js/echarts.min.js"></script>
<body>
<%--<s:action name="select_UserAction" executeResult="false"></s:action>--%>
<table border="1" width="100%">
	<tr>
		<th>行为</th>
		<th>人数</th>
	</tr>
	<s:iterator value="#session.userActionMap" var="q" status="st">
		<tr <s:if test="#st.even">style="background-color: #bdc7e2"</s:if>>
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
    var data1 ='${sessionScope.userActionMap}';
    data1= data1.replace(/=/g,":")
    console.log(data1)

    console.log(data1.match(/\w+:\w+/g))
    data1 = data1.replace(/(\w+):(\w+)/g,"\"$1\":\"$2\"")
    console.log(data1)
    datajson = JSON.parse(data1)
    // 指定图表的配置项和数据
    var option = {
        title : {
            text: '统计行为的饼图',
            x:'center'
        },
        tooltip : {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        legend: {
            orient: 'vertical',
            left: 'left',
            data: ['加入购物车','购买','收藏','点击']
        },
        series : [
            {
                name: '行为占比',
                type: 'pie',
                radius : '55%',
                center: ['50%', '60%'],
                data:[
                    {value:datajson.add, name:'加入购物车'},
                    {value:datajson.buy, name:'购买'},
                    {value:datajson.attention, name:'收藏'},
                    {value:datajson.click, name:'点击'}
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
