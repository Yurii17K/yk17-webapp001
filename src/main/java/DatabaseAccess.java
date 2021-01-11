import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "DatabaseAccess", value = "/DatabaseAccess")
public class DatabaseAccess extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // JDBC driver name and database URL
        final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        final String DB_URL="jdbc:sqlserver://localhost:4032;Database=witcher";

        // Database credentials
        final String USER = "sa";
        final String PASS = "1961";

        // Set response content type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String title = "Database Result";

        String docType =
                "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";

        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor = \"#f0f0f0\">\n" +
                "<h1 align = \"center\">" + title + "</h1>\n" +
                        "<table width = \"55%\" border = \"1\" align = \"center\">\n" +
                        "<tr bgcolor = \"#949494\">\n" +
                        "</tr>\n");

        try {
            // Register JDBC driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // Open a connection
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Execute SQL query
            Statement stmt = conn.createStatement();
            String sql;
            sql = "SELECT elixir, duration, doses FROM Elixirs";
            ResultSet rs = stmt.executeQuery(sql);

            // Extract data from result set
            out.println("<tr><th>elixir</th>");
            out.println("<th>duration</th>");
            out.println("<th>doses</th></tr>");

            while(rs.next()){
                //Retrieve by column name
                String elixir = rs.getString("elixir");
                int duration = rs.getInt("duration");
                int doses  = rs.getInt("doses");

                //Display values
                out.println("<tr><td>" + elixir + "</td>");
                out.println("<td>" + duration + "</td>");
                out.println("<td>" + doses + "</td>");
            }
            out.println("</tr>\n</table>\n</body></html>");


            // Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        } //Handle errors for Class.forName
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        //end try
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
