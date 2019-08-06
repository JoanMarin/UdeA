package co.edu.udea.asistentenutricionaludea.entidades;

import java.io.Serializable;

public class RecomendacionGeneral implements Serializable{
    private int id;
    private int imageRecomendacion;
    private String group;

    public RecomendacionGeneral(int id, int imageRecomendacion, String group) {
        this.id = id;
        this.imageRecomendacion = imageRecomendacion;
        this.group = group;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImageRecomendacion() {
        return imageRecomendacion;
    }

    public void setImageRecomendacion(int imageRecomendacion) {
        this.imageRecomendacion = imageRecomendacion;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}
