package com.zmis.test;

import java.util.Date;

import org.compass.core.json.JsonObject;
import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.zmis.core.Message;
import com.zmis.model.menu.bean.MenuBean;
import com.zmis.model.user.User;

public class TestJson {
	@Test
	public void message() {
		Message msg = new Message();
		msg.setSuccess(true);
		msg.setMessage("添加成功");
		User user = new User();
		user.setUserId(1);
		user.setUserName("ricker");
		user.setUserPwd("loveone");
		user.setDelete(false);
		msg.setJsonData(JSON.toJSONString(user, SerializerFeature.UseSingleQuotes));
		System.out.println(JSON.toJSONString(user, SerializerFeature.UseSingleQuotes));
		System.out.println("22;"+JSON.toJSONString(user, SerializerFeature.QuoteFieldNames));
		System.out.println("2233;"+JSON.toJSONString(user, SerializerFeature.DisableCircularReferenceDetect));
		
		//String j = "{"jsonData":"{\"active\":true,\"delete\":false,\"employeeId\":0,\"inputDate\":1351003550508,\"userId\":1,\"userName\":\"ricker\",\"userPwd\":\"0390cc43663c50b84daa4f8ec97110c13f867175\"}","success":true,"success_msg":"添加成功"}";
		/**前台过来的字符数据*/
		String us= "{\"active\":true,\"delete\":false,\"employeeId\":0,\"inputDate\":1351003873980,\"userId\":1,\"userName\":\"ricker\",\"userPwd\":\"0390cc43663c50b84daa4f8ec97110c13f867175\"}";
		/**后台JSON数据拼装*/
		JSONObject jsonObject = JSONObject.parseObject(us);
		/**转换对象*/
		User u = JSONArray.toJavaObject(jsonObject, User.class);    
		System.out.println("\nuserName:"+u.getUserName());
		System.out.println("\nuserName:"+u.getUserPwd());
		
		String json = JSONObject.toJSON(user).toString();
		//除去第一个和最后一个{}
		//System.out.println("1:"+json);
		//json = json.substring(1,json.length());
		//json = json.substring(0,json.length()-1);
		//System.out.println("2:"+json);
	}
	
	
	@Test
	public void testMenu() {
		MenuBean menu = new MenuBean();
		menu.setActive(true);
		menu.setDelete(false);
		menu.setExpanded(true);
		menu.setInputDate(new Date());
		menu.setLeaf(true);
		menu.setLvl(2);
		menu.setParentId(22);
		menu.setMenuKey("test");
		String json = JSONObject.toJSON(menu).toString();
		System.out.println(json);
	}
}
