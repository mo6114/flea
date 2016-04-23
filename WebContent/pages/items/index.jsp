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
					<li class="active title all"><a href="#"
						class="dropdown-toggle" data-toggle="dropdown"> 全部分类 <b
							class="caret"></b>
					</a></li>
					<li class="title"><a href="#">首页</a></li>
					<li class="title"><a href="#">热门点击</a></li>
					<li class="title"><a href="#">拍卖行</a></li>
				</ul>
			</div>
			</nav>
		</div>
		<div id="content">
			<div class="all-cgy">
				<ul>
					<li><a class="active"
						href="${pageContext.request.contextPath}/fGoods/queryByConditions?categoryNum=1&ruleNum=0">图书
							/ books</a></li>
					<li><a
						href="${pageContext.request.contextPath}/fGoods/queryByConditions?categoryNum=11&ruleNum=0">小说
							/ xiaoshuo</a></li>
					<li><a
						href="${pageContext.request.contextPath}/fGoods/queryByConditions?categoryNum=12&ruleNum=0">杂志
							/ magzines</a></li>
					<li><a
						href="${pageContext.request.contextPath}/fGoods/queryByConditions?categoryNum=13&ruleNum=0">学习资料
							/ studies</a></li>
					<li><a
						href="${pageContext.request.contextPath}/fGoods/queryByConditions?categoryNum=2&ruleNum=0">服装
							/ cloths</a></li>
					<li><a
						href="${pageContext.request.contextPath}/fGoods/queryByConditions?categoryNum=21&ruleNum=0">上装
							/ cloths</a></li>
					<li><a
						href="${pageContext.request.contextPath}/fGoods/queryByConditions?categoryNum=22&ruleNum=0">下装
							/ cloths</a></li>
					<li><a
						href="${pageContext.request.contextPath}/fGoods/queryByConditions?categoryNum=23&ruleNum=0">套装
							/ cloths</a></li>
					<li><a
						href="${pageContext.request.contextPath}/fGoods/queryByConditions?categoryNum=24&ruleNum=0">鞋子
							/ shoes</a></li>
					<li><a
						href="${pageContext.request.contextPath}/fGoods/queryByConditions?categoryNum=3&ruleNum=0">电子产品
							/ eletrics</a></li>
					<li><a
						href="${pageContext.request.contextPath}/fGoods/queryByConditions?categoryNum=31&ruleNum=0">手机
							/ phones</a></li>
					<li><a
						href="${pageContext.request.contextPath}/fGoods/queryByConditions?categoryNum=32&ruleNum=0">笔记本电脑
							/ laptop</a></li>
					<li><a
						href="${pageContext.request.contextPath}/fGoods/queryByConditions?categoryNum=33&ruleNum=0">平板电脑
							/ broad</a></li>
					<li><a
						href="${pageContext.request.contextPath}/fGoods/queryByConditions?categoryNum=34&ruleNum=0">外设
							/ outsets</a></li>
					<li><a
						href="${pageContext.request.contextPath}/fGoods/queryByConditions?categoryNum=4&ruleNum=0">其它
							/ other</a></li>
				</ul>
			</div>
			<div class="show">
				<div class="search"></div>
				<div class="list-bar">
					<ul class="sortTag">
						<li class="tag"><a
							href="${pageContext.request.contextPath}/fGoods/queryByConditions?orderByNum=1&ruleNum=0">名称降序</a></li>
						<li class="tag"><a
							href="${pageContext.request.contextPath}/fGoods/queryByConditions?orderByNum=1&ruleNum=1">名称升序</a></li>
						<li class="tag"><a
							href="${pageContext.request.contextPath}/fGoods/queryByConditions?orderByNum=3&ruleNum=0">价格降序</a></li>
						<li class="tag"><a
							href="${pageContext.request.contextPath}/fGoods/queryByConditions?orderByNum=3&ruleNum=1">价格升序</a></li>
						<li class="tag"><a
							href="${pageContext.request.contextPath}/fGoods/queryByConditions?orderByNum=4&ruleNum=0">点击量降序</a></li>
						<li class="tag"><a
							href="${pageContext.request.contextPath}/fGoods/queryByConditions?orderByNum=4&ruleNum=1">点击量升序</a></li>
						<li class="tag"><a
							href="${pageContext.request.contextPath}/fGoods/queryByConditions?orderByNum=2&ruleNum=0">上架日期降序</a></li>
						<li class="tag"><a
							href="${pageContext.request.contextPath}/fGoods/queryByConditions?orderByNum=2&ruleNum=1">上架日期升序</a></li>
					</ul>
				</div>
				<div class="item-list">
					<s:iterator var="list" value="#session.fGoodsList" status="times">
						<div class="thumbnail" id="item_3">
							<img
								src="${pageContext.request.contextPath}/uploadPicture/<s:property value = 'picture'/>">
							<div class="caption">
								<h3>
									<a><s:property value="name" /></a>
								</h3>
								<p>
									价格:¥
									<s:property value="price" />
								</p>
								<p>
									<a href="#" class="btn btn-warning" role="button"> 加入购物车 </a> <a
										href="#" class="btn btn-warning" role="button"> 购买 </a>
								</p>
							</div>
						</div>
						<s:if test="(#times.index+1)%3==0">
							<br>
						</s:if>
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
	<script src="../public/js/sign-in-up.js"></script>
	<script src="index.js"></script>
</body>
</html>