package Servlet;
import java.sql.*;
public class InsertIntoDb 
{
    static void setData(String name,String gen,String addr,int mem,int sal,String u,String p)
    {
        try
        {
            Connection con=MyOracleConnection2.getCon();
            String pro="{call REGISTER_DATA(?,?,?,?,?,?,?)}";
            CallableStatement cs=con.prepareCall(pro);
            cs.setString(1,name);
            cs.setString(2,gen);
            cs.setString(3,addr);
            cs.setInt(4, mem);
            cs.setInt(5, sal);
            cs.setString(6,u);
            cs.setString(7,p);
            cs.execute();
            cs.close();
            con.close();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
   /* public static void main(String[] args) 
    {
        setData("SUKRIT FULE","M","JARUD",3,30000,"SUKRIT","S123");
    }*/
}
