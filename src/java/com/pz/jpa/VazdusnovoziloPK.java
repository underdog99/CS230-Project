/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pz.jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author i5Killer
 */
@Embeddable
public class VazdusnovoziloPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "IDVOZILO")
    private int idvozilo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDVAZVOZILA")
    private int idvazvozila;

    public VazdusnovoziloPK() {
    }

    public VazdusnovoziloPK(int idvozilo, int idvazvozila) {
        this.idvozilo = idvozilo;
        this.idvazvozila = idvazvozila;
    }

    public int getIdvozilo() {
        return idvozilo;
    }

    public void setIdvozilo(int idvozilo) {
        this.idvozilo = idvozilo;
    }

    public int getIdvazvozila() {
        return idvazvozila;
    }

    public void setIdvazvozila(int idvazvozila) {
        this.idvazvozila = idvazvozila;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idvozilo;
        hash += (int) idvazvozila;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VazdusnovoziloPK)) {
            return false;
        }
        VazdusnovoziloPK other = (VazdusnovoziloPK) object;
        if (this.idvozilo != other.idvozilo) {
            return false;
        }
        if (this.idvazvozila != other.idvazvozila) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pz.jpa.VazdusnovoziloPK[ idvozilo=" + idvozilo + ", idvazvozila=" + idvazvozila + " ]";
    }
    
}
