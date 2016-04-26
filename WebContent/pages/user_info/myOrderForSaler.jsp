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
			<nav class="navbar navbar-inverse" role="navigation"> <jsp:include
				page="/pages/common/title.jsp"></jsp:include> </nav>
		</div>
		<div id="content">
			<jsp:include page="/pages/common/userInfomation.jsp"></jsp:include>
			<!-- 右侧我的商品展示 -->
			<div class="right-side">
				<jsp:include page="/pages/user_info/myOrder/headForSaler.jsp"></jsp:include>

				<s:iterator var="hehe" value="#session.fOrderList">
	sEmail:<s:property value="sEmail" />
	bEmail:<s:property value="bEmail" />
	<s:property value="bEmail"/>
	space:<s:property value="space"/>
	id:<s:property value="id" />
	sEmail:<s:property value="hehe.sEmail"/>
					<br>
					<s:if test="#session.fOrderForSalerStatus==1">
						<a href = "${pageContext.request.contextPath}/fOrder/cancelOrderForSaler?id=<s:property value='id'/>">取消订单</a>
					</s:if>
				</s:iterator>

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
	<script src="../public/login-output/js/login-output.js"></script>
	<script src="../public/login-output/js/glo-validate.js"></script>
	<script src="../public/login-output/js/glo-select.js"></script>
	<script src="../public/js/sign-in-up.js"></script>
</body>
</html>