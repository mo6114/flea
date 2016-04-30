/**
 * Created by zxr on 2016/4/30.
 */
//简易的underscore实现
(function(){
    //保存当前环境和_标识符的引用
    var root = this;
    var previous = root._;

    //创建_引用
    var _ = function(obj){
        if(obj instanceof _) return obj;
        if(!(this instanceof _)) return new _(obj);
    }
    //将_标识符添加到当前环境
    root._ = _;
    //指定传参规则
    var ruleIt = function(fn,context,argCount){
        if(context===void 0) return fn;
        switch(argCount===null? 3:argCount){
            case 1: return function(value){
                return fn.call(context,value);
            };
            case 2: return function(value,index){
                return fn.call(context,value,index);
            }
            case 3: return function(value,index,arr){
                return fn.call(context,value,index,arr);
            };
        }
        return function(){
            return fn.apply(context,arguments);
        }
    }
    //判断是否是类数组元素
    function isArraylike(arr){
        var length = arr!==null && arr.length;
        return typeof length=='number'&&length>0
    }
    //是否为对象
    _.isObject = function(obj){
        var type = typeof obj;
        return type=='function'||type=='object'&&!!obj
    }
    //将对象的属性所在位置与索引值对应
    _.keys = function(obj){
        if(!_.isObject(obj)) return [];
        if(Object.keys) return Object.keys(obj);
        var ar = [];
        for(var str in obj) if(_.has(obj,str)) ar.push(str);
        return ar;
    }
    //判断对象中是否存在属性
    _.has = function(obj,key){
        return obj!==null && obj.hasOwnProperty(key);
    }
    //遍历数组元素
    _.each = function(obj,fn,context){
        var length,i;
        fn = ruleIt(fn,context);
        if(isArraylike(obj)){
            for(i=0,length=obj.length;i<length;i++){
                fn(obj[i],i,obj);
            }
        }else{
            var keys = _.keys(obj);
            for(i=0,length=keys.length;i<length;i++){
                fn(obj[keys[i]],i,obj);
            }
        }
        return obj
    }

})()

