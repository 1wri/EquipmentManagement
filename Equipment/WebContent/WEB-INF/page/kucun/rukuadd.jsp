<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  
  <head>
    <meta charset="UTF-8">
    <title>欢迎页面-X-admin2.0</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="${ctx}/public/css/font.css">
    <link rel="stylesheet" href="${ctx}/public/css/xadmin.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="${ctx}/public/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="${ctx}/public/js/xadmin.js"></script>
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
      <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
      <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  
  <body>
    <div class="x-body">
        <form class="layui-form" method="POST" id="rukuForm"  action="${ctx}/kucun/rukuadd">
        <input type="hidden" name="id" id="id" value="${ruku.id }" >
          <div class="layui-form-item">
              <label for="username" class="layui-form-label">
                  <span class="x-red">*</span>设备名称
              </label>
              <div class="layui-input-inline">
              <select  name="equipmentname" required="" lay-verify="required">
             <option>${ruku.equipmentname }</option>
 				<c:forEach items="${equipment_list}" var="list"  varStatus="status">
 				<c:if test="${list.name != ruku.equipmentname}">
				<option>${list.name}</option>
				</c:if>
			</c:forEach>
             </select>
              </div>
             
          </div>
    <div class="layui-inline">
      <label class="layui-form-label">
		<span class="x-red">*</span>时间
		</label>
      <div class="layui-input-inline">
        <input type="text" class="layui-input" id="test" name="time" value="${ruku.time}" lay-verify="required">
      </div>
    </div>
          <div class="layui-form-item">
              <label for="phone" class="layui-form-label">
                  <span class="x-red">*</span>数量
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="daxiao" name="shuliang" required="" lay-verify="required"
                  autocomplete="off" class="layui-input" value="${ruku.shuliang }">
              </div>
          </div>
          <div class="layui-form-item">
              <label for="phone" class="layui-form-label">
                  <span class="x-red">*</span>负责人
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="guige" name="fuzeren" required="" lay-verify="required"
                  autocomplete="off" class="layui-input" value="${ruku.fuzeren }">
              </div>
          </div>
          <div class="layui-form-item">
              <label for="phone" class="layui-form-label">
                  <span class="x-red">*</span>备注
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="kucun" name="beizhu" required="" lay-verify="required"
                  autocomplete="off" class="layui-input" value="${ruku.beizhu }">
              </div>
          </div>
          <div class="layui-form-item">
              <label for="L_repass" class="layui-form-label">
              </label>
              <input type="submit" value=" 提交" class="layui-btn" lay-filter="add" lay-submit=""/>
                 
          </div>
      </form>
    </div>
    <script>
        layui.use(['form','layer'], function(){
            $ = layui.jquery;
          var form = layui.form
          ,layer = layui.layer;
          //监听提交
          form.on('submit(add)', function(data){
            //发异步，把数据提交给php
            layer.alert("成功", {icon: 6},function () {
            	document.getElementById('rukuForm').submit();
                // 获得frame索引
                var index = parent.layer.getFrameIndex(window.name);
                //关闭当前frame
                parent.layer.close(index);
               
            });
            return false;
          });

        });
        layui.use('laydate', function(){
        	  var laydate = layui.laydate;
        	  
        	  //执行一个laydate实例
        	  laydate.render({
        	    elem: '#test' //指定元素
        	    	,type: 'datetime'
        	  });
        	});
    </script>
    
  </body>

</html>