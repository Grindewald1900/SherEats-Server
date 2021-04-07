package Utils;

import java.sql.*;
import java.util.LinkedHashMap;
import java.util.Properties;

import Configuration.BasicConfig;
import org.json.*;


public class ConnectionUtil {
    public static String getConnectionResult(String sql, int type){
        String jsonResult = "";
        ResultSet result = null;
        try {
            // Load database driver
            Class.forName(BasicConfig.driver).newInstance();
            // Setup properties
            Properties properties = new Properties();
            properties.setProperty("user", BasicConfig.usr);
            properties.setProperty("password", BasicConfig.pwd);
            // Get connection
            Connection conn = DriverManager.getConnection(BasicConfig.url, properties);
            Statement stm = conn.createStatement();
            switch (type){
                case BasicConfig.executeQuery:
                    result = stm.executeQuery(sql);
                    break;
                case BasicConfig.executeUpdate:
                    stm.executeUpdate(sql);
                    break;
                default:
                    break;

            }
            if(null != result){
                jsonResult = resultSetToJson(result);
            }
            stm.close();
            conn.close();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e);
        }
        return jsonResult;
    }

    public static String resultSetToJson(ResultSet rs) throws SQLException,JSONException {
        String jsonResult = "";
        try{
            JSONArray array = new JSONArray();
            // Column count of result
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            // Iterate
            while (rs.next()) {
                JSONObject jsonObj = new JSONObject(new LinkedHashMap());

                // Each column of a record
                for (int i = 1; i <= columnCount; i++) {
                    String columnName = metaData.getColumnLabel(i);
                    String value = rs.getString(columnName);
                    jsonObj.put(columnName, value);
                }
                array.put(jsonObj);
            }
            jsonResult =  array.toString();

        }catch (Exception e){
            e.printStackTrace();
        }
        return jsonResult;
    }

    public static Boolean isNullOrEmpty(String str){
        return null != str && !str.trim().isEmpty();
    }

}
