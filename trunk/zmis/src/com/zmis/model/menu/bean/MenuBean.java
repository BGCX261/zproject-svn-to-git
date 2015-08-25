package com.zmis.model.menu.bean;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.zmis.core.base.entity.BaseEntity;

/**
 * 数据库承载数据的载体(TreeStore) <br>
 * 包括数据库设计<br>  transient
 * 
 * 动态配置数据放在系统启动的时候进行初始化
 * 2012-9-23 下午11:45:55
 * @author ricker.zlj
 */
@Entity
@Table(name="SYS_MENU")
public class MenuBean extends BaseEntity {
	private int menuId;                //菜单ID
	private int parentId;              //父级菜单的id
	private String menuKey;            //菜单key
	private String text;           //菜单显示value        text
	private String menuType;           //菜单类型     后期作动态与静态的标示
	private String icon;               //菜单图标                                   iconCls
	private String url;                //点击访问的url地址
	private boolean expanded=false;    //默认是否展开节点            expanded
	private int lvl = 0;               //tree兄弟节点
	private List<MenuBean> children;   //tree子节点                             children(逻辑中拼写leaf:true)
	private boolean leaf;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="menu_id")
	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	
	@Column(name="menu_name", length=30, nullable=false)
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	@Column(name="menu_icon", length=50, nullable=true)
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	@Column(name="parent_id")
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	@Column(name="menu_key", nullable=false, unique=true)
	public String getMenuKey() {
		return menuKey;
	}
	public void setMenuKey(String menuKey) {
		this.menuKey = menuKey;
	}
	@Column(name="menu_type")
	public String getMenuType() {
		return menuType;
	}
	public void setMenuType(String menuType) {
		this.menuType = menuType;
	}
	@Column(name="url")
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Column(name="expanded")
	public boolean isExpanded() {
		return expanded;
	}
	public void setExpanded(boolean expanded) {
		this.expanded = expanded;
	}
	@Column(name="lvl")
	public int getLvl() {
		return lvl;
	}
	public void setLvl(int lvl) {
		this.lvl = lvl;
	}
	@Column(name="children_id")
	@OneToMany(fetch=FetchType.EAGER, mappedBy="children")
	public List<MenuBean> getChildren() {
		return children;
	}
	public void setChildren(List<MenuBean> children) {
		this.children = children;
	}
	@Transient
	public boolean isLeaf() {
		return leaf;
	}
	public void setLeaf(boolean leaf) {
		this.leaf = leaf;
	}
	
}
