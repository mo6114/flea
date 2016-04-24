<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<div>
	<ul class="nav navbar-nav">
		<li class="active title all"><a href="#" class="dropdown-toggle"
			data-toggle="dropdown"> 全部分类 <b class="caret"></b>
		</a></li>
		<li class="title"><a href="${pageContext.request.contextPath}/pages/items/index.jsp">首页</a></li>
		<li class="title"><a href="#">热门点击</a></li>
		<li class="title"><a href="#">拍卖行</a></li>
	</ul>
</div>