## 小应用之单聊

### 聊天页面`liao.jsp`

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>聊</title>
</head>
<body>
	<div align="center">
		<form action="./chuli.jsp" method="post">
			<input type="text" name="hua"/>
			<input type="submit" value="发送"/>
		</form>
	</div>
	<%
		//接收从chuli.jsp中传递的值
		String hua1 = (String)request.getAttribute("hua");
	%>
	<%=hua1 %>
	<hr>
	${hua}
	
</body>
</html>
```
### 处理页面`chuli.jsp`

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>处理</title>
</head>
<body>
	<!-- 
		处理页面要做的事情
			1、接收聊页面发送的话
			2、做简单的处理
			3、将处理后的话发送回聊页面显示
	 -->
	 <%
	 	request.setCharacterEncoding("utf-8");
	 	//接值,通过URL所携带的参数名称接收参数值
	 	String hua = request.getParameter("hua");
	 	//处理
	 	request.setAttribute("hua", hua);
	 	//跳转页面
	 	request.getRequestDispatcher("./liao.jsp").forward(request, response);
	 %>
</body>
</html>
```
