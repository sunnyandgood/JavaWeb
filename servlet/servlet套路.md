# servlet套路

* 1、创建form表单，确定提交方式

* 2、创建servlet类：创建类，继承HttpServlet，该类在servlet-api.jar；复写doGet/doPost方法

* 3、配置请求映射
    ```xml
    <servlet>
         <!--servlet名称，与配置文件中的<servlet-mapping>标签中的servlet-name匹配-->
         <servlet-name>servlet01</servlet-name>
         <!--servlet类的全名称，原理：Java反射机制-->
         <servlet-class>com.wxkj.servlet.action.ServletAction</servlet-class>
    </servlet>
    <servlet-mapping>
          <!--servlet名称，与配置文件中的<servlet>标签中的servlet-name匹配-->
          <servlet-name>servlet01</servlet-name>
          <!--响应请求，当浏览器请求到达时，此处首先匹配-->
          <url-pattern>/form01</url-pattern>
    </servlet-mapping>
    ```
* 4、表单的method属性决定了servlet类对象呗访问的是doGet还是doPost
    * method属性值为get，则访问doGet
    * method属性值为post，则访问doPost
    * 超链接相当于显示提交，访问doGet
    * 浏览器地址栏直接敲请求，也为get方式

* 5、servlet生命周期	
    * init()初始化方法，当servlet被创建时调用，一般做初始化处理
    * service(HttpServletRequest arg0, HttpServletResponse arg1)
        * 整个生命周期过程中调用的方法，所有的请求都走service方法
        * 如果service方法中调用父类service方法，则根据提交方式自动分发给doGet/doPost方法
    * destroy()销毁，当servlet被销毁时调用，一般做警告处理

* 6、`<load-on-startup>0</load-on-startup>`
	  
    * 当服务器启动时创建servlet实例
	  * 标签包裹的部分为整数类型数字
	  * 当数字大于等于0时，数字越小，创建越早
	  * 当数字小于0时，等同于不写该标签 

* 7、自定义方法的使用
	  
    * 创建自定义方法，在service方法中进行调用
	  
    * 在请求中添加状态参数，service根据状态参数来决定调用哪一个自定义方法
  
  
  
  
  
  
  
  
  
  
  
