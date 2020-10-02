
package com.pz.graf;

import com.pz.jpa.Cinovi;
import com.pz.jpa.Kasarna;
import com.pz.jpa.Oficir;
import com.pz.jpa.Podoficir;
import com.pz.jpa.Vojnik;
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

@Named
@RequestScoped
public class grafKasarna {

    @PersistenceContext(unitName = "CS230-PZ-Mladen-Simeonovic-3668PU")
    private EntityManager em;
    
    private PieChartModel pieModel1;
    private PieChartModel pieModel2;
    private PieChartModel pieModel3;
    
    private int countK;
    
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
    
    public PieChartModel getPieModel2() {
        return pieModel2;
    }
    
    public PieChartModel getPieModel3() {
        return pieModel3;
    }

    public int getCountK() {
        return countK;
    }
    
    
    private void createPieModels() {
       
        try {
            createPieModel1();
            createPieModel2();
            createPieModel3();
        } catch (Exception ex) {
            Logger.getLogger(grafJedinica.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void createPieModel1() throws Exception {
        pieModel1 = new PieChartModel();
        
        Vojnik v = null;
        Kasarna k = null;
        
        try{

            List<Kasarna> kl = em.createNamedQuery("Kasarna.findAll").getResultList();
            countK = kl.size();
            System.out.println(kl.size());
            
            for (int i = 1; i <= kl.size(); i++) {
                k = (Kasarna) em.createNamedQuery("Kasarna.findByIdkasarna").setParameter("idkasarna", i).getSingleResult();
                
                List<Vojnik> vl = k.getVojnikList();
            
                if (vl.size() != 0) {
            
                    pieModel1.set(k.getNazivkasarna(), vl.size());
                } else {
                    System.out.println("Naziv i/ili size su 0!");
                }
            }
            
            pieModel1.setTitle("Procenat Vojnika u kasarni");
            pieModel1.setLegendPosition("w");
            pieModel1.setShadow(false);
            pieModel1.setShowDataLabels(true);
            
        
        } catch (NoResultException e) {
            System.out.println(e.getMessage());
            pieModel1.setTitle("Procenat Vojnika u kasarni");
            pieModel1.setLegendPosition("w");
            pieModel1.setShadow(false);
            pieModel1.setShowDataLabels(true);
        }catch (Exception e) {
            System.out.println("AKO PUKNE NESTO IDEMO NA ERROR STRANU");
            System.out.println(e.getMessage());
        }
        
    }
    
    private void createPieModel2() throws Exception {
        pieModel2 = new PieChartModel();
        
        Podoficir p = null;
        Kasarna k = null;
        
        try{

            List<Kasarna> kl = em.createNamedQuery("Kasarna.findAll").getResultList();
            System.out.println(kl.size());
            
            for (int i = 1; i <= kl.size(); i++) {
                k = (Kasarna) em.createNamedQuery("Kasarna.findByIdkasarna").setParameter("idkasarna", i).getSingleResult();
                
                List<Podoficir> pl = k.getPodoficirList();
            
                if (pl.size() != 0) {
            
                    pieModel2.set(k.getNazivkasarna(), pl.size());
                } else {
                    System.out.println("Naziv i/ili size su 0!");
                }
            }
            
            pieModel2.setTitle("Procenat Podoficira u kasarni");
            pieModel2.setLegendPosition("w");
            pieModel2.setShadow(false);
            pieModel2.setShowDataLabels(true);
            
        
        } catch (NoResultException e) {
            System.out.println(e.getMessage());
            pieModel2.setTitle("Procenat Podoficira u kasarni");
            pieModel2.setLegendPosition("w");
            pieModel2.setShadow(false);
            pieModel2.setShowDataLabels(true);
        }catch (Exception e) {
            System.out.println("AKO PUKNE NESTO IDEMO NA ERROR STRANU");
            System.out.println(e.getMessage());
        }
        
    }
    
    private void createPieModel3() throws Exception {
        pieModel3 = new PieChartModel();
        
        Oficir o = null;
        Kasarna k = null;
        
        try{

            List<Kasarna> kl = em.createNamedQuery("Kasarna.findAll").getResultList();
            System.out.println(kl.size());
            
            for (int i = 1; i <= kl.size(); i++) {
                k = (Kasarna) em.createNamedQuery("Kasarna.findByIdkasarna").setParameter("idkasarna", i).getSingleResult();
                
                List<Oficir> ol = k.getOficirList();
            
                if (ol.size() != 0) {
            
                    pieModel3.set(k.getNazivkasarna(), ol.size());
                } else {
                    System.out.println("Naziv i/ili size su 0!");
                }
            }
            
            pieModel3.setTitle("Procenat Oficira u kasarni");
            pieModel3.setLegendPosition("w");
            pieModel3.setShadow(false);
            pieModel3.setShowDataLabels(true);
            
        
        } catch (NoResultException e) {
            System.out.println(e.getMessage());
            pieModel3.setTitle("Procenat Oficira u kasarni");
            pieModel3.setLegendPosition("w");
            pieModel3.setShadow(false);
            pieModel3.setShowDataLabels(true);
        }catch (Exception e) {
            System.out.println("AKO PUKNE NESTO IDEMO NA ERROR STRANU");
            System.out.println(e.getMessage());
        }
       
    }
    
}
