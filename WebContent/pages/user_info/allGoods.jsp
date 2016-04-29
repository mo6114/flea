<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="UTF-8">
<title>用户信息</title>
<link rel="stylesheet" href="../public/css/main.css">
<link rel="stylesheet" href="../public/css/top_bar.css">
<link rel="stylesheet" href="../public/css/search_bar.css">
<link rel="stylesheet" href="../public/css/nav.css">
<link rel="stylesheet" href="../public/css/user_info_content.css">
	<link rel="stylesheet" href="../public/item_float/glo-float.css">
<link rel="stylesheet" href="allGoods.css">
<link rel="stylesheet"
	href="../public/login-output/css/login-output.css">
<link rel="stylesheet" href="../public/login-output/css/select.css">
<link rel="stylesheet"
	href="../public/Font-Awesome-3.2.1/Font-Awesome-3.2.1/css/font-awesome.min.css">
<link rel="stylesheet"
	href="../public/bootstrap/dist/css/bootstrap.min.css">
</head>
<body>
	<div id="huge_wraper">

		<jsp:include page="/pages/user_info/head.jsp"></jsp:include>
		<jsp:include page="/pages/common/serach.jsp"></jsp:include>
		<div id="nav_bar">
			<nav class="navbar navbar-inverse" role="navigation"> <jsp:include
				page="/pages/common/title.jsp"></jsp:include> </nav>
		</div>
		<div id="content">
			<jsp:include page="/pages/common/userInfomation.jsp"></jsp:include>
			<!-- 右侧我的商品展示 -->
			<div class="right-side">
				<jsp:include page="/pages/user_info/myGoods/head.jsp"></jsp:include>

				<s:iterator value="#session.fGoodsList">
	name:<s:property value="name" />
	email:<s:property value="email" />
	id:<s:property value="id" />
	<s:if test="#session.status==1">
		<a href = "${pageContext.request.contextPath}/fGoods/goodsSoldOut?id=<s:property value='id'/>">下架商品</a>
	</s:if>
					<br>
				</s:iterator>
				<table class="table table-hover">
					<caption>全部商品</caption>
					<thead>
					<tr>
						<th>商品名</th>
						<th>价格</th>
						<th>状态</th>
						<th>操作</th>
					</tr>
					</thead>
					<tbody>
					<tr>
						<td class="title title-js">HTTP权威指南</td>
						<td class="price-js">69.6</td>
						<td>已上架</td>
						<td><button type="button" class="btn btn-info">下架</button></td>
					</tr>
					<tr>
						<td class="title title-js">HTTP权威指南</td>
						<td class="price-js">69.6</td>
						<td>已上架</td>
						<td><button type="button" class="btn btn-info">下架</button></td>
					</tr>
					<tr>
						<td class="title title-js">HTTP权威指南</td>
						<td class="price-js">69.6</td>
						<td>已上架</td>
						<td><button type="button" class="btn btn-info">下架</button></td>
					</tr>
					</tbody>
				</table>

			</div>

		</div>

	</div>

	<script src="../public/jquery/dist/jquery.min.js"></script>
	<script src="../public/bootstrap/dist/js/bootstrap.min.js"></script>
	<script src="../public/login-output/js/XMLasynchronous.js"></script>
	<script src="../public/item_float/js/glo-float.js"></script>
	<script src="../public/js/myFuncs.js"></script>
	<script src="allGoods.js"></script>
</body>
</html>