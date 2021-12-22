package DAO;

import Configuration.BasicConfig;
import Utils.ConnectionUtil;

import java.io.ByteArrayOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.Properties;

/**
 * Database access object
 */
public class RegisterDao {

    /**
     * userRegister: add user into database
     * @param id id
     * @param name name
     * @param password password
     * @param email email
     * @param img img
     * @return if no identical user exists, return success
     */
    public int userRegister(String id, String name, String password, String email, ByteArrayOutputStream img){
        int register = BasicConfig.registerDefault;
        String sqlGetId = "select * from users where user_id = '"+id+"' ";
        String sqlGetName = "select * from users where user_name = '"+name+"' ";

        String sqlAddUser = "insert into users(user_id, user_name , user_password, user_birthday, user_gender, user_tel," +
                " user_mail, user_icon) " + "values('"+id+"', '"+name+"','"+password+"', '"+new Date(1994, 9, 24)+"'" +
                "," + "'M', '8008008888', '"+email+"', '"+img+"')";

        try{
            Class.forName(BasicConfig.driver).newInstance();

            Properties properties = new Properties();
            properties.setProperty("user", BasicConfig.usr);
            properties.setProperty("password", BasicConfig.pwd);
            Connection conn = DriverManager.getConnection(BasicConfig.url, properties);
            Statement stm = conn.createStatement();
            ResultSet resultId = stm.executeQuery(sqlGetId);
            if(resultId.next()){
                register = BasicConfig.registerDuplicateId;
                return register;
            }
            ResultSet resultName = stm.executeQuery(sqlGetName);

            if(resultName.next()){
                register = BasicConfig.registerDuplicateName;
                return register;
            }
            stm.execute(sqlAddUser);
            register = BasicConfig.registerSuccess;

            resultId.close();
            resultName.close();
            stm.close();
            conn.close();
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }

        return register;
    }

}
