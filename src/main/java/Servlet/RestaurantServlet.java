package Servlet;

import Configuration.BasicConfig;
import Configuration.EntityConfig;
import DAO.StoreDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Servlet.RestaurantServlet: a servlet deal Restaurant
 */
@WebServlet(name = "Servlet.RestaurantServlet")
public class RestaurantServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Servlet.RestaurantServlet");
        // The result to be return
        String result = "";
        StoreDao myPOJO=new StoreDao();

        // Set response header
        response.setContentType(BasicConfig.contentType);
        response.setCharacterEncoding(BasicConfig.encodingType);

        // Get parameters from url data
        int daoType = Integer.parseInt(request.getParameter(EntityConfig.DAO_TYPE));

        // Invoke userRegister(), connect to database and insert user info
        Map<String, String[]>  m = new HashMap<String, String[]>();
        m = request.getParameterMap();

        switch (daoType){
            case 1:
                result = myPOJO.getStore();
                break;
            case 2:
                int id = Integer.parseInt(request.getParameter(EntityConfig.ID));
                result = myPOJO.getStoreById(id);
                break;
            default:
                break;
        }
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
