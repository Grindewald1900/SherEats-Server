package DAO;

import Configuration.BasicConfig;
import Utils.ConnectionUtil;

public class BadgeDao {
    /**
     * getDish: get badge info by user id
     * @return jsonResult: result
     */
    public String getBadgeById(String id){
        String jsonResult = "";
        String sql = "select * from badges where user_id = '"+id+"'";

        try{
            jsonResult = ConnectionUtil.getConnectionResult(sql, BasicConfig.executeQuery);

        }catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return jsonResult;
    }
}
