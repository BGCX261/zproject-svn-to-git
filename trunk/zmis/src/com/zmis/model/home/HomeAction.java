package com.zmis.model.home;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.zmis.core.base.action.BaseAction;
import com.zmis.model.user.User;


/**
 * 拦截非法请求<br>
 * 
 * 2013-1-11 下午08:28:02
 * @author ricker.zlj[271218983@qq.com]
 */
@SuppressWarnings("serial")
@Controller(value="model/home/action")
@Scope("prototype")
public class HomeAction extends BaseAction {
	
	public void initSystem() {
		User user = (User) request.getSession().getAttribute("user");
		
	}
	
}
