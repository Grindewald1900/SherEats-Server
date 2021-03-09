import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserLogin {

    public boolean isuserlogin(String id,String password){
        boolean isValid = false;

        String sql="select * from login where name='"+id+"' and password='"+password+"'";
        try{
            Class.forName(BasicConfig.drv).newInstance();
            Connection conn = DriverManager.getConnection(BasicConfig.url,BasicConfig.usr,BasicConfig.pwd);
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);

            if(rs.next()){
                isValid = true;
            }

            rs.close();
            stm.close();
            conn.close();
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        if(isValid){
            return true;
        }
        else return false;
    }

}
