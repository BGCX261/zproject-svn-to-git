<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <jsp:include page="../extcore.jsp"></jsp:include>
    <title><%=config.getServletContext().getInitParameter("project_name") %></title>
    <link rel="shortcut icon" href="favicon.ico" />
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<script type="text/javascript">
		Ext.onReady(function() {
			new Ext.Viewport({
				layout:"border",
				items:[
					{//LOGO 不知道怎么设计
						region:"north",
						autoHeight:true,
						border:false,
						frame:true
					}, {//菜单
						region:"west",
						title:"菜单",
						split:true,    //分割条
						collapsible:true,  //收缩条
						layout:"accordion",
						layoutConfig:{//动画
	                      animate:true //, activeOnTop : true   活动放在最上面   一般不需要这样的需求
						},
						width:"200",
						border:false,
						items:[
							{
								iconCls:"test_image_src",
								title:"系统管理",
								autoScroll:true,
								icon:"jxx.jpg"
							}, {
								title:"用户设置",
								autoScroll:true,
							}, {// 系统必用选项 (可控菜单生成)
								autoScroll:true,
								title:"动态设置"
							}
						]
					}, {//content
						region:"center",
						xtype:"tabpanel",
						activeTab:0,	
						border:false,
						items:[
						     {
						    	 style:"<span ><span>"
						    	 title:"我的桌面",
						    	 html:"我的桌面",
						    	 frame:true
						     } 
						]
					}, {//
						region:"south",
						autoHeight:true,
						frame:true,
						border:false,
						html:"<img src='resources/images/message.png'/>欢迎您,开发人员! 帐户:developer 所属部门:平台研发部"
					}
				]
			});
		});
	</script>
  </head>
  <body>
  </body>
</html>
