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
<s:iterator var="list" value="#session.list" status="xixi">
	<s:property value = "#list"/>nn
	<s:property value="#xixi.index"/>
	<s:if test="(#xixi.index+1)%3==0">zzz<br></s:if>
</s:iterator>
<s:iterator value="#session.fGoodsList">
	name:<s:property value="name"/>
	email:<s:property value="email"/>
	id:<s:property value="id"/>
	<br>
</s:iterator>
<s:property value = "#request.fGoods.name"/>
<s:property value = "#request.fGoods.email"/>
</body>
</html>