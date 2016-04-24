//===============强制登录模块=============//
(function(){
    var aForce = document.querySelectorAll('.force'),
        oTop = document.querySelector('#top_bar');
    //===判断是否已登录===//
    var boolean = oTop.querySelectorAll('button');
    //未登录
    if(boolean.length!==0){
        //===添加强制登录事件==//
        for(var i=0,item;item = aForce[i++];){
            item.addEventListener('click',function(e){
                glo_login.pop();
                e.preventDefault();
            },false);
        }
    }
})();
//===============商品点击模块=============//
(function(){
    var aTile = document.querySelectorAll('.float-title');
    for(var i=0,item;item=aTile[i++];){
        item.addEventListener('click',function(e){
            if(/float/.test(e.target.className)){
                var self = this;
                var href = this.querySelector('.float-link').href;
                href = href.split('=');
                XMLasynchronous('get','/flea/fGoods/queryById',{id:href[1]},true,function(err,text){
                    if(err){
                        console.log(err);
                    }else{
                        var data = JSON.parse(text);
                        data.img = self.querySelector('.float-img').src;
                        console.log(data);
                        //glo_float.pop({name:data.name,amount:data.amount,price:data.price,introduction:data.introduction,img:data.img});
                    }
                });
                e.preventDefault()
            }

        },false);
    }
})();

