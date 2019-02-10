package Servlet;
import java.util.*;
import java.sql.*;
public class Report 
{
    static ArrayList<CustomerDetails > getCustomerData(String name,String gen,int mem)
    {
        ArrayList<CustomerDetails> data=new ArrayList<CustomerDetails>();
        try
        {
            Connection con=MyOracleConnection2.getCon();
            Statement st=con.createStatement();
            String s="SELECT ID,NAME,GENDER,ADDRESS,MTYPE,USERNAME "
                    + " FROM CUSTOMER_MAST "
                    + " WHERE 1=1";
            if(name != null)
            {
                s=s +" AND NAME LIKE '"+name+"%'";
            }
            if(gen != null)
            {
                s=s +" AND GENDER='"+gen+"'";
            }
            if(mem !=0)
            {
                s=s +" AND MTYPE="+mem;
            }
            ResultSet rs=st.executeQuery(s);
            while(rs.next())
            {
                data.add(new CustomerDetails(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6)));
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return data;
    }
    /*public static void main(String[] args) 
    {
        ArrayList al=getCustomerData(null,null,0);
        for(Object c:al)
        {
            System.out.println(c);
        }
    }*/
}
