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
    /*hideAndshow*/
    function hideAndshow(obj1,obj2){
        current = obj2;
        $(obj1).hide();
        $(obj2).fadeIn();
        for(var i=0,btn;btn = Wraperdom.querySelectorAll('.sign-btn')[i++];){
            if(btn.dataset.typ===obj1.dataset.typ){
                btn.parentNode.classList.remove('active');
            }else if(btn.dataset.typ===obj2.dataset.typ){
                btn.parentNode.classList.add('active');
            }
        }
    }
    /*初始化信息*/
    function initInfo(){
        /*清空所有表单域*/
        for(var i=0,input;input = Wraperdom.getElementsByTagName('input')[i++];){
            input.value = '';
        }
        /*清空错误标签*/
        for(var j=0,tip;tip = Wraperdom.getElementsByClassName('tip')[j++];){
            tip.innerHTML = '';
        }
        /*清理按钮*/
        for(var k=0,btn;btn = Wraperdom.getElementsByTagName('button')[k++];){
            if((k-1)===0){
                btn.innerHTML = '登录';
            }else if((k-1)===1){
                btn.innerHTML = '注册';
            }
        }

    }
    /*注册，登录标签事件*/
    loginBtn.onclick = function(){
        hideAndshow(SignupForm,LoginForm);
    };
    signupBtn.onclick = function(){
        hideAndshow(LoginForm,SignupForm);
    };
    return {
        //弹出动作
        pop:function(){
            if(window.getComputedStyle(Coverdom).display!=='none'||window.getComputedStyle(Wraperdom).display!=='none'){
                return false;
            }
            document.body.style.overflow = 'hidden';
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
            current.querySelector('.submit').innerHTML = "<span class='icon-spinner'></span>";
        },
        success:function(){
            var self = this,name,data = {};
            if(current=== LoginForm){
                name = '登录';
            }else if(current=== SignupForm){
                name = '注册';
            }
            setTimeout(function(){
                current.querySelector('.submit').innerHTML = "<span class='icon-spinner'></span>"+name+"成功";
                current.querySelector('.submit').classList.add('success');
            },2000);
            if(current===SignupForm){
                setTimeout(function(){
                    current.querySelector('.submit').classList.remove('success');
                    self.setCurrent('signin');
                },4000);
            }else if(current===LoginForm){
                setTimeout(function(){
                    self.close();
                    current.querySelector('.submit').classList.remove('success');
                },4000);
                data.user = LoginForm.querySelector('.username').value.trim();
                data.password = LoginForm.querySelector('.password').value.trim();
            }
            return data;
        },
        setCurrent:function(flag){
            initInfo();
            if(flag==='signin'){
                hideAndshow(SignupForm,LoginForm);
            }else if(flag==='signup'){
                hideAndshow(LoginForm,SignupForm);
            }
        },
        failed:function(){
            var self = this;
            setTimeout(function(){
                current.querySelector('.submit').innerHTML = "<span class='icon-spinner'></span>用户名或密码输入错误";
                current.querySelector('.submit').classList.add('failed');
                setTimeout(function(){
                    current.querySelector('.submit').classList.remove('failed');
                    self.setCurrent('signin');

                },2000);
            },2000);
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

