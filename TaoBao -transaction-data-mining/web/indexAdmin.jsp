<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>管理员首页</title>
	<style>
		body{
			background-image: url("admin/图.jpg");
			background-size: cover;
			width: 100%;
			overflow-x: hidden;
			overflow-y: hidden;
		}
		li{
			height:40px;
			line-height:20px;
		}
		a{
			text-decoration:none;
			color: darkslateblue;
		}
		.left-menu{
			float: left;
			border: 20px;
			margin: auto;
			background-color: #DCDEE0;
			width: auto;
			height: 500px;
			opacity: 0.7;
			position: relative;
			left: 15px;
		}
		iframe{
			width: 83%;
			height: 500px;
			background-color: #DCDEE0;
			opacity: 0.7;
			float: right;
			position: relative;
			right: 40px;
		}
		.box{
			background: center 20px;
			margin: auto;
			border: 20px;
			position: relative;
			top: 130px;
		}
	</style>
</head>
<body>
<%--头部--%>
<div align="center" name="Head">
	<jsp:include page="template/top_nav.jsp" />
</div>

<div class="box">
	<div class="left-menu">
		<ul>
			<li><a href="selectGenderNum" target="Myiframe">男女对比</a></li>
			<li><a href="selectActionNum" target="Myiframe">行为对比&emsp;&emsp;</a></li>
			<li><a href="selectAge_rangeNum" target="Myiframe">年龄段对比</a></li>
			<li><a href="selectUserRules" target="Myiframe">关联规则汇总</a></li>
		</ul>
	</div>
	<%--&emsp;&emsp;&emsp;&emsp;--%>
	<div class="show-body">
		<iframe name="Myiframe" src="content/welcome.jsp"></iframe>
	</div>
</div>

<%--尾部--%>
<div align="center" name="bottom">
	<jsp:include page="template/bottom.jsp"/>
</div>
</body>
</html>
