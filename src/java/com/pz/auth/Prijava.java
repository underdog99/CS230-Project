
package com.pz.auth;

import com.pz.jpa.Korisnik;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpSession;

@Named
@ApplicationScoped
public class Prijava {
    
     @PersistenceContext(unitName = "CS230-PZ-Mladen-Simeonovic-3668PU")
     private EntityManager em;
     
     private static final long serialVersionUID = 1L;
     
     private String username;
     private String password;
     
     private String dozvola = "none";
     private boolean loggedIn;

    public EntityManager getEm() {
        return em;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getDozvola() {
        return dozvola;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDozvola(String dozvola) {
        this.dozvola = dozvola;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }
     
     public String login() {
         Korisnik user = null;
         boolean valid = false;
         
         System.out.println("USAO SAM U LOGIN METODU");
         
         try {
             user = (Korisnik) em.createNamedQuery("Korisnik.findByUsername").setParameter("username", username).getSingleResult();
             System.out.println("POSTOJI KORISNIK SA USERNAME-om > " + username);
             valid = validateUser(user);
         } catch (NoResultException ex) {
             System.out.println("NEPOSTOJI KORISNIK SA USERNAME-om > " + username);
             valid = false; 
         }
         
         if (valid) {
             HttpSession session = SessionUtils.getSession();
                session.setMaxInactiveInterval(100 * 9999);
                
                System.out.println("KREIRAMO SESIJU");
                System.out.println("ID SESIJE :" + session.getId());
                session.setAttribute("username", user.getUsername());
                System.out.println("SETUJEMO ATRIBUT SESIJE -user- u " + user.getUsername());
                System.out.println("ATRIBUT SESIJE -user- : " + session.getAttribute("username"));
                
                session.setAttribute("dozvola", user.getDozvolakorisnik());
                System.out.println("SETUJEMO ATRIBUT SESIJE -role- u " + user.getDozvolakorisnik());
                System.out.println("ATRIBUT SESIJE -role- : " + session.getAttribute("dozvola"));
                
                loggedIn = true;
                System.out.println("KORISNIK JE LOGOVAN");
                
                return "pocetna";
                      
         } else {
             System.out.println("USER NIJE VALIDAN, VRATI GA NA LOGIN");
             FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, new FacesMessage("Netacna lozinka ili korisnicko ime", "Molimo Vas da proverite podatke i pokušate ponovo."));
            
            return "index";    
         }
     }
     
     private boolean validateUser(Korisnik user) {
         
         if (user.getPass().equals(password)) {
             System.out.println("USEROV PASSWORD JE DOBAR");
             return true;
         } else {
             System.out.println("USEROV PASSWORD NIJE DOBAR");
             return false;
         }
     }
     
     public String logout() {
        clearData();
        return "login";
    }
     
    private void clearData() {
        username = "";
        password = "";
        dozvola = "none";
        loggedIn = false;
    } 
}
