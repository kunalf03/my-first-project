package Servlet;
import javax.servlet.AsyncContext.*;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.ServletException;
public class LogOf extends HttpServlet
{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
        HttpSession s=req.getSession();
        s.invalidate();
        resp.sendRedirect("pkf");
    }
    
    
}
