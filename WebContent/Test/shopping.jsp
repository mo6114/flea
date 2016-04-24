<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<s:property value = "#session.fGoods.name"/><br>
<s:property value = "#session.fGoods.price"/><br>
<form action="${pageContext.request.contextPath}/fOrder/buyOneGoods" method = "post">
	交易地点：<input type = "text" name = "space"><br>
	交易时间：<input type = "text" name = "saleTime"><br>
	<button type = "submit"></button>
</form>
</body>
</html>