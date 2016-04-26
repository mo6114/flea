/**
 * Created by zxr on 2016/4/26.
 */
(function(){
    //商品列表对象
    var goodsSelect = (function(){
        var goods = document.querySelectorAll('.item-js');

        //商品栈
        var goodsStack = [];
        //商品类
        function Good(obj){
            this.dom = obj;
            this.name = obj.querySelector('.item_name-js').innerHTML.trim();
            this.price = obj.querySelector('.item_price-js').innerHTML.trim();
            this.cgy = obj.querySelector('.item_cgy-js').innerHTML.trim();
            this.checked = obj.querySelector('.check-js');
        }
        //添加点击事件
        Good.prototype.init = function(){
            var oCheck = this.dom.querySelector('.check-js');
            oCheck.addEventListener('click',function(){
                sumAndnum.set();
            },false);
        }
        //创建商品实例，推入商品栈
        for(var i=0,t;t = goods[i++];){
            var temp = new Good(t);
            temp.init();
            goodsStack.push(temp);
        }
        return {getGoodsStack:function(){return goodsStack}}
    })();

    //下方显示模块
    var sumAndnum = (function(){
        var oNum = document.querySelector('.item-num-js'),
            oSum = document.querySelector('.item-sum-js'),
            sum = 0,num = 0;

        //合计
        var goods = goodsSelect.getGoodsStack();
        function pipe(){
            sum = 0;num = 0;
            goods.forEach(function(item,index,array){
                if(item.checked.checked){
                    num+=1;
                    sum+= parseInt(item.price);
                }
            });
            oNum.innerHTML = num;
            oSum.innerHTML = sum;
        }
        pipe();
        return {
            set:function(){pipe()}
        }
    })();
    //类数组，同样的动作
    function doSameWork(arr,fn){
        for(var i=0,item;item = arr[i++];){
            fn(item,i-1);
        }
    }
    //全选按钮
    var oAll = document.querySelector('.check-all-js'),
        aCheck = document.querySelectorAll('.check-js');

    oAll.addEventListener('click',function(){
        var self = this;
        doSameWork(aCheck,function(item,index){
            item.checked = self.checked;
        });
        sumAndnum.set();
    },false);
})()
