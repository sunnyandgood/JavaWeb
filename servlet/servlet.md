# servlet

### 一、servlet的创建
* 1、继承`servlet-api.jar`包内的`HttpServlet`类即可。

     >eg:
     ```java
     public class StoreServlet extends HttpServlet{
        private static final long serialVersionUID = 1L;
        @Override
        protected void service(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
          // TODO Auto-generated method stub
          super.service(request, response);
        }
     }
     ```
* 2、`private static final long serialVersionUID = 1L;`的作用：

      >作用：防止类对象冲突，给类的对象编号。


































