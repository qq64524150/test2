<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新班级添加</title>
</head>
<body>
	<h2>添加班级</h2>
	<s:form action="actionClass_addClass" method="post">
		班级姓名：<s:textfield name=""/><br>
		班级编号：<s:textfield name=""/>
		<s:submit value="添加"/>
	</s:form>
	
</body>
</html>