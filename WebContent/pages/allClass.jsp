<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>班级信息</title>
</head>
<body>
	<div>
		<table align="center" border="1" width="500" >
			<tr>
				<th>编号</th>
				<th>班级编号</th>
				<th>班级名称</th>
				<th>创建名称</th>
				<th>操作</th>
				
			</tr>
			
			
			<s:if test="#attr.classList == null or  #attr.classList.size==0" >
				<tr align="center">
					<td colspan="4" style="color:red;text-align: count">没有数据!</td>
				</tr>
			</s:if>
			<s:else>
				<s:iterator value="#attr.classList" var="cls" status="stuc">
					<tr align="center" >
						<td>${stuc.count }</td>
						<td>${cls.gno }</td>
						<td>${cls.gname }</td>
						<td>${cls.gtime.substring(0,10) }</td>
						<td> <a href="actionClass_upClass?cclass.gno=${cls.gno }"> 修改</a> | <a href=""> 删除</a></td>
					</tr>
				</s:iterator>
			
			</s:else>
				
			<tr align="center">
				<td colspan="5"><a href=#">添加新的班级</a></td>
			</tr>
		</table>
		
	
		
	</div>
	
	
</body>
</html>