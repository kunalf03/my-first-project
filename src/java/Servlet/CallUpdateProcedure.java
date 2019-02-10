package Servlet;
import java.sql.*;
public class CallUpdateProcedure 
{
    static void sendData(int id,String n,String g,String a,int m,int sal,String u,String p)
    {
        try
        {
            Connection con=MyOracleConnection2.getCon();
            String pro="{call UPDATE_CUST_DATA(?,?,?,?,?,?,?,?)}";
            CallableStatement cs=con.prepareCall(pro);
            cs.setInt(1,id);
            cs.setString(2,n);
            cs.setString(3,g);
            cs.setString(4,a);
            cs.setInt(5,m);
            cs.setInt(6,sal);
            cs.setString(7,u);
            cs.setString(8,p);
            cs.execute();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
    }
    /*public static void main(String[] args) 
    {
        sendData(3,"MISS.POOJA FULE","F","MANEWADA", 1, 20000,"POOJA","P123");            
    }*/
}
