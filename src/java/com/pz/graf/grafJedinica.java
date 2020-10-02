
package com.pz.graf;

import com.pz.jpa.Jedinica;
import com.pz.jpa.Oficir;
import com.pz.jpa.Podoficir;
import com.pz.jpa.Saradnici;
import com.pz.jpa.Vojnik;
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
public class grafJedinica {

    @PersistenceContext(unitName = "CS230-PZ-Mladen-Simeonovic-3668PU")
    private EntityManager em;
    
    int id = 1;
    
    private PieChartModel pieModel1;
    private PieChartModel pieModel2;
    private PieChartModel pieModel3;
    private PieChartModel pieModel4;
    
    private int countJ;
    
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
    
    public PieChartModel getPieModel4() {
        return pieModel4;
    }

    public int getCountJ() {
        return countJ;
    }

    
    private void createPieModels() {
       
        try {
            createPieModel1();
            createPieModel2();
            createPieModel3();
            createPieModel4();
        } catch (Exception ex) {
            Logger.getLogger(grafJedinica.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void createPieModel1() throws Exception {
        pieModel1 = new PieChartModel();
        
        Vojnik v = null;
        Jedinica j = null;
        
        try{
            
            System.out.println("GRAF METODA");
            List<Jedinica> jl = em.createNamedQuery("Jedinica.findAll").getResultList();
            System.out.println(jl.size());
            countJ = jl.size();
            
            for (int i = 1; i <= jl.size(); i++) {
                j = (Jedinica) em.createNamedQuery("Jedinica.findByIdjedinice").setParameter("idjedinice", i).getSingleResult();
                
                List<Vojnik> vl = j.getVojnikList();
            
                System.out.println(vl.size());
            
                System.out.println(vl.toString());
         
                pieModel1.set(j.getNazivjedinice(), vl.size());
            }
            
            v = (Vojnik) em.createNamedQuery("Vojnik.findByIdvojnika").setParameter("idvojnika", 1).getSingleResult();
            
            pieModel1.setTitle("Procenat vojnika u jedinici");
            pieModel1.setLegendPosition("w");
            pieModel1.setShadow(false);
            pieModel1.setShowDataLabels(true);
        
        } catch (NoResultException e) {
            System.out.println(e.getMessage());
        }catch (Exception e) {
            System.out.println("AKO PUKNE NESTO IDEMO NA ERROR STRANU");
            System.out.println(e.getMessage());
        }
    }
    
    private void createPieModel2() throws Exception {
        pieModel2 = new PieChartModel();
        
        Podoficir po = null;
        Jedinica j = null;
        
        try{
            
            System.out.println("GRAF METODA2");
            List<Jedinica> jl = em.createNamedQuery("Jedinica.findAll").getResultList();
            System.out.println(jl.size());
            
            for (int i = 1; i <= jl.size(); i++) {
                j = (Jedinica) em.createNamedQuery("Jedinica.findByIdjedinice").setParameter("idjedinice", i).getSingleResult();
                
                List<Podoficir> pol = j.getPodoficirList();
            
                System.out.println(pol.size());
            
                System.out.println(pol.toString());

                pieModel2.set(j.getNazivjedinice(), pol.size());
            }

            
            pieModel2.setTitle("Procenat podoficira u jedinici");
            pieModel2.setLegendPosition("w");
            pieModel2.setShadow(false);
            pieModel2.setShowDataLabels(true);

        
        } catch (NoResultException e) {
            System.out.println(e.getMessage());
        }catch (Exception e) {
            System.out.println("AKO PUKNE NESTO IDEMO NA ERROR STRANU");
            System.out.println(e.getMessage());
        }
    }
    
    private void createPieModel3() throws Exception {
        pieModel3 = new PieChartModel();
        
        Oficir o = null;
        Jedinica j = null;
        
        try{
            
            System.out.println("GRAF METODA3");
            List<Jedinica> jl = em.createNamedQuery("Jedinica.findAll").getResultList();
            System.out.println(jl.size());
            
            for (int i = 1; i <= jl.size(); i++) {
                j = (Jedinica) em.createNamedQuery("Jedinica.findByIdjedinice").setParameter("idjedinice", i).getSingleResult();
                
                List<Oficir> ol = j.getOficirList();
            
                System.out.println(ol.size());
            
                System.out.println(ol.toString());

                pieModel3.set(j.getNazivjedinice(), ol.size());
            }

                        
            pieModel3.setTitle("Procenat Oficira u jedinici");
            pieModel3.setLegendPosition("w");
            pieModel3.setShadow(false);
            pieModel3.setShowDataLabels(true);

        
        } catch (NoResultException e) {
            System.out.println(e.getMessage());
        }catch (Exception e) {
            System.out.println("AKO PUKNE NESTO IDEMO NA ERROR STRANU");
            System.out.println(e.getMessage());
        }
    }
    
    
     private void createPieModel4() throws Exception {
        pieModel4 = new PieChartModel();
        
        Jedinica j = null;
        
        try{
            
            System.out.println("GRAF METODA4");
            List<Jedinica> jl = em.createNamedQuery("Jedinica.findAll").getResultList();
            System.out.println(jl.size());
            
            for (int i = 1; i <= jl.size(); i++) {
                j = (Jedinica) em.createNamedQuery("Jedinica.findByIdjedinice").setParameter("idjedinice", i).getSingleResult();
                

                pieModel4.set(j.getNazivjedinice(), j.getTrosakjedinice());
            }

            
            
            pieModel4.setTitle("Procenat troskova u jedinici na mesecnom nivou(Hrana, Elektricna energija, Gorivo, Voda, Municije)");
            pieModel4.setLegendPosition("w");
            pieModel4.setShadow(false);
            pieModel4.setShowDataLabels(true);

        
        } catch (NoResultException e) {
            System.out.println(e.getMessage());
        }catch (Exception e) {
            System.out.println("AKO PUKNE NESTO IDEMO NA ERROR STRANU");
            System.out.println(e.getMessage());
        }
    }
    
}
