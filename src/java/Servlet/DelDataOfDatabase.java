package Servlet;
import java.sql.*;
public class DelDataOfDatabase 
{
    static int delData(String id)
    {
        int i=Integer.parseInt(id);
        try
        {
            Connection con=MyOracleConnection2.getCon();
            Statement st=con.createStatement();
            String s=" DELETE CUSTOMER_MAST WHERE ID= "+i;
            st.execute(s);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return i;
    }
    /*public static void main(String[] args) 
    {
        
        int i=delData(21);
        System.out.println(i+" is successfully delete");
    }*/
}
