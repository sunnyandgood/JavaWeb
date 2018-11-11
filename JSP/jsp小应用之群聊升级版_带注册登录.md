# 小应用之群聊升级版_带注册登录

### 初始页面`chushi.jsp`

```jsp
<%@page import="java.util.ArrayList"%>
<%@page import="com.sun.javafx.collections.MappingChange.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>初始化页面</title>
</head>
<body>
	<%
		//用来存放用户和其所说的话的map，map存放用户名及其所说的话
		List<Map<String,String>> huaList = new ArrayList<>();
		//存放用户名和密码的map，map存放用户名和密码
		List<Map<String,String>> userList = new ArrayList<>();
		application.setAttribute("huaList", huaList);
		application.setAttribute("userList", userList);
		response.sendRedirect("./login.jsp");
	%>
</body>
</html>
```

### 注册页面`zuce.jsp`

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册</title>
</head>
<body>
	<form action="./zuceChuli.jsp" method="post">
		<input type="text" name="userName"/>
		<input type="password" name="password"/>
		<button>注册</button>
	</form>
	<a href="login.jsp">登录</a>
</body>
</html>
```

### 注册处理页面`zuceChuli.jsp`

```jsp
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册处理</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		//接收用户名和密码
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		Map<String,String> map = new HashMap<>();
		map.put("userName", userName);
		map.put("password", password);
		//在jdk1.7以后，存放于application和session中的数据，只需要取出来跟新，则application和session中对应的数据会同步更新
		List<Map<String,String>> list = (List<Map<String,String>>)application.getAttribute("userList");
		list.add(map);
		response.sendRedirect("./login.jsp");
	%>
</body>
</html>
```

### 登录页面`login.jsp`

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录页面</title>
</head>
<body>
	<form action="./judgeLogin.jsp" method="post">
		<input type="text" name="userName"/>
		<input type="password" name="password"/>
		<button>登录</button>
	</form>
	<a href="zuce.jsp">注册</a>
</body>
</html>
```

### 登录处理页面`judegLogin.jsp`

```jsp
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录处理页面</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		//接收用户名和密码
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		List<Map<String,String>> list = (List<Map<String,String>>)application.getAttribute("userList");
		if(list.size()>0){
			Boolean flag = false;
			for(int i=0;i<list.size();i++){
				Map<String,String> map = list.get(i);
				if(userName.equals(map.get("userName")) && password.equals(map.get("password"))){
					//将已经登录的用户名存放到session中，方便后边使用
					session.setAttribute("userName", userName);
					flag = true;
				}else{
					flag = false;
				}
			}
			if(flag){
				response.sendRedirect("./liao.jsp");
			}else{
				response.sendRedirect("./login.jsp");
			}
		}else{
			response.sendRedirect("./login.jsp");
		}
	%>
</body>
</html>
```

### 聊天页面`liao.jsp`

```jsp
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>聊天页面</title>
</head>
<body>
	<form action="./chuli.jsp" method="post">
		<input type="text" name="hua"/>
		<input type="submit" value="发送">
	</form>
	<hr>
	<%
		List<Map<String,String>> list = (List<Map<String,String>>)application.getAttribute("huaList");
		if(list.size()>0){
			for(int i=0;i<list.size();i++){
				Map<String,String> map = list.get(i);
				String userName = map.get("userName");
				String timeAndHua = map.get("timeAndHua");
				%>
					<font size="5"><%=userName %></font>
					<font size="4"><%=timeAndHua %></font>
					<br/>
				<%
			}
		}
	%>
</body>
</html>
```
### 处理页面`chuli.jsp`

```jsp
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>处理页面</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		String hua = request.getParameter("hua");
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
		String formatDate = dateFormat.format(date);
		String timeAndHua = formatDate + "：" + hua;
		List<Map<String,String>> list = (List<Map<String,String>>)application.getAttribute("huaList");
		String userName = (String)session.getAttribute("userName");
		Map<String,String> map = new HashMap<>();
		map.put("userName", userName);
		map.put("timeAndHua", timeAndHua);
		list.add(map);
		response.sendRedirect("./liao.jsp");
	%>
</body>
</html>
```
