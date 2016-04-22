<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<h3>上架新商品</h3>
<form role="form"
	action="${pageContext.request.contextPath}/fGoods/onShelves"
	method="post" enctype="multipart/form-data">
	<div class="form-group">
		<label for="inputfile">图片</label> <input type="file" id="inputfile"
			name="picture">
		<p class="help-block">上传您的商品图片</p>
	</div>
	<div class="form-group">
		<label for="name">名称</label> <input type="text" class="form-control"
			id="name" name="name" placeholder="请输入名称">
	</div>
	<div class="form-group">
		<label for="name">简介</label> <input type="text" class="form-control"
			id="introduction" name="introduction" placeholder="请输入简介">
	</div>
	<div class="form-group">
		<label for="name">价格</label> <input type="text" class="form-control"
			id="price" name="price" placeholder="请输入价格">
	</div>
	<div class="form-group">
		<label for="name">数量</label> <input type="text" class="form-control"
			id="amount" name="amount" placeholder="请输入数量">
	</div>
	<div class="form-group">
		<label for="name">一级菜单</label> <select name="one_level"><option>1</option></select>
		<label for="name">二级菜单</label> <select name="two_level"><option>11</option></select>
	</div>
	<button type="submit" class="btn btn-default">提交</button>
</form>