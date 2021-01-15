import org.hibernate.Session;

import java.util.Iterator;
import java.util.List;

public class Manager {

    public void addMeal(String meal, int price){

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Meals elixirID = new Meals(meal, price);

        session.save(elixirID);
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
