package Servlet;
import java.sql.*;
public class StoredCustData 
{
    static CustomerUpdate getData(int id)
    {
        CustomerUpdate c=null;
        try
        {
            Connection con=MyOracleConnection2.getCon();
            String s="{call GET_CUSTOMER_DATA(?,?,?,?,?,?,?,?)}";
            CallableStatement cs=con.prepareCall(s);
            cs.setInt(1, id);
            cs.registerOutParameter(2,Types.VARCHAR);
            cs.registerOutParameter(3,Types.VARCHAR);
            cs.registerOutParameter(4,Types.VARCHAR);
            cs.registerOutParameter(5,Types.NUMERIC);
            cs.registerOutParameter(6,Types.NUMERIC);
            cs.registerOutParameter(7,Types.VARCHAR);
            cs.registerOutParameter(8,Types.VARCHAR);
            cs.execute();
            int mem=cs.getInt(5);int sal=cs.getInt(6);
            String name=cs.getString(2);String gen=cs.getString(3);String addr=cs.getString(4);String un=cs.getString(7);String pw=cs.getString(8);         
            c=new CustomerUpdate(id,name,gen,addr,mem,sal,un,pw);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return c;
    }
    /*public static void main(String[] args) 
    {
        CustomerUpdate data=getData(1);
        System.out.println(data.gen);
    }*/
}
