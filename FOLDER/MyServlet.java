import javax.servlet.*;
import java.io.*;
import java.sql.*;
 
public class MyServlet implements Servlet {
    public void init(ServletConfig cfg) {
        System.out.println("servlet object created");
    }
 
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");// to set the response type
 
        PrintWriter out = res.getWriter();// to get the output stream
 
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "abcd1234@");
            // here sonoo is database name, root is username and password
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from test");
            while (rs.next())
                out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
            con.close();
        } catch (Exception e) {
            out.println(e);
        }
    }
 
 
 
    public void destroy() {
    }
 
    public String getServletInfo() {
        return (null);
    }
 
    public ServletConfig getServletConfig() {
        return (null);
    }
}



