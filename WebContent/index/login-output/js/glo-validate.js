/**
 * Created by zxr on 2016/4/20.
 */
var Element = {
    form:'signup-form-area',//id
    Items:[['username','username-tip'],['email','email-tip'],['password','password-tip'],['confirm_password','confirm_password-tip'],['phone','phone-tip']]//需要验证的输入框classname
};
var rules = {
    'username':{
        required:true,
        Length:{
            maxLength:30,
            minLength:2
        },
        ajax:{
            url:'http://localhost:8989/flea/fUser/userNameIsExist',
            method:'post',
            data:{
                userName:function(obj){
                    return obj.value;
                }
            }
        }
    },
    'email':{
        required:true,
        email:true,
        ajax:{
            url:'http://localhost:8989/flea/fUser/emailIsExist',
            method:'post',
            data:{
                email:function(obj){
                    return obj.value;
                }
            }
        }
    },
    'password':{
        required:true,
        Length:{
            maxLength:30,
            minLength:2
        }
    },
    'confirm_password':{
        required:true,
        sameAs:'password'
    },
    'phone':{
        required:true,
        phone:true
    }

}
var glo_validate = (function(){
    var glo_validate = function(elements,rules){
        var elem = elements,
            form = document.getElementById(elem.form),
            Parts = [];
        //既定校验规则集合
        var staticRules = {
            required:{
                message:'此项不能为空',
                test:function(obj){
                    return (obj.value.trim()!=='');
                }
            },
            Length:{
                message:'',
                maxLength:0,
                minLength:0,
                test:function(obj){
                    var pattern = /[\u4e00-\u9fa5]/g,
                        stack = [];
                    for(var i=0;i<obj.value.length;i++){
                        var matched = pattern.exec(obj.value);
                        if(matched){
                            stack.every(function(item,index,array){return item!==matched.index})&&stack.push(matched.index);
                        }
                    }
                    this.message = '长度应在'+this.minLength+'~'+this.maxLength+'之间';
                    return (stack.length+obj.value.length)>=this.minLength&&(stack.length+obj.value.length)<=this.maxLength;
                }
            },
            email:{
                message:'邮箱格式不正确',
                test:function(obj){
                    var pattern = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/;
                    return pattern.test(obj.value);
                }
            },
            phone:{
                message:'手机号码格式不正确',
                test:function(obj){
                    var pattern = /^(13[0-9]|14[0-9]|15[0-9]|18[0-9])\d{8}$/i;
                    return pattern.test(obj.value);
                }
            },
            sameAs:{
                message:'两次输入密码不一致',
                test:function(){
                    var o = arguments[0];
                    return function(obj){
                        return o.value===obj.value;
                    }
                }
            },
            ajax:{
                message:'用户名已存在',
                test:function(url,method,data){
                    return function(obj){
                        for(str in data){
                            if((typeof data[str])==='function'){
                                data[str] = data[str](obj);
                            }else{
                                data[str] = obj.value;
                            }
                        }
                        var resText = XMLasynchronous(method,url,data,false);
                        if(resText==='true'){
                            resText = true;
                        }else{
                            resText = false;
                        }
                        return resText;
                    }

                }
            }
        }
        //测试单位类
        function singlePart(ele){
            this.dom = form.querySelector('.'+ele[0]);
            this.message = form.querySelector('.'+ele[1]);
            //测试栈
            this.testStack = [];
        }
        //单位测试动作
        singlePart.prototype.test = function(){
            //遍历测试栈
            for(var i=0,rule;rule=this.testStack[i++];){
                if(!rule.test(this.dom)){
                    this.message.innerHTML = rule.message;
                    return false;
                }
            }
            this.message.innerHTML = '';
            return true;
        }
        //将每个验证单元推入储存室
        elem.Items.forEach(function(item,index,array){
            var single = new singlePart(item);
            for(str in rules[item[0]]){
                function fn(){}
                fn.prototype = staticRules[str];
                var rule = new fn();
                console.log(rule.message);
                if(str==='require'||str==='email'||str==='phone'){
                    rules[item[0]][str] && single.testStack.push(rule);
                }else if(str==='Length'){
                    rule.maxLength = rules[item[0]][str].maxLength;
                    rule.minLength = rules[item[0]][str].minLength;
                    single.testStack.push(rule);
                }else if(str==='sameAs'){
                    var obj = form.querySelector('.'+rules[item[0]][str]);
                    rule.test = rule.test(obj);
                    single.testStack.push(rule);
                }else if(str==='ajax'){
                    var url = rules[item[0]][str].url,
                        method = rules[item[0]][str].method,
                        data = rules[item[0]][str].data;
                    rule.test = rule.test(url,method,data);
                    single.testStack.push(rule);
                }else{
                    single.testStack.push(rule);
                }
            }
            Parts.push(single);
        });
        //每个single添加事件
        Parts.forEach(function(item,index,array){
            item.dom.addEventListener('blur',function(){
                item.test();
            },false);
        });
        console.log(Parts);
        //总test
        var test = function(){
            return Parts.every(function(item,index,array){
                return item.test();
            });
        }
        //获取当前表单的json数据
        var getFormData = function(){
            var data = {};
            Parts.forEach(function(item,index,array){
                data[item.dom.getAttribute('name')] = item.dom.value.trim();
            });
            return data;
        }
        return {
            test:test,
            getFormData:getFormData
        }
    }

    return {
        init:function(){
            return glo_validate(arguments[0].elements,arguments[0].rules);
        },
        test:function(obj){
            return obj.test();
        },
        getFormData:function(obj){
            return obj.getFormData();
        }
    }
})();
var form1 = glo_validate.init({elements:Element,rules:rules});