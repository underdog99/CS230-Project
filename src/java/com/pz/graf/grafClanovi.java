
package com.pz.graf;

import com.pz.jpa.Jedinica;
import com.pz.jpa.Oficir;
import com.pz.jpa.Podoficir;
import com.pz.jpa.Saradnici;
import com.pz.jpa.Vojnik;
import com.pz.jpa.Cinovi;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import org.primefaces.event.ItemSelectEvent;
import org.primefaces.model.chart.PieChartModel;

@Named
@RequestScoped
public class grafClanovi {
    
    @PersistenceContext(unitName = "CS230-PZ-Mladen-Simeonovic-3668PU")
    private EntityManager em;
    
    private PieChartModel pieModel1;
    private PieChartModel pieModel2;
    private PieChartModel pieModel3;
    private int countV;
    private int countP;
    private int countO;
    
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

    public int getCountV() {
        return countV;
    }
    
    public int getCountP() {
        return countP;
    }
    
     public int getCountO() {
        return countO;
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
        Cinovi c = null;
        
        try{
            
            System.out.println("GRAF METODA");
            
            List<Cinovi> cl = em.createNamedQuery("Cinovi.findAll").getResultList();
            System.out.println(cl.size());
            List<Vojnik> vl = null;
            
            for (int i = 0; i <= cl.size(); i++) {
                c = (Cinovi) em.createNamedQuery("Cinovi.findByIdcina").setParameter("idcina", i).getSingleResult();
                
                vl = c.getVojnikList();
            
                if (vl.size() != 0) {
                    System.out.println("Br vojnika: " + vl.size());
                    countV = vl.size();
                    pieModel1.set(c.getNazivcina(), vl.size());
                } else {
                    System.out.println("Naziv i/ili size su 0!");
                }
            }
            pieModel1.setTitle("Procenat Vojnika sa cinom");
            pieModel1.setLegendPosition("w");
            pieModel1.setShadow(false);
            pieModel1.setShowDataLabels(true);
            
        
        } catch (NoResultException e) {
            System.out.println(e.getMessage());
            pieModel1.setTitle("Procenat Vojnika sa cinom");
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
        Cinovi c = null;
        
        try{
            
            System.out.println("GRAF METODA2");
            
            List<Cinovi> cl = em.createNamedQuery("Cinovi.findAll").getResultList();
            System.out.println(cl.size());
            List<Podoficir> pl = null;
            
            for (int i = 0; i <= cl.size(); i++) {
                c = (Cinovi) em.createNamedQuery("Cinovi.findByIdcina").setParameter("idcina", i).getSingleResult();
                
                pl = c.getPodoficirList();
                System.out.println("Br podoficrA: " + pl.size());
                if (pl.size() != 0) {
                    System.out.println("Br podoficra: " + pl.size());
                    pieModel2.set(c.getNazivcina(), pl.size());
                    countP = countP + pl.size();
                } else {
                    System.out.println("Naziv i/ili size su 0!");
                }
            }
            pieModel2.setTitle("Procenat Podoficira sa cinom");
            pieModel2.setLegendPosition("w");
            pieModel2.setShadow(false);
            pieModel2.setShowDataLabels(true);
            
        
        } catch (NoResultException e) {
            System.out.println(e.getMessage());
            pieModel2.setTitle("Procenat Podoficira sa cinom");
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
        Cinovi c = null;
        
        try{
            
            System.out.println("GRAF METODA3");
            
            List<Cinovi> cl = em.createNamedQuery("Cinovi.findAll").getResultList();
            System.out.println(cl.size());
            List<Oficir> ol = null;
            
            for (int i = 0; i <= cl.size(); i++) {
                c = (Cinovi) em.createNamedQuery("Cinovi.findByIdcina").setParameter("idcina", i).getSingleResult();
                
                ol = c.getOficirList();
                System.out.println("Br OficrA: " + ol.size());
                if (ol.size() != 0) {
                    System.out.println("Br Oficra: " + ol.size());
                    pieModel3.set(c.getNazivcina(), ol.size());
                    countO = countO + ol.size();
                } else {
                    System.out.println("Naziv i/ili size su 0!");
                }
            }
            pieModel3.setTitle("Procenat Podoficira sa cinom");
            pieModel3.setLegendPosition("w");
            pieModel3.setShadow(false);
            pieModel3.setShowDataLabels(true);
            
        
        } catch (NoResultException e) {
            System.out.println(e.getMessage());
            pieModel3.setTitle("Procenat Podoficira sa cinom");
            pieModel3.setLegendPosition("w");
            pieModel3.setShadow(false);
            pieModel3.setShowDataLabels(true);
        }catch (Exception e) {
            System.out.println("AKO PUKNE NESTO IDEMO NA ERROR STRANU");
            System.out.println(e.getMessage());
        }
 
    }
    
}
