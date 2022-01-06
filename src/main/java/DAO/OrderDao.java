package DAO;

import Configuration.BasicConfig;
import Entity.OrderItem;
import Utils.ConnectionUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Database access object
 */
public class OrderDao {
    /**
     * addOrder: Insert order when user click on 'Checkout'

     * @return if successful
     */
    public boolean addOrder(List<OrderItem> items){
        boolean isValid = true;
        int size = items.size();
        ArrayList<String> sqls = new ArrayList<String>();
        String sqlGetId = "select * from orders where id = '"+items.get(0).getId()+"' ";
        String sql = "";

        for(int i=0; i<size; i++){
            OrderItem item = items.get(i);
            String temp = "insert into orders values" +
                    "('"+item.getId()+"','"+item.getOrder_id()+"','"+item.getUser_id()+"','"+item.getRestaurant_id()+"'" +
                    ",'"+item.getUpload_time()+"','"+item.getOrder_price()+"','"+item.getItem_id()+"'" +
                    ",'"+item.getItem_amount()+"','"+item.getItem_taste()+"' ,'"+item.getItem_environment()+"'" +
                    ",'"+item.getItem_service()+"' ,'"+item.getItem_name()+"' ,'"+item.getRestaurant_name()+"');";
            sqls.add(temp);
            sql = sql.concat(temp);
            sql = sql.concat("\n");
        }

        try{
            ConnectionUtil.getConnectionResult(sql, BasicConfig.executeUpdate);

        }catch (Exception e) {
            e.printStackTrace();
            isValid = false;
            System.out.println(e);
        }
        return isValid;
    }

    /**
     * getOrder: return order by id
     * @param userId
     * @return order info
     */
    public String getOrderByUser(String userId){
        String result = "";
        String sql = "select * from orders where user_id = '" +userId+ "'";
        try{
            result = ConnectionUtil.getConnectionResult(sql, BasicConfig.executeQuery);

        }catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return result;
    }

    /**
     * getOrder: return order by id
     * @param orderId
     * @return order info
     */
    public String getOrderByOrder(String orderId){
        String result = "";
        String sql = "select * from orders where order_id = '" + orderId + "'";

        try{
            result = ConnectionUtil.getConnectionResult(sql, BasicConfig.executeQuery);

        }catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return result;
    }

}
