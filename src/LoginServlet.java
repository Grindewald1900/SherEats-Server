import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request, response);
        System.out.println("BU");
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("UTF-8");

        boolean b = false;
        UserLogin MyPOJO=new UserLogin();

        String id=request.getParameter("id");
        String password=request.getParameter("password");
        String result = "";

        b = MyPOJO.isuserlogin(id,password);
        PrintWriter out = response.getWriter();
        if(b){
            result = "success";
        }
        else {
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
