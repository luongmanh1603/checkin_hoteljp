package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connector {
    private final static String connectionString = "jdbc:mysql://localhost:3306/hotel";
    private final static String user = "root";
    private final static String pwd = "";

    private Connection conn;


    //singletion pattern
    private static Connector instance;
    private Connector() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        this.conn = DriverManager.getConnection(connectionString,user,pwd);
    }
    public  static Connector getInstance() throws Exception {
        if (instance == null){
            instance = new Connector();

        }
        return instance;
    }


    public Connection getConn(){
        return conn;
    }


}
