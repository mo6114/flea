<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<h3>
	<a
		href="${pageContext.request.contextPath}/fOrder/queryByStatusForBuyer?status=4">全部订单</a>
	<a
		href="${pageContext.request.contextPath}/fOrder/queryByStatusForBuyer?status=1">待完成订单</a>
	<a
		href="${pageContext.request.contextPath}/fOrder/queryByStatusForBuyer?status=2">已完成订单</a>
	<a
		href="${pageContext.request.contextPath}/fOrder/queryByStatusForBuyer?status=3">已取消订单</a>
</h3>