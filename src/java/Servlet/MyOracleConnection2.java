package Servlet;
import java.sql.*;
public class MyOracleConnection2 
{
    public static Connection getCon() throws ClassNotFoundException
    {
        Connection con=null;
        try
        {
            String url="jdbc:oracle:thin:@localhost:1521:ORCL2";
            Class.forName("oracle.jdbc.driver.OracleDriver"); 
            con=DriverManager.getConnection(url,"kunal","k");
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return con;
    }  
}
