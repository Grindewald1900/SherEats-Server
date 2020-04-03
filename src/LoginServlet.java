import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request, response);
        System.out.println("BU");
        //设置客户端的解码方式为utf-8
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("UTF-8");

        boolean b = false;
        UserLogin MyPOJO=new UserLogin();//新建MyPOJO类的对象myPOJO

        //根据标示名获取JSP文件中表单所包含的参数
        String id=request.getParameter("id");
        String password=request.getParameter("password");
        String result = "";

        b = MyPOJO.isuserlogin(id,password);//使用模型对账号和密码进行验证，返回一个boolean类型的对象
        PrintWriter out = response.getWriter();//回应请求
        if(b){  //如果验证结果为真，跳转至登录成功页面
            result = "success";
        }
        else {  //如果验证结果为假，跳转至登录失败页面
            result = "fail";
        }
        out.write(result);
        out.flush();
        out.close();
        System.out.println(result);

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
}
