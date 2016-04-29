/**
 * Created by zxr on 2016/4/29.
 */
(function(){
    //给每个title添加事件
    var aTitle = document.querySelectorAll('.title-js');
    
    doSameWork(aTitle,function(item){
        item.addEventListener('click',function(){
            glo_float.pop({
                img:'2.jpg',name:'HTTP权威指南',amount:'1',price:'69.6',
                introduction:'商品描述',cart:'#',buy:'#'
            });
            glo_float.pureShow();
        },false)
    });
})();
