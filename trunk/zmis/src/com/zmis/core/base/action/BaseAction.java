package com.zmis.core.base.action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;
import com.zmis.core.Message;
import com.zmis.core.system.config.SysConfig;

/**
 * 通用Action<br>
 * 1：有文件上传功能
 * 		使用：只需继承， 且调用upLoadFile方法(name:zfile)<br>
 * 2: Ajax消息对象(Message) 以及消息对象的输出 out<br>
 * 2012-9-19 下午08:36:58<br>
 * @author zlj
 */
public class BaseAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {
	protected static final long serialVersionUID = 1L;
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	private Logger logger = Logger.getLogger(BaseAction.class);
	/**前端文件名称name='zfile'*/
	protected List<File> zfile;
	/**上传文件名称*/
	protected List<String> zfileFileName;
	/**文件类型*/
	protected List<String> zfileContentType;
	/**允许上传的文件类型*/
	protected String allowedTypes;
	
	/**Ajax 客服端信息体*/
	protected PrintWriter out;  //其中的print方法会自动刷新缓冲区
	
	/**客服端消息数据对象*/
	protected Message message;
	
	
	/**
	 * 根据返回的string作为 execute判断依据
	 * @return
	 */
	public String upLoadFile() {
		if(zfile!=null && zfile.size()>0) {
			//在配置文件中  获取上传目录
			String destDir = ServletActionContext.getServletContext().getRealPath((String) SysConfig.getValueByKey("destFileDir"));
			for(int i=0; i<zfile.size(); i++) {
				String fileName = zfileFileName.get(i);
				String suf = fileName.substring(fileName.lastIndexOf("."), fileName.length());
				String name = fileName.substring(0, fileName.lastIndexOf("."));
				String remoteIP=request.getRemoteAddr();
				long mi = System.currentTimeMillis();
				fileName = name+"("+remoteIP+"-"+mi+")"+suf;
				File descFile = new File(destDir, fileName);
				try {
					FileUtils.copyFile(zfile.get(i), descFile);
				} catch (Exception e) {
					logger.error("文件上传错误");
					message.setMessage("文件上传错误");
					return "input";
				}
			}
			message.setMessage("文件上传成功");
			return "success";
		}else {
			message.setMessage("请选择你要上传的文件");
			return "input";
		}
	}
	
	/**
	 * 测试阶段 需要测试到添加错误信息到 addActionError中的情况
	 * 这里还需要处理类型问题
	 * 
	 */
	@Override
	public void addFieldError(String fieldName, String errorMessage) {
		//改从国际化里取值   
		System.out.println("addFieldError======================="+errorMessage);
		if (errorMessage.startsWith("the request was rejected because its size") || errorMessage.startsWith("File too large")) {
			message.setMessage("addFieldError:上传文件不能超过30M");
			super.addFieldError(fieldName, errorMessage);
		}else {
			super.addFieldError(fieldName, errorMessage);
		}
	}
	
	@Override
	public void addActionError(String anErrorMessage) {
		System.out.println("addActionError======================="+anErrorMessage);
		if (anErrorMessage.startsWith("the request was rejected because its size") || anErrorMessage.startsWith("File too large")) {
			message.setMessage("addActionError:上传文件不能超过30M");
			super.addActionError(anErrorMessage);
		}else {
			super.addActionError(anErrorMessage);
		}
	}
	
	public void printData(Object... os) {
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<os.length;i++) {
			sb.append(os.toString());
			if(i!=os.length) {
				sb.append("\n");
			}
		}
		out.print(sb.toString());
	}
	
	public HttpServletRequest getRequest() {
		return request;
	}
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	public HttpServletResponse getResponse() {
		return response;
	}
	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}
	public List<File> getZfile() {
		return zfile;
	}
	public void setZfile(List<File> zfile) {
		this.zfile = zfile;
	}
	public List<String> getZfileFileName() {
		return zfileFileName;
	}
	public void setZfileFileName(List<String> zfileFileName) {
		this.zfileFileName = zfileFileName;
	}
	public List<String> getZfileContentType() {
		return zfileContentType;
	}
	public void setZfileContentType(List<String> zfileContentType) {
		this.zfileContentType = zfileContentType;
	}
	public String getAllowedTypes() {
		return allowedTypes;
	}
	public void setAllowedTypes(String allowedTypes) {
		this.allowedTypes = allowedTypes;
	}
	public Message getMessage() {
		return message;
	}
	public void setMessage(Message message) {
		this.message = message;
	}

	public PrintWriter getOut() {
		return out;
	}

	public void setOut(PrintWriter out) throws IOException {
		this.out = out;
	}

	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
		response.setContentType("text/html;charset=UTF-8"); // 用于处理response中ajax为乱码
		message = new Message();
		try {
			this.out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	
}
