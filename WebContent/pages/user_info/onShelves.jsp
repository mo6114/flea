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
			<nav class="navbar navbar-inverse" role="navigation">
			<jsp:include page="/pages/common/title.jsp"></jsp:include>
			</nav>
		</div>
		<div id="content">
			<jsp:include page="/pages/common/userInfomation.jsp"></jsp:include>
			<div class="right-side">
				<h3>上架新商品</h3>
            <form role="form" action="${pageContext.request.contextPath}/fGoods/onShelves" method = "post" enctype="multipart/form-data">
                <div class="form-group">
                    <label for="inputfile">图片</label>
                    <input type="file" id="inputfile" name = "picture">
                    <p class="help-block">上传您的商品图片</p>
                </div>
                <div class="form-group">
                    <label for="name">名称</label>
                    <input type="text" class="form-control" id="name" name = "name" placeholder="请输入名称">
                </div>
                <div class="form-group">
                    <label for="name">简介</label>
                    <input type="text" class="form-control" id="introduction" name = "introduction" placeholder="请输入简介">
                </div>
                <div class="form-group">
                    <label for="name">价格</label>
                    <input type="text" class="form-control" id="price" name = "price" placeholder="请输入价格">
                </div>
                <div class="form-group">
                    <label for="name">数量</label>
                    <input type="text" class="form-control" id="amount" name = "amount" placeholder="请输入数量">
                </div>
                <div class="form-group">
                    <label for="name">一级菜单</label>
                    <select name = "one_level" class="one_level"></select>
                    <label for="name">二级菜单</label>
                    <select name = "two_level" class="two_level"></select>
                </div>
                    <button type="submit" class="btn btn-default">提交</button>
            </form>
			</div>
		</div>
	</div>
	<script src="../public/jquery/dist/jquery.min.js"></script>
	<script src="../public/bootstrap/dist/js/bootstrap.min.js"></script>
	<script src="../public/login-output/js/XMLasynchronous.js"></script>
	<script src="../public/login-output/js/login-output.js"></script>
	<script src="../public/login-output/js/glo-validate.js"></script>
	<script src="../public/login-output/js/glo-select.js"></script>
	<script src="../public/js/sign-in-up.js"></script>
	<script src="../public/js/categy.js"></script>
</body>
</html>