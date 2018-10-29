# jsp九大内置对象

* jsp内置对象就是在jsp页面中可以使用的java类对象。

* 内置对象产生的时机

     >一个JSP页面对应一个Servlet类，每个Servlet类有三个方法：
　　    
     * init方法：初始化JSP/Servlet的方法。
　　    
     * destroy方法：销毁JSP/Servlet的方法。
　　    
     * service方法：对用户请求产生响应的方法。
　 　
   
* request对象和response对象是service方法的形参，
   
* application对象，page对象，out对象，pageContext对象，session对象都是service的方法中生成的实例。

### 一、request对象
* 客户端的请求信息被封装在request对象中，通过它才能了解到客户的需求，然后做出响应。它是HttpServletRequest类的实例。
* request对象具有请求域,即完成客户端的请求之前,该对象一直有效。

<table>
   <tr>
      <td>序号  </td>
      <td>方 法</td>
      <td>说 明</td>
   </tr>
   <tr>
      <td>1</td>
      <td>object getAttribute(String name)</td>
      <td>返回指定属性的属性值</td>
   </tr>
   <tr>
      <td>2</td>
      <td>Enumeration getAttributeNames()</td>
      <td>返回所有可用属性名的枚举</td>
   </tr>
   <tr>
      <td>3</td>
      <td>String getCharacterEncoding()</td>
      <td>返回字符编码方式</td>
   </tr>
   <tr>
      <td>4</td>
      <td>int getContentLength()</td>
      <td>返回请求体的长度（以字节数）</td>
   </tr>
   <tr>
      <td>5</td>
      <td>String getContentType() </td>
      <td>得到请求体的MIME类型</td>
   </tr>
   <tr>
      <td>6</td>
      <td>ServletInputStream getInputStream()</td>
      <td>得到请求体中一行的二进制流</td>
   </tr>
   <tr>
      <td>7</td>
      <td>String getParameter(String name) </td>
      <td>返回name指定参数的参数值</td>
   </tr>
   <tr>
      <td>8</td>
      <td>Enumeration getParameterNames()</td>
      <td>返回可用参数名的枚举</td>
   </tr>
   <tr>
      <td>9</td>
      <td>String[] getParameterValues(String name)</td>
      <td>返回包含参数name的所有值的数组</td>
   </tr>
   <tr>
      <td>10</td>
      <td>String getProtocol()</td>
      <td>返回请求用的协议类型及版本号</td>
   </tr>
   <tr>
      <td>11</td>
      <td>String getScheme()</td>
      <td>返回请求用的计划名,如:http.https及ftp等</td>
   </tr>
   <tr>
      <td>12</td>
      <td>String getServerName()</td>
      <td>返回接受请求的服务器主机名</td>
   </tr>
   <tr>
      <td>13</td>
      <td>int getServerPort()</td>
      <td>返回服务器接受此请求所用的端口号</td>
   </tr>
   <tr>
      <td>14</td>
      <td>BufferedReader getReader()</td>
      <td>返回解码过了的请求体</td>
   </tr>
   <tr>
      <td>15</td>
      <td>String getRemoteAddr()</td>
      <td>返回发送此请求的客户端IP地址</td>
   </tr>
   <tr>
      <td>16</td>
      <td>String getRemoteHost()</td>
      <td>返回发送此请求的客户端主机名</td>
   </tr>
   <tr>
      <td>17</td>
      <td>void setAttribute(String key,Object obj)</td>
      <td>设置属性的属性值</td>
   </tr>
   <tr>
      <td>18</td>
      <td>String getRealPath(String path)</td>
      <td>返回一虚拟路径的真实路径</td>
   </tr>
   <tr>
      <td>19</td>
      <td>String request.getContextPath()</td>
      <td>返回上下文路径</td>
   </tr>
</table>


### 二、response对象
* response对象包含了响应客户请求的有关信息，但在JSP中很少直接用到它。它是HttpServletResponse类的实例。
* response对象具有页面作用域，即访问一个页面时，该页面内的response对象只能对这次访问有效，其它页面的response对象对当前页面无效。

<table>
   <tr>
      <td>序号  </td>
      <td>方 法</td>
      <td>说 明</td>
   </tr>
   <tr>
      <td>1</td>
      <td>String getCharacterEncoding() </td>
      <td>返回响应用的是何种字符编码</td>
   </tr>
   <tr>
      <td>2</td>
      <td>ServletOutputStream getOutputStream() </td>
      <td>返回响应的一个二进制输出流</td>
   </tr>
   <tr>
      <td>3</td>
      <td>PrintWriter getWriter() </td>
      <td>返回可以向客户端输出字符的一个对象</td>
   </tr>
   <tr>
      <td>4</td>
      <td>void setContentLength(int len) </td>
      <td>设置响应头长度</td>
   </tr>
   <tr>
      <td>5</td>
      <td>void setContentType(String type) </td>
      <td>设置响应的MIME类型</td>
   </tr>
   <tr>
      <td>6</td>
      <td>sendRedirect(java.lang.String location) </td>
      <td>重新定向客户端的请求</td>
   </tr>
</table>

### 三、session对象
* session对象指的是客户端与服务器的一次会话，从客户端连到服务器的一个WebApplication开始，直到客户端与服务器断开连接为止。它是HttpSession类的实例。
* Session对象是一个JSP内置对象，它在第一个JSP页面被装载时 自动创建，完成会话期管理。从一个客户打开浏览器并连接到服务器开始，到客户关闭浏览器离开这个服务器结束，被称为一个会话。当一个客户访问一个服务器 时，可能会在这个服务器的几个页面之间切换，服务器应当通过某种办法知道这是一个客户，就需要Session对象。
* session对象具有会话作用域。

<table>
   <tr>
      <td>序号  </td>
      <td>方 法</td>
      <td>说 明</td>
   </tr>
   <tr>
      <td>1</td>
      <td>long getCreationTime() </td>
      <td>返回SESSION创建时间</td>
   </tr>
   <tr>
      <td>2</td>
      <td>public String getId() </td>
      <td>返回SESSION创建时JSP引擎为它设的唯一ID号</td>
   </tr>
   <tr>
      <td>3</td>
      <td>long getLastAccessedTime() </td>
      <td>返回此SESSION里客户端最近一次请求时间</td>
   </tr>
   <tr>
      <td>4</td>
      <td>int getMaxInactiveInterval() </td>
      <td>返回两次请求间隔多长时间此SESSION被取消(ms)</td>
   </tr>
   <tr>
      <td>5</td>
      <td>String[] getValueNames() </td>
      <td>返回一个包含此SESSION中所有可用属性的数组</td>
   </tr>
   <tr>
      <td>6</td>
      <td>void invalidate() </td>
      <td>取消SESSION，使SESSION不可用</td>
   </tr>
   <tr>
      <td>7</td>
      <td>boolean isNew() </td>
      <td>返回服务器创建的一个SESSION,客户端是否已经加入</td>
   </tr>
   <tr>
      <td>8</td>
      <td>void removeValue(String name) </td>
      <td>删除SESSION中指定的属性</td>
   </tr>
   <tr>
      <td>9</td>
      <td>void setMaxInactiveInterval() </td>
      <td>设置两次请求间隔多长时间此SESSION被取消(ms)</td>
   </tr>
</table>


### 四、out对象
* out对象是JspWriter类的实例,是向客户端输出内容常用的对象

<table>
   <tr>
      <td>序号  </td>
      <td>方 法</td>
      <td>说 明</td>
   </tr>
   <tr>
      <td>1</td>
      <td>void clear() </td>
      <td>清除缓冲区的内容</td>
   </tr>
   <tr>
      <td>2</td>
      <td>void clearBuffer() </td>
      <td>清除缓冲区的当前内容</td>
   </tr>
   <tr>
      <td>3</td>
      <td>void flush() </td>
      <td>清空流</td>
   </tr>
   <tr>
      <td>4</td>
      <td>int getBufferSize() </td>
      <td>返回缓冲区以字节数的大小，如不设缓冲区则为0</td>
   </tr>
   <tr>
      <td>5</td>
      <td>int getRemaining() </td>
      <td>返回缓冲区还剩余多少可用</td>
   </tr>
   <tr>
      <td>6</td>
      <td>boolean isAutoFlush() </td>
      <td>返回缓冲区满时，是自动清空还是抛出异常</td>
   </tr>
   <tr>
      <td>7</td>
      <td>void close() </td>
      <td>关闭输出流</td>
   </tr>
   <tr>
      <td>8</td>
      <td>void removeValue(String name) </td>
      <td>删除SESSION中指定的属性</td>
   </tr>
   <tr>
      <td>9</td>
      <td>void setMaxInactiveInterval() </td>
      <td>设置两次请求间隔多长时间此SESSION被取消(ms)</td>
   </tr>
</table>

### 五、page对象
* page对象就是指向当前JSP页面本身，有点象类中的this指针，它是java.lang.Object类的实例

<table>
   <tr>
      <td>序号  </td>
      <td>方 法</td>
      <td>说 明</td>
   </tr>
   <tr>
      <td>1</td>
      <td>class getClass </td>
      <td>返回此Object的类</td>
   </tr>
   <tr>
      <td>2</td>
      <td>int hashCode() </td>
      <td>返回此Object的hash码</td>
   </tr>
   <tr>
      <td>3</td>
      <td>boolean equals(Object obj) </td>
      <td>判断此Object是否与指定的Object对象相等</td>
   </tr>
   <tr>
      <td>4</td>
      <td>void copy(Object obj) </td>
      <td>把此Object拷贝到指定的Object对象中</td>
   </tr>
   <tr>
      <td>5</td>
      <td>Object clone() </td>
      <td>克隆此Object对象</td>
   </tr>
   <tr>
      <td>6</td>
      <td>String toString() </td>
      <td>把此Object对象转换成String类的对象</td>
   </tr>
   <tr>
      <td>7</td>
      <td>void notify() </td>
      <td>唤醒一个等待的线程</td>
   </tr>
   <tr>
      <td>8</td>
      <td>void notifyAll() </td>
      <td>唤醒所有等待的线程</td>
   </tr>
   <tr>
      <td>9</td>
      <td>void wait(int timeout) </td>
      <td>使一个线程处于等待直到timeout结束或被唤醒</td>
   </tr>
   <tr>
      <td>10</td>
      <td>void wait() </td>
      <td>使一个线程处于等待直到被唤醒</td>
   </tr>
   <tr>
      <td>11</td>
      <td>void enterMonitor() </td>
      <td>对Object加锁</td>
   </tr>
   <tr>
      <td>12</td>
      <td>void exitMonitor() </td>
      <td>对Object开锁</td>
   </tr>
</table>

### 六、application对象
* application对象实现了用户间数据的共享，可存放全局变量。它 开始于服务器的启动，直到服务器的关闭，在此期间，此对象将一直存在；这样在用户的前后连接或不同用户之间的连接中，可以对此对象的同一属性进行操作；在 任何地方对此对象属性的操作，都将影响到其他用户对此的访问。服务器的启动和关闭决定了application对象的生命。它是 ServletContext类的实例。

<table>
   <tr>
      <td>序号  </td>
      <td>方 法</td>
      <td>说 明</td>
   </tr>
   <tr>
      <td>1</td>
      <td>Object getAttribute(String name) </td>
      <td>返回给定名的属性值</td>
   </tr>
   <tr>
      <td>2</td>
      <td>Enumeration getAttributeNames() </td>
      <td>返回所有可用属性名的枚举</td>
   </tr>
   <tr>
      <td>3</td>
      <td>void setAttribute(String name,Object obj) </td>
      <td>设定属性的属性值</td>
   </tr>
   <tr>
      <td>4</td>
      <td>void removeAttribute(String name) </td>
      <td>删除一属性及其属性值</td>
   </tr>
   <tr>
      <td>5</td>
      <td>String getServerInfo() </td>
      <td>返回JSP(SERVLET)引擎名及版本号</td>
   </tr>
   <tr>
      <td>6</td>
      <td>String getRealPath(String path) </td>
      <td>返回一虚拟路径的真实路径</td>
   </tr>
   <tr>
      <td>7</td>
      <td>ServletContext getContext(String uripath) </td>
      <td>返回指定WebApplication的application对象</td>
   </tr>
   <tr>
      <td>8</td>
      <td>int getMajorVersion() </td>
      <td>返回服务器支持的Servlet API的最大版本号</td>
   </tr>
   <tr>
      <td>9</td>
      <td>int getMinorVersion() </td>
      <td>返回服务器支持的Servlet API的最小版本号</td>
   </tr>
   <tr>
      <td>10</td>
      <td>String getMimeType(String file) </td>
      <td>返回指定文件的MIME类型</td>
   </tr>
   <tr>
      <td>11</td>
      <td>URL getResource(String path) </td>
      <td>返回指定资源(文件及目录)的URL路径</td>
   </tr>
   <tr>
      <td>12</td>
      <td>InputStream getResourceAsStream(String path) </td>
      <td>返回指定资源的输入流</td>
   </tr>
   <tr>
      <td>13</td>
      <td>RequestDispatcher getRequestDispatcher(String uripath) </td>
      <td>返回指定资源的RequestDispatcher对象</td>
   </tr>
   <tr>
      <td>14</td>
      <td>Servlet getServlet(String name) </td>
      <td>返回指定名的Servlet</td>
   </tr>
   <tr>
      <td>15</td>
      <td>Enumeration getServlets() </td>
      <td>返回所有Servlet的枚举</td>
   </tr>
   <tr>
      <td>16</td>
      <td>Enumeration getServletNames() </td>
      <td>返回所有Servlet名的枚举</td>
   </tr>
   <tr>
      <td>17</td>
      <td>void log(String msg) </td>
      <td>把指定消息写入Servlet的日志文件</td>
   </tr>
   <tr>
      <td>18</td>
      <td>void log(Exception exception,String msg) </td>
      <td>把指定异常的栈轨迹及错误消息写入Servlet的日志文件</td>
   </tr>
   <tr>
      <td>19</td>
      <td>void log(String msg,Throwable throwable) </td>
      <td>把栈轨迹及给出的Throwable异常的说明信息 写入Servlet的日志文件</td>
   </tr>
</table>

### 七、exception对象
* exception对象是一个例外对象，当一个页面在运行过程中发生了例外，就产生这个对象。如果一个JSP页面要应用此对象，就必须把isErrorPage设为true，否则无法编译。他实际上是java.lang.Throwable的对象

<table>
   <tr>
      <td>序号  </td>
      <td>方 法</td>
      <td>说 明</td>
   </tr>
   <tr>
      <td>1</td>
      <td>String getMessage() </td>
      <td>返回描述异常的消息</td>
   </tr>
   <tr>
      <td>2</td>
      <td>String toString() </td>
      <td>返回关于异常的简短描述消息</td>
   </tr>
   <tr>
      <td>3</td>
      <td>void printStackTrace() </td>
      <td>显示异常及其栈轨迹</td>
   </tr>
   <tr>
      <td>4</td>
      <td>Throwable FillInStackTrace() </td>
      <td>重写异常的执行栈轨迹</td>
   </tr>
</table>


### 八、pageContext对象
* pageContext对象提供了对JSP页面内所有的对象及名字空间的访问，也就是说他可以访问到本页所在的SESSION，也可以取本页面所在的application的某一属性值，他相当于页面中所有功能的集大成者，它的本类名也叫pageContext。


<table>
   <tr>
      <td>序号  </td>
      <td>方 法</td>
      <td>说 明</td>
   </tr>
   <tr>
      <td>1</td>
      <td>JspWriter getOut() </td>
      <td>返回当前客户端响应被使用的JspWriter流(out)</td>
   </tr>
   <tr>
      <td>2</td>
      <td>HttpSession getSession() </td>
      <td>返回当前页中的HttpSession对象(session)</td>
   </tr>
   <tr>
      <td>3</td>
      <td>Object getPage() </td>
      <td>返回当前页的Object对象(page)</td>
   </tr>
   <tr>
      <td>4</td>
      <td>ServletRequest getRequest() </td>
      <td>返回当前页的ServletRequest对象(request)</td>
   </tr>
   <tr>
      <td>5</td>
      <td>ServletResponse getResponse() </td>
      <td>返回当前页的ServletResponse对象(response)</td>
   </tr>
   <tr>
      <td>6</td>
      <td>Exception getException() </td>
      <td>返回当前页的Exception对象(exception)</td>
   </tr>
   <tr>
      <td>7</td>
      <td>ServletConfig getServletConfig() </td>
      <td>返回当前页的ServletConfig对象(config)</td>
   </tr>
   <tr>
      <td>8</td>
      <td>ServletContext getServletContext() </td>
      <td>返回当前页的ServletContext对象(application)</td>
   </tr>
   <tr>
      <td>9</td>
      <td>void setAttribute(String name,Object attribute) </td>
      <td>设置属性及属性值</td>
   </tr>
   <tr>
      <td>10</td>
      <td>void setAttribute(String name,Object obj,int scope) </td>
      <td>在指定范围内设置属性及属性值</td>
   </tr>
   <tr>
      <td>11</td>
      <td>public Object getAttribute(String name) </td>
      <td>取属性的值</td>
   </tr>
   <tr>
      <td>12</td>
      <td>Object getAttribute(String name,int scope) </td>
      <td>在指定范围内取属性的值</td>
   </tr>
   <tr>
      <td>13</td>
      <td>public Object findAttribute(String name) </td>
      <td>寻找一属性,返回起属性值或NULL</td>
   </tr>
   <tr>
      <td>14</td>
      <td>void removeAttribute(String name) </td>
      <td>删除某属性</td>
   </tr>
   <tr>
      <td>15</td>
      <td>void removeAttribute(String name,int scope) </td>
      <td>在指定范围删除某属性</td>
   </tr>
   <tr>
      <td>16</td>
      <td>int getAttributeScope(String name) </td>
      <td>返回某属性的作用范围</td>
   </tr>
   <tr>
      <td>17</td>
      <td>Enumeration getAttributeNamesInScope(int scope) </td>
      <td>返回指定范围内可用的属性名枚举</td>
   </tr>
   <tr>
      <td>18</td>
      <td>void release() </td>
      <td>释放pageContext所占用的资源</td>
   </tr>
   <tr>
      <td>19</td>
      <td>void forward(String relativeUrlPath) </td>
      <td>使当前页面重导到另一页面</td>
   </tr>
   <tr>
      <td>20</td>
      <td>void include(String relativeUrlPath) </td>
      <td>在当前位置包含另一文件</td>
   </tr>
</table>


### 九、config对象
config对象是在一个Servlet初始化时，JSP引擎向它传递信息用的，此信息包括Servlet初始化时所要用到的参数（通过属性名和属性值构成）以及服务器的有关信息（通过传递一个ServletContext对象）

<table>
   <tr>
      <td>序号  </td>
      <td>方 法</td>
      <td>说 明</td>
   </tr>
   <tr>
      <td>1</td>
      <td>ServletContext getServletContext() </td>
      <td>返回含有服务器相关信息的ServletContext对象</td>
   </tr>
   <tr>
      <td>2</td>
      <td>String getInitParameter(String name) </td>
      <td>返回初始化参数的值</td>
   </tr>
   <tr>
      <td>3</td>
      <td>Enumeration getInitParameterNames() </td>
      <td>返回Servlet初始化所需所有参数的枚举</td>
   </tr>
</table>































