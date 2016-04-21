<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>用户信息</title>
    <link rel="stylesheet" href="main.css">
    <link rel="stylesheet" href="top_bar.css">
    <link rel="stylesheet" href="search_bar.css">
    <link rel="stylesheet" href="nav.css">
    <link rel="stylesheet" href="login-output/css/login-output.css">
    <link rel="stylesheet" href="login-output/css/select.css">
    <link rel="stylesheet" href="Font-Awesome-3.2.1/Font-Awesome-3.2.1/css/font-awesome.min.css">
    <link rel="stylesheet" href="bootstrap/dist/css/bootstrap.min.css">
</head>
<body>
<div id="huge_wraper">
    <div id="top_bar">
        <div class="cart">
            <span class="icon-shopping-cart">&nbsp;</span>
            <span class="mallCart_name">购物车</span>
            <span class="mallCart_proNum">(0)</span>
            <span class="icon-angle-down">&nbsp;</span>
        </div>
        <div class="btn_set">
            <button class="memberOption memberLogin btn btn-primary">登录</button>
            <button class="memberOption memberReg btn btn-default">注册</button>
        </div>
    </div>
    <div id="search_bar">
        <div class="logo">logo</div>
        <div class="search_box">
            <div class="input-group">
                <input type="text" class="form-control">
               <span class="input-group-btn">
                  <button class="btn btn-default" type="button">
                     <span class="icon-search">&nbsp;</span>搜索
                  </button>
               </span>
            </div>
        </div>
    </div>
    <div id="nav_bar">
        <nav class="navbar navbar-inverse" role="navigation">
            <div>
                <ul class="nav navbar-nav">
                    <li class="active title">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            全部分类 <b class="caret"></b>
                        </a>
                    </li>
                    <li class="title"><a href="#">首页</a></li>
                    <li class="title"><a href="#">热门点击</a></li>
                    <li class="title"><a href="#">拍卖行</a></li>
                </ul>
            </div>
        </nav>
    </div>
    <div id="content"></div>
</div>
<div id="glo-login-cover">
    <div id="glo-login-wraper">
        <div class="cont_tabs_login">
            <ul class='ul_tabs'>
                <li class="active"><a class="signin-btn">登录</a>
                    <span class="linea_bajo_nom"></span>
                </li>
                <li>
                    <a class="signup-btn">注册</a>
                    <span class="linea_bajo_nom"></span>
                </li>
            </ul>
        </div>
        <div class="login-form-area">
            <div class="line">
                <input type="text" class="username" name="username" placeholder="用户名"><br>
            </div>
            <div class="line">
                <input type="password" class="password" name="password" placeholder="密码"><br>
            </div>
            <button class="submit" type="submit">登录</button>
        </div>
        <div class="signup-form-area" id="signup-form-area">
            <div class="line">
                <input type="text" class="username" name="username" placeholder="用户名"><br>
                <label class="tip username-tip"></label>
            </div>
            <div class="line">
                <input type="text" class="email" name="email" placeholder="邮箱"><br>
                <label class="tip email-tip"></label>
            </div>
            <div class="line">
                <input type="password" class="password" name="password" placeholder="密码"><br>
                <label class="tip password-tip"></label>
            </div>
            <div class="line">
                <input type="password" class="confirm_password" placeholder="再次输入密码"><br>
                <label class="tip confirm_password-tip"></label>
            </div>
            <div class="line">
                <input type="text" class="phone" name="phone" placeholder="手机号码"><br>
                <label class="tip phone-tip"></label>
            </div>
            <div id="glo-select">
                <div class="wraper">
                    <ul class="select-list province fold">
                    </ul>
                    <ul class="select-list school fold"></ul>
                </div>
            </div>
            <button class="submit" type="submit">注册</button>
        </div>
    </div>
</div>
<script src="XMLasynchronous.js"></script>
<script src="login-output/jquery/dist/jquery.min.js"></script>
<script src="login-output/js/glo-select.js"></script>
<script src="login-output/js/glo-validate.js"></script>
<script src="login-output/js/login-output.js"></script>
<script src="main.js"></script>

</body>

</html>