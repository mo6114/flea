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
				<jsp:include page="/pages/user_info/myOrder/headForBuyer.jsp"></jsp:include>

				<%-- <s:iterator value="#session.fOrderList">
	sEmail:<s:property value="sEmail" />
	bEmail:<s:property value="bEmail" />
	id:<s:property value="id" />
					<br>
					<s:if test="#session.fOrderForBuyerStatus==1">
						<a href = "${pageContext.request.contextPath}/fOrder/confirmOrder?id=<s:property value='id'/>">确认订单</a>
						<a href = "${pageContext.request.contextPath}/fOrder/cancelOrderForBuyer?id=<s:property value='id'/>">取消订单</a>
					</s:if>
				</s:iterator> --%>
				<table class="table table-hover">
					<%-- <caption>我的订单</caption> --%>
					<thead>
					<tr>
						<th>商品名</th>
						<th>价格</th>
						<th>买家邮箱</th>
						<th>卖家邮箱</th>
						<th>交易时间</th>
						<th>交易地点</th>
						<th style="text-align: center">操作</th>
					</tr>
					</thead>
					<tbody>
					
					<s:iterator value="#session.fOrderList">
					<tr>
						<td class="title title-js"><s:property value="name"/></td>
						<td class="price-js"><s:property value="price"/></td>
						<td><s:property value="buyerEmail"/></td>
						<td><s:property value="salerEmail"/></td>
						<td><span class="time"><s:property value="saleTime"/></span></td>
						<td><span class="place"><s:property value="place"/></span></td>
						<s:if test="#session.fOrderForBuyerStatus==1">
						<td style="text-align: center"><a type="button" class="btn btn-link">确认订单</a><a type="button" class="btn btn-link">取消订单</a></td>
						</s:if>
						<s:else>
							<td style="text-align: center">无</td>
						</s:else>
					</tr>
					</s:iterator>
					
					<%-- <tr>
						<td class="title title-js">HTTP权威指南</td>
						<td class="price-js">69.6</td>
						<td>jabbla</td>
						<td>jabbla</td>
						<td><span class="time">2016.2.2</span></td>
						<td><span class="place">吉大南校莘子园</span></td>
						<td style="text-align: center"><a type="button" class="btn btn-link">确认订单</a><a type="button" class="btn btn-link">取消订单</a></td>
					</tr>
					<tr>
						<td class="title title-js">HTTP权威指南</td>
						<td class="price-js">69.6</td>
						<td>jabbla</td>
						<td>jabbla</td>
						<td><span class="time">2016.2.2</span></td>
						<td><span class="place">吉大南校莘子园</span></td>
						<td style="text-align: center"><a type="button" class="btn btn-link">确认订单</a><a type="button" class="btn btn-link">取消订单</a></td>
					</tr> --%>
					</tbody>
				</table>
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
	<script src="../public/item_float/js/glo-float.js"></script>
	<script src="../public/js/myFuncs.js"></script>
	<script src="allGoods.js"></script>
</body>
</html>