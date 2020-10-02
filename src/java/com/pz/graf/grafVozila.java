
package com.pz.graf;

import com.pz.jpa.Kopnenovozilo;
import com.pz.jpa.Vazdusnovozilo;
import com.pz.jpa.Vodenovozilo;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import org.primefaces.event.ItemSelectEvent;
import org.primefaces.model.chart.PieChartModel;


@Named(value = "grafVozila")
@RequestScoped
public class grafVozila {

    @PersistenceContext(unitName = "CS230-PZ-Mladen-Simeonovic-3668PU")
    private EntityManager em;
    
    private PieChartModel pieModel1;
    
    private int countKop;
    private int countVod;
    private int countVaz;
    
    @PostConstruct
    public void init() {
        createPieModels();
    }
    
    public void itemSelect(ItemSelectEvent event) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Item selected",
                "Item Index: " + event.getItemIndex() + ", Series Index:" + event.getSeriesIndex());
 
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public PieChartModel getPieModel1() {
        return pieModel1;
    }

    public int getCountKop() {
        return countKop;
    }

    public int getCountVod() {
        return countVod;
    }

    public int getCountVaz() {
        return countVaz;
    }
    
    private void createPieModels() {
       
        try {
            createPieModel1();
        } catch (Exception ex) {
            Logger.getLogger(grafJedinica.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
    private void createPieModel1() throws Exception {
        pieModel1 = new PieChartModel();
        
        List<Kopnenovozilo> kl;
        List<Vodenovozilo> vvl;
        List<Vazdusnovozilo> vavl;
        
        try{
            System.out.println("GRAF METODA");
            
            kl = em.createNamedQuery("Kopnenovozilo.findAll").getResultList();
            vvl = em.createNamedQuery("Vodenovozilo.findAll").getResultList();
            vavl = em.createNamedQuery("Vazdusnovozilo.findAll").getResultList();
            
            countKop = kl.size();
            countVod = vvl.size();
            countVaz = vavl.size();
            
            pieModel1.set("Kopnena vozila", kl.size());
            pieModel1.set("Vodena vozila", vvl.size());
            pieModel1.set("Vazdusna vozila", vavl.size());
            
            pieModel1.setTitle("Vojna vozila");
            pieModel1.setLegendPosition("w");
            pieModel1.setShadow(false);
            pieModel1.setShowDataLabels(true);
        } catch(NoResultException e) {
            System.out.println(e.getMessage());
        } catch(Exception e) {
            System.out.println("AKO PUKNE NESTO IDEMO NA ERROR STRANU");
            System.out.println(e.getMessage());
        }
    }
}
