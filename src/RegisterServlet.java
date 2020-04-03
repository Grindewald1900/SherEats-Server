import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
        response.setContentType("text/html;charset=utf-8");
        //
        response.setCharacterEncoding("UTF-8");
        boolean b = false;
        Register myPOJO=new Register();

        String id=request.getParameter("id");
        String password=request.getParameter("password");
        String email = request.getParameter("email");

        String result = "";
        b=myPOJO.userregister(id,password,email);//连接数据库，插入该用户信息
        PrintWriter out = response.getWriter();//回应请求
        if(b){
            result = "success";
        }
        else{
            result = "fail";
        }
        out.write(result);
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
