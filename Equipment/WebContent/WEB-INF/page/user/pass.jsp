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
  </head>
  
  <body>
    <div class="x-body">
    
            <form class="layui-form" method="POST" id="dataForm1" >
           <div class="layui-form-item">
              <label for="username" class="layui-form-label">
                  <span class="x-red">*</span>原密码
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="password1" name="password1" required="" lay-verify="required"
                  autocomplete="off" class="layui-input" >
              </div> 
          </div>
           <div class="layui-form-item">
              <label for="username" class="layui-form-label">
                  <span class="x-red">*</span>新密码
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="password2" name="password2" required="" lay-verify="required"
                  autocomplete="off" class="layui-input">
              </div> 
          </div>
      </form>
    
        <form class="layui-form" method="POST" id="dataForm"  action="${ctx}/user/pass">       
           <input type="hidden" name="id" id="id" value="${user.id }" >
           <div class="layui-form-item">
              <label for="username" class="layui-form-label">
                  <span class="x-red">*</span>确认密码
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="password" name="password" required="" lay-verify="required"
                  autocomplete="off" class="layui-input">
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
        	  
        	  var userPwReal="${user.password}";
              if(document.getElementById('dataForm1').password1.value !=userPwReal)
              {
                  alert("原密码不正确");
              }
              
              else if(document.getElementById('dataForm1').password2.value !=document.getElementById('dataForm').password.value)
              {
            	  console.log(document.getElementById('dataForm1').password2.value);
            	  console.log(document.getElementById('dataForm').password.value);
                  alert("两次密码不正确");
              }

              else{
            layer.alert("成功", {icon: 6},function () {
            	document.getElementById('dataForm').submit();
                // 获得frame索引
                var index = parent.layer.getFrameIndex(window.name);
                //关闭当前frame
                parent.layer.close(index);
               
            });
              }
            return false;
          }); 
        });
    </script>
    
  </body>

</html>