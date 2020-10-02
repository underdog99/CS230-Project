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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author i5Killer
 */
@Entity
@Table(name = "relationship_2")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Relationship2.findAll", query = "SELECT r FROM Relationship2 r")
    , @NamedQuery(name = "Relationship2.findByIdR2", query = "SELECT r FROM Relationship2 r WHERE r.idR2 = :idR2")})
public class Relationship2 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idR2")
    private Integer idR2;
    @JoinColumn(name = "IDKASARNA", referencedColumnName = "IDKASARNA")
    @ManyToOne
    private Kasarna idkasarna;
    @JoinColumn(name = "IDNAORUZANJA", referencedColumnName = "IDNAORUZANJA")
    @ManyToOne(optional = false)
    private Naoruzanje idnaoruzanja;

    public Relationship2() {
    }

    public Relationship2(Integer idR2) {
        this.idR2 = idR2;
    }

    public Integer getIdR2() {
        return idR2;
    }

    public void setIdR2(Integer idR2) {
        this.idR2 = idR2;
    }

    public Kasarna getIdkasarna() {
        return idkasarna;
    }

    public void setIdkasarna(Kasarna idkasarna) {
        this.idkasarna = idkasarna;
    }

    public Naoruzanje getIdnaoruzanja() {
        return idnaoruzanja;
    }

    public void setIdnaoruzanja(Naoruzanje idnaoruzanja) {
        this.idnaoruzanja = idnaoruzanja;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idR2 != null ? idR2.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Relationship2)) {
            return false;
        }
        Relationship2 other = (Relationship2) object;
        if ((this.idR2 == null && other.idR2 != null) || (this.idR2 != null && !this.idR2.equals(other.idR2))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pz.jpa.Relationship2[ idR2=" + idR2 + " ]";
    }
    
}
