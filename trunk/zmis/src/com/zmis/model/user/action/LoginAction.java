package com.zmis.model.user.action;

import java.io.Serializable;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSON;
import com.zmis.core.Message;
import com.zmis.core.QueryResult;
import com.zmis.core.base.action.BaseAction;
import com.zmis.model.user.User;
import com.zmis.model.user.dao.UserDao;
import com.zmis.utils.Digest;
import com.zmis.utils.StringUtil;

@Controller("model/user/login")
@Scope("prototype")
public class LoginAction extends BaseAction implements Serializable {
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(LoginAction.class);
	@Resource(name="userDaoImpl")
	private UserDao userDao;
	
	/**
	 * 登陆操作
	 * @return
	 * @throws Exception
	 */
	public String login() throws Exception {
		this.setRequest(ServletActionContext.getRequest());
		HttpSession session = request.getSession();
		String zcode = request.getParameter("userCode");
		//获取session中的验证码
		String sessionZcode = (String) session.getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
		if(!sessionZcode.equals(zcode)) {//验证码比较
			Message msg = new Message("验证码输入错误!","");
			Object json = JSON.toJSON(msg);
			out.print(json.toString());
			return null;
		}else {
			String userName = request.getParameter("userName");
			String userPwd = request.getParameter("userPwd");
			userPwd = Digest.shaHexEncode(userPwd);
			if(!StringUtil.isEmpty(userName) && !StringUtil.isEmpty(userPwd)) {
				System.out.println("name:"+userName+",  userPwd:"+userPwd);
				QueryResult<User> users= userDao.getData(User.class, "o.userName=?1 and o.userPwd=?2", new Object[]{userName, userPwd});
				if(users.getCount()>0) {
					this.message.setMessage("登录成功");
					this.message.setFlag("redirect");
					session.setAttribute("user", users.getResultList().get(0));
					Object o = JSON.toJSON(this.message);
					out.print(o.toString());
					return null;
				}else {
					this.message.setMessage("不存在用户，或密码输入错误");
					Object o = JSON.toJSON(this.message);
					out.print(o.toString());
					return null;
				} 
			}else {
				Message msg = new Message();
				msg.setSuccess(true);
				msg.setMessage("请输入用户名和密码");
				return null;
			}
		}
	}

	public UserDao getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
}
