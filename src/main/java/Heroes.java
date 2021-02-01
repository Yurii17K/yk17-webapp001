

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;
import java.sql.*;

@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "Heroes")

public class Heroes {


    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "h_id")
    private int h_id;

    @Column(name = "hero")
    private String hero;

    @Column(name = "delicacy")
    private int delicacy;

    public Heroes(int h_id, String hero, int delicacy) {
        this.h_id = h_id;
        this.hero = hero;
        this.delicacy = delicacy;
    }

    public Heroes() {

    }

    public int getH_id() {
        return h_id;
    }

    public void setH_id(int h_id) {
        this.h_id = h_id;
    }

    public String getHero() {
        return hero;
    }

    public void setHero(String hero) {
        this.hero = hero;
    }

    public int getDelicacy() {
        return delicacy;
    }

    public void setDelicacy(int delicacy) {
        this.delicacy = delicacy;
    }







}