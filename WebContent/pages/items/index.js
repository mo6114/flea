
//===============商品点击模块=============//
(function(){
    var aTile = document.querySelectorAll('.float-title');
    for(var i=0,item;item=aTile[i++];){
        item.addEventListener('click',function(e){
            if(/float/.test(e.target.className)){
                var self = this;
                var desc = self.dataset.desc||null,
                    //amount = self.dataset.amount||null,
                    name = self.querySelector('.float-link').innerHTML.trim(),
                    price = self.querySelector('.price').innerHTML.trim(),
<<<<<<< HEAD
                    cartHref = self.querySelector('.cart').href,
                    buyHref = self.querySelector('.buy').href,
                    imgSrc = self.querySelector('.float-img').src;
=======
                    //cartHref = self.querySelector('.cart').href || null,
                    //buyHref = self.querySelector('.buy').href || null,
>>>>>>> origin/master
                    data = {
                        name:name,
                        price:price,
                        introduction:desc,
<<<<<<< HEAD
                        amount:amount,
                        cart:cartHref,
                        buy:buyHref,
                        img:imgSrc
=======
                        amount:1,
                        cart:null,
                        buy:null
>>>>>>> origin/master
                    }
                glo_float.pop(data);
                e.preventDefault()
            }
        },false);
    }
})();

