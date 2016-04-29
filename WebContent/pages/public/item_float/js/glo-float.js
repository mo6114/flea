/**
 * Created by zxr on 2016/4/23.
 */
var glo_float = (function(){
    //======浮窗类=====//
    function float(){
        this.dom = document.createElement('div');
    }
    float.prototype.putData = function(data){
        this.data = data;
        this.createDom()
    }
    float.prototype.createDom = function(){
        this.dom.id = 'glo-float-cover';
        this.dom.innerHTML = '<div class="glo-float-wraper">    <div class="show-area">        <div class="img">            <img src="'+this.data.img+'">        </div>        <div class="des">            <div class="line book-name">名称: <span>'+this.data.name+'</span></div>            <div class="line author-name">库存: <span>'+this.data.amount+'</span></div>            <div class="line price">价格: RMB<span>'+this.data.price+'</span></div>            <div class="detail">                <h3>商品描述</h3>                <p>'+this.data.introduction+'</p>            </div>        </div>    </div>    <div class="btn-set">        <a type="button" href="'+this.data.cart+'" class="btn btn-warning force cart">加入购物车</a>        <a type="button" href="'+this.data.buy+'" class="btn btn-danger force buy">立即购买</a>    </div>    <a class="back">关闭窗口</a></div>';
        document.body.insertBefore(this.dom,document.body.firstElementChild);
        //=======添加关闭事件=======//
        var oClose = this.dom.querySelector('.back'),
            self = this;
        oClose.addEventListener('click',function(){
            $(self.dom).fadeOut();
        }
        ,false);
    }
    //=====浮窗实例=====//
    var instance;
    return {
        //====初始化创建浮窗====//
        init:function(){
            if(instance){
                return instance
            }
            instance = new float();
        },
        pop:function(data){
            if(instance){
                instance.dom.style.top = document.body.scrollTop+'px';
                document.body.style.overflow = 'hidden';
                instance.putData(data);
                $(instance.dom).fadeIn();
            }else{
                alert('请先初始化浮窗');
            }

        },
        pureShow:function(){
            var oCart = instance.dom.querySelector('.cart');
            var oBuy = instance.dom.querySelector('.buy');
            oCart.style.display = 'none';
            oBuy.style.display = 'none';

        }
    }
})();
glo_float.init();