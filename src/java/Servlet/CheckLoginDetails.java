package Servlet;
import java.sql.*;
public class CheckLoginDetails 
{
    int checklogin(String u,String p)
    {
      int i=0;
        try{      
        Connection con=MyOracleConnection2.getCon();
        System.out.println("get connected");
        String f="{?=call GET_NAME(? ,?)}";
        CallableStatement cs=con.prepareCall(f);
        cs.registerOutParameter(1,Types.NUMERIC);
        cs.setString(2, u);
        cs.setString(3, p);
        cs.execute();
        i=cs.getInt(1);
       }catch(Exception e)
       {
           e.printStackTrace();
       }
        return i;
    }
    /*public static void main(String[] args) 
    {
        CheckLoginDetails obj=new CheckLoginDetails();
        int i=obj.checklogin("KUNAL","KUNAL123");
        System.out.println("c_id=" +i);
    }*/
}
