package com.pz.jsf;

import com.pz.jpa.Vazdusnovozilo;
import com.pz.jsf.util.JsfUtil;
import com.pz.jsf.util.JsfUtil.PersistAction;
import com.pz.zrno.VazdusnovoziloFacade;

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

@Named("vazdusnovoziloController")
@SessionScoped
public class VazdusnovoziloController implements Serializable {

    @EJB
    private com.pz.zrno.VazdusnovoziloFacade ejbFacade;
    private List<Vazdusnovozilo> items = null;
    private Vazdusnovozilo selected;

    public VazdusnovoziloController() {
    }

    public Vazdusnovozilo getSelected() {
        return selected;
    }

    public void setSelected(Vazdusnovozilo selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
        selected.setVazdusnovoziloPK(new com.pz.jpa.VazdusnovoziloPK());
    }

    private VazdusnovoziloFacade getFacade() {
        return ejbFacade;
    }

    public Vazdusnovozilo prepareCreate() {
        selected = new Vazdusnovozilo();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("VazdusnovoziloCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("VazdusnovoziloUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("VazdusnovoziloDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Vazdusnovozilo> getItems() {
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

    public Vazdusnovozilo getVazdusnovozilo(com.pz.jpa.VazdusnovoziloPK id) {
        return getFacade().find(id);
    }

    public List<Vazdusnovozilo> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Vazdusnovozilo> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Vazdusnovozilo.class)
    public static class VazdusnovoziloControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            VazdusnovoziloController controller = (VazdusnovoziloController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "vazdusnovoziloController");
            return controller.getVazdusnovozilo(getKey(value));
        }

        com.pz.jpa.VazdusnovoziloPK getKey(String value) {
            com.pz.jpa.VazdusnovoziloPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new com.pz.jpa.VazdusnovoziloPK();
            key.setIdvozilo(Integer.parseInt(values[0]));
            key.setIdvazvozila(Integer.parseInt(values[1]));
            return key;
        }

        String getStringKey(com.pz.jpa.VazdusnovoziloPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getIdvozilo());
            sb.append(SEPARATOR);
            sb.append(value.getIdvazvozila());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Vazdusnovozilo) {
                Vazdusnovozilo o = (Vazdusnovozilo) object;
                return getStringKey(o.getVazdusnovoziloPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Vazdusnovozilo.class.getName()});
                return null;
            }
        }

    }

}
