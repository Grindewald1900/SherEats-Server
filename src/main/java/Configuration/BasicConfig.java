package Configuration;

public class BasicConfig {
    public static final String drv = "org.postgresql:postgresql-42.2.19";
    public static final String driver = "org.postgresql.Driver";
    public static final String url = "jdbc:postgresql://localhost:5432/ShereatsDB";
    public static final String usr = "postgres";
    public static final String pwd = "123456";


    public static final String contentType = "text/html;charset=utf-8";
    public static final String encodingType = "UTF-8";
    public static final String success = "success";
    public static final String fail = "fail";
    public static final int executeQuery = 101;
    public static final int executeUpdate = 102;

    public static final int registerDefault = 200; // Default, fail
    public static final int registerSuccess = 201; // Success
    public static final int registerDuplicateId = 202; // Duplicated ID
    public static final int registerDuplicateName = 203; // Duplicated Name



    //Database
    public static final String Restaurant = "restaurants";




}
