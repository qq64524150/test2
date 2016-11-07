<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生信息</title>
</head>
<body>
	<div style="width: 800px ;height: 890px; margin: 0px auto; ">
		<table border="1" width="700">
			<tr>
				<th colspan="7"><h2>信息列表</h2><span style="float: right;"><a href="#" id="addUser">添加</a></span></th>
			</tr>
			<tr>
				<th>学号</th>
				<th>姓名</th>
				<th>性别</th>
				<th>年龄</th>
				<th>班级</th>
				<th>时间</th>
				<th>操作</th>
			</tr>
			<tbody>
				<s:iterator value="#attr.allStu" var="stu">
					<tr align="center">
						<td>${stu[0] }</td>
						<td>${stu[1] }</td>
						<td>${stu[2] }</td>
						<td>${stu[3] }</td>
						<td>${stu[6] }</td>
						<td>${stu[5].substring(0,10) }</td>
						
						<td ><a href="#" class="updata" name="${stu[4] }">修改</a>　<a href="#" class="del">删除</a></td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
		
	</div>


<!-- 添加 -->
	<div id="bigDiv" style='position: absolute;width: 100%;height: 100%;background:rgba(0,0,0,0.3); top: 0px; left:0px;display: none;'>
		<div id="dialog"  style="width: 400px ;height: 190px; margin: 180px auto; border:1px solid; padding: 20px;background: #fff;">
			 <s:form action="ActionStu_addStu" method="post" theme="simple" name="forms">
				<table border="1" width='400px' height='190px'>
					 <tr >
						<th colspan="5">学生信息添加</th>
					</tr>
					<tr>
						<td>姓名:</td><td><s:textfield name="stu.sname"/></td>
					</tr>
					 <tr>
					<tr>
					<td>性别:</td>
						<td>
							 <s:radio list="{'男','女'}" value="%{'男'}" name="stu.ssex" />
						</td>
					</tr>
					<tr>
					<tr>
						<td>年龄:</td><td><s:textfield name="stu.sage"/></td>
					</tr> 
					 <tr>
						<td>班级:</td>
						
						<td>
							<s:select list="#attr.classtList"  name="cclass.gclassno" headerKey="" headerValue="请选择班级"  listKey="gclassno" listValue="gname"/>
						</td> 
					</tr>
					
					<tr>
						<td colspan="7" style="text-align: center;"><s:reset value="添加" name="tijiao"/> <s:reset value="取消"  name="quxiao" /></td>
					</tr>
				</table>
			</s:form> 
		</div>
	</div>
	
	
	
	<!-- 修改 -->
	<div id="upbigDiv" style='position: absolute;width: 100%;height: 100%;background:rgba(0,0,0,0.3); top: 0px; left:0px;display: none;'>
		<div id=""  style="width: 400px ;height: 190px; margin: 180px auto; border:1px solid; padding: 20px;background: #fff;">
			 <s:form action="ActionStu_updataStu" method="post" theme="simple" name="fors">
				<table border="1" width='400px' height='190px'>
					 <tr >
						<th colspan="5">学生信息修改</th>
					</tr>
					<tr>
						<td>学号:</td><td><s:textfield name="stu.sno" /></td>
					</tr>
					<tr>
						<td>姓名:</td><td><s:textfield name="stu.sname"/></td>
					</tr>
					 <tr>
					<tr>
					<td>性别:</td>
						<td>
							 <s:radio list="{'男','女'}"  name="stu.ssex" value="%{'男'}" />
						</td>
					</tr>
					<tr>
					<tr>
						<td>年龄:</td><td><s:textfield name="stu.sage"/></td>
					</tr> 
					 <tr>
						<td>班级:</td>
						
						<td>
							<s:select list="#attr.classtList"  name="cclass.gclassno" headerKey="" headerValue="请选择班级"  listKey="gclassno" listValue="gname"/>
						</td> 
					</tr>
					
					<tr>
						<td colspan="7" style="text-align: center;"><s:reset value="添加" name="uptijiao"/> <s:reset value="取消"  name="quxiao" /></td>
					</tr>
				</table>
			</s:form> 
		</div>
	</div>
	
</body>
</html>

<script type="text/javascript">


	//添加
	$("#addUser").click(function(){
		$("#bigDiv").css("display","block");
		
	});
	
	//删除
	
	$('.del').click(function(){
		
		$.ajax({
			url:"ActionStu_dalStu?sno="+$(this).parent().parent().find(":nth-child(1)").html(),
			type:"post" ,
			success:function(data){
				if(data==1){
					alert("添加成功！");
					location.reload() ;
				}else{
					alert("添加失败！");
				}
			}
		});
		
	});
	
	//修改
	$('.updata').click(function(){
		//获取编号
		var sno = $(this).parent().parent().find(":nth-child(1)").html();
		//获取姓名
		var sname = $(this).parent().parent().find(":nth-child(2)").html();
		//获取性别
		var ssex = $(this).parent().parent().find(":nth-child(3)").html() ;
		//获取年龄
		var sage = $(this).parent().parent().find(":nth-child(4)").html() ;
		//获取班级
		/* var sclass = $(this).parent().parent().find(":nth-child(5)").val(1).val();
		 */
		var sclass = $(this).attr("name");;
		
		$("#upbigDiv").css("display","block");
		$("[name='stu.sno']").val(sno);
		$("[name='stu.sname']").val(sname);
		$("[name='stu.ssex']").val();
		if(ssex=="女"){
			$("#ActionStu_updataStu_stu_ssex男").removeAttr("checked");
			$("#ActionStu_updataStu_stu_ssex女").attr("checked","checked");
		}
		
		$("[name='stu.sage']").val(sage);
		$("#ActionStu_updataStu_cclass_gclassno").find("option[value="+sclass+"]").attr("selected",true);;
		//设置属性--不可编译
		$("[name='stu.sno']").attr("readonly","readonly");
	});
	
	//添加
	 $('input[name="tijiao"]').click(function(){
		$("#bigDiv").css("display","none");
		var param=$("[name='forms']").serialize();
		
		$.ajax({
			url:"ActionStu_addStu",
			type:"post" ,
			data:param ,
			success:function(data){
				if(data==1){
					alert("添加成功！");
					location.reload() ;
				}else{
					alert("添加失败！");
				}
			}
		});
	}); 
	//修改
	 $('input[name="uptijiao"]').click(function(){
		 $("#upbigDiv").css("display","none");
		var param=$("[name='fors']").serialize();
		
		$.ajax({
			url:"ActionStu_updataStu",
			type:"post" ,
			data:param ,
			success:function(data){
				if(data==1){
					alert("修改成功！");
					location.reload() ;
				}else{
					alert("修改失败！");
				}
			}
		});
	}); 
	
	
	//取消
	$('[name="quxiao"]').click(function(){
		$("#bigDiv").css("display","none");
		$("#upbigDiv").css("display","none");

	});
	
	
	

</script>
