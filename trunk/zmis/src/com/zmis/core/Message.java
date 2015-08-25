package com.zmis.core;

import com.zmis.core.system.config.SysConfig;


/**
 * { success:true, flag:"S", error_msg:"", warning_msg:"", 
 * confirm_msg:"", success_msg:"保存 成功", jsonData:"[{}]", 
 * external_params_1:"", external_params_2:"", 
 * external_params_3:"", jsonObject:{} }
 * 
 * <ul>
 * 	<li>数据传输对象</li>
 * 	<li>这里为了方便使用success:ture为默认, 在有异常的时候需要手工setXX..()进行设置</li>
 * 
 * 	<li>构造函数包括一个默认的无参构造函数， 和一个消息内容，数据对象的两个参数</li>
 * </ul>
 */
public class Message {
	private String title = (String) SysConfig.getValueByKey("msg_title");     //提示框的title
	private boolean success = true;		//ExtJs中的链接标示
	
	/**
	 * S:表示成功<br>
	 * C:表示错误<br>
	 * W：警告(用于显示在提示框上面的图标)<br>
	 * redirect: 浏览器动作
	 */
	private String flag = "S";         
	private String message;			// 消息内容
	private String jsonData; 			// 数据体； 用于显示如同：GridPanel中的数据
	
	
	public Message(){
	}
	public Message(String message){
		this.message = message;
	}
	/**
	 * 简便消息构造
	 * @param success Ajax请求成功标志(ExtJs中必须要使用的)
	 * @param success_msg 成功消息
	 */
	public Message(String message, String jsonData) {
		this.message = message;
		this.jsonData = jsonData;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getJsonData() {
		return jsonData;
	}

	public void setJsonData(String jsonData) {
		this.jsonData = jsonData;
	}
	
}
