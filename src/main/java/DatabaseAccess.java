import org.hibernate.*;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Iterator;
import java.util.List;

@WebServlet(name = "DatabaseAccess", value = "/DatabaseAccess")
public class DatabaseAccess extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Manager ME = new Manager();

        // Set refresh, autoload time as 5 seconds
        response.setIntHeader("Refresh", 5);

        // Set response content type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String title = "Database Result";

        String docType =
                "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";

        out.println(docType +
                "<html>\n" +
                "<head>" +
                "<title>" + title + "</title>" +
                "</head>\n" +
                "<body bgcolor = \"#f0f0f0\">\n");
        out.println("<h1 align = \"center\"> Number of meals in 'Meals' table: " + ME.countMeals() + "</h1>\n");
        out.println("<table width = \"56%\" border = \"1\" align = \"center\">\n" +
                "<tr bgcolor = \"#949494\">\n" +
                "<th>m_id</th>" +
                "<th>meal</th>\n"+
                "<th>price</th>\n"+
                "</tr>\n");
        for (Object o : ME.listMeals()) {
            Meals meal = (Meals) o;

            //Display values
            out.println("<tr><td>" + meal.getm_id() + "</td>");
            out.println("<td>" + meal.getmeal() + "</td>");
            out.println("<td>" + meal.getprice() + "</td>");
        }

        out.println("</tr>\n</table>\n");
        out.println("Please return to the <a href=\"" +
                response.encodeURL("https://yk17-webapp001.herokuapp.com/") +
                "\">Home Page</a>.");
        out.println("</body></html>");


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
