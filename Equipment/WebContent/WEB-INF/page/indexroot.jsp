<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>设备管理</title>
	<meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta http-equiv="Cache-Control" content="no-siteapp" />

    <link rel="shortcut icon" href="${ctx}/public/logo.ico" type="image/x-icon" />
    <link rel="stylesheet" href="${ctx}/public/css/font.css">
	<link rel="stylesheet" href="${ctx}/public/css/xadmin.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="${ctx}/public/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="${ctx}/public/js/xadmin.js"></script>

</head>
<body>
    <!-- 顶部开始 -->
    <div class="container">
        <div class="logo"><a href="#">企业设备管理系统</a></div>
        
        <ul class="layui-nav right" lay-filter="">
          <li class="layui-nav-item">
            <a href="javascript:;">${sessionScope.user_session.username }</a>
            <dl class="layui-nav-child"> <!-- 二级菜单 -->
           	 
             <dd><a href="${ctx}/user/logout">切换账号</a></dd>
            </dl>
          </li>
          <li class="layui-nav-item to-index"><a>欢迎登录</a></li>
        </ul>
        
    </div>
    <!-- 顶部结束 -->
    <!-- 中部开始 -->
     <!-- 左侧菜单开始 -->
    <div class="left-nav">
      <div id="side-nav">
        <ul id="nav">
            <li>
                <a href="javascript:;">
                    <i class="iconfont">&#xe6b8;</i>
                    <cite>员工管理</cite>
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a _href="${ctx }/user/list">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>员工列表</cite>
                            
                        </a>
                    </li >
                    <li>
                        <a _href="${ctx }/user/add">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>添加员工</cite>
                            </a>
                    </li>  
                </ul>
            </li>
             <li>
                <a href="javascript:;">
                    <i class="iconfont">&#xe6c9;</i>
                    <cite>设备管理</cite>
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a _href="${ctx }/equipment/list">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>设备列表</cite>
                        </a>
                    </li >
                    <li>
                        <a _href="${ctx }/equipment/add">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>添加设备</cite>
                        </a>
                    </li >
                </ul>
            </li>
            <li>
                <a href="javascript:;">
                     <i class="layui-icon">&#xe657;</i>
                    <cite>采购管理</cite>
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a _href="${ctx }/caigou/list">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>采购列表</cite>
                        </a>
                    </li >
                </ul>
            </li>
            <li>
                <a href="javascript:;">
                    <i class="iconfont">&#xe713;</i>
                    <cite>库存管理</cite>
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a _href="${ctx }/kucun/rukulist">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>入库查询</cite>
                        </a>
                    </li >
                     <li>
                        <a _href="${ctx }/kucun/chukulist">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>出库查询</cite>
                        </a>
                    </li >
                     <li>
                        <a _href="${ctx }/kucun/kucunlist">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>库存查询</cite>
                        </a>
                    </li >
                </ul>
            </li>
             <li>
                <a href="javascript:;">
                    <i class="iconfont">&#xe6ae;</i>
                    <cite>设备报修管理</cite>
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a _href="${ctx }/baoxiu/list">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>设备报修列表</cite>
                        </a>
                    </li >
                </ul>
            </li>
                       <li>
                <a href="javascript:;">
                    <i class="iconfont">&#xe6ce;</i>
                    <cite>设备报废管理</cite>
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a _href="${ctx }/baofei/list">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>设备报废列表</cite>
                        </a>
                    </li >
                </ul>
            </li>
        </ul>
      </div>
    </div>
    <!-- <div class="x-slide_left"></div> -->
    <!-- 左侧菜单结束 -->
    <!-- 右侧主体开始 -->
    <div class="page-content">
        <div class="layui-tab tab" lay-filter="xbs_tab" lay-allowclose="false">
          <ul class="layui-tab-title">
            <li class="home"><i class="layui-icon">&#xe68e;</i>我的桌面</li>
          </ul>
          <div class="layui-tab-content">
 
            <div class="layui-tab-item layui-show">
                <iframe src='${ctx}/welcome' frameborder="0" scrolling="yes" class="x-iframe"></iframe>
            </div>
          </div>
        </div>
    </div>
    <div class="page-content-bg"></div>
    <!-- 右侧主体结束 -->
    <!-- 中部结束 -->
    <!-- 底部开始 -->
    <div class="footer">
        <div class="copyright">****</div>  
    </div>
    <!-- 底部结束 -->
 
</body>
</html>