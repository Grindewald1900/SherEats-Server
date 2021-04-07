package Servlet;

import Configuration.BasicConfig;
import Configuration.EntityConfig;
import DAO.LoginDao;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "Servlet.LoginServlet")
public class LoginServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        System.out.println("Servlet.LoginServlet");

        doGet(request, response);
        // Set response header
        response.setContentType(BasicConfig.contentType);
        response.setCharacterEncoding(BasicConfig.encodingType);

        boolean isSuccess;
        String jsonResult;
        LoginDao MyPOJO=new LoginDao();

        String name=request.getParameter(EntityConfig.NAME);
        String password=request.getParameter(EntityConfig.PASSWORD);

        jsonResult = MyPOJO.isUserLogin(name,password);
        PrintWriter out = response.getWriter();

        // Return result
        out.write(jsonResult);
        out.flush();
        out.close();
        System.out.println(jsonResult);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
    }
}
