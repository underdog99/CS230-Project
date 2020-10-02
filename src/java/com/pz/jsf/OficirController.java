package com.pz.jsf;

import com.pz.jpa.Oficir;
import com.pz.jpa.Vojnik;
import com.pz.jsf.util.JsfUtil;
import com.pz.jsf.util.JsfUtil.PersistAction;
import com.pz.zrno.OficirFacade;
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

@Named("oficirController")
@SessionScoped
public class OficirController implements Serializable {

    @EJB
    private com.pz.zrno.OficirFacade ejbFacade;
    private List<Oficir> items = null;
    private Oficir selected;

    public OficirController() {
    }

    public Oficir getSelected() {
        return selected;
    }

    public void setSelected(Oficir selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private OficirFacade getFacade() {
        return ejbFacade;
    }

    public Oficir prepareCreate() {
        selected = new Oficir();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("OficirCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("OficirUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("OficirDeleted"));
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

    public List<Oficir> getItems() {
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

    public Oficir getOficir(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Oficir> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Oficir> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Oficir.class)
    public static class OficirControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            OficirController controller = (OficirController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "oficirController");
            return controller.getOficir(getKey(value));
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
            if (object instanceof Oficir) {
                Oficir o = (Oficir) object;
                return getStringKey(o.getIdoficira());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Oficir.class.getName()});
                return null;
            }
        }

    }
    
    
    private Part upFile1;
    private Part upFile2;
    private final String folderProfil = "c:\\slike\\oficir";
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
            Oficir o = null;
            o = (Oficir) em.createNamedQuery("Oficir.findByIdoficira").setParameter("idoficira", idInt).getSingleResult();
            System.out.println("Ime oficira: " + o.getImeclana());
                selected.setIdoficira(o.getIdoficira());
                selected.setImeclana(o.getImeclana());
                selected.setPrezimeclana(o.getPrezimeclana());
                selected.setJmbgclana(o.getJmbgclana());
                selected.setGodinarodjenjaclana(o.getGodinarodjenjaclana());
                selected.setMestorodjenjaclana(o.getMestorodjenjaclana());
                selected.setKontaktclana(o.getKontaktclana());
                selected.setVisinaclana(o.getVisinaclana());
                selected.setKilazaclana(o.getKilazaclana());
                selected.setBojaociuclana(o.getBojaociuclana());
                selected.setFotoclana(fileName);
                selected.setOtisakprstaclana(o.getOtisakprstaclana());
                selected.setPlataclana(o.getPlataclana());
                selected.setIdcina(o.getIdcina());
                selected.setIdjedinice(o.getIdjedinice());
                selected.setIdkasarna(o.getIdkasarna());
                selected.setPocetaksluzbeoficira(o.getPocetaksluzbeoficira());
                selected.setKrajsluzbeoficira(o.getKrajsluzbeoficira());
               
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
