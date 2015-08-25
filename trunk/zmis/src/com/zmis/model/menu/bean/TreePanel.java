package com.zmis.model.menu.bean;

import java.util.List;

/**
 * 前台ExtJs TreePanel数据格式<br>
 * 
 * 2013-1-14 下午10:47:48
 * @author ricker.zlj[271218983@qq.com]
 */
public class TreePanel {
	private String text;
	private boolean leaf;
	private boolean expanded;
	private List<TreePanel> children;
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public boolean isLeaf() {
		return leaf;
	}
	public void setLeaf(boolean leaf) {
		this.leaf = leaf;
	}
	public boolean isExpanded() {
		return expanded;
	}
	public void setExpanded(boolean expanded) {
		this.expanded = expanded;
	}
	public List<TreePanel> isChildren() {
		return children;
	}
	public void setChildren(List<TreePanel> children) {
		this.children = children;
	}
	
}
