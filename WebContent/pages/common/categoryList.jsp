<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<div class="all-cgy">
	<ul>

		<s:if test="#session.categoryNum==1">
			<li><a class="active"
				href="${pageContext.request.contextPath}/fGoods/queryByConditions?categoryNum=1&ruleNum=0&orderByNum=1">图书
					/ books</a></li>
		</s:if>
		<s:else>
			<li><a
				href="${pageContext.request.contextPath}/fGoods/queryByConditions?categoryNum=1&ruleNum=0&orderByNum=1">图书
					/ books</a></li>
		</s:else>

		<s:if test="#session.categoryNum==11">
			<li><a class="active"
				href="${pageContext.request.contextPath}/fGoods/queryByConditions?categoryNum=11&ruleNum=0&orderByNum=1">小说
					/ xiaoshuo</a></li>
		</s:if>
		<s:else>
			<li><a
				href="${pageContext.request.contextPath}/fGoods/queryByConditions?categoryNum=11&ruleNum=0&orderByNum=1">小说
					/ xiaoshuo</a></li>
		</s:else>

		<s:if test="#session.categoryNum==12">
			<li><a class="active"
				href="${pageContext.request.contextPath}/fGoods/queryByConditions?categoryNum=12&ruleNum=0&orderByNum=1">杂志
					/ magzines</a></li>
		</s:if>
		<s:else>
			<li><a
				href="${pageContext.request.contextPath}/fGoods/queryByConditions?categoryNum=12&ruleNum=0&orderByNum=1">杂志
					/ magzines</a></li>
		</s:else>

		<s:if test="#session.categoryNum==13">
			<li><a class="active"
				href="${pageContext.request.contextPath}/fGoods/queryByConditions?categoryNum=13&ruleNum=0&orderByNum=1">学习资料
					/ studies</a></li>
		</s:if>
		<s:else>
			<li><a
				href="${pageContext.request.contextPath}/fGoods/queryByConditions?categoryNum=13&ruleNum=0&orderByNum=1">学习资料
					/ studies</a></li>
		</s:else>

		<s:if test="#session.categoryNum==2">
			<li><a class="active"
				href="${pageContext.request.contextPath}/fGoods/queryByConditions?categoryNum=2&ruleNum=0&orderByNum=1">服装
					/ cloths</a></li>
		</s:if>
		<s:else>
			<li><a
				href="${pageContext.request.contextPath}/fGoods/queryByConditions?categoryNum=2&ruleNum=0&orderByNum=1">服装
					/ cloths</a></li>
		</s:else>

		<s:if test="#session.categoryNum==21">
			<li><a class="active"
				href="${pageContext.request.contextPath}/fGoods/queryByConditions?categoryNum=21&ruleNum=0&orderByNum=1">上装
					/ cloths</a></li>
		</s:if>
		<s:else>
			<li><a
				href="${pageContext.request.contextPath}/fGoods/queryByConditions?categoryNum=21&ruleNum=0&orderByNum=1">上装
					/ cloths</a></li>
		</s:else>

		<s:if test="#session.categoryNum==22">
			<li><a class="active"
				href="${pageContext.request.contextPath}/fGoods/queryByConditions?categoryNum=22&ruleNum=0&orderByNum=1">下装
					/ cloths</a></li>
		</s:if>
		<s:else>
			<li><a
				href="${pageContext.request.contextPath}/fGoods/queryByConditions?categoryNum=22&ruleNum=0&orderByNum=1">下装
					/ cloths</a></li>
		</s:else>

		<s:if test="#session.categoryNum==23">
			<li><a class="active"
				href="${pageContext.request.contextPath}/fGoods/queryByConditions?categoryNum=23&ruleNum=0&orderByNum=1">套装
					/ cloths</a></li>
		</s:if>
		<s:else>
			<li><a
				href="${pageContext.request.contextPath}/fGoods/queryByConditions?categoryNum=23&ruleNum=0&orderByNum=1">套装
					/ cloths</a></li>
		</s:else>

		<s:if test="#session.categoryNum==24">
			<li><a class="active"
				href="${pageContext.request.contextPath}/fGoods/queryByConditions?categoryNum=24&ruleNum=0&orderByNum=1">鞋子
					/ shoes</a></li>
		</s:if>
		<s:else>
			<li><a
				href="${pageContext.request.contextPath}/fGoods/queryByConditions?categoryNum=24&ruleNum=0&orderByNum=1">鞋子
					/ shoes</a></li>
		</s:else>

		<s:if test="#session.categoryNum==3">
			<li><a class="active"
				href="${pageContext.request.contextPath}/fGoods/queryByConditions?categoryNum=3&ruleNum=0&orderByNum=1">电子产品
					/ eletrics</a></li>
		</s:if>
		<s:else>
			<li><a
				href="${pageContext.request.contextPath}/fGoods/queryByConditions?categoryNum=3&ruleNum=0&orderByNum=1">电子产品
					/ eletrics</a></li>
		</s:else>

		<s:if test="#session.categoryNum==31">
			<li><a class="active"
				href="${pageContext.request.contextPath}/fGoods/queryByConditions?categoryNum=31&ruleNum=0&orderByNum=1">手机
					/ phones</a></li>
		</s:if>
		<s:else>
			<li><a
				href="${pageContext.request.contextPath}/fGoods/queryByConditions?categoryNum=31&ruleNum=0&orderByNum=1">手机
					/ phones</a></li>
		</s:else>

		<s:if test="#session.categoryNum==32">
			<li><a class="active"
				href="${pageContext.request.contextPath}/fGoods/queryByConditions?categoryNum=32&ruleNum=0&orderByNum=1">笔记本电脑
					/ laptop</a></li>
		</s:if>
		<s:else>
			<li><a
				href="${pageContext.request.contextPath}/fGoods/queryByConditions?categoryNum=32&ruleNum=0&orderByNum=1">笔记本电脑
					/ laptop</a></li>
		</s:else>

		<s:if test="#session.categoryNum==33">
			<li><a class="active"
				href="${pageContext.request.contextPath}/fGoods/queryByConditions?categoryNum=33&ruleNum=0&orderByNum=1">平板电脑
					/ broad</a></li>
		</s:if>
		<s:else>
			<li><a
				href="${pageContext.request.contextPath}/fGoods/queryByConditions?categoryNum=33&ruleNum=0&orderByNum=1">平板电脑
					/ broad</a></li>
		</s:else>

		<s:if test="#session.categoryNum==34">
			<li><a class="active"
				href="${pageContext.request.contextPath}/fGoods/queryByConditions?categoryNum=34&ruleNum=0&orderByNum=1">外设
					/ outsets</a></li>
		</s:if>
		<s:else>
			<li><a
				href="${pageContext.request.contextPath}/fGoods/queryByConditions?categoryNum=34&ruleNum=0&orderByNum=1">外设
					/ outsets</a></li>
		</s:else>

		<s:if test="#session.categoryNum==4">
			<li><a class="active"
				href="${pageContext.request.contextPath}/fGoods/queryByConditions?categoryNum=4&ruleNum=0&orderByNum=1">其它
					/ other</a></li>
		</s:if>
		<s:else>
			<li><a
				href="${pageContext.request.contextPath}/fGoods/queryByConditions?categoryNum=4&ruleNum=0&orderByNum=1">其它
					/ other</a></li>
		</s:else>
	</ul>
</div>