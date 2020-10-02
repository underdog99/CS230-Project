/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pz.zrno;

import com.pz.jpa.Oficir;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author i5Killer
 */
@Stateless
public class OficirFacade extends AbstractFacade<Oficir> {

    @PersistenceContext(unitName = "CS230-PZ-Mladen-Simeonovic-3668PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OficirFacade() {
        super(Oficir.class);
    }
    
}
