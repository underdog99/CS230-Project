package com.pz.jsf;

import com.pz.jpa.Relationship2;
import com.pz.jsf.util.JsfUtil;
import com.pz.jsf.util.JsfUtil.PersistAction;
import com.pz.zrno.Relationship2Facade;

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

@Named("relationship2Controller")
@SessionScoped
public class Relationship2Controller implements Serializable {

    @EJB
    private com.pz.zrno.Relationship2Facade ejbFacade;
    private List<Relationship2> items = null;
    private Relationship2 selected;

    public Relationship2Controller() {
    }

    public Relationship2 getSelected() {
        return selected;
    }

    public void setSelected(Relationship2 selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private Relationship2Facade getFacade() {
        return ejbFacade;
    }

    public Relationship2 prepareCreate() {
        selected = new Relationship2();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("Relationship2Created"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("Relationship2Updated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("Relationship2Deleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Relationship2> getItems() {
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

    public Relationship2 getRelationship2(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Relationship2> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Relationship2> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Relationship2.class)
    public static class Relationship2ControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            Relationship2Controller controller = (Relationship2Controller) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "relationship2Controller");
            return controller.getRelationship2(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Relationship2) {
                Relationship2 o = (Relationship2) object;
                return getStringKey(o.getIdR2());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Relationship2.class.getName()});
                return null;
            }
        }

    }

}
