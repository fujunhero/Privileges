<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.eshore.crm.api.sysmgr.model.WebSysstaffBean" %>
<%@ include file="/inc/crminc/crmHeadInc.jsp" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
	Long postId = (Long)session.getAttribute("postId");  
	String staffId = (String)session.getAttribute("staffId");  
	String cityId = (String)session.getAttribute("cityId");  
	String casPath=(String)session.getAttribute("casPath");
	String loginOutPath=casPath+basePath;
	WebSysstaffBean staffBean = (WebSysstaffBean)session.getAttribute("staff"); 
	System.out.println("postId="+postId+",staffId="+staffId+",cityId="+cityId);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<link href="${contextPath}/skin/default/css/sysmgr/index/index.css" rel="stylesheet" type="text/css" />
	</head>

	<body>
		<input type="hidden" id="basePath" value="${contextPath}"/>
		<input type="hidden" id="postId" value="<%=postId %>"/>
		<input type="hidden" id="staffId" value="<%=staffId%>"/>
		<input type="hidden" id="cityId" value="<%=cityId%>"/>
		<!--top-->
		<div class="top">
		   <div class="topMain">
		       <div class="logo"><a href="${contextPath}/mgr/sysmgr/main/index.jsp"><img src="${contextPath}/skin/default/images/sysmgr/index/logo.png"><span>CRM门户</span></a></div>
		       <div class="icons">
		           <a href="###"><span class="on"><img src="${contextPath}/skin/default/images/sysmgr/index/icon01.png"></span></a>
		           <a href="###"><span><img src="${contextPath}/skin/default/images/sysmgr/index/icon02.png"></span><em>5</em></a>
		           <a href="###"><span><img src="${contextPath}/skin/default/images/sysmgr/index/icon03.png"></span></a>
		           <a href="${contextPath}/sysmgr/logout.action"><span><img src="${contextPath}/skin/default/images/sysmgr/index/icon04.png"></span></a>
		       </div>
		   </div>
		</div>
		<div class="nav">
		   <div class="navMain">
		       <ul id="menuInfo">
		            <li><a href="javascript:void(0)" onclick="goToPage('${contextPath}/mgr/sysmgr/main/indexBanner.jsp',1,0,0)" class="active">首页</a></li>
		       </ul>
		   </div>
		</div>
		<!-- main页面 -->
		<div class="main-body" id="mainBody">
			<iframe width="100%" height="100%" id="mainFrame" name="mainFrame" src="${contextPath}/mgr/sysmgr/main/indexBanner.jsp" frameBorder="0">
			</iframe>
		</div>
		
		<!--foot-->
		<div class="foot">
		    <p>Copyright © 2015 中国电信股份有限公司广东分公司</p>
		</div>
		<script src="${contextPath}/mgr/sysmgr/main/js/index.js"></script>
	</body>
</html>
