<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<h3>
	<a
		href="${pageContext.request.contextPath}/fGoods/queryByStatus?status=3">全部商品</a>
	<a
		href="${pageContext.request.contextPath}/fGoods/queryByStatus?status=1">在售商品</a>
	<a
		href="${pageContext.request.contextPath}/fGoods/queryByStatus?status=2">已下架商品</a>
</h3>