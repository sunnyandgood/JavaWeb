# 访问web-inf下面的文件的方法
### 方法1：

* 本来WEB-INF中的jsp就是无法通过地址栏访问的.所以安全.如果说要访问这个文件夹中的jsp文件需要在项目的`web.xml`文件中去配置servlet格式差不多的配置就ok了。如下:

  ```xml
  <servlet>
    <servlet-name>runtain</servlet-name>
    <jsp-file>/WEB-INF/INF.jsp</jsp-file>
  </servlet>
  <servlet-mapping>
    <servlet-name>runtain</servlet-name>
    <url-pattern>/XXX</url-pattern>
  </servlet-mapping>
  ```

* 访问地址:`http://localhost:8080/runtain/xxx`就可以看见内容了!

### 方法2：`<jsp:forward page ="/WEB-INF/jsp/test/test.jsp" />`

### 方法3：
* `request.getRequestDispatcher("/WEB-INF/a.jsp").forward(request,response);`

* 怎么样让servlet访问web-inf下的网页或jsp文件呢.因为web-inf下,应用服务器把它指为禁访目录,即直接在浏览器里是不能访问到的.
因些,可以让servlet进行访问,如web-inf下有a.jsp则可以用`request.getRequestDispatcher("/WEB-INF/a.jsp").forward(request,response);`进行派遣访问.但如果web-inf下有a.htm,则用`request.getRequestDispatcher("/WEB-INF/a.htm").forward(request,response)`;就不能访问.

  ```xml
  <servlet-mapping>
    <servlet-name>jsp</servlet-name>
    <url-pattern>*.jsp</url-pattern>
  </servlet-mapping>
  ```
  ```xml
  <servlet-mapping>
    <servlet-name>jsp</servlet-name>
    <url-pattern>*.htm</url-pattern>
  </servlet-mapping>
  <servlet-mapping>
    <servlet-name>jsp</servlet-name>
    <url-pattern>*.html</url-pattern>
  </servlet-mapping>
  ```

* 结果:访问a.htm,和a.html在work/web-inf/下者有a$htm.class,a$html.class生成
