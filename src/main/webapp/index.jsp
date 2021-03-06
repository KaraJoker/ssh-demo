<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>注册页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	<script type="text/javascript" src="/bootstrap/js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript">
        $(document).ready(function(){
            $.ajax({
                type: "get",
                dataType: "json",
                contentType: "application/json;charset=utf-8",
                url: "<%=basePath%>checkUser.action",
                success: function (msg) {
                    /*if (msg) {
                        var str = "";
                        var data = msg.data;
                        alert(msg);
                        for (var i in data) {
                            str += "<tr>" +
                                "<td align='center'>" + data[i].id + "</td>" +
                                "<td align='center'>" + data[i].password + "</td>" +
                                "<td align='center'>" + data[i].userName + "</td>" +
                                "</tr>";
                        }
                        $("#tbody-result").innerHTML = str;
                    }*/
                },
                error: function () {
                    alert("查询失败")
                }
            });
        });
	</script>
  </head>
  
  <body>
  	<div align="center">
		<h3>新增测试</h3>
		<div>
			<input type="text" value="live" class="userName">
			<input type="password" value="qq521977" class="password">
			<input type="button" value="注册" class="register">
		</div>
		<h3>展示用户</h3>
		<div>
			<table id="table-result" width="80%" align="center" border="1">
				<thead>
					<tr>
						<td>序号</td>
						<td>密码</td>
						<td>姓名</td>
					</tr>
				</thead>
				<tbody id="tbody-result">
					<c:if test="${result.userList}" var="user">
						<tr>
							<td>${user.id}</td>
							<td>${user.password}</td>
							<td>${user.userName}</td>
						</tr>
					</c:if>
				</tbody >
			</table>
		</div>
		<h3>删除测试</h3>
		<div>
			<input type="text" value="" class="id">
			<input type="button" value="删除" class="delete">
		</div>
		<h3>HQL查询测试</h3>
		<div>
			<input type="text" value="" class="hql_userName">
			<input type="button" value="查询" class="query">
		</div>
	</div>
  </body>
  <script type="text/javascript">
  	/**
  	 *	新增
  	**/
  	$(".register").click(function(){
  		var userName = $(".userName").val();
  		var password = $(".password").val();
  		$.ajax({
  			type:'post',
			dataType:'json',
			async:false,
			data:{
				"userName":userName,
				"password":password,
			},
			url:'<%=basePath%>saveUser.action',
			success:function(data){
				if(data == 1)
					alert("新增成功！");
			}	
		});
  	});
  	
  	/**
  	 *	删除
  	**/
  	$(".delete").click(function(){
  		var id = $(".id").val();
  		$.ajax({
  			type:'post',
			dataType:'json',
			async:false,
			data:{
				"id":id,
			},
			url:'<%=basePath%>delUser.action',
			success:function(data){
				if(data == 1)
					alert("删除成功！");
			}	
		});
  	});
  	
  	/**
  	*	查询
  	**/
  	$(".query").click(function(){
  		var userName = $(".hql_userName").val();
  		$.ajax({
  			type:'post',
			dataType:'json',
			async:false,
			data:{
				"userName":userName,
			},
			url:'<%=basePath%>queryUserByHql.action',
			success:function(data){
				alert(data);
			}	
		});
  	});
  </script>
</html>
