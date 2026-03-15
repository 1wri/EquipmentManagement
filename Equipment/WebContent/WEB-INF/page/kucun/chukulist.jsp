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
    <link rel="shortcut icon" href="${ctx}/public/logo.ico" type="image/x-icon" />
    <link rel="stylesheet" href="${ctx}/public/css/font.css">
    <link rel="stylesheet" href="${ctx}/public/css/xadmin.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="${ctx}/public/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="${ctx}/public/js/xadmin.js"></script>
  </head>
  
  <body>
    <div class="x-body">
      <div class="layui-row" style="" align="center">
        <form class="layui-form layui-col-md12 x-so" method="get" action="${ctx }/kucun/chukulist">

          <input type="text" name="content" style="width:50%;"  placeholder="请输入查找设备名称" autocomplete="off" class="layui-input">
          <button class="layui-btn"  lay-submit="" lay-filter="sreach"><i class="layui-icon">&#xe615;</i></button>
        </form>
                </div>
      <table class="layui-table" lay-filter="demo">
        <thead>
          <tr>
            <th lay-data="{field:'equipmentname'}">设备名称</th>
            <th lay-data="{field:'time',sort:true}">时间</th>
            <th lay-data="{field:'shuliang',sort:true}">数量设备</th>
            <th lay-data="{field:'fuzeren'}">负责人</th>
            <th lay-data="{field:'beizhu'}">备注</th>
            <c:if test="${sessionScope.tip  == 1 }">
            <th lay-data="{field:'caozuo'}">操作</th>
            </c:if>
        </thead>
        <tbody>
        <c:forEach items="${requestScope.chukulist}" var="chuku" varStatus="stat">
     <tr>

            <td>${chuku.equipmentname}</td>
            <td>${chuku.time}</td>
            <td>${chuku.shuliang}</td>
            <td>${chuku.fuzeren}</td>
            <td>${chuku.beizhu}</td>

			<c:if test="${sessionScope.tip  == 1 }">
            <td class="td-manage">
             <div class="layui-btn-group">
              <a title="编辑"  class="layui-btn layui-btn-sm layui-btn-warm" href="${ctx}/kucun/chukuadd?id=${chuku.id }">
                <i class="layui-icon">&#xe642;</i>
              </a>
              
              <a title="删除" class="layui-btn layui-btn-sm layui-btn-danger" onclick="member_del(this,'${chuku.id }')" href="javascript:;">
                <i class="layui-icon">&#xe640;</i>
              </a>
              </div>
            </td>
		</c:if>
          </tr>
			</c:forEach>
        </tbody>
      </table>
    </div>
    <script>
    layui.use('table', function(){
	    var table = layui.table;
	  	table.init('demo', {
	    limit: 10
	    ,toolbar:true
	    ,page: true
	  	}); 
});
      /*用户-删除*/
      function member_del(obj,id){
          layer.confirm('确认要删除吗？',function(index){
              //发异步删除数据
              //等以后再使用异步，这里先使用
              $.get("${ctx}/kucun/chukudelete?id="+id);
              $(obj).parents("tr").remove();
              layer.msg('已删除!',{icon:1,time:1000});
          });
      }
    </script>
  </body>

</html>