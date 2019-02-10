package Servlet;
public class CustomerUpdate 
{
    int id;
    String name,gen,addr;
    int mem,sal;
    String uname,upass;

    public CustomerUpdate(int id, String name, String gen, String addr, int mem, int sal, String uname, String upass) {
        this.id = id;
        this.name = name;
        this.gen = gen;
        this.addr = addr;
        this.mem = mem;
        this.sal = sal;
        this.uname = uname;
        this.upass = upass;
    }
    @Override
    public String toString() 
    {
        return id+" "+name+" "+gen+" "+addr+" "+mem+" "+sal+" "+uname+" "+upass;
    }
    
}
