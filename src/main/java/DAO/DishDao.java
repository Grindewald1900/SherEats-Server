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

    /**
     * getDish: get dish info by restaurants id
     * @return jsonResult: result
     */
    public String getDishByKeyword(String keyword, Boolean typeRestaurant, Boolean typeDish, Boolean typeCuisine, Boolean typeLocation, Boolean typeAll){
        Boolean isMultiType = false;
        String jsonResult = "";
        String sql;
        if (typeAll){
            sql = "select * from items where restaurant_name like '%" +keyword+ "%' or  item_name like '%"+keyword+"%' or  item_genre like '%"+keyword+"%'";
        }else {
            sql = "select * from items where";
            if(typeRestaurant){
                sql = sql.concat(" restaurant_name like '%"+keyword+"%'");
                isMultiType = true;
            }
            if(typeDish){
                if (isMultiType)
                    sql = sql.concat(" or ");
                sql = sql.concat(" item_name like '%"+keyword+"%'");
                isMultiType = true;
            }
            if(typeCuisine){
                if (isMultiType)
                    sql = sql.concat(" or ");
                sql = sql.concat(" item_genre like '%"+keyword+"%'");
            }
        }
        try{
            System.out.println(sql);
            jsonResult = ConnectionUtil.getConnectionResult(sql, BasicConfig.executeQuery);

        }catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return jsonResult;
    }

}
