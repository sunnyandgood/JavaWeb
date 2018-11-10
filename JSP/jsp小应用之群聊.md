# 小应用之群聊

### 初始页面`chushi.jsp`

```jsp
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>初始化</title>
</head>
<body>
	<%
		List<String> list = new ArrayList<>();
	 	list.add("");
	 	//处理
	 	application.setAttribute("huaList", list);
	 	//跳转页面
	 	//request.getRequestDispatcher("./liao.jsp").forward(request, response);
	 	response.sendRedirect("./liao.jsp");
	%>
</body>
</html>
```

### 聊天页面`liao.jsp`

```jsp
<%@page import="java.util.List"%>
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
		//String hua1 = (String)request.getAttribute("hua");
		List<String> list = (List)application.getAttribute("huaList");
		if(list.size()>0){
			for(int i=0;i<list.size();i++){
				String hua = list.get(i);
				%>
					<font size="5"><%=hua %></font><br/>
				<%
			}
		}
	%>
</body>
</html>
```
### 处理页面`chuli.jsp`

```jsp
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
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
	 	//hua = new String(hua.getBytes("utf-8"),"iso8859-1");//终极转码方式
	 	List<String> list = (List)application.getAttribute("huaList");
	 	list.add(hua);
	 	//处理
	 	application.setAttribute("huaList", list);
	 	//跳转页面
	 	//request.getRequestDispatcher("./liao.jsp").forward(request, response);
	 	response.sendRedirect("./liao.jsp");
	 %>
</body>
</html>
```
