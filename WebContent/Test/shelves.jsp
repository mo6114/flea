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
	<form action="${pageContext.request.contextPath}/fGoods/onShelves" method = "post" enctype="multipart/form-data">
		图片：<input type = "file" name = "picture">
		名称：<input type = "text" name = "name">
		一级：<input type = "text" name = "one_level">
		二级：<input type = "text" name = "two_level">
		简介：<input type = "text" name = "introduction">
		价格：<input type = "text" name = "price">
		数量：<input type = "text" name = "amount">
		<input type = "submit">
	</form>
</body>
</html>