<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
	<head>
		<%@include file="/inc/crminc/crmHeadInc.jsp"%>
		<link href="${contextPath}/skin/default/css/sysmgr/index/indexBanner.css"
			rel="stylesheet" type="text/css" />
	</head>
	<body>
		<!--banner-->
		<div class="banner">
		   <ul class="b_ul">
		       <li class="li_act"><a href="###" class="bg01"></a></li>
		       <li><a href="###" class="bg02"></a></li>
		       <li><a href="###" class="bg03"></a></li>
		   </ul>
		   <div class="b_main">
		       <ul class="list">
		           <li class="list_act"></li>
		           <li></li>
		           <li></li>
		       </ul>
		       <span class="list-bg"></span>
		       <div class="pre"><img src="${contextPath}/skin/default/images/sysmgr/index/pre.png"></div>
		      <div class="next"><img src="${contextPath}/skin/default/images/sysmgr/index/next.png"></div>
		   </div>
		</div>
		<script src="${contextPath}/mgr/sysmgr/main/js/indexBanner.js"></script>
	</body>
</html>
