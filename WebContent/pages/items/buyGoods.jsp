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
	<link rel="stylesheet" href="css/shopCart.css">
	<link rel="stylesheet" href="../public/css/all-cgy.css">
	<link rel="stylesheet" href="../public/css/main.css">
	<link rel="stylesheet" href="../public/css/top_bar.css">
	<link rel="stylesheet" href="../public/css/search_bar.css">
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
				<form>
					<table class="table shopCart table-hover">
						<caption><h3>购买商品</h3></caption>
						<thead>
						<tr>
							<th>商品名</th>
							<th>商品分类</th>
							<th>价格</th>

						</tr>
						</thead>
						<tbody>
						<tr class="item-js">
							<td><img src="2.jpg"><span class="item_name-js">HTTP权威指南</span></td>
							<td class="item_cgy-js">图书</td>
							<td class="item_price-js">69.6</td>

						</tr>
						</tbody>
					</table>
					<div class="cal-bar">
						<div class="input-group fl">
							<span class="input-group-addon">交易地址</span>
							<input type="text" class="form-control" name="space" placeholder="请填写您的交易地址">
						</div>
						<div class="input-group fr">
							<span class="input-group-addon">交易时间</span>
							<input type="text" class="form-control" name="saleTime" placeholder="请填写您的交易时间">
						</div>
						<div class="cal-bar_item">合计: ¥<span class="item-sum-js num">52</span></div>
						<button type="button" class="btn btn-info force">确认下单</button>
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
	<script src="shopCart.js"></script>
</body>
</html>