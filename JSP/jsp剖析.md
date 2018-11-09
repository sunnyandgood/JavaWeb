# jsp剖析

### 一、`http://localhost:8080/jsp/`解析

* `http://`：HTTP协议

* `localhost`：表示本地，如果访问其他主机的服务器，则替换为要访问主机的IP地址

* 8080：表示当前服务器的端口号

* `/jsp`：表示要访问的项目(工程)的路径

* `/`：表示要访问的页面的路径，当前为默认路径
    * 默认路径的指定（`web.xml`文件）
```xml    
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
   xmlns="http://xmlns.jcp.org/xml/ns/javaee" 
   xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee 
		       http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd" 
   id="WebApp_ID" version="4.0">
	<display-name>jsp</display-name>
	<welcome-file-list>
	<welcome-file>index.html</welcome-file>
	<welcome-file>index.htm</welcome-file>
	<welcome-file>index.jsp</welcome-file>
	<welcome-file>default.html</welcome-file>
	<welcome-file>default.htm</welcome-file>
	<welcome-file>default.jsp</welcome-file>
	</welcome-file-list>
</web-app>    
```

### 二、`http://localhost:8080/jsp/jsp/myNewJsp.jsp`中`jsp/myNewJsp.jsp`解析

* `jsp`：表示自定义文件夹路径

* `myNewJsp.jsp`：表示自定义jsp文件

### 三、jsp的九大内置对象（注意：jsp页面中所有Java代码必须包裹在`<%%>`中）

* 1、out输出对象，将内容输出到页面上

* 2、request表示一次请求
  
  * 转发方式
		
    * 1>相对路径
    	```java
	request.getRequestDispatcher("jie.jsp").forward(request,response);
	```
    * 2>绝对路径

          request.getRequestDispatcher("/jsp/request/jie.jsp").forward(request,response);
 
      
  * 表示请求转发，使请求转发到指定页面，该行为为服务器行为（一次请求）
  
    * `getRequestDispatcher("requestJie.jsp")`指定要去的页面，参数为String类型的路径
    
    * `forward(request,response)`表示将当前请求中所含的信息一起转发
    
    * 特点：浏览器地址栏内容不变
  
* 3、response表示重定向,响应对象

  * 转发方式
		  
    * 1>相对路径
			
          response.sendRedirect("jie.jsp");
		  
    * 2>绝对路径
    
			response.sendRedirect(request.getContextPath()+"/jsp/jieChuan/jie.jsp");
			
        * request.getContextPath()表示获取当前项目在服务器上的路径
      
  * 表示重定向，使请求重新定向到新的请求或页面，还行为为浏览器行为（两次请求）
		
    * `sendRedirect("jie.jsp")`表示设置重定向路径
		
    * 特点：浏览器地址栏内容改变(页面真实路径)
		
    * `http://localhost:8080/jsp/jsp/request/jie.jsp`
	
    * **注意：使用重定向跳转页面（请求）时，request不能传递值**
    
* 4、session表示浏览器级别作用域,会话对象
		
  * 作用：存储键值对，方便后续取用
		
  * 范围：浏览器级别，只要浏览器不关闭，当前session一直有效

* 5、application表示服务器级别的作用域，上下文

  * 作用：存储键值对，方便后续取用

  * 范围：服务器级别，只要服务器不关闭，当前application一直有效
	
* 6、最后四个：page、pageContext、config、exception
	
### 四、四大作用域
	
* page	

* request		

* session		

* application

### 五、Java代码和HTML代码结合使用
	
* 可以将Java代码前后分离,只要所有`<%%>`连接起来，Java代码整齐就行，在`%>` HTML代码 `<%`中间书写HTML代码

* 如果需要对Java变量进行输出，则需要将Java变量使用`<%=变量%>`包裹

### 六、el表达式

* 写法：`${键}`

* 作用：接收三大作用域中传递的值

* 顺序：当三大作用域同时传递同样的键时，`request>session>application`

### 七、HTML表单（form）提交方式

* get：显式提交，有body部分，所有参数名称和参数值`(参数名称=参数值)`显示在浏览器地址栏中

* post：隐式提交,没有body部分，表单元素组成的参数名称和参数值不显示在浏览器地址栏中

* 注意：**表单元素组成的参数名称**和**参数值**：表单元素的name属性值作为参数名称，value属性值做参数值

### 八、中文乱码		

* 隐式提交：使用`request.setCharacterEncoding("utf-8");`可解决

* 注意：以上方式中，转码方法必须放在第一行

* 显式提交：`new String(hua.getBytes("utf-8"),"iso8859-1");`终极转码方式


















