<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<head>
<base href="<%=basePath%>">
	<title>CRM统一销售门户</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	<meta http-equiv="pragma" content="no-cache" />
	<meta http-equiv="cache-control" content="no-cache" />
	<meta http-equiv="expires" content="0" />
	<link href="<%=basePath%>/skin/default/css/sysmgr/login/login.css"
		rel="stylesheet" type="text/css" />
	<link href="<%=basePath%>skin/default/css/sysmgr/password/change_password.css" rel="stylesheet" type="text/css" />
	<link type="text/css" rel="stylesheet" href="<%=basePath%>/js/crmpub/prettify-alert/prettify.alert.helper.css" />
	
	<script type="text/javascript">
	var contextPath='<%=basePath%>';
	</script>
	<script type="text/javascript"
		src="<%=basePath%>/js/modules/jquery/1.8.0/jquery-1.8.0.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>/js/crmpub/jquery.utils.js"></script>
	<script type="text/javascript" src="<%=basePath%>/js/crmpub/common.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>/js/modules/jquery/blockui/jquery.blockUI.js"></script>
	<script type="text/javascript" src="<%=basePath%>/js/crmpub/json2.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>/js/crmpub/prettify-alert/prettify.alert.helper.js"></script>
</head>

<body style="overflow-y: hidden">
	<!--top-->
	<div class="top">
		<div class="topMain">
			<div class="logo">
				<a href="javascript:void(0)"><img
					src="<%=basePath%>/skin/default/images/sysmgr/login/logo.png"><span>CRM门户</span>
				</a>
			</div>
			<!--        <div class="help"> -->
			<!--            <a href="###"><img src="<%=basePath%>/skin/default/images/sysmgr/login/icon_help.png">帮助中心</a> -->
			<!--            <a href="###"><img src="<%=basePath%>/skin/default/images/sysmgr/login/icon_online.png">在线客服</a> -->
			<!--        </div> -->
		</div>
	</div>

	<!--banner-->
	<div class="banner01">
		<div class="b_main">
			<!--登陆-->
			<div class="div_login">
				<ul class="title">
					<li class="li_on">会员登录</li>
					<li>扫二维码</li>
				</ul>
				<!--文本输入-->
				<div class="tab">
					<form action="" method="post" id="loginForm">
						<input type="hidden" id="accTypeMark" value="0" /> 
						<input type="hidden" id="theUuid" />
						<div class="input">
							&nbsp;账户 <input type="text" name="userName" id="userid" />
						</div>
						<div class="input">
							&nbsp;密码 <input type="password" name="pwd" id="password" />
						</div>
						<select name="area" id="loginAreaSelect">
						</select> <select name="positionId" id="positionSelect">
						</select>
						<div class="test expand expand-sms">
							<input name="sms" type="text" id="sms" /> <a id="getsms"
								href="javascript:void(0)">获取验证码</a>
						</div>
						<!--                 <p class="tip">忘记密码</p> -->
						<a href="javascript:void(0)" class="btn-login" id="loginBnt">登 录</a>
					</form>
				</div>
				<!--二维码-->
				<div class="tab none">
					<span><img
						src="<%=basePath%>/skin/default/images/sysmgr/login/er.jpg">
					</span>
					<p class="sao">手机扫描 下载客户端</p>
				</div>
			</div>
		</div>
	</div>
	
	<div>
		<%@include file="../password/change_password.jsp" %>
	</div>
	<!--foot-->
	<div class="foot login_foot">
		<p>Copyright © 2015 中国电信股份有限公司广东分公司</p>
	</div>

	<script type="text/javascript"
		src="<%=basePath%>/mgr/sysmgr/login/js/login.js"></script>
	
<script src="<%=basePath%>skin/default/js/common/win.js"></script>
<script src="<%=basePath%>mgr/sysmgr/password/js/change_password.js"></script>
		
</body>
</html>
