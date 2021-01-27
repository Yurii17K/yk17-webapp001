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

        HttpSession session = request.getSession();
        session.setAttribute("mealsList", ME.listMeals());
        session.setAttribute("mealsCount", ME.countMeals());

        request.getRequestDispatcher("endpoint_1.jsp").include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
