/**
 * Created by zxr on 2016/4/18.
 */
var glo_login=(function(){
    var Coverdom = document.getElementById('glo-login-cover'),
        Wraperdom = document.getElementById('glo-login-wraper'),
        LoginForm = document.querySelector('.login-form-area'),
        SignupForm = document.querySelector('.signup-form-area'),
        loginBtn = document.querySelector('.signin-btn'),
        signupBtn = document.querySelector('.signup-btn'),
        regSubmit = SignupForm.querySelector('.submit'),
        logSubmit = LoginForm.querySelector('.submit');

    var current;
    /*注册，登录标签事件*/
    loginBtn.onclick = function(){
        current = logSubmit;
       $(SignupForm).hide();
        $(LoginForm).fadeIn();
        this.parentNode.classList.add('active');
        signupBtn.parentNode.classList.remove('active');
    };
    signupBtn.onclick = function(){
        current = regSubmit;
        $(LoginForm).hide();
        $(SignupForm).fadeIn();
        this.parentNode.classList.add('active');
        loginBtn.parentNode.classList.remove('active');
    };
    return {
        //弹出动作
        pop:function(){
            if(window.getComputedStyle(Coverdom).display!=='none'||window.getComputedStyle(Wraperdom).display!=='none'){
                return false;
            }
            document.body.style.overflow = 'hidden';
            /*清空所有表单域*/
            for(var i=0,input;input = Wraperdom.getElementsByTagName('input')[i++];){
                input.value = '';
            }
            /*清空错误标签*/
            for(var j=0,tip;tip = Wraperdom.getElementsByClassName('tip')[j++];){
                tip.innerHTML = '';
            }
            if(arguments.length===0){
                $(Coverdom).fadeIn();
                $(Wraperdom).fadeIn();
            }else{
                arguments[0].cover(Coverdom);
                arguments[0].wraper(Wraperdom);
            }
            return true;
        },
        //关闭动作
        close:function(){
            if(window.getComputedStyle(Coverdom).display==='none'||window.getComputedStyle(Wraperdom).display==='none'){
                return false;
            }
            document.body.style.overflow = 'auto';
            if(arguments.length===0){
                $(Coverdom).fadeOut();
                $(Wraperdom).fadeOut();
            }else{
                arguments[0].cover(Coverdom);
                arguments[0].wraper(Wraperdom);
            }
            return true;
        },
        sending:function(){
            current.innerHTML = "<span class='icon-spinner'></span>";
        },
        getWraper:function(){
            return Wraperdom;
        },
        getCover:function(){
            return Coverdom;
        },
        getSignin:function(){
            return logSubmit;
        },
        getSignup:function(){
            return regSubmit;
        }
    }
})();

