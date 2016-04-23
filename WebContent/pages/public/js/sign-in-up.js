/**
 * Created by zxr on 2016/4/21.
 */
(function(){
    var oTop = document.querySelector('#top_bar'),
        aBtn = oTop.querySelectorAll('.btn'),
        oBtnSet = oTop.querySelector('.btn_set');

    for(var i=0,btn;btn=aBtn[i++];){
        btn.addEventListener('click',function(){
            glo_login.pop();
            glo_login.setCurrent(this.innerHTML+'页面');
        },false)
    }
    //判断结点是否存在指定父元素
    function hasRoot(child,parent){
        while(child.parentNode){
            if(child.parentNode===parent){
                return true;
            }
            child = child.parentNode;
        }
        return false;
    }
    //添加登录注册消失事件
    glo_login.getCover().addEventListener('click',function(e){
        if(!hasRoot(e.target,glo_login.getWraper())){
            glo_login.close();
        }
    },false);
    //注册按钮的事件
    glo_login.getSignup().addEventListener('click',function(){
        if(glo_validate.test(form1)){
            glo_login.sending();
            var oSelect = document.getElementById('glo-select'),
                oProvince = oSelect.querySelector('.province').firstElementChild.innerHTML.trim(),
                oSchool = oSelect.querySelector('.school').firstElementChild.nextElementSibling.innerHTML.trim(),
                data = glo_validate.getFormData(form1);

            data.province = oProvince;
            data.school = oSchool;
            XMLasynchronous('post','/flea/fUser/register',data,true,function(err,res){
                if(err){
                    glo_login.failed();
                }else{
                    if(res){
                        glo_login.success();
                    }
                }
            });
        }
    },false)
    //登录按钮事件
    glo_login.getSignin().addEventListener('click',function(){
        glo_login.sending();
        var user = document.querySelector('.login-form-area').querySelector('.username').value.trim(),
            password = document.querySelector('.login-form-area').querySelector('.password').value.trim();
        var data = {};
        if(/@/.test(user)){
            data.email = user;
        }else{
            data.userName = user;
        }
        data.password = password;
        XMLasynchronous('post','/flea/fUser/login',data,true,function(err,res){
            if(err){
                glo_login.failed();
            }else{
                if(res==='true'){
                    glo_login.success();
                    setTimeout(function(){
                        glo_login.close();
                    },2000);
                }else{
                    glo_login.failed();
                }
            }

        });
    },false);

})();

