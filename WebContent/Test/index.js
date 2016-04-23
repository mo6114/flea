var items = (function(){
    //标签实例栈
    var aSortStack = [];
    function sortTag(obj){
        this.state = obj.state;
        this.dom = obj.dom;
    }
    sortTag.prototype.toggleHref = function(){
        var href;
        if(this.state==='0'){
            this.state = '1';
            href = this.dom.querySelector('a').href.slice(0,this.dom.querySelector('a').href.length-1)+'1';
            this.dom.querySelector('a').href = href;
            this.dom.querySelector('span').className = 'icon-angle-up';
        }else{
            this.state = '0';
            href = this.dom.querySelector('a').href.slice(0,this.dom.querySelector('a').href.length-1)+'0';
            this.dom.querySelector('a').href = href;
            this.dom.querySelector('span').className = 'icon-angle-down';
        }
        this.currentHref = href;
    }
    //构建排序标签实例
    var aTag = document.querySelectorAll('.tag');

    for(var i=0,item;item = aTag[i++];){
        var obj = {};
        //当前排序状态
        item.querySelector('span').className = 'icon-angle-down';
        obj.state = item.querySelector('a').href[item.querySelector('a').href.length-1];
        obj.dom = item;
        aSortStack.push(new sortTag(obj));
    }
    //每个标签类添加点击事件
    aSortStack.forEach(function(item,index,array){
        var self = item;
        item.dom.addEventListener('click',function(e){
            if(e.target===this){
                self.toggleHref();
                console.log(self.currentHref);
            }

        },false);
    });
})()