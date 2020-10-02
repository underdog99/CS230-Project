
package com.pz.graf;

import com.pz.jpa.Jedinica;
import com.pz.jpa.Naoruzanje;
import com.pz.jpa.Vojnik;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
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
public class grafOruzije {

    @PersistenceContext(unitName = "CS230-PZ-Mladen-Simeonovic-3668PU")
    private EntityManager em;
    
    private PieChartModel pieModel1;
    
    private int countP;
    private int countK;
    private int countSMG;
    private int countJP;
    private int countM;
    private int countGL;
    private int countPVO;
    private int countPTO;
    private int countE;
    private int countZ;
    private int countD;
    
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

    public int getCountP() {
        return countP;
    }
    
    public int getCountK() {
        return countK;
    }

    public int getCountSMG() {
        return countSMG;
    }

    public int getCountJP() {
        return countJP;
    }

    public int getCountM() {
        return countM;
    }

    public int getCountGL() {
        return countGL;
    }

    public int getCountPVO() {
        return countPVO;
    }

    public int getCountPTO() {
        return countPTO;
    }

    public int getCountE() {
        return countE;
    }

    public int getCountZ() {
        return countZ;
    }

    public int getCountD() {
        return countD;
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
        
        List<Naoruzanje> nlP;
        List<Naoruzanje> nlK;
        List<Naoruzanje> nlSMG;
        List<Naoruzanje> nlJP;
        List<Naoruzanje> nlM;
        List<Naoruzanje> nlGL;
        List<Naoruzanje> nlPVO;
        List<Naoruzanje> nlPTO;
        List<Naoruzanje> nlE;
        List<Naoruzanje> nlZ;
        List<Naoruzanje> nlD;
 
        
        try{
            
            System.out.println("GRAF METODA");
            
            nlP = em.createNamedQuery("Naoruzanje.findByTip").setParameter("tipnaoruzanja", "Pistolj").getResultList();
            nlK = em.createNamedQuery("Naoruzanje.findByTip").setParameter("tipnaoruzanja", "Karabin").getResultList();
            nlSMG = em.createNamedQuery("Naoruzanje.findByTip").setParameter("tipnaoruzanja", "SMG").getResultList();
            nlJP = em.createNamedQuery("Naoruzanje.findByTip").setParameter("tipnaoruzanja", "Jurisna puska").getResultList();
            nlM = em.createNamedQuery("Naoruzanje.findByTip").setParameter("tipnaoruzanja", "Mitraljez").getResultList();
            nlGL = em.createNamedQuery("Naoruzanje.findByTip").setParameter("tipnaoruzanja", "GL").getResultList();
            nlPVO = em.createNamedQuery("Naoruzanje.findByTip").setParameter("tipnaoruzanja", "PVO").getResultList();
            nlPTO = em.createNamedQuery("Naoruzanje.findByTip").setParameter("tipnaoruzanja", "PTO").getResultList();
            nlE = em.createNamedQuery("Naoruzanje.findByTip").setParameter("tipnaoruzanja", "EXP").getResultList();
            nlZ = em.createNamedQuery("Naoruzanje.findByTip").setParameter("tipnaoruzanja", "Zastita").getResultList();
            nlD = em.createNamedQuery("Naoruzanje.findByTip").setParameter("tipnaoruzanja", "DO").getResultList();
            
            countP = nlP.size();
            countSMG = nlSMG.size();
            countK = nlK.size();
            countJP = nlJP.size();
            countM = nlK.size();
            countGL = nlGL.size();
            countPVO = nlPVO.size();
            countPTO = nlPTO.size();
            countE = nlE.size();
            countZ = nlZ.size();
            countD = nlD.size();
            
            pieModel1.set("Pistolji", nlP.size());
            pieModel1.set("Karabini", nlK.size());
            pieModel1.set("SMG", nlSMG.size());
            pieModel1.set("Jurisne puske", nlJP.size());
            pieModel1.set("Mitraljezi", nlM.size());
            pieModel1.set("GL", nlGL.size());
            pieModel1.set("PVO", nlPVO.size());
            pieModel1.set("PTO", nlPTO.size());
            pieModel1.set("EXP", nlE.size());
            pieModel1.set("Zastita", nlZ.size());
            pieModel1.set("Dodatna oprema", nlD.size());
            
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
}
