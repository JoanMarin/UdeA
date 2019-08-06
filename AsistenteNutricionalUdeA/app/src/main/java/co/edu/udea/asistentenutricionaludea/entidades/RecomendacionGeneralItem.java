package co.edu.udea.asistentenutricionaludea.entidades;

import java.io.Serializable;

public class RecomendacionGeneralItem implements Serializable {
    private int id;
    private int recomendacionGeneralId;
    private int image;
    private String title;
    private String description;

    public RecomendacionGeneralItem(int id, int recomendacionGeneralId, int image, String title, String description) {
        this.id = id;
        this.recomendacionGeneralId = recomendacionGeneralId;
        this.image = image;
        this.title = title;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRecomendacionGeneralId() {
        return recomendacionGeneralId;
    }

    public void setRecomendacionGeneralId(int recomendacionGeneralId) {
        this.recomendacionGeneralId = recomendacionGeneralId;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
