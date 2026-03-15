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

      <table class="layui-table">
        <thead>
          <tr>
            <th>设备名称</th>
            <th>维修时间</th>
            <th>维修原因</th>
            <th>维修结果</th>
            <th>维修人</th>
            <c:if test="${sessionScope.tip  == 1 }">
            <th>操作</th>
            </c:if>
        </thead>
        <tbody>
        <c:forEach items="${requestScope.list}" var="baoxiu" varStatus="stat">
     <tr>

            <td>${baoxiu.equipmentname}</td>
            <td>${baoxiu.weixiushijian}</td>
            <td>${baoxiu.yuanyin}</td>
            <td>${baoxiu.jieguo}</td>
            <td>${baoxiu.weixiuren}</td>

			<c:if test="${sessionScope.tip  == 1 }">
            <td class="td-manage">
              <a title="编辑"  href="${ctx}/baoxiu/add?id=${baoxiu.id }">
                <i class="layui-icon">&#xe642;</i>
              </a>
              <a title="删除" onclick="member_del(this,'${baoxiu.id }')" href="javascript:;">
                <i class="layui-icon">&#xe640;</i>
              </a>
            </td>     
					  </c:if>
          </tr>
			</c:forEach>
        </tbody>
      </table>
    </div>
    <script>
      /*删除*/
      function member_del(obj,id){
          layer.confirm('确认要删除吗？',function(index){
              //发异步删除数据
              //等以后再使用异步，这里先使用
              $.get("${ctx}/baoxiu/delete?id="+id);
              $(obj).parents("tr").remove();
              layer.msg('已删除!',{icon:1,time:1000});
          });
      }
    </script>
  </body>
</html>