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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author i5Killer
 */
@Entity
@Table(name = "relationship_3")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Relationship3.findAll", query = "SELECT r FROM Relationship3 r")
    , @NamedQuery(name = "Relationship3.findByIdR3", query = "SELECT r FROM Relationship3 r WHERE r.idR3 = :idR3")})
public class Relationship3 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idR3")
    private Integer idR3;
    @JoinColumn(name = "IDJEDINICE", referencedColumnName = "IDJEDINICE")
    @ManyToOne(optional = false)
    private Jedinica idjedinice;
    @JoinColumn(name = "IDKASARNA", referencedColumnName = "IDKASARNA")
    @ManyToOne
    private Kasarna idkasarna;

    public Relationship3() {
    }

    public Relationship3(Integer idR3) {
        this.idR3 = idR3;
    }

    public Integer getIdR3() {
        return idR3;
    }

    public void setIdR3(Integer idR3) {
        this.idR3 = idR3;
    }

    public Jedinica getIdjedinice() {
        return idjedinice;
    }

    public void setIdjedinice(Jedinica idjedinice) {
        this.idjedinice = idjedinice;
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
        hash += (idR3 != null ? idR3.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Relationship3)) {
            return false;
        }
        Relationship3 other = (Relationship3) object;
        if ((this.idR3 == null && other.idR3 != null) || (this.idR3 != null && !this.idR3.equals(other.idR3))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pz.jpa.Relationship3[ idR3=" + idR3 + " ]";
    }
    
}
