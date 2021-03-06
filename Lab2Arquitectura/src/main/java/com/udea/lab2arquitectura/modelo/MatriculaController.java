package com.udea.lab2arquitectura.modelo;

import com.udea.lab2arquitectura.modelo.util.JsfUtil;
import com.udea.lab2arquitectura.modelo.util.JsfUtil.PersistAction;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("matriculaController")
@SessionScoped
public class MatriculaController implements Serializable {

    @EJB
    private com.udea.lab2arquitectura.modelo.MatriculaFacade ejbFacade;
    private List<Matricula> items = null;
    private Matricula selected;

    public MatriculaController() {
    }

    public Matricula getSelected() {
        return selected;
    }

    public void setSelected(Matricula selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getMatriculaPK().setEstudianteId(selected.getEstudiante().getIdentificacion());
        selected.getMatriculaPK().setMateriaId(selected.getMateria().getCodigo());
    }

    protected void initializeEmbeddableKey() {
        selected.setMatriculaPK(new com.udea.lab2arquitectura.modelo.MatriculaPK());
    }

    private MatriculaFacade getFacade() {
        return ejbFacade;
    }

    public Matricula prepareCreate() {
        selected = new Matricula();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("MatriculaCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("MatriculaUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("MatriculaDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Matricula> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public Matricula getMatricula(com.udea.lab2arquitectura.modelo.MatriculaPK id) {
        return getFacade().find(id);
    }

    public List<Matricula> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Matricula> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Matricula.class)
    public static class MatriculaControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            MatriculaController controller = (MatriculaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "matriculaController");
            return controller.getMatricula(getKey(value));
        }

        com.udea.lab2arquitectura.modelo.MatriculaPK getKey(String value) {
            com.udea.lab2arquitectura.modelo.MatriculaPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new com.udea.lab2arquitectura.modelo.MatriculaPK();
            key.setEstudianteId(Integer.parseInt(values[0]));
            key.setMateriaId(Integer.parseInt(values[1]));
            key.setSemestre(values[2]);
            return key;
        }

        String getStringKey(com.udea.lab2arquitectura.modelo.MatriculaPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getEstudianteId());
            sb.append(SEPARATOR);
            sb.append(value.getMateriaId());
            sb.append(SEPARATOR);
            sb.append(value.getSemestre());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Matricula) {
                Matricula o = (Matricula) object;
                return getStringKey(o.getMatriculaPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Matricula.class.getName()});
                return null;
            }
        }

    }

}
