import org.hibernate.Session;

public class Manager {

    public void addElixir(String meal, int price){

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Meals elixirID = new Meals(meal, price);

        session.save(elixirID);
        session.getTransaction().commit();
        session.close();
    }

}
