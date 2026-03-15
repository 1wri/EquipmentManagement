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
      <table id="demo" class="layui-table">
        <thead>
          <tr>
            <th>设备名称</th>
            <th>原因</th>
            <th>状态</th>
            <c:if test="${sessionScope.tip  == 1 }">
            <th>操作</th>
            </c:if>
        </thead>
        <tbody>
        <c:forEach items="${requestScope.list}" var="baofei" varStatus="stat">
     <tr>

            <td>${baofei.equipmentname}</td>
            <td>${baofei.yuanyin}</td>
            
            <c:choose>
		    <c:when test="${baofei.zhuangtai == null}">
		    <td>审核中</td>
		    </c:when>
		    <c:when test="${baofei.zhuangtai == 0}">
		    <td><font color="red">未通过</font></td>
		    </c:when>
		    <c:otherwise>
		    <td><font color="red">通过</font></td>
   			 </c:otherwise>
			</c:choose>

			<c:if test="${sessionScope.tip  == 1 && baofei.zhuangtai == null}">
            <td class="td-manage">
              <a title="通过"  onclick="member_yes(this,'${baofei.id }')" href="javascript:;">
               <i class="layui-icon">&#xe605;</i>
              </a>
              <a title="不通过" onclick="member_no(this,'${baofei.id }')" href="javascript:;">
               <i class="layui-icon">&#x1006;</i>
              </a>
            </td>
            </c:if>       
			<c:if test="${sessionScope.tip  == 1 && baofei.zhuangtai != null}">
            <td>已审核</td>
            </c:if>       
          </tr>
			</c:forEach>
        </tbody>
      </table>
    </div>
    <script>
      /*用户-删除*/
      function member_yes(obj,id){
          layer.confirm('确认要同意吗？',function(index){
              //发异步删除数据
              //等以后再使用异步，这里先使用
              $.get("${ctx}/baofei/yes?id="+id);
              layer.msg('已同意!',{icon:1,time:1000},function(){window.location.replace("${ctx}/baofei/list")});
          });
      }
      function member_no(obj,id){
          layer.confirm('确认要不同意吗？',function(index){
              //发异步删除数据
              //等以后再使用异步，这里先使用
              $.get("${ctx}/baofei/no?id="+id);
              layer.msg('已拒绝!',{icon:1,time:1000},function(){window.location.replace("${ctx}/baofei/list")});
          });
      }
 
    </script>
  </body>

</html>