# flea<br>
graduation-project<br>
<br>
网站模版：http://mo6114.faisco.cn/<br>
账号：mo6114 <br>
密码：a942170996<br>
<br>
商品类别<br>
图书(1)：小说(11)、杂志(12)、学习资料(13)<br>
服装(2)：上装(21)、下装(22)、整套服装(23)、鞋子(24)<br>
电子产品(3)：手机(31)、笔记本电脑(32)、平板电脑(33)、外设(34)<br>
其他(4)：其他(41)<br>
<br>
排序规则<br>
传递0表示升序<br>
传递1表示降序<br>
<br>
上架：规格（中文名——表单名）（表单项顺序未定，先看着弄，有遗忘项请提醒）<br>
名称——name<br>
一级类别——one_level<br>
二级类别——two_level（这两个类别做成一个下拉列表，选完一级类别后，选择二级类别；或者做成类似学校那样。内容待定）<br>
图片——picture（上传文件）<br>
简介——introduction<br>
价格——price<br>
数量——amount（默认1）<br>
<br>
登陆规格<br>
用户名——userName（允许是用户名或邮箱）<br>
密码——password<br>
<br>
登陆、退出注意事项<br>
登陆、退出成功时返回字符串“true”<br>
登陆失败时返回字符串“false”<br>
<br>
表单提交地址<br>
注册：${pageContext.request.contextPath}/fUser/register<br>
登陆：${pageContext.request.contextPath}/fUser/login<br>
退出：${pageContext.request.contextPath}/fUser/quit<br>
上架新商品：${pageContext.request.contextPath}/fGoods/onShelves(Test/shelves.jsp为示例)<br>
验证用户名是否存在：/flea/fUser/userNameIsExist<br>
验证邮箱是否存在：/flea/fUser/emailIsExist<br>
<br>