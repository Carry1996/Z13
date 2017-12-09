<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="layui/css/layui.css">
<style>
.infoBox {
float:right;
}
</style>
</head>
<body>

<div class="layui-tab">
<div class="layui-side layui-bg-black kit-side">
                   

  <ul class="layui-tab-title navContent layui-nav layui-nav-tree layui-inline">
    <li class="logo layui-nav-item">网站设置</li>
    <li class="book layui-nav-item">用户管理</li>
    <li class="box layui-nav-item">权限分配</li>
    <li class="box1 layui-nav-item">商品管理</li>
    <li class="contact layui-nav-item">订单管理</li>
  </ul>
  <div class="layui-tab-content infobox">
    <div class="layui-tab-item infBox" >
      1. 高度默认自适应，也可以随意固宽。
      <br>2. Tab进行了响应式处理，所以无需担心数量多少。
    </div>
    <div class="layui-tab-item secondInfo" >内容2</div>
    <div class="layui-tab-item thirdInfo" >内容3</div>
    <div class="layui-tab-item fourInfo" >内容4</div>
    <div class="layui-tab-item lastInfo" >内容5</div>
  </div>
</div>

</div>
           
<script src="layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
layui.use('element', function(){
  var $ = layui.jquery
  ,element = layui.element; //Tab的切换功能，切换事件监听等，需要依赖element模块
  
  //触发事件
  var active = {
    tabAdd: function(){
      //新增一个Tab项
      element.tabAdd('demo', {
        title: '新选项'+ (Math.random()*1000|0) //用于演示
        ,content: '内容'+ (Math.random()*1000|0)
        ,id: new Date().getTime() //实际使用一般是规定好的id，这里以时间戳模拟下
      })
    }
    ,tabDelete: function(othis){
      //删除指定Tab项
      element.tabDelete('demo', '44'); //删除：“商品管理”
      
      
      othis.addClass('layui-btn-disabled');
    }
    ,tabChange: function(){
      //切换到指定Tab项
      element.tabChange('demo', '22'); //切换到：用户管理
    }
  };
  
  $('.site-demo-active').on('click', function(){
    var othis = $(this), type = othis.data('type');
    active[type] ? active[type].call(this, othis) : '';
  });
  
  //Hash地址的定位
  var layid = location.hash.replace(/^#test=/, '');
  element.tabChange('test', layid);
  
  element.on('tab(test)', function(elem){
    location.hash = 'test='+ $(this).attr('lay-id');
  });
  
});
</script>

</body>
</html>