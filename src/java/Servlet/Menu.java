package Servlet;
import javax.servlet.AsyncContext.*;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;
public class Menu extends HttpServlet 
{

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
        resp.setContentType("text/html");
        PrintWriter out=resp.getWriter();
        out.println("<html><body><form action='Log' method='post'>");
        out.println("<input type='submit' value='LogOff'>");
        out.println("</form></body></html>");
    }   
}
