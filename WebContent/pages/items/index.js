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
                var href = this.querySelector('.float-link').href,
                    desc = self.dataset.desc,
                    amount = self.dataset.amount,
                    name = self.querySelector('.float-link').innerHTML.trim(),
                    price = self.querySelector('.price').innerHTML.trim(),
                    cartHref = self.querySelector('.cart').href,
                    buyHref = self.querySelector('.buy').href,
                    data = {
                        name:name,
                        price:price,
                        introduction:desc,
                        amount:amount,
                        cart:cartHref,
                        buy:buyHref
                    }
                glo_float.pop(data);
                e.preventDefault()
            }

        },false);
    }
})();

