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
@Table(name = "relationship_1")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Relationship1.findAll", query = "SELECT r FROM Relationship1 r")
    , @NamedQuery(name = "Relationship1.findByIdR1", query = "SELECT r FROM Relationship1 r WHERE r.idR1 = :idR1")})
public class Relationship1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idR1")
    private Integer idR1;
    @JoinColumn(name = "IDKASARNA", referencedColumnName = "IDKASARNA")
    @ManyToOne
    private Kasarna idkasarna;
    @JoinColumn(name = "IDMRE", referencedColumnName = "IDMRE")
    @ManyToOne(optional = false)
    private Mrekit idmre;

    public Relationship1() {
    }

    public Relationship1(Integer idR1) {
        this.idR1 = idR1;
    }

    public Integer getIdR1() {
        return idR1;
    }

    public void setIdR1(Integer idR1) {
        this.idR1 = idR1;
    }

    public Kasarna getIdkasarna() {
        return idkasarna;
    }

    public void setIdkasarna(Kasarna idkasarna) {
        this.idkasarna = idkasarna;
    }

    public Mrekit getIdmre() {
        return idmre;
    }

    public void setIdmre(Mrekit idmre) {
        this.idmre = idmre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idR1 != null ? idR1.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Relationship1)) {
            return false;
        }
        Relationship1 other = (Relationship1) object;
        if ((this.idR1 == null && other.idR1 != null) || (this.idR1 != null && !this.idR1.equals(other.idR1))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pz.jpa.Relationship1[ idR1=" + idR1 + " ]";
    }
    
}
