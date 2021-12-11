package DAO;

import Configuration.BasicConfig;
import Utils.ConnectionUtil;

/**
 * Database access object
 */
public class StoreDao {
    /**
     * getDish: get restaurants info
     * @return jsonResult: result
     */
    public String getStore(){
        String jsonResult = "";
        String sql = "select * from restaurants";

        try{
            jsonResult = ConnectionUtil.getConnectionResult(sql, BasicConfig.executeQuery);

        }catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return jsonResult;
    }

    /**
     * getDish: get restaurants info by id
     * @return jsonResult: result
     */
    public String getStoreById(int id){
        String jsonResult = "";
        String sql = "select * from restaurants where restaurant_id = '"+id+"' ";

        try{
            jsonResult = ConnectionUtil.getConnectionResult(sql, BasicConfig.executeQuery);

        }catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return jsonResult;
    }

}
