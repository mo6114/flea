<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="UTF-8">
<title>商品列表</title>
<link rel="stylesheet" href="css/item.css">
<link rel="stylesheet" href="../public/css/all-cgy.css">
<link rel="stylesheet" href="../public/css/main.css">
<link rel="stylesheet" href="../public/css/top_bar.css">
<link rel="stylesheet" href="../public/css/search_bar.css">
<link rel="stylesheet" href="shopCart-1.css">
<link rel="stylesheet" href="../public/css/nav.css">
<link rel="stylesheet" href="../public/item_float/glo-float.css">
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
			<jsp:include page="/pages/common/categoryList.jsp"></jsp:include>
			<!-- 右侧商品展示 -->
			<div class="show">
				<%-- <form action="${pageContext.request.contextPath}/fOrder/buyGoods"
					method="post">
					<s:iterator value="#session.shoppingCart">
						<input type="checkbox" name="fGoodsIdList"
							value="<s:property value="id"/>">
						<img
							src="${pageContext.request.contextPath}/uploadPicture/<s:property value = 'picture'/>">
						<s:property value="name" />
						<s:property value="price" />
				1<br>
					</s:iterator>
					请填写交易地址：<input type="text" name="space"> 请填写交易时间：<input
						type="text" name="saleTime">
					<button type="submit">确认下单</button>
				</form> --%>

				<form action="${pageContext.request.contextPath}/fOrder/buyGoods"
					method="post">
					<table class="table table-hover">
						<caption>
							<h1>购物车</h1>
						</caption>
						<thead>
							<tr>
								<th><input type="checkbox" class="all-js">全选</th>
								<th>商品图片</th>
								<th>商品名称</th>
								<th>商品价格</th>
							</tr>
						</thead>
						<tbody>
							<s:iterator value="#session.shoppingCart">
								<tr class="good-js">
									<td><input class="check-js" type="checkbox"
										name="fGoodsIdList" value="<s:property value="id"/>"></td>
									<td class="good-img"><img
										src="${pageContext.request.contextPath}/uploadPicture/<s:property value = 'picture'/>">
									</td>
									<td><s:property value="name" /></td>
									<td class="price-js"><s:property value="price" /></td>
								</tr>
							</s:iterator>
							<!-- 
					<tr class="good-js">
						<td><input class="check-js" type="checkbox"></td>
						<td class="good-img"><img src="2.jpg">HTTP权威指南</td>
						<td class="price-js">69.9</td>
					</tr>
					<tr class="good-js">
						<td><input class="check-js" type="checkbox"></td>
						<td class="good-img"><img src="2.jpg">HTTP权威指南</td>
						<td class="price-js">69.9</td>
					</tr> -->
						</tbody>
					</table>
					<div class="info">
						<span>已选商品<span class="num num-js">0</span>件
						</span> <span>合计￥<span class="num total-js">0</span></span> <a
							type="button" class="btn btn-success">确认下单</a>
					</div>
				</form>
			</div>

		</div>
	</div>
	<script src="../public/jquery/dist/jquery.min.js"></script>
	<script src="../public/bootstrap/dist/js/bootstrap.min.js"></script>
	<script src="../public/login-output/js/XMLasynchronous.js"></script>
	<script src="../public/login-output/js/login-output.js"></script>
	<script src="../public/login-output/js/glo-select.js"></script>
	<script src="../public/login-output/js/glo-validate.js"></script>
	<script src="../public/js/sign-in-up.js"></script>
	<script src="index.js"></script>
	<script src="myself-1.js"></script>
	<script src="shopCart-1.js"></script>
</body>
</html>