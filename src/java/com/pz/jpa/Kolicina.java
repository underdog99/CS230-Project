/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pz.jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author i5Killer
 */
@Entity
@Table(name = "kolicina")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kolicina.findAll", query = "SELECT k FROM Kolicina k")
    , @NamedQuery(name = "Kolicina.findByIdkolicina", query = "SELECT k FROM Kolicina k WHERE k.idkolicina = :idkolicina")
    , @NamedQuery(name = "Kolicina.findByKolikokolicina", query = "SELECT k FROM Kolicina k WHERE k.kolikokolicina = :kolikokolicina")})
public class Kolicina implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDKOLICINA")
    private Integer idkolicina;
    @Lob
    @Size(max = 65535)
    @Column(name = "CEGAKOLICINA")
    private String cegakolicina;
    @Column(name = "KOLIKOKOLICINA")
    private Integer kolikokolicina;
    @JoinColumn(name = "IDKASARNA", referencedColumnName = "IDKASARNA")
    @ManyToOne
    private Kasarna idkasarna;

    public Kolicina() {
    }

    public Kolicina(Integer idkolicina) {
        this.idkolicina = idkolicina;
    }

    public Integer getIdkolicina() {
        return idkolicina;
    }

    public void setIdkolicina(Integer idkolicina) {
        this.idkolicina = idkolicina;
    }

    public String getCegakolicina() {
        return cegakolicina;
    }

    public void setCegakolicina(String cegakolicina) {
        this.cegakolicina = cegakolicina;
    }

    public Integer getKolikokolicina() {
        return kolikokolicina;
    }

    public void setKolikokolicina(Integer kolikokolicina) {
        this.kolikokolicina = kolikokolicina;
    }

    public Kasarna getIdkasarna() {
        return idkasarna;
    }

    public void setIdkasarna(Kasarna idkasarna) {
        this.idkasarna = idkasarna;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idkolicina != null ? idkolicina.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kolicina)) {
            return false;
        }
        Kolicina other = (Kolicina) object;
        if ((this.idkolicina == null && other.idkolicina != null) || (this.idkolicina != null && !this.idkolicina.equals(other.idkolicina))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pz.jpa.Kolicina[ idkolicina=" + idkolicina + " ]";
    }
    
}
