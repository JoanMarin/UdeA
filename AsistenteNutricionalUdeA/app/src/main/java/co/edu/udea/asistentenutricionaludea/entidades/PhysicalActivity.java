package co.edu.udea.asistentenutricionaludea.entidades;

public class PhysicalActivity {
    private int id;
    private String name;
    private float valueMan;
    private float valueWomen;

    public PhysicalActivity(int id, String name, float valueMan, float valueWomen) {
        this.id = id;
        this.name = name;
        this.valueMan = valueMan;
        this.valueWomen = valueWomen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getValueMan() {
        return valueMan;
    }

    public void setValueMan(float valueMan) {
        this.valueMan = valueMan;
    }

    public float getValueWomen() {
        return valueWomen;
    }

    public void setValueWomen(float valueWomen) {
        this.valueWomen = valueWomen;
    }
}
