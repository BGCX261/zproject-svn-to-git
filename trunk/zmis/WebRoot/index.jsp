<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <jsp:include page="page/extcore.jsp"></jsp:include>
    <title><%=config.getServletContext().getInitParameter("project_name")%></title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="zmis">
	<meta http-equiv="description" content="zmis">
	<link rel="shortcut icon" href="favicon.ico" />
	<script type="text/javascript" src="home.js"></script>
	<script type="text/javascript">
	Ext.onReady(function() {
		var store = Ext.create('Ext.data.TreeStore', {
		    root: {
		        expanded: true,
		        children: [
		            { text: "detention", leaf: true },
		            { text: "homework", expanded: true, leaf:false,children: [
		                { text: "book report", leaf: true },
		                { text: "alegrbra", leaf: true}
		            ] },
		            { text: "buy lottery tickets", leaf: true }
		        ]
		    }
		});
		
		var _treeStore = Ext.create("Ext.data.TreeStore", {
			proxy: {
				type:"ajax",
				url:"model/menu/menuAction!getMenuTreeByName.action"
			}
		});

		var _tree = Ext.create('Ext.tree.Panel', {
			border:false,
		    store: store,
		    rootVisible: false,
		});
		
		
		
		Ext.create("Ext.container.Viewport", {
		    layout: "border",
		    items: [{
		        region: "north",
		        items:headerPanel
		    }, {
		        region: "west",
		        split:true,
		        title: "系统菜单",
		        icon:"page/resources/icon/flag_green.png",
		        border:true,
		        hideCollapseTool:false,
		        width: 220,
		        collapsible: true,
		        width: 220,
		        layout: {
		            type: 'accordion',
			        titleCollapse: true,//标题可以切换
			        hideCollapseTool:true, //隐藏收紧按钮
		            animate: true
		        },
		        items: [{
		            title: "系统动态配置",
		            icon:"page/resources/icon/folder_wrench.png", 
		            items:_tree
		        }]
		    }, {
		        region: "center",
		        split:true,
		        border:false,
		        xtype:"tabpanel",
		        activeTab: 0,   
		        items: [{
		        	title:"系统主页"	,
		        	icon:"page/resources/icon/picklist_enable.png"
		        },{
		            title: "testPanel",
		            closable:true,
		            xtype:"panel",
		            layout:"fit",
		            loader: {
		            	autoLoad:true,
		            	url:"http://localhost:8080/zmis/login.jsp"
		            }
		        }]
		    }]
		});
	});		
	</script>
  </head>
  <body>
  </body>
</html>
