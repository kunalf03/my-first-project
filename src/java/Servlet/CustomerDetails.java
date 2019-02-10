package Servlet;
public class CustomerDetails 
{
    int id;
    String name,addr,gen;
    int mem;
    String username;

    public CustomerDetails(int id, String name, String addr, String gen, int mem, String username) {
        this.id = id;
        this.name = name;
        this.addr = addr;
        this.gen = gen;
        this.mem = mem;
        this.username = username;
    }
    
    @Override
    public String toString() 
    {
        return id+" "+name+" "+gen+" "+addr+" "+mem+" "+username;
    }       
}
