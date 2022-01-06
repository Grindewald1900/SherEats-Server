package Servlet;

import Configuration.BasicConfig;
import Configuration.EntityConfig;
import DAO.OrderDao;
import Entity.OrderItem;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.System.out;

@WebServlet(name = "Servlet.OrderServlet")
public class OrderServlet  extends javax.servlet.http.HttpServlet  {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        out.println("Servlet.OrderServlet");
        doGet(request, response);
        Map<String, Integer> map = new HashMap<String, Integer>();
        // The result to be return
        String result = "";
        boolean isSuccess = false;
        OrderDao myPOJO = new OrderDao();

        // Set response header
        response.setContentType(BasicConfig.contentType);
        response.setCharacterEncoding(BasicConfig.encodingType);

        // Get parameters from url data
        int daoType = Integer.parseInt(request.getParameter(EntityConfig.DAO_TYPE));
        // Get data from request body
        String body = getBodyTxt(request);
        Gson gson = new Gson();
        Type type = new TypeToken<List<OrderItem>>(){}.getType();
        List<OrderItem> items = gson.fromJson(body, type);

        // Invoke different method, according to daoType(from app)
        switch (daoType){
            case 1:
                // Add items to orders
                isSuccess = myPOJO.addOrder(items);
                if (isSuccess){
                    map.put("result", EntityConfig.STATE_SUCCESS);
                }else {
                    map.put("result", EntityConfig.STATE_FAIL);
                }
                result = gson.toJson(map);
                break;
            case 2:
                // Get order by order id
                String orderId = request.getParameter(EntityConfig.ORDER_ID);
                result = myPOJO.getOrderByOrder(orderId);
                break;
            case 3:
                // Get order by user id
                String userId = request.getParameter(EntityConfig.USER_ID);
                result = myPOJO.getOrderByUser(userId);
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

    String getBodyTxt(HttpServletRequest request) throws IOException {
        BufferedReader br = request.getReader();
        String str, wholeStr = "";
        while((str = br.readLine()) != null){
            wholeStr += str;
        }
//        String convertedSting = "{\"master\":"+wholeStr+"}";
        return wholeStr;
    }
}
