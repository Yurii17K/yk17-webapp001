import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Manager", value = "/Manager")
public class Manager extends HttpServlet {

    private Manager user;


    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        user = new Manager();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Meals meal;

        //Updating a meal
        if (request.getParameter("meal_ID_2") != null && request.getParameter("meal_price_2") != null) {
            Integer mealID = Integer.valueOf(request.getParameter("meal_ID_2"));
            Integer mealPrice = Integer.valueOf((request.getParameter("meal_price_2")));

            user.updateMeal(mealID, mealPrice);

            meal = getMealById(mealID);

            HttpSession session = request.getSession();
            session.setAttribute("meal", meal);
            session.setAttribute("message", "Meal " + mealID + " updated.");

            request.getRequestDispatcher("db_actions_display.jsp").include(request, response);
        }

        //Adding a meal
        if (request.getParameter("meal_name") != null) {
            String mealName = request.getParameter("meal_name");
            Integer mealPrice = Integer.valueOf((request.getParameter("meal_price")));

            user.addMeal(mealName, mealPrice);

            meal = getMealByName(mealName);

            HttpSession session = request.getSession();
            session.setAttribute("meal", meal);
            session.setAttribute("message", "Meal " + mealName + " added.");

            request.getRequestDispatcher("db_actions_display.jsp").include(request, response);
        }

        //Deleting a meal
        if (request.getParameter("meal_ID") != null) {
            Integer mealID = Integer.valueOf(request.getParameter("meal_ID"));

            meal = getMealById(mealID);

            user.deleteMeal(mealID);

            HttpSession session = request.getSession();
            session.setAttribute("meal", meal);
            session.setAttribute("message", "Meal " + mealID + " deleted.");

            request.getRequestDispatcher("db_actions_display.jsp").include(request, response);
        }
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

    public List<Meals> listMeals () {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        List mealsObj = session.createQuery("FROM Meals").list();
        List<Meals> meals = new ArrayList<Meals>();

        for (Object o : mealsObj) {
            Meals meal = (Meals) o;
            meals.add(meal);
        }

        session.getTransaction().commit();
        session.close();
        return meals;
    }

    public List<Integer> checkFKs () {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        List heroesObj = session.createQuery("FROM Heroes").list();
        List<Integer> heroes = new ArrayList<Integer>();

        for (Object o : heroesObj) {
            Heroes hero = (Heroes) o;
            heroes.add(hero.getH_id());
        }

        session.getTransaction().commit();
        session.close();

        return heroes;
    }

    public long countMeals () {
        long count = 0;

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        List meals = session.createQuery("FROM Meals").list();
        count = meals.size();


        session.getTransaction().commit();
        session.close();
        return count;
    }

}
