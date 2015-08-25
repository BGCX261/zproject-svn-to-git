package com.zmis.model.paging.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.zmis.core.PageView;
import com.zmis.core.QueryResult;
import com.zmis.core.system.config.SysConfig;
import com.zmis.model.paging.dao.PagingDao;
import com.zmis.model.user.User;

@Controller("model/paging/pagingActioin")
public class PagingActioin extends ActionSupport {
	private static Logger loger = Logger.getLogger(PagingActioin.class);
	
	private static final long serialVersionUID = 1L;
	@Resource(name="pagingDaoImpl")
	private PagingDao pagingDao;
	private int page_size = Integer.parseInt((String) SysConfig.getValueByKey("page_size"));
	
	@Override
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
//		HttpServletResponse response = ServletActionContext.getResponse();
		String currentPage = request.getParameter("currentPage");
		request.setCharacterEncoding("UTF-8");
		
		if(currentPage==null || "".equals(currentPage)) {
			currentPage = "1";
		}
		int page = 1;
		try {
			page = Integer.parseInt(currentPage);
		} catch (Exception e) {
			loger.error("分页数据传入错误");
			page = 1;
		}
		System.out.println(page);
		PageView<User> pageView = new PageView<User>(page, page_size);
		QueryResult<User> results = null;
		try {
			results = pagingDao.getData(User.class, pageView.getStartIndex(), page_size);
		} catch (Exception e) {
			e.printStackTrace();
		}
		pageView.setResults(results);
		request.setAttribute("pageView", pageView);
		request.setAttribute("test", "demo");
		return SUCCESS;
	}
}
