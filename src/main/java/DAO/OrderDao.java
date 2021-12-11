package DAO;

import Configuration.BasicConfig;
import Utils.ConnectionUtil;

/**
 * Database access object
 */
public class OrderDao {
    /**
     * addOrder: Insert order when user click on 'Checkout'
     * @param sequenceId: inner id in a certain order
     * @param orderId: order id
     * @param userId: the user who placed this order
     * @param restaurantId: the restaurant that provide the dish
     * @param time: upload time
     * @param itemId: dish id
     * @param amount: amount
     * @return if successful
     */
    public boolean addOrder(int sequenceId, int orderId, int userId, int restaurantId, java.sql.Date time, int itemId, int amount){
        boolean isValid = true;
        String sql = "insert into orders values('"+sequenceId+"','"+orderId+"','"+userId+"','"+restaurantId+"','"+time+"','"+itemId+"','"+amount+"')";

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
     * @param id
     * @return order info
     */
    public String getOrder(int id){
        String result = "";
        String sql = "select" +
                "       public.orders.order_id," +
                "       (select public.users.user_name from users where public.users.user_id = '"+id+"')," +
                "       '"+id+"' as user_id," +
                "       public.orders.upload_time," +
                "       sum(items.item_price * public.orders.item_amount * items.item_discount) as order_price," +
                "       (select public.stores.store_tel from stores where stores.store_id  = orders.store_id)," +
                "       string_agg(concat_ws('*', orders.item_amount, items.item_name),  ' , ') as order_content\n" +
                "\n" +
                "from items,public.orders\n" +
                "where items.item_id = public.orders.item_id and public.orders.user_id = '"+id+"'\n" +
                "group by public.orders.order_id, public.orders.upload_time, public.orders.store_id, public.items.item_name\n" +
                "order by public.orders.order_id ASC";

        try{
            result = ConnectionUtil.getConnectionResult(sql, BasicConfig.executeQuery);

        }catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return result;
    }

}
