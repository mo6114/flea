(function(){
	var data = [
	            {superC:{name:'图书',value:1},subC:[{name:'小说',value:11},{name:'杂志',value:12},{name:'学习资料',value:13}]},
	            {superC:{name:'服装',value:2},subC:[{name:'上装',value:21},{name:'下装',value:22},{name:'整套服装',value:23},{name:'鞋子',value:24}]},
	            {superC:{name:'电子产品',value:3},subC:[{name:'手机',value:31},{name:'笔记本电脑',value:32},{name:'外设',value:34}]},
	            {superC:{name:'其它',value:4},subC:[{name:'其它',value:41}]}
	            ];
	
	var oneLevel = document.querySelector('.one_level'),
		twoLevel = document.querySelector('.two_level');
	
	//初始化一级菜单
	for(var i=0;i<data.length;i++){
		var option = document.createElement('option');
		
		option.value = data[i].superC.value;
		option.innerHTML = data[i].superC.name;
		
		oneLevel.appendChild(option);
	}
	//初始化二级菜单
	for(var j=0;j<data[0].subC.length;j++){
		var option = document.createElement('option');
		
		option.value = data[0].subC[j].value;
		option.innerHTML = data[0].subC[j].name;
		twoLevel.appendChild(option);
	}
	//返回一级菜单对应二级菜单数组
	function findTwo(value){
		var result;
		data.forEach(function(item,index,array){
			if(item.superC.value===parseInt(value)) result = item.subC;
			
		});
		return result
	}
	//一级菜单事件
	oneLevel.addEventListener('change',function(){
		//同步一级菜单,二级菜单
		var result = findTwo(this.value);
		twoLevel.innerHTML = '';
		for(var t = 0;t<result.length;t++){
			var option = document.createElement('option');
			option.value = result[t].value;
			option.innerHTML = result[t].name;
			twoLevel.appendChild(option);
		}
	},false);
	
})();