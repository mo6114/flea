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
				<form action="${pageContext.request.contextPath}/fOrder/buyOneGoods"
					method="post">
					<img
						src="${pageContext.request.contextPath}/uploadPicture/<s:property value = '#session.fGoods.picture'/>">
					<s:property value="#session.fGoods.name" />
					<s:property value="#session.fGoods.price" />
					1<br> 请填写交易地址：<input type="text" name="space">
					请填写交易时间：<input type="text" name="saleTime">
					<button type="submit">确认下单</button>
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
</body>
</html>