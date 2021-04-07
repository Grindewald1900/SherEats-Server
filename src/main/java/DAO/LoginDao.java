package DAO;

import Configuration.BasicConfig;
import Utils.ConnectionUtil;


/**
 * Database access object
 */
public class LoginDao {

    /**
     * isUserLogin: if user exists, return user record
     * @param name: user name
     * @param password: user password
     * @return jsonResult: result
     */
    public String isUserLogin(String name, String password){
        String jsonResult = "";

        String sql = "select * from users where user_name='"+name+"' and user_password='"+password+"'";

        try{
            jsonResult = ConnectionUtil.getConnectionResult(sql, BasicConfig.executeQuery);

        }catch (Exception e) {
            e.printStackTrace();
        }
        return jsonResult;
    }

}
