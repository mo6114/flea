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
		<%-- <div id="top_bar">
        <div class="cart">
            <span class="icon-shopping-cart">&nbsp;</span>
            <span class="mallCart_name">购物车</span>
            <span class="mallCart_proNum">(0)</span>
            <span class="icon-angle-down">&nbsp;</span>
        </div>
        <div class="btn_set">
            <button class="memberOption memberLogin btn btn-primary">登录</button>
            <button class="memberOption memberReg btn btn-default">注册</button>
        </div>
    </div> --%>
		<jsp:include page="/pages/user_info/head.jsp"></jsp:include>
		<div id="search_bar">
			<div class="logo">logo</div>
			<div class="search_box">
				<div class="input-group">
					<input type="text" class="form-control"> <span
						class="input-group-btn">
						<button class="btn btn-default" type="button">
							<span class="icon-search">&nbsp;</span>搜索
						</button>
					</span>
				</div>
			</div>
		</div>
		<div id="nav_bar">
			<nav class="navbar navbar-inverse" role="navigation">
			<div>
				<ul class="nav navbar-nav">
					<li class="active title"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown"> 全部分类 <b class="caret"></b>
					</a></li>
					<li class="title"><a href="#">首页</a></li>
					<li class="title"><a href="#">热门点击</a></li>
					<li class="title"><a href="#">拍卖行</a></li>
				</ul>
			</div>
			</nav>
		</div>
		<div id="content">
			<div class="left-side">
				<h3>个人中心</h3>
				<ul class="nav nav-pills nav-stacked">
					<li><a href="#">我的资料</a></li>
					<li class="dropdown"><a href="#">我是买家</a>
						<ul class="menue">
							<li role="presentation"><a role="menuitem" tabindex="-1"
								href="#">我的订单</a></li>
							<li role="presentation"><a role="menuitem" tabindex="-1"
								href="#">参加的拍卖</a></li>
						</ul></li>
					<li class="active"><a href="#">我是卖家</a>
						<ul class="menue">
							<li role="presentation"><a role="menuitem" tabindex="-1"
								href="#">上架新商品</a>
							</li>
							<li role="presentation"><a role="menuitem" tabindex="-1"
								href="#">已上架商品</a></li>
							<li role="presentation"><a role="menuitem" tabindex="-1"
								href="#">我的订单</a></li>
							<li role="presentation"><a role="menuitem" tabindex="-1"
								href="#">我的拍卖</a></li>
						</ul></li>
				</ul>
			</div>
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
                    <select name = "one_level"><option>1</option></select>
                    <label for="name">二级菜单</label>
                    <select name = "two_level"><option>11</option></select>
                </div>
                    <button type="submit" class="btn btn-default">提交</button>
            </form>
			</div>
		</div>
	</div>
	<div id="glo-login-cover">
		<div id="glo-login-wraper">
			<div class="cont_tabs_login">
				<ul class='ul_tabs'>
					<li class="active"><a class="signin-btn sign-btn"
						data-typ="signin">登录</a> <span class="linea_bajo_nom"></span></li>
					<li><a class="signup-btn sign-btn" data-typ="signup">注册</a> <span
						class="linea_bajo_nom"></span></li>
				</ul>
			</div>
			<div class="login-form-area" data-typ="signin">
				<div class="line">
					<input type="text" class="username" name="username"
						placeholder="用户名/电子邮箱"><br>
				</div>
				<div class="line">
					<input type="password" class="password" name="password"
						placeholder="密码"><br>
				</div>
				<button class="submit" type="submit">登录</button>
			</div>
			<div class="signup-form-area" id="signup-form-area" data-typ="signup">
				<div class="line">
					<input type="text" class="username" name="username"
						placeholder="用户名"><br> <label
						class="tip username-tip"></label>
				</div>
				<div class="line">
					<input type="text" class="email" name="email" placeholder="邮箱"><br>
					<label class="tip email-tip"></label>
				</div>
				<div class="line">
					<input type="password" class="password" name="password"
						placeholder="密码"><br> <label class="tip password-tip"></label>
				</div>
				<div class="line">
					<input type="password" class="confirm_password"
						placeholder="再次输入密码"><br> <label
						class="tip confirm_password-tip"></label>
				</div>
				<div class="line">
					<input type="text" class="phone" name="mobile" placeholder="手机号码"><br>
					<label class="tip phone-tip"></label>
				</div>
				<div id="glo-select">
					<div class="wraper">
						<ul class="select-list province fold">
						</ul>
						<ul class="select-list school fold"></ul>
					</div>
				</div>
				<button class="submit" type="submit">注册</button>
			</div>
		</div>
	</div>
	<script src="../public/jquery/dist/jquery.min.js"></script>
	<script src="../public/bootstrap/dist/js/bootstrap.min.js"></script>
	<script src="../public/login-output/js/XMLasynchronous.js"></script>
	<script src="../public/login-output/js/glo-select.js"></script>
	<script src="../public/login-output/js/glo-validate.js"></script>
	<script src="../public/login-output/js/login-output.js"></script>
	<script src="../public/js/sign-in-up.js"></script>
</body>
</html>