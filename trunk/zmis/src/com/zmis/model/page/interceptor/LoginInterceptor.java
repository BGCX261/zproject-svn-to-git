package com.zmis.model.page.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.compass.core.json.JsonObject;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.zmis.core.Message;
import com.zmis.model.user.User;
import com.zmis.model.user.action.LoginAction;

public class LoginInterceptor extends AbstractInterceptor {
	private Logger logger = Logger.getLogger(LoginInterceptor.class);
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		Map session = invocation.getInvocationContext().getSession();
		User user = (User)session.get("user");
		if(user != null) {
			return invocation.invoke();
		}else {
			Message message = new Message("你还没有登录, 请重新登录.");
			Object json = JSON.toJSON(message);
			logger.debug("非法访问数据："+json.toString());
			return Action.LOGIN;
		}
	}

}
