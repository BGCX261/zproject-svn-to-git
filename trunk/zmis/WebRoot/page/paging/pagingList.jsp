<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>显示分页列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
		<%-- cellpadding:内容离内层边框的数量    cellspacing:内容外框离外层的数量 --%>
    	<table cellpadding="1" cellspacing="1" border="2" bordercolor="blank">
    		<tr>
    			<td>UserId</td>
    			<td>UserName</td>
    			<td>UserPwd</td>
    			<td>Employee</td>
    			<td>input_date</td> 
    			<td>remark</td>
    		</tr> 
   		<s:iterator value="#request.pageView.getResults().getResultList()" var="user">
 			<tr>
 				<td>${user.userId }</td>
 				<td>${user.userName }</td>
 				<td>${user.userPwd }</td>
 				<td>${user.employeeId }</td>
 				<td>${user.inputDate }</td>
 				<td>${user.remark }</td>
 			</tr>		
 		</s:iterator>
   	</table>
	<s:iterator begin="1" end="#request.pageView.totalPage" var="i">
		<a href="pagingAction.action?currentPage=${i}">${i}</a>
	</s:iterator>	
  		
  		
		<%--  	<c:out value="${requestScope.test}">	--%>
  		<%-- //TODO JSTL 		<c:forEach items="${requestScope.pageView}" var="t" varStatus="j">--%>
		<%--  			e--%>
		<%--  		</c:forEach>--%>
  </body>
</html>
