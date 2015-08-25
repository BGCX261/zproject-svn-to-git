<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
  <head>
    <base href="<%=basePath%>">
    <title><%=config.getServletContext().getInitParameter("project_name")%></title>
  	<link rel="icon" href="http://www.163.com/favicon.ico" type="image/x-icon" /> 
	<link rel="shortcut icon" href="http://www.163.com/favicon.ico" type="image/x-icon" />
  
  	<script type="text/javascript">
  		function onMore() {
			var td = document.getElementById("more");
			var br = document.createElement("br");
			var input = document.createElement("input");
			var _delete = document.createElement("input");
			input.type="file";
			input.name="zfile";
			_delete.type="button";
			_delete.value="删除";
			
			_delete.onclick =function() {
				td.removeChild(br);
				td.removeChild(input);
				td.removeChild(_delete);
			};

			td.appendChild(br);
			td.appendChild(input);
			td.appendChild(_delete);
  	  	}
  	</script>
  </head>
  <body>
		<table align="center">
			<tr>
				<TD>
					 <s:property value="message"/>
				</TD>
			</tr>
		</table>    
		
		<s:form action="system/fileupload.action" theme="simple" method="post" enctype="multipart/form-data">
		<s:token />
			<table align="center" border="0" width="60%">
		       <tr>
		     		<td>文件</td>
		     		<td id="more"><s:file name="zfile" ></s:file>
		      			<input type="button" value="更多.." onclick="onMore()">
		     		</td>
		    	</tr>
		    <tr>
		     <td>
		      
		     </td>
		     <td><s:submit value="submit"></s:submit>
		      <s:reset value="reset"></s:reset>
		     </td>
		    </tr>
		   </table>
			
		</s:form>	
  </body>
</html>
