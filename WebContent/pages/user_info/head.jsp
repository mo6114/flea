<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<s:if test="#session.email == null">
	<div id="top_bar">
		<div class="cart">
			<span class="icon-shopping-cart">&nbsp;</span> <span
				class="mallCart_name"><a href="${pageContext.request.contextPath}/pages/items/shoppingCart.jsp">购物车</a></span> <span class="mallCart_proNum">(0)</span>
			<span class="icon-angle-down">&nbsp;</span>
		</div>
		<div class="btn_set">
			<button class="memberOption memberLogin btn btn-primary">登录</button>
			<button class="memberOption memberReg btn btn-default">注册</button>
		</div>
	</div>
</s:if>
<s:else>
	<div id="top_bar">
		<div class="cart">
			<span class="icon-shopping-cart">&nbsp;</span> <span
				class="mallCart_name"><a href="${pageContext.request.contextPath}/pages/items/shoppingCart.jsp">购物车</a></span> <span class="mallCart_proNum">(0)</span>
			<span class="icon-angle-down">&nbsp;</span>
		</div>
		<div class="btn_set">
			<a href="${pageContext.request.contextPath}/pages/user_info/user_info.jsp"><s:property value = "#session.userName"/></a>
			<a href="${pageContext.request.contextPath}/fUser/quit">退出</a>
		</div>
	</div>
</s:else>