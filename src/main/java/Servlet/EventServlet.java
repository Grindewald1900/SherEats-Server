package Servlet;

import Configuration.BasicConfig;
import Configuration.EntityConfig;
import DAO.EventDao;
import DAO.StoreDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet.EventServlet: a servlet deal with user login
 */
@WebServlet(name = "Servlet.EventServlet")
public class EventServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Servlet.EventServlet");
        // The result to be return
        String result = "";
        boolean isSuccess;
        EventDao myPOJO=new EventDao();

        doGet(request, response);
        // Set response header
        response.setContentType(BasicConfig.contentType);
        response.setCharacterEncoding(BasicConfig.encodingType);

        // Get parameters from url data
        int daoType = Integer.parseInt(request.getParameter(EntityConfig.DAO_TYPE));
        int userId = Integer.parseInt(request.getParameter(EntityConfig.USER_ID));
        int eventId, storeId;
        // Invoke userRegister(), connect to database and insert user info
        switch (daoType){
            case 1:
                eventId = Integer.parseInt(request.getParameter(EntityConfig.EVENT_ID));
                storeId = Integer.parseInt(request.getParameter(EntityConfig.STORE_ID));
                String eventType = request.getParameter(EntityConfig.EVENT_TYPE);
                result = myPOJO.addEvent(eventId, userId, storeId, eventType);
                break;
            case 2:
                storeId = Integer.parseInt(request.getParameter(EntityConfig.STORE_ID));
                result = myPOJO.removeEvent(storeId);
                break;
            case 3:
                result = myPOJO.getEvent(userId);
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