package Servlet;

import Configuration.BasicConfig;
import Configuration.EntityConfig;
import DAO.OrderDao;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import static java.lang.System.out;

@WebServlet(name = "Servlet.OrderServlet")
public class OrderServlet  extends javax.servlet.http.HttpServlet  {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        out.println("Servlet.OrderServlet");
        doGet(request, response);
        // The result to be return
        String result = "";
        boolean isSuccess;
        OrderDao myPOJO = new OrderDao();

        // Set response header
        response.setContentType(BasicConfig.contentType);
        response.setCharacterEncoding(BasicConfig.encodingType);

        // Get parameters from url data
        int id = Integer.parseInt(request.getParameter(EntityConfig.ID));
        int orderId = Integer.parseInt(request.getParameter(EntityConfig.ORDER_ID));
        int userId = Integer.parseInt(request.getParameter(EntityConfig.USER_ID));
        int storeId = Integer.parseInt(request.getParameter(EntityConfig.STORE_ID));
        // Yield this value from server side, DO NOT pass it from front end.
        Date time = new Date(System.currentTimeMillis());
//        Date time = new Date(Long.parseLong(request.getParameter(EntityConfig.UPLOAD_TIME)));
        int itemId = Integer.parseInt(request.getParameter(EntityConfig.ITEM_ID));
        int itemAmount = Integer.parseInt(request.getParameter(EntityConfig.ITEM_AMOUNT));
        int daoType = Integer.parseInt(request.getParameter(EntityConfig.DAO_TYPE));

        // Invoke different method, according to daoType(from app)
        switch (daoType){
            case 1:
                // Invoke userRegister(), connect to database and insert user info
                isSuccess = myPOJO.addOrder(id, orderId, userId, storeId, time, itemId, itemAmount);
                result = isSuccess?  BasicConfig.success : BasicConfig.fail;
                break;
            case 2:
                // Get order by id
                result = myPOJO.getOrder(id);
                break;
            default:
                break;
        }

        // Return result
        System.out.println(result);
        PrintWriter out = response.getWriter();
        out.write(result);
        out.flush();
        out.close();
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
    }
}
