package Servlet;
import javax.servlet.AsyncContext.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.Date;
import javax.servlet.ServletException;
public class Servlet1 extends HttpServlet 
{
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException 
    {
        System.out.println("output from do get");
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        Date d=new Date();
        out.println("<html><body>Do-Get "+d+ "</body><html>");  
         
    }
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException 
    {
        System.out.println("output from do post");
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        Date d=new Date();
        out.println("<html><body>do-post "+d+ "</body><html>");  
         
    }
}
