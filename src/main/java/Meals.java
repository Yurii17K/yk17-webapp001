
import javax.persistence.*;
import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;
import java.sql.*;

@Entity
@Table(name = "Meals")
public class Meals {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "m_id")
    private int m_id;

    @Column(name = "meal")
    private String meal;

    @Column(name = "effect")
    private int effect;

    @Column(name = "duration")
    private int duration;

    @Column(name = "price")
    private int price;


    public Meals() {
    
    }

    public Meals(String meal, int price) {
        this.meal = meal;
        this.price = price;
    }

    public Meals(int m_id_, String meal_, int effect_, int duration_, int price_) {
        this.m_id = m_id_;
        this.meal = meal_;
        this.effect = effect_;
        this.duration = duration_;
        this.price = price_;
    }



    public int getm_id() {
        return this.m_id;
    }

    public void setm_id(int value) {
        this.m_id = value;
    }

    public String getmeal() {
        return this.meal;
    }

    public void setmeal(String value) {
        this.meal = value;
    }

    public int geteffect() {
        return this.effect;
    }

    public void seteffect(int value) {
        this.effect = value;
    }

    public int getduration() {
        return this.duration;
    }

    public void setduration(int value) {
        this.duration = value;
    }

    public int getprice() {
        return this.price;
    }

    public void setprice(int value) {
        this.price = value;
    }
}