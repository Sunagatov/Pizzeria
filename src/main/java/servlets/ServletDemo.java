package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

/**
 * Created by Zufar on 12-Jul-17.
 */
@WebServlet("/")
public class ServletDemo extends HttpServlet {

    private Connection con;

    @Override
    public void init() throws ServletException {
        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace(System.out);
        }
        try {
            con= DriverManager.getConnection("jdbc:hsqldb:file:testdb","SA","");
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet( request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("Hello world!");
        out.println("</body></html>");
        try {
            PreparedStatement pst=con.prepareStatement("select * from ORDERS");
            pst.clearParameters();
            ResultSet rs=pst.executeQuery();
            while(rs.next()){
                out.write("<br/>"+rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void destroy() {
        try {
            con.prepareStatement("SHUTDOWN").execute();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        super.destroy();
    }
}
