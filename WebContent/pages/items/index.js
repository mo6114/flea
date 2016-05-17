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
                    imgSrc = self.querySelector('.float-img').src;
                    data = {
                        name:name,
                        price:price,
                        introduction:desc,
                        amount:amount,
                        cart:cartHref,
                        buy:buyHref,
                        img:imgSrc
                    }
                glo_float.pop(data);
                e.preventDefault()
            }

        },false);
    }
})();
//===============加入购物车模块=============//
(function(){
	var aCart = document.querySelectorAll('.cart'),
		aC = [];
	for(var i=0;i<aCart.length;i++){
		if(aCart[i].tagName==='A'){
			aC.push(aCart[i]);
		}
	}
	aC.forEach(function(item,index,array){
		item.onclick = function(){
			item.innerHTML = '发送中....';
			item.classList.remove('btn-warning');
			item.classList.add('btn-info');
			var state = true;
			//模拟数据接受过程
			setTimeout(function(){
				if(state){
					item.innerHTML = '加入成功';
					item.classList.remove('btn-info');
					item.classList.add('btn-success');
				}
			},5000);
		}
	});
})();
