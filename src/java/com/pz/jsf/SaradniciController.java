package com.pz.jsf;

import com.pz.jpa.Saradnici;
import com.pz.jpa.Vojnik;
import com.pz.jsf.util.JsfUtil;
import com.pz.jsf.util.JsfUtil.PersistAction;
import com.pz.zrno.SaradniciFacade;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import java.io.Serializable;
import java.nio.file.Files;
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
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.Part;

@Named("saradniciController")
@SessionScoped
public class SaradniciController implements Serializable {

    @EJB
    private com.pz.zrno.SaradniciFacade ejbFacade;
    private List<Saradnici> items = null;
    private Saradnici selected;

    public SaradniciController() {
    }

    public Saradnici getSelected() {
        return selected;
    }

    public void setSelected(Saradnici selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private SaradniciFacade getFacade() {
        return ejbFacade;
    }

    public Saradnici prepareCreate() {
        selected = new Saradnici();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("SaradniciCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("SaradniciUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("SaradniciDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }
    
     public String slika() {
        String s = "profile/" + selected.getFotoclana();
        return s;
    } 
    
        public String prst() {
        String o = "otisak/" + selected.getOtisakprstaclana();
        return o;
    }

    public List<Saradnici> getItems() {
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

    public Saradnici getSaradnici(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Saradnici> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Saradnici> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Saradnici.class)
    public static class SaradniciControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            SaradniciController controller = (SaradniciController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "saradniciController");
            return controller.getSaradnici(getKey(value));
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
            if (object instanceof Saradnici) {
                Saradnici o = (Saradnici) object;
                return getStringKey(o.getIdclana());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Saradnici.class.getName()});
                return null;
            }
        }

    }
    
    private Part upFile1;
    private Part upFile2;
    private final String folderProfil = "c:\\slike\\saradnik";
    private final String folderOtisak = "c:\\test22";
    private String idString;
    
    @PersistenceContext(unitName = "CS230-PZ-Mladen-Simeonovic-3668PU")
    private EntityManager em;
    

    public Part getUpFile1() {
        return upFile1;
    }

    public void setUpFile1(Part upFile1) {
        this.upFile1 = upFile1;
    }
    
     public Part getUpFile2() {
        return upFile2;
    }

    public void setUpFile2(Part upFile2) {
        this.upFile2 = upFile2;
    }

    public String getIdString() {
        return idString;
    }

    public void setIdString(String idString) {
        this.idString = idString;
    }
    
    
    public void uploadSlika() {
        try (InputStream input = upFile1.getInputStream()) {
            int idInt = Integer.parseInt(idString);
            String fileName = upFile1.getSubmittedFileName();
            System.out.println("Ime fajla: " + fileName);
            Files.copy(input, new File(folderProfil, fileName).toPath());
            Saradnici s = null;
            s = (Saradnici) em.createNamedQuery("Saradnici.findByIdclana").setParameter("idclana", idInt).getSingleResult();
            System.out.println("Ime saradnika: " + s.getImeclana());
                
                selected.setIdclana(s.getIdclana());
                selected.setImeclana(s.getImeclana());
                selected.setPrezimeclana(s.getPrezimeclana());
                selected.setJmbgclana(s.getJmbgclana());
                selected.setGodinarodjenjaclana(s.getGodinarodjenjaclana());
                selected.setMestorodjenjaclana(s.getMestorodjenjaclana());
                selected.setKontaktclana(s.getKontaktclana());
                selected.setVisinaclana(s.getVisinaclana());
                selected.setKilazaclana(s.getKilazaclana());
                selected.setBojaociuclana(s.getBojaociuclana());
                selected.setFotoclana(fileName);
                selected.setOtisakprstaclana(s.getOtisakprstaclana());
                selected.setStatusclana(s.getStatusclana());
                selected.setPlataclana(s.getPlataclana());
                selected.setIdsaradnika(s.getIdsaradnika());
                selected.setOblast(s.getOblast());
               
                update();
            
//-------------------------------------------------------------------------

            InputStream input2 = upFile2.getInputStream();
            String fileName2 = upFile2.getSubmittedFileName();
            Files.copy(input2, new File(folderOtisak, fileName2).toPath());
        }
        catch(IOException e) {
            e.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}
