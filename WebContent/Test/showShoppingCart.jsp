<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Insert title here</title>
</head>
<body>
<s:iterator value="#session.shoppingCart">
	<s:property value="id"/>
	<s:property value="name"/>
</s:iterator>

<form action="${pageContext.request.contextPath}/fOrder/buyGoods" method = "post">
<s:iterator value = "#session.shoppingCart">
	<input type = "checkbox" name = "fGoodsIdList" value = "<s:property value="id"/>"><s:property value="id"/>
</s:iterator>
	<input type = "text" name = "space">
	<input type = "text" name = "saleTime">
	<button type = "submit">tijiao</button>
</form>
</body>
</html>