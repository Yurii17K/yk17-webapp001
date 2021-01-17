import org.hibernate.Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "Manager", value = "/Manager")
public class Manager extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Manager user = new Manager();
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if (request.getParameter("meal_ID_2") != null && request.getParameter("meal_price_2") != null) {
            Integer mealID = Integer.valueOf(request.getParameter("meal_ID_2"));
            Integer mealPrice = Integer.valueOf((request.getParameter("meal_price_2")));

            user.updateMeal(mealID, mealPrice);

            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet upload</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("Meal " + mealID + " updated<br>");
        }

        if (request.getParameter("meal_name") != null) {
            String mealName = request.getParameter("meal_name");
            Integer mealPrice = Integer.valueOf((request.getParameter("meal_price")));

            user.addMeal(mealName, mealPrice);

            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet upload</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("Meal" + mealName + " added<br>");
        }

        if (request.getParameter("meal_ID") != null) {
            Integer mealID = Integer.valueOf(request.getParameter("meal_ID"));

            if (mealID <= user.listMeals() && mealID > 0) {
                user.deleteMeal(mealID);

                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet upload</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("Meal #" + mealID + " deleted<br>");
            }
        }

        out.println("Please return to the <a href=\"" +
                response.encodeURL("http://localhost:4232/webapp001_war") +
                "\">Home Page</a>.");
        out.println("</body>");
        out.println("</html>");
    }

    public void updateMeal (Integer mealID, int newPrice) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Meals meal = (Meals) session.get(Meals.class, mealID - 1);
        meal.setprice(newPrice);

        session.update(meal);
        session.getTransaction().commit();
        session.close();
    }

    public void deleteMeal (Integer mealID) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Meals meal = (Meals) session.get(Meals.class, mealID);
        session.delete(meal);

        session.getTransaction().commit();
        session.close();
    }

    public void addMeal (String mealName, int mealPrice){

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Meals meal = new Meals(mealName, mealPrice);

        session.save(meal);
        session.getTransaction().commit();
        session.close();
    }

    public long listMeals () {

        long count = 0;

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        List meals = session.createQuery("FROM Meals").list();
        count = meals.size();
//        for (Object o : meals) {
//            Meals meal = (Meals) o;
//            System.out.print("  Meal: " + meal.getmeal());
//            System.out.println("  Price: " + meal.getprice());
//        }

        session.getTransaction().commit();
        session.close();
        return count;
    }

}
