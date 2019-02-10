package Servlet;
import javax.servlet.AsyncContext.*;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.ServletException;
public class Registration extends HttpServlet 
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
        resp.setContentType("text/html");
        PrintWriter out=resp.getWriter();
        out.println("<html>\n"
                + "    <head>\n"
                + "        <title>New Registration</title>\n"
                + "    </head>\n"
                + "    <body>\n"
                + "    <center>\n"
                + "        <font color='red' size='5'><b><u>KAF GROUP</u></b></font>\n"
                + "    </center><br>\n"
                + "    <form action='Reg' method='post'>\n"
                + "        <table border='2'>\n"
                + "            <tr>\n"
                + "                <td><b>Name:</b></td>\n"
                + "                <td>\n"
                + "                    <input type='text' name='NAME' size='50'>\n"
                + "                </td>\n"
                + "            </tr>\n"
                + "            <tr>\n"
                + "                <td><b>Gender:</b></td>\n"
                + "                <td>\n"
                + "                    <input type='radio' name='GENDER' value='M' size='50'>Male<br>\n"
                + "                    <input type='radio' name='GENDER' value='F' size='50'>Female\n"
                + "                </td>\n"
                + "            </tr>\n"
                + "            <tr>\n"
                + "                <td><b>Address:</b></td>\n"
                + "                <td>\n"
                + "                    <textarea name='ADDRESS' rows='3' cols='37'></textarea>\n"
                + "                </td>\n"
                + "            </tr>\n"
                + "            <tr>\n"
                + "                <td><b>Membership:</b></td>\n"
                + "                <td>\n"
                + "                    <select name='MTYPE'>\n"
                + "                        <option value='0'>----Select----\n"
                + "                        <option value='1'>Platinum\n"
                + "                        <option value='2'>Gold\n"
                + "                        <option value='3'>Silver\n"
                + "                    </select>\n"
                + "                </td>\n"
                + "            </tr>\n"
                + "            <tr>\n"
                + "                <td><b>Salary:</b></td>\n"
                + "                <td>\n"
                + "                    <input type='number' name='SALARY'>\n"
                + "                </td>\n"
                + "            </tr>\n"
                + "            <tr>\n"
                + "                <td><b>User Name:</b></td>\n"
                + "                <td>\n"
                + "                    <input type='text' name='USERNAME'>\n"
                + "                </td>\n"
                + "            </tr>\n"
                + "            <tr>\n"
                + "                <td><b>Password:</b></td>\n"
                + "                <td>\n"
                + "                    <input type='password' name='PASSWORD'>\n"
                + "                </td>\n"
                + "            </tr>\n"
                + "            <tr>\n"
                + "                <td colspan='2'>\n"
                + "                    <center>\n"
                + "                        <input type='submit' value='Register'>\n"
                + "                        <input type='reset' value='Clear'>\n"
                + "                    </center>\n"
                + "                </td>\n"
                + "            </tr>\n"
                + "        </table>\n"
                + "    </form>\n"
                + "    </body>\n"
                + "</html>");
        out.close();
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
        String name=req.getParameter("NAME");
        String gender=req.getParameter("GENDER");
        String addr=req.getParameter("ADDRESS");
        int mem=Integer.parseInt(req.getParameter("MTYPE"));
        int sal=Integer.parseInt(req.getParameter("SALARY"));
        String un=req.getParameter("USERNAME");
        String pw=req.getParameter("PASSWORD");
        InsertIntoDb.setData(name,gender,addr,mem,sal,un,pw);
        resp.setContentType("text/html");
        PrintWriter out=resp.getWriter();
        out.println("<html><body>User Successfully Register</body></html>");
    }  
}
