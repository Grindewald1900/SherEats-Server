package DAO;

import Configuration.BasicConfig;
import Utils.ConnectionUtil;

/**
 * Database access object
 */
public class StoreDao {
    /**
     * getDish: get store info
     * @return jsonResult: result
     */
    public String getStore(){
        String jsonResult = "";
        String sql = "select * from stores";

        try{
            jsonResult = ConnectionUtil.getConnectionResult(sql, BasicConfig.executeQuery);

        }catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return jsonResult;
    }

    /**
     * getDish: get store info by id
     * @return jsonResult: result
     */
    public String getStoreById(int id){
        String jsonResult = "";
        String sql = "select * from stores where store_id = '"+id+"' ";

        try{
            jsonResult = ConnectionUtil.getConnectionResult(sql, BasicConfig.executeQuery);

        }catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return jsonResult;
    }

}
