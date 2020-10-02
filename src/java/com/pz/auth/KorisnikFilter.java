
package com.pz.auth;

import com.pz.jpa.Korisnik;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebFilter(filterName = "KorisnikFilter", urlPatterns = {"/faces/pocetna.xhtml"})
public class KorisnikFilter implements Filter {
    
    @Inject
    Prijava prijava;
    
     @PersistenceContext(unitName = "CS230-PZ-Mladen-Simeonovic-3668PU")
     private EntityManager em;
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        
        HttpServletRequest reqt = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        
        HttpSession session2 = (HttpSession) reqt.getSession(false);
        
        Korisnik korisnik = null;
        
        try {
            System.out.println("GETUJEMO KORISNIKA");
            korisnik = (Korisnik) em.createNamedQuery("Korisnik.findByUsername").setParameter("username", prijava.getUsername()).getSingleResult();
            
            String reqURI = reqt.getRequestURI();
            if (!korisnik.getDozvolakorisnik().isEmpty()) {
                System.out.println("AKO JE VALIDAN SLOBODNO NASTAVI GDE SI POSAO");
                chain.doFilter(request, response);
            } else {
                System.out.println("IZVOLI NA LOGIN");
          
                resp.sendRedirect(reqt.getContextPath() + "/faces/index.xhtml");
            }
        } catch (NoResultException e) {
            System.out.println("AKO NE POSTOJI KORISNIK IZVOLI NA LOGIN");
            System.out.println(e.getMessage());
            resp.sendRedirect(reqt.getContextPath() + "/faces/index.xhtml");
        } catch (IOException | ServletException e) {
            System.out.println("AKO PUKNE NESTO IDEMO NA ERROR STRANU");
            System.out.println(e.getMessage());
            resp.sendRedirect(reqt.getContextPath() + "/faces/error.xhtml");
        }
    }

    @Override
    public void destroy() {
       
    }
    
    
}
