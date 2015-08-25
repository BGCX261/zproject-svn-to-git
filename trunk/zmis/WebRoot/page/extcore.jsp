<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<link type="text/css" rel="Stylesheet" href="<%=basePath%>extlib/resources/css/ext-all.css" />
<link type="text/css" rel="Stylesheet" href="<%=basePath%>css/commons.css" />
<script type="text/javascript" src="<%=basePath%>extlib/bootstrap.js"></script>
<script type="text/javascript" src="<%=basePath%>extlib/ext-lang-zh_CN.js"></script>
<script type="text/javascript">
Ext.onReady(function() {
	Ext.BLANK_IMAGE_URL = "<%=basePath%>/extlib/resources/images/default/s.gif";
	Ext.QuickTips.init(); 
	Ext.Loader.setConfig({enabled:true}); 
})
</script>

