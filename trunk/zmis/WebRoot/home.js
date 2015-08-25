/**
 * titlePanel
 * 
 * new Ext.Toolbar.Fill()  // "-"
 */
var headerPanel = Ext.create("Ext.panel.Panel", {
	id:"headerPanel",
    border:false,
    height:30,
    tbar:Ext.create("Ext.toolbar.Toolbar", {
		id:"toolBar",
	    border:false,
	    'items':[{
	    		xtype:"box",
	    		style: {
			        color: "#3C3C3C",
			        fontSize:19
			    },
	    		autoEl:{cn:"<img src='page/resources/images/logo.png' width=25 height=25>ZMIS信息管理系统平台"}
	    	},
	    	"->","-",
			{
				xtype: "box",
				autoEl: { cn: "<img src='page/resources/icon/user.png'>当前角色:developer" }
			},"",{
	    		text:"修改密码",
	    		icon:"page/resources/icon/cog_edit.png"
	    	},{
	    		text:"登出",
	    		icon:"page/resources/icon/node_delete.png"
	    	}
	    ]
	})
});
	

/**
 * menu
 * @type 
 */
var treePanle = Ext.create("Ext.panel.Panel", {
	layout:"accordion",
	items:[
		
	]
});