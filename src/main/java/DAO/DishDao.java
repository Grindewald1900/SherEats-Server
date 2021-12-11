package DAO;

import Configuration.BasicConfig;
import Utils.ConnectionUtil;

/**
 * Database access object
 */
public class DishDao {
    /**
     * getDish: get dish info
     * @return jsonResult: result
     */
    public String getDish(){
        String jsonResult = "";
        String sql = "select * from items";

        try{
            jsonResult = ConnectionUtil.getConnectionResult(sql, BasicConfig.executeQuery);

        }catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return jsonResult;
    }

    /**
     * getDish: get dish info by restaurants id
     * @return jsonResult: result
     */
    public String getDishById(int id){
        String jsonResult = "";
        String sql = "select * from items where restaurant_id = '"+id+"'";

        try{
            jsonResult = ConnectionUtil.getConnectionResult(sql, BasicConfig.executeQuery);

        }catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return jsonResult;
    }

}
