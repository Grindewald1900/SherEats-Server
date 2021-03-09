import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Register {

    public boolean userregister(String id,String password,String email){
        boolean b = false;
        String sql = "select * from login where name='"+id+"'";

        try{
            Class.forName(BasicConfig.drv).newInstance();
            Connection conn = DriverManager.getConnection(BasicConfig.url,BasicConfig.usr,BasicConfig.pwd);
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);

            if(!rs.next()){

                sql = "insert into login(name,password,email) values('"+id+"','"+password+"','"+email+"')";
                stm.execute(sql);
                b = true;
            }

            rs.close();
            stm.close();
            conn.close();
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }

        if(b)
        {
            return true;
        }
        else return false;
    }

}
