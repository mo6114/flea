<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<div class="search"></div>
<div class="list-bar">
	<ul class="sortTag">
		<s:if test="#session.orderByNum==1">
			<s:if test="#session.ruleNum!=1">
				<li class="tag"><a
					href="${pageContext.request.contextPath}/fGoods/queryByConditions?orderByNum=1&ruleNum=0">名称降序</a><span></span></li>
			</s:if>
			<s:else>
				<li class="tag"><a
					href="${pageContext.request.contextPath}/fGoods/queryByConditions?orderByNum=1&ruleNum=1">名称升序</a></li>
			</s:else>
		</s:if>
		<s:else>
			<li class="tag"><a
				href="${pageContext.request.contextPath}/fGoods/queryByConditions?orderByNum=1&ruleNum=0">名称降序</a><span></span></li>
		</s:else>

		<s:if test="#session.orderByNum==3">
			<s:if test="#session.ruleNum!=1">
				<li class="tag"><a
					href="${pageContext.request.contextPath}/fGoods/queryByConditions?orderByNum=3&ruleNum=0">价格降序</a><span></span></li>
			</s:if>
			<s:else>
				<li class="tag"><a
					href="${pageContext.request.contextPath}/fGoods/queryByConditions?orderByNum=3&ruleNum=1">价格升序</a></li>
			</s:else>
		</s:if>
		<s:else>
			<li class="tag"><a
				href="${pageContext.request.contextPath}/fGoods/queryByConditions?orderByNum=3&ruleNum=0">价格降序</a><span></span></li>
		</s:else>

		<s:if test="#session.orderByNum==4">
			<s:if test="#session.ruleNum!=1">
				<li class="tag"><a
					href="${pageContext.request.contextPath}/fGoods/queryByConditions?orderByNum=4&ruleNum=0">点击量降序</a><span></span></li>
			</s:if>
			<s:else>
				<li class="tag"><a
					href="${pageContext.request.contextPath}/fGoods/queryByConditions?orderByNum=4&ruleNum=1">点击量升序</a></li>
			</s:else>
		</s:if>
		<s:else>
			<li class="tag"><a
				href="${pageContext.request.contextPath}/fGoods/queryByConditions?orderByNum=4&ruleNum=0">点击量降序</a><span></span></li>
		</s:else>

		<s:if test="#session.orderByNum==2">
			<s:if test="#session.ruleNum!=1">
				<li class="tag"><a
					href="${pageContext.request.contextPath}/fGoods/queryByConditions?orderByNum=2&ruleNum=0">上架日期降序</a><span></span></li>
			</s:if>
			<s:else>
				<li class="tag"><a
					href="${pageContext.request.contextPath}/fGoods/queryByConditions?orderByNum=2&ruleNum=1">上架日期升序</a></li>
			</s:else>
		</s:if>
		<s:else>
			<li class="tag"><a
				href="${pageContext.request.contextPath}/fGoods/queryByConditions?orderByNum=2&ruleNum=0">上架日期降序</a><span></span></li>
		</s:else>

		<%-- <s:if test="#session.ruleNum!=1">
							<li class="tag"><a
								href="${pageContext.request.contextPath}/fGoods/queryByConditions?orderByNum=3&ruleNum=0">价格</a><span></span></li>
						</s:if>
						<li><a
							href="${pageContext.request.contextPath}/fGoods/queryByConditions?orderByNum=3&ruleNum=1">价格升序</a></li>
						<li class="tag"><a
							href="${pageContext.request.contextPath}/fGoods/queryByConditions?orderByNum=4&ruleNum=0">点击量</a><span></span></li> --%>
		<%--<li><a--%>
		<%--href="${pageContext.request.contextPath}/fGoods/queryByConditions?orderByNum=4&ruleNum=1">点击量升序</a></li>--%>
		<%-- <li class="tag"><a
							href="${pageContext.request.contextPath}/fGoods/queryByConditions?orderByNum=2&ruleNum=0">上架日期</a><span></span></li> --%>
		<%--<li><a--%>
		<%--href="${pageContext.request.contextPath}/fGoods/queryByConditions?orderByNum=2&ruleNum=1">上架日期升序</a></li>--%>
	</ul>
</div>
	<div class="item-list">
	<s:iterator var="list" value="#session.fGoodsList" status="times">
		<div class="thumbnail float-title" id="item_3" data-desc="<s:property value='introduction'/>" data-amount="1">
		<img class="float-img"
		src="${pageContext.request.contextPath}/uploadPicture/<s:property value = 'picture'/>">
		<div class="caption">
		<h3>
		<a class="float-link" href = "${pageContext.request.contextPath}/fGoods/queryById?id=<s:property value='id'/>"><s:property value="name" /></a>
		</h3>
		<p>
		价格:¥<span class="price"><s:property value="price" /></span>

		</p>
		<p>
		<a
		href="${pageContext.request.contextPath}/fOrder/insertShoppingCart?id=<s:property value='id'/>"
		class="btn btn-warning force cart" role="button"> 加入购物车 </a> <a
		href="${pageContext.request.contextPath}/fOrder/controlBuySkip?id=<s:property value='id'/>"
		class="btn btn-warning force buy" role="button"> 购买 </a>
		</p>
		</div>
		</div>
		<s:if test="(#times.index+1)%3==0">
			<br>
		</s:if>
	</s:iterator>
	</div>