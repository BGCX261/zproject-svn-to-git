package com.zmis.model.page.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.zmis.model.user.filter.LoginFilter;

/**
 * 过滤指定的url请求
 * 
 * 2013-1-11 下午09:12:55
 * @author ricker.zlj[271218983@qq.com]
 */
public class PageFilter implements Filter {

	private FilterConfig config;
	private Logger logger = Logger.getLogger(LoginFilter.class);
	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		String enabled = config.getInitParameter("enabled");
		String input = config.getInitParameter("input");
		if("false".equals(enabled)) {
			chain.doFilter(request, response);
			return;
		}
		//
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		HttpSession session = req.getSession(false); // 不创建session
		String uri = req.getRequestURI();
		System.out.println("uri:"+uri);
		String ignored = config.getInitParameter("ignored");
		if(uri.equals(ignored)) {
			chain.doFilter(request, response);
			return;
		}
		if(session==null || session.getAttribute("user")==null) {
			logger.debug("来自:["+req.getRemoteAddr()+"]的非法请求已拦截..");
			String path = req.getContextPath();
			res.sendRedirect(path+"/"+input+"?errorMode=noSeesion");
		}else {
			chain.doFilter(request, response);
			return;
		}
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		this.config = filterConfig;
	}


}
