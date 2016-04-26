<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<div class="left-side">
	<h3>个人中心</h3>
	<ul class="nav nav-pills nav-stacked">
		<li><a href="#">我的资料</a></li>
		<li class="dropdown"><a href="#">我是买家</a>
			<ul class="menue">
				<li role="presentation"><a role="menuitem" tabindex="-1"
					href="${pageContext.request.contextPath}/fOrder/queryByStatusForBuyer?status=4">我的订单</a></li>
				<li role="presentation"><a role="menuitem" tabindex="-1"
					href="#">参加的拍卖</a></li>
			</ul></li>
		<li class="active"><a href="#">我是卖家</a>
			<ul class="menue">
				<li role="presentation"><a role="menuitem" tabindex="-1"
					href="${pageContext.request.contextPath}/pages/user_info/onShelves.jsp">上架新商品</a></li>
				<li role="presentation"><a role="menuitem" tabindex="-1"
					href="${pageContext.request.contextPath}/fGoods/queryByStatus?status=3">我的商品</a></li>
				<li role="presentation"><a role="menuitem" tabindex="-1"
					href="${pageContext.request.contextPath}/fOrder/queryByStatusForSaler?status=4">我的订单</a></li>
				<li role="presentation"><a role="menuitem" tabindex="-1"
					href="#">我的拍卖</a></li>
			</ul></li>
	</ul>
</div>