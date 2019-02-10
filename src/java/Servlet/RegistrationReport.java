package Servlet;
import javax.servlet.AsyncContext.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.ArrayList;
import javax.servlet.ServletException;
public class RegistrationReport extends HttpServlet 
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
        resp.setContentType("text/html");
        PrintWriter out=resp.getWriter();
        out.println("<html>\n"
                + "    <head>\n"
                + "        <title>Search</title>\n"
                + "    </head>\n"
                + "    <body>\n"
                + "        <form action='Rep' method='post'>\n"
                + "            <table border='1'>\n"
                + "                <tr>\n"
                + "                    <td>Enter Name:</td>\n"
                + "                    <td>\n"
                + "                        <input type='text' name='NAME' size='40'>\n"
                + "                    </td>\n"
                + "                </tr>\n"
                + "                <tr>\n"
                + "                    <td>Select Membership:</td>\n"
                + "                    <td>\n"
                + "                        <select name='MTYPE'>\n"
                + "                            <option value='0'>---Select---\n"
                + "                            <option value='1'>Platinum\n"
                + "                            <option value='2'>Gold\n"
                + "                            <option value='3'>Silver\n"
                + "                        </select>\n"
                + "                    </td>\n"
                + "                </tr>\n"
                + "                <tr>\n"
                + "                    <td>Gender:</td>\n"
                + "                    <td>\n"
                + "                        <input type='radio' name='GENDER' size='40' value='M'>Male<br>\n"
                + "                        <input type='radio' name='GENDER' size='40' value='F'>Female\n"
                + "                    </td>\n"
                + "                </tr>\n"
                + "                <tr>\n"
                + "                    <td colspan='2'>\n"
                + "                        <center>\n"
                + "                            <input type='submit' value='Show'>\n"
                + "                             <input type='reset' value='clear'>\n"
                + "                        </center>\n"
                + "                    </td>\n"
                + "                </tr>\n"
                + "            </table>\n"
                + "        </form>\n"
                + "    </body>\n"
                + "</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
        resp.setContentType("text/html");
        PrintWriter out=resp.getWriter();
        String name=(String)req.getParameter("NAME");
        int mem=Integer.parseInt(req.getParameter("MTYPE"));
        String gen=req.getParameter("GENDER");
        ArrayList<CustomerDetails> al=Report.getCustomerData(name, gen, mem);
        out.println("<html><head><title>Report</title></head>");
        out.println("<body><form action='Rep'><table border=1>");
        out.println("<tr><th>ID</th><th>NAME</th><th>ADDRESS</th><th>GENDER</th><th>MTYPE</th><th>USERNAME</th></tr>");
        for(CustomerDetails s:al)
        {
             out.println("<tr><td>"+s.id+"</td>");
             out.println("<td>"+s.name+"</td>");
             out.println("<td>"+s.gen+"</td>");
             out.println("<td>"+s.addr+"</td>");
             out.println("<td>"+s.mem+"</td>");
             out.println("<td>"+s.username+"</td></tr>");
        }
        out.println("<tr><td colspan='6'>");
        out.println("<center><input type='submit' value='Back'></center>");
        out.println("</tr></td>");
        out.println("</table>");
        out.println("</form></body></html>");       
    }
}
