package co.edu.udea.asistentenutricionaludea.entidades;

import java.util.Date;

public class Caracterizacion {

    private int id;
    private String user;
    private float weight;
    private int height;
    private Date age;
    private String gender;
    private String physicalActivity;

    /*
    public Caracterizacion(int id, String user, float weight, int height, Date age, String gender, String physicalActivity) {
        this.id = id;
        this.user = user;
        this.weight = weight;
        this.height = height;
        this.age = age;
        this.gender = gender;
        this.physicalActivity = physicalActivity;
    }
    */

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Date getAge() {
        return age;
    }

    public void setAge(Date age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhysicalActivity() {
        return physicalActivity;
    }

    public void setPhysicalActivity(String physicalActivity) {
        this.physicalActivity = physicalActivity;
    }
}
