# flea<br>
graduation-project<br>
<br>
网站模版：http://mo6114.faisco.cn/<br>
账号：mo6114 <br>
密码：a942170996<br>
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