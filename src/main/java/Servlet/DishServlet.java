package Servlet;

import Configuration.BasicConfig;
import Configuration.EntityConfig;
import DAO.DishDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet.RegisterServlet: a servlet deal with user login
 */
@WebServlet(name = "Servlet.DishServlet")
public class DishServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Servlet.DishServlet");
        // The result to be return
        String result;
        boolean isSuccess;
        DishDao myPOJO=new DishDao();

        doGet(request, response);
        // Set response header
        response.setContentType(BasicConfig.contentType);
        response.setCharacterEncoding(BasicConfig.encodingType);

        // Get parameters from url data
        if(Integer.parseInt(request.getParameter(EntityConfig.ID)) > 0){
            System.out.println("ID" + request.getParameter(EntityConfig.ID));
            result = myPOJO.getDishById(Integer.parseInt(request.getParameter(EntityConfig.ID)));
        }else {
            result = myPOJO.getDish();
        }

        // Invoke userRegister(), connect to database and insert user info
        PrintWriter out = response.getWriter();

        System.out.println(result);
        // Return result
        out.write(result);
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
