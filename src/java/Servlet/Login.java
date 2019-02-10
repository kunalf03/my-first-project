package Servlet;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;
public class Login extends HttpServlet
{
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
        resp.setContentType("text/html");
        PrintWriter out=resp.getWriter();
        out.println("<html>\n"
                + "    <head>\n"
                + "        <title>Login</title>\n"
                + "    </head>\n"
                + "    <body>\n"
                + "        <form action='pkf' method='post'>\n"
                + "            <table border='2'>\n"
                + "                <tr>\n"
                + "                    <td><b>User Name :</b></td>\n"
                + "                    <td>\n"
                + "                        <input type='text' name='USERNAME' size='30'>\n"
                + "                    </td>\n"
                + "                </tr>\n"
                + "                <tr>\n"
                + "                    <td><b>Password :</b></td>\n"
                + "                    <td>\n"
                + "                        <input type='password' name='PASSWORD' size='30'>\n"
                + "                    </td>\n"
                + "                </tr>\n"
                + "                <tr>\n"
                + "                    <td colspan='2'>\n"
                + "                        <center>\n"
                + "                            <input type='submit' value='login'>\n"
                + "                        </center>\n"
                + "                    </td>\n"
                + "                </tr>\n"
                + "            </table>\n"
                + "        </form><br><br>\n"
                + "        <form action='Reg' method='get'>\n"
                + "            <input type='submit' value='New Registration'>\n"
                + "        </form>\n"
                + "    </body>\n"
                + "</html>\n"
                + "");
        out.close();
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
        
        resp.setContentType("text/html");
        PrintWriter out=resp.getWriter();            
        String u=req.getParameter("USERNAME");
        String p=req.getParameter("PASSWORD");
        System.out.println(u+"   "+p);
        CheckLoginDetails obj=new CheckLoginDetails(); 
        int id=obj.checklogin(u,p); 
        System.out.println("id  "+id);
        if(id > 0)
        {
            HttpSession session=req.getSession(true);
            session.setAttribute("ID",id+"");
            int i=Integer.parseInt((String)session.getAttribute("ID"));
            
            /*out.println("<html>\n"
                    + "    <head>\n"
                    + "        <title>Menu</title>\n"
                    + "    </head>\n"
                    + "    <body>\n"
                    + "        <a href='http://localhost:8084/servlet/Main.html'>\n"
                    + "            Menu\n"
                    + "        </a>\n"
                    + "    </body>        \n"
                    + "</html>");
            out.println("<html><body>Succesful</body></html>");*/
            resp.sendRedirect("Menu");
            //out.println("<html><body>succesful"+i+"</body></html>");
        }
        else
        {
            out.println("<html><body>Unsuccesful</body></html>");
        }  
        out.close();
    }
}
