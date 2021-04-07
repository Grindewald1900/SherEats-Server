package Servlet;

import Configuration.BasicConfig;
import Configuration.EntityConfig;
import DAO.RegisterDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet.RegisterServlet: a servlet deal with user login
 */
@WebServlet(name = "Servlet.RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Servlet.RegisterServlet");
        // The result to be return
        String result;
        boolean isSuccess;
        RegisterDao myPOJO=new RegisterDao();

        doGet(request, response);
        // Set response header
        response.setContentType(BasicConfig.contentType);
        response.setCharacterEncoding(BasicConfig.encodingType);

        // Get parameters from url data
        int id = Integer.parseInt(request.getParameter(EntityConfig.ID));
        String name = request.getParameter(EntityConfig.NAME);
        String password = request.getParameter(EntityConfig.PASSWORD);
        String email = request.getParameter(EntityConfig.EMAIL);

        // Invoke userRegister(), connect to database and insert user info
        isSuccess = myPOJO.userRegister(id, name, password, email, new ByteArrayOutputStream());
        PrintWriter out = response.getWriter();

        // Return result
        result = isSuccess?  BasicConfig.success : BasicConfig.fail;
        System.out.println(result);
        out.write(result);
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
