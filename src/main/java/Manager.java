import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import javax.servlet.ServletConfig;
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

    private Manager user;
    private String tableInitializing;
    private Meals meal;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        user = new Manager();
        tableInitializing = "<table width = \"56%\" border = \"1\" align = \"center\">\n" +
                "<tr bgcolor = \"#949494\">\n" +
                "<th>m_id</th>" +
                "<th>meal</th>\n"+
                "<th>price</th>\n"+
                "</tr>\n";
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        //Start of HTML
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet upload</title>");
        out.println("</head>");
        out.println("<body>");

        //Updating a meal
        if (request.getParameter("meal_ID_2") != null && request.getParameter("meal_price_2") != null) {
            Integer mealID = Integer.valueOf(request.getParameter("meal_ID_2"));
            Integer mealPrice = Integer.valueOf((request.getParameter("meal_price_2")));

                user.updateMeal(mealID, mealPrice);

                meal = getMealById(mealID);

                out.println("Meal " + mealID + " updated<br>");
                out.println(tableInitializing);
        }

        //Adding a meal
        if (request.getParameter("meal_name") != null) {
            String mealName = request.getParameter("meal_name");
            Integer mealPrice = Integer.valueOf((request.getParameter("meal_price")));

            user.addMeal(mealName, mealPrice);

            meal = getMealByName(mealName);

            out.println("Meal " + mealName + " added<br>");
            out.println(tableInitializing);
        }

        //Deleting a meal
        if (request.getParameter("meal_ID") != null) {
            Integer mealID = Integer.valueOf(request.getParameter("meal_ID"));

                meal = getMealById(mealID);

                user.deleteMeal(mealID);

                out.println("Meal #" + mealID + " deleted<br>");
                out.println(tableInitializing);
        }


        //Display values
        out.println("<tr><td>" + meal.getm_id() + "</td>");
        out.println("<td>" + meal.getmeal() + "</td>");
        out.println("<td>" + meal.getprice() + "</td>");

        //End of HTML
        out.println("</tr>\n</table>\n");
        out.println("Please return to the <a href=\"" +
                response.encodeURL("http://localhost:4232/webapp001_war") +
                "\">Home Page</a>.");
        out.println("</body>");
        out.println("</html>");
    }


    //Methods
    public Meals getMealByName (String mealName) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Criteria criteria = session.createCriteria(Meals.class);
        Meals yourObject = (Meals) criteria.add(Restrictions.eq("meal", mealName))
                .uniqueResult();

        session.close();

        return yourObject;
    }

    public Meals getMealById (Integer mealID) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Meals meal = (Meals) session.get(Meals.class, mealID);

        session.close();

        return meal;
    }

    public void updateMeal (Integer mealID, int newPrice) {
       // if (mealID <= user.listMeals() && mealID > 0) {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            Meals meal = (Meals) session.get(Meals.class, mealID);
            meal.setprice(newPrice);

            session.update(meal);
            session.getTransaction().commit();
            session.close();
        //}
    }

    public void deleteMeal (Integer mealID) {
        //if (mealID <= user.listMeals() && mealID > 0) {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            Meals meal = (Meals) session.get(Meals.class, mealID);
            session.delete(meal);

            session.getTransaction().commit();
            session.close();
       // }
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
