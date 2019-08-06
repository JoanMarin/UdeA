package gr10.compumovil.udea.edu.co.lab2e10;

/**
 * Created by personal on 5/09/2016.
 */
public class Contact {
	

    private String nombre, email, unombre, contraseña;
    private int session;

    public int getSession() {
        return session;
    }

    public void setSession(int session) {
        this.session = session;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return this.nombre;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getEmail(){
        return this.email;
    }

    public void setUnombre(String unombre){
        this.unombre = unombre;
    }

    public String getUnombre(){
        return this.unombre;
    }

    public void setContraseña(String contraseña){
        this.contraseña = contraseña;
    }

    public String getContraseña(){
        return this.contraseña;
    }
}
