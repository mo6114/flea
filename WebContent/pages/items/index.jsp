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
<link rel="stylesheet" href="../public/css/nav.css">
<link rel="stylesheet" href="../public/item_float/glo-float.css">
<link rel="stylesheet"
	href="../public/login-output/css/login-output.css">
<link rel="stylesheet" href="../public/login-output/css/select.css">
<link rel="stylesheet"
	href="../public/Font-Awesome-3.2.1/Font-Awesome-3.2.1/css/font-awesome.min.css">
<link rel="stylesheet"
	href="../public/bootstrap/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="css/index.css">
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
				<!--banner区域-->
				<div class="banner">
					<ul class="banner-list">
						<li><img src="1.jpg"></li>
					</ul>
				</div>
				<!--分类展示-->
				<div class="cgy-block">
					<h2>
						图书<a class="btn btn-link more">更多</a>
					</h2>
					<s:iterator value="#session.book">
					<div class="thumbnail float-title" id="item_3"
						data-desc="<s:property value='introduction'/>" data-amount="1">
						<img class="float-img"
							src="${pageContext.request.contextPath}/uploadPicture/<s:property value = 'picture'/>">
						<div class="caption">
							<h3>
								<a class="float-link"
									href="${pageContext.request.contextPath}/fGoods/queryById?id=<s:property value='id'/>"><s:property
										value="name" /></a>
							</h3>
							<p>
								价格:¥<span class="price"><s:property value="price" /></span>

							</p>
							<p>
								<a
									href="${pageContext.request.contextPath}/fOrder/insertShoppingCart?id=<s:property value='id'/>"
									class="btn btn-warning force cart" role="button"> 加入购物车 </a> <a
									href="${pageContext.request.contextPath}/fOrder/controlBuySkip?id=<s:property value='id'/>"
									class="btn btn-warning force buy" role="button"> 购买 </a>
							</p>
						</div>
					</div>
					</s:iterator>
				</div>
				<div class="cgy-block">
					<h2>
						服装<a class="btn btn-link more">更多</a>
					</h2>
					<s:iterator value="#session.cloth">
					<div class="thumbnail float-title" id="item_3"
						data-desc="<s:property value='introduction'/>" data-amount="1">
						<img class="float-img"
							src="${pageContext.request.contextPath}/uploadPicture/<s:property value = 'picture'/>">
						<div class="caption">
							<h3>
								<a class="float-link"
									href="${pageContext.request.contextPath}/fGoods/queryById?id=<s:property value='id'/>"><s:property
										value="name" /></a>
							</h3>
							<p>
								价格:¥<span class="price"><s:property value="price" /></span>

							</p>
							<p>
								<a
									href="${pageContext.request.contextPath}/fOrder/insertShoppingCart?id=<s:property value='id'/>"
									class="btn btn-warning force cart" role="button"> 加入购物车 </a> <a
									href="${pageContext.request.contextPath}/fOrder/controlBuySkip?id=<s:property value='id'/>"
									class="btn btn-warning force buy" role="button"> 购买 </a>
							</p>
						</div>
					</div>
					</s:iterator>
				</div>
				<div class="cgy-block">
					<h2>
						电子产品<a class="btn btn-link more">更多</a>
					</h2>
					<s:iterator value="#session.electron">
					<div class="thumbnail float-title" id="item_3"
						data-desc="<s:property value='introduction'/>" data-amount="1">
						<img class="float-img"
							src="${pageContext.request.contextPath}/uploadPicture/<s:property value = 'picture'/>">
						<div class="caption">
							<h3>
								<a class="float-link"
									href="${pageContext.request.contextPath}/fGoods/queryById?id=<s:property value='id'/>"><s:property
										value="name" /></a>
							</h3>
							<p>
								价格:¥<span class="price"><s:property value="price" /></span>

							</p>
							<p>
								<a
									href="${pageContext.request.contextPath}/fOrder/insertShoppingCart?id=<s:property value='id'/>"
									class="btn btn-warning force cart" role="button"> 加入购物车 </a> <a
									href="${pageContext.request.contextPath}/fOrder/controlBuySkip?id=<s:property value='id'/>"
									class="btn btn-warning force buy" role="button"> 购买 </a>
							</p>
						</div>
					</div>
					</s:iterator>
				</div>
				<div class="cgy-block">
					<h2>
						其它<a class="btn btn-link more">更多</a>
					</h2>
					<s:iterator value="#session.other">
					<div class="thumbnail float-title" id="item_3"
						data-desc="<s:property value='introduction'/>" data-amount="1">
						<img class="float-img"
							src="${pageContext.request.contextPath}/uploadPicture/<s:property value = 'picture'/>">
						<div class="caption">
							<h3>
								<a class="float-link"
									href="${pageContext.request.contextPath}/fGoods/queryById?id=<s:property value='id'/>"><s:property
										value="name" /></a>
							</h3>
							<p>
								价格:¥<span class="price"><s:property value="price" /></span>

							</p>
							<p>
								<a
									href="${pageContext.request.contextPath}/fOrder/insertShoppingCart?id=<s:property value='id'/>"
									class="btn btn-warning force cart" role="button"> 加入购物车 </a> <a
									href="${pageContext.request.contextPath}/fOrder/controlBuySkip?id=<s:property value='id'/>"
									class="btn btn-warning force buy" role="button"> 购买 </a>
							</p>
						</div>
					</div>
					</s:iterator>
				</div>
			</div>

		</div>
	</div>
	<script src="../public/jquery/dist/jquery.min.js"></script>
	<script src="../public/bootstrap/dist/js/bootstrap.min.js"></script>
	<script src="../public/login-output/js/XMLasynchronous.js"></script>
	<script src="../public/login-output/js/login-output.js"></script>
	<script src="../public/login-output/js/glo-select.js"></script>
	<script src="../public/login-output/js/glo-validate.js"></script>
	<script src="../public/item_float/js/glo-float.js"></script>
	<script src="../public/js/sign-in-up.js"></script>
	<script src="index.js"></script>
</body>
</html>