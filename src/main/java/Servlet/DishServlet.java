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
        String result, keyword;
        boolean isRestaurant, isDish, isCuisine, isLocation, isAll;
        DishDao myPOJO=new DishDao();

        doGet(request, response);
        // Set response header
        response.setContentType(BasicConfig.contentType);
        response.setCharacterEncoding(BasicConfig.encodingType);
        isRestaurant = Boolean.parseBoolean(request.getParameter(EntityConfig.TYPE_RESTAURANT));
        isDish = Boolean.parseBoolean(request.getParameter(EntityConfig.TYPE_DISH));
        isCuisine = Boolean.parseBoolean(request.getParameter(EntityConfig.TYPE_CUISINE));
        isLocation = Boolean.parseBoolean(request.getParameter(EntityConfig.TYPE_LOCATION));
        isAll = Boolean.parseBoolean(request.getParameter(EntityConfig.TYPE_ALL));
        keyword = request.getParameter(EntityConfig.KEYWORD);


        // Get parameters from url data
        if(Integer.parseInt(request.getParameter(EntityConfig.ID)) > 0){
            System.out.println("ID" + request.getParameter(EntityConfig.ID));
            result = myPOJO.getDishById(Integer.parseInt(request.getParameter(EntityConfig.ID)));
        }else {
            if(!keyword.equals("")){
                result = myPOJO.getDishByKeyword(keyword, isRestaurant, isDish, isCuisine, isLocation, isAll);
            }else {
                result = myPOJO.getDish();
            }
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
