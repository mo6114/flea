/**
 * Created by zxr on 2016/4/30.
 */
(function(){
    var goods = (function(){
        var goodStack = [];

        function Good(obj){
            this.checked = obj.querySelector('.check-js');
            this.price = obj.querySelector('.price-js');
        }
        //新建Good实例并推入goodSrack
        function add(item){goodStack.push(new Good(item));}
        var aTr = document.querySelectorAll('.good-js');
        _.each(aTr,add);
        return {
            getData:function(){
                var sum=0,num=0;
                goodStack.forEach(function(item){
                    if(item.checked.checked){
                        num++;
                        sum += parseInt(item.price.innerHTML);
                    }
                });
                return {num:num,sum:sum};
            }
        }
    })()
    //添加事件
    var oAll = document.querySelector('.all-js');
    var aCheck = document.querySelectorAll('.check-js');
    var oNum = document.querySelector('.num-js');
    var oSum = document.querySelector('.total-js');

    function update(){
        //获取数据加入到展示块
        var num = goods.getData().num;
        var sum = goods.getData().sum;
        oNum.innerHTML = num;
        oSum.innerHTML = sum;
    }
    oAll.addEventListener('click',function(){
        _.each(aCheck,function(item){item.checked = oAll.checked;});
        update();
    },false);
    document.addEventListener('click',function(e){
        if(e.target.className==='check-js') update();
    },false)
})()