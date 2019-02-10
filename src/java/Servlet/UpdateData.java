package Servlet;
import javax.servlet.AsyncContext.*;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.ServletException;
public class UpdateData extends HttpServlet 
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
        resp.setContentType("text/html");
        PrintWriter out=resp.getWriter();
        /*String c="M1";
        String m = null,f=null;
        if(c == "M1")
        {
            m=" ";
            f="checked";
        }
        out.println("<html><body><form>");
        out.println("<input type='radio' name='GENDER' value='M'"+m+">Male");
        out.println("<input type='radio' name='GENDER' value='F'"+f+">Female");
        out.println("</form></body></html>");*/
        String m=null,f=null;
        CustomerUpdate cu=StoredCustData.getData(2);
        if("M".equals(cu.gen))
        {
            m= " checked";
            f= " ";
        }
        out.println("<html><body><form>");
        out.println("<input type='radio' name='GENDER' value='M' "+m+">Male<br>");
        out.println("<input type='radio' name='GENDER' value='F' "+f+">Female<br>");
        out.println("Name:<input type='text' name='NAME' value='"+cu.name+"'>");
        out.println("</form></body></html>");
    }
   
}
