package DAO;

import Configuration.BasicConfig;
import Utils.ConnectionUtil;

public class EventDao {
    /**
     * addEvent: add event
     * @return jsonResult: if success
     */
    public String addEvent(int eventId, int userId, int restaurantId, String eventType){
        Boolean isSuccess = true;
        String sql = "insert into user_events values('"+eventId+"','"+userId+"','"+restaurantId+"','"+eventType+"')";
        try{
             ConnectionUtil.getConnectionResult(sql, BasicConfig.executeUpdate);

        }catch (Exception e) {
            e.printStackTrace();
            isSuccess = false;
            System.out.println(e.getMessage());
        }
        return isSuccess.toString();
    }

    /**
     * addEvent: add event
     * @return jsonResult: if success
     */
    public String removeEvent(int restaurantId){
        Boolean isSuccess = true;
        String sql = "delete from user_events where restaurantId = '"+restaurantId+"' ";
        try{
            ConnectionUtil.getConnectionResult(sql, BasicConfig.executeUpdate);

        }catch (Exception e) {
            e.printStackTrace();
            isSuccess = false;
            System.out.println(e.getMessage());
        }
        return isSuccess.toString();
    }

    /**
     * getDish: get event info by id
     * @return jsonResult: result
     */
    public String getEvent(int id){
        String jsonResult = "";
        String sql = "select * from restaurantId where restaurant_id in (select restaurant_id from user_events where user_id = '"+id+"') ";

        try{
            jsonResult = ConnectionUtil.getConnectionResult(sql, BasicConfig.executeQuery);

        }catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return jsonResult;
    }

}
