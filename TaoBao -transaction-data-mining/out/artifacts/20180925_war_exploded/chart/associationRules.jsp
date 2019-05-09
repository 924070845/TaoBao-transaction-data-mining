<%@ taglib prefix="s" uri="/struts-tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>关联规则分析</title>
</head>
<script src="../js/echarts.min.js"></script>
<body>
<%--<s:action name="select_UserAction" executeResult="false"></s:action>--%>
<table border="1" width="100%">
	<tr>
		<th>关联规则</th>
		<th>频次</th>
	</tr>
	<tr>
		<th >
			gender | 性别:0表示女性，1表示男性，2和NULL表示未知 <br>
			age_range | 买家年龄分段：1表示年龄<18,2表示年龄在[18,24]，3表示年龄在[25,29]，4表示年龄在[30,34]，<br>
			5表示年龄在[35,39]，6表示年龄在[40,49]，7和8表示年龄>=50,0和NULL则表示未知 <br>
			action | 行为,取值范围{0,1,2,3},0表示点击，1表示加入购物车，2表示购买，3表示关注商品 <br>
			brand_id | 品牌id <br>
			cat_id | 商品类别 <br>
		</th>
	</tr>
	<s:iterator value="#session.userRulesMap" var="q" status="st">
		<tr>
				<%--<td style="width: 100px"><s:property value="#q.gender0Num"/></td>--%>
			<td style="width: 100px"><s:property value="#q.key"/></td>
			<td style="width: 100px"><s:property value="#q.value"/></td>
		</tr>
	</s:iterator>
</table>

</body>
</html>
