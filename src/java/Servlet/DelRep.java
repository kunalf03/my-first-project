package Servlet;
import javax.servlet.AsyncContext.*;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.ServletException;
public class DelRep extends HttpServlet 
{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
        resp.setContentType("text/html");
        PrintWriter out=resp.getWriter();
        String s[]=req.getParameterValues("I");
        for(String id:s)
        {
           int i= DelDataOfDatabase.delData(id);
           out.println("<html></body>"+i+"< IS DELETED SUCCESSFULLY/body></html>");
        } 
        //resp.sendRedirect("Del");
    }    
}
