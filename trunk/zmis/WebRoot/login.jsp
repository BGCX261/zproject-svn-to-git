<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<HTML>
	<HEAD>
		<base href="<%=basePath%>">
		<jsp:include page="page/extcore.jsp"></jsp:include>
		<TITLE><%=config.getServletContext().getInitParameter("project_name")%>[登录页]</TITLE>
		<LINK href="page/resources/images/User_Login.css" type=text/css rel=stylesheet>
		<link rel="shortcut icon" href="favicon.ico" />
		<META http-equiv=Content-Type content="text/html; charset=UTF-8">
		<script type="text/javascript">
			Ext.onReady(function() {
				<%
					String error = request.getParameter("errorMode");
					if("noSeesion".equals(error)) {
						out.print("Ext.MessageBox.alert('温馨提示', '非法访问操作, 请先登录');");
					}
				%>
				Ext.get("userCode").on("keydown",function(_e, _textfield) {
					if(_e.keyCode == 13) {
						login();
					}
				});
			});
			
		
			function login() {
				var _form = document.getElementById("login_form");
				var userName = _form.userName.value;
				var userPwd = _form.userPwd.value;
				var userCode = _form.userCode.value;
				if(userName=="") {
					Ext.MessageBox.alert("温馨提示", "请输入用户名");
					_form.userName.focus();
					return false; 
				}
				if(userPwd=="") {
					Ext.MessageBox.alert("温馨提示", "请输入用户密码");
					_form.userPwd.focus();
					return false;
				}
				if(userCode=="") {
					Ext.MessageBox.alert("温馨提示", "请输入验证码");
					_form.userCode.focus();
					return false;
				}
				
				//请求参数
				var paramList = new Object();
				paramList.userName=userName;
				paramList.userPwd=userPwd;
				paramList.userCode=userCode;
				
				Ext.MessageBox.wait("正在尝试登陆系统...", "登陆中");
				Ext.Ajax.request({
					url:"model/user/login!login.action",
					method:"post",
					success:function(response,options) {
						var result = Ext.JSON.decode(response.responseText);
						if(result.flag == "redirect") {
							location.replace("index.jsp?page=mainMis");//
						}else {
							Ext.MessageBox.alert(result.title,result.message);
						}
					},
					failure:function(response,options) {
						
					},
					params:paramList
				});
				
				/*_form.submit();*/
				return ;
			}
		</script>
	</HEAD>
	
		<BODY id=userlogin_body>
		<form action="model/user/login!login.action" id="login_form" method="post">
			<DIV id=user_login>
				<DL>
					<DD id=user_top>
						<UL>
							<LI class=user_top_l></LI>
							<LI class=user_top_c></LI>
							<LI class=user_top_r></LI>
						</UL>
							<UL>
								<LI class=user_main_l></LI>
								<LI class=user_main_c>
									<DIV class=user_main_box>
										<UL>  
											<LI class="user_main_text">
												用户名：
											</LI>
											<LI class=user_main_input>
												<INPUT class="TxtUserNameCssClass" id="userName" maxLength=10
													name="user.userName">
											</LI>
										</UL>
										<UL>
											<LI class="user_main_text">
												密 码：
											</LI>
											<LI class="user_main_input">
												<INPUT class="TxtPasswordCssClass" id="userPwd" maxLength=10
													type=password name="user.userPwd">
											</LI>
										</UL>
										<UL>
											<LI class=user_main_text>
												验证码:
											</LI>
											<LI class=user_main_input>
												<INPUT id="userCode" name="zcode" size="5" maxLength=5>
											</LI>
											<LI>
												<img src="zcode.jpg" width="90" height="32" style="cursor:pointer; margin-left: 3px">
											</LI>
										</UL>
									</DIV>
								</LI>
								<LI class=user_main_r>
									<img alt="登录" src="page/resources/images/user_botton.gif" 
									class=IbtnEnterCssClass onclick='javascript:login()'
								style="cursor:pointer; BORDER-TOP-WIDTH: 0px; BORDER-LEFT-WIDTH: 0px; BORDER-BOTTOM-WIDTH: 0px; BORDER-RIGHT-WIDTH: 0px">
								</LI>
							</UL>
								<UL>
									<LI class=user_bottom_l></LI>
									<LI class=user_bottom_c></LI>
									<LI class=user_bottom_r></LI>
								</UL>
							</DD>
				</DL>
			</DIV>
			<SPAN id=ValrUserName style="DISPLAY: none; COLOR: red"></SPAN>
			<SPAN id=ValrPassword style="DISPLAY: none; COLOR: red"></SPAN>
			<SPAN id=ValrValidateCode style="DISPLAY: none; COLOR: red"></SPAN>
			<DIV id=ValidationSummary1 style="DISPLAY: none; COLOR: red"></DIV>
			</FORM>
		</BODY>
</HTML>
