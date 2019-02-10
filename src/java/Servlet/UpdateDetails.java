package Servlet;
import javax.servlet.AsyncContext.*;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.ServletException;
public class UpdateDetails extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
        int id=Integer.parseInt(req.getParameter("I"));
        CustomerUpdate cd=StoredCustData.getData(id);
        //System.out.println(id);
        //System.out.println(cd.addr);
        String mal=null,n=null,pl=null,go=null,si=null,sel=null;
        if("M".equalsIgnoreCase(cd.gen))
        {
            mal=" checked ";
            n=" ";
        }
        if("F".equalsIgnoreCase(cd.gen))
        {
            mal=" ";
            n=" checked ";
        }
        if(cd.mem==0)
        {
            sel="selected";
            pl=" ";
            go=" ";
            si=" ";
        }
        if(cd.mem==1)
        {
            sel=" ";
            pl="selected";
            go=" ";
            si=" ";
        }
        if(cd.mem==1)
        {
            sel=" ";
            pl=" ";
            go="selected";
            si=" ";
        }
        if(cd.mem==2)
        {
            sel=" ";
            pl=" ";
            go=" ";
            si="selected";
        }
        resp.setContentType("text/html");
        PrintWriter out=resp.getWriter();
        out.println("<html><head><title>Updation</title></head><body><form action='Upd' method='post'><table border='4'>");
        out.println("<tr><td><b>Name:</b></td><td><input type='text' name='NAME' value='"+cd.name+" ' size='40'></td></tr>");
        out.println("<tr><td><b>Gender:</b></td><td><input type='radio' name='GENDER' value='M' "+mal+" >Male<br>"
                + "<input type='radio' name='GENDER' value='F' "+n+">Female</td></tr>");
        out.println("<tr><td><b>Address:</b></td><td><textarea rows='3' cols='30' placeholder='"+cd.addr+"'></textarea></td></tr>");
        out.println("<tr><td><b>Mtype:</b></td><td><select name='MTYPE'><option value='0' "+sel+">---Select---"
                + "<option value='1' "+pl+">Platinum"
                        + "<option value='2' "+go+">Gold"
                                + "<option value='2' "+si+">Silver</select></td></tr>");
        out.println("<tr><td><b>Salary:</b></td><td><input type='number' name='SALARY' value='"+cd.sal+"' size='40'></td></tr>");
        out.println("<tr><td><b>User Name:</b></td><td><input type='text' name='USERNAME' value='"+cd.uname+"' size='40'></td></tr>");
        out.println("<tr><td><b>Password:</b></td><td><input type='password' name='PASSWORD' value='"+cd.upass+"' size='40'></td></tr>");
        out.println("<tr><td colspan='2'><center><input type='submit' value='Update'>"
                + "<input type='reset' name='Clear All'></center></td></tr>");
        out.println("</table><input type='hidden' name='ID' value='"+id+"'>");
        out.println("<input type='hidden' name='ADDRESS' value='"+cd.addr+"'>");
        out.println("</form></body></html>");
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
        int id=Integer.parseInt(req.getParameter("ID"));
        String n=req.getParameter("NAME");
        String gen=req.getParameter("GENDER");
        String addr=req.getParameter("ADDRESS");
        int m=Integer.parseInt(req.getParameter("MTYPE"));
        int sal=Integer.parseInt(req.getParameter("SALARY"));
        String u=req.getParameter("USERNAME");
        String p=req.getParameter("PASSWORD");
        System.out.println(id+" "+n+" "+gen+" "+addr+" "+m+" "+sal+" "+u+" "+p);
        CallUpdateProcedure.sendData(id,n,gen,addr,m,sal,u,p);
        resp.setContentType("text/html");
        PrintWriter out=resp.getWriter();
        out.println("<html><body>"+id+" is successfully updated</body></html>");
    } 
}
