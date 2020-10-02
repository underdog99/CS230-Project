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
@Table(name = "relationship_5")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Relationship5.findAll", query = "SELECT r FROM Relationship5 r")
    , @NamedQuery(name = "Relationship5.findByIdR5", query = "SELECT r FROM Relationship5 r WHERE r.idR5 = :idR5")})
public class Relationship5 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idR5")
    private Integer idR5;
    @JoinColumn(name = "IDHRANAPICE", referencedColumnName = "IDHRANAPICE")
    @ManyToOne(optional = false)
    private Reshranapice idhranapice;
    @JoinColumn(name = "IDKASARNA", referencedColumnName = "IDKASARNA")
    @ManyToOne
    private Kasarna idkasarna;

    public Relationship5() {
    }

    public Relationship5(Integer idR5) {
        this.idR5 = idR5;
    }

    public Integer getIdR5() {
        return idR5;
    }

    public void setIdR5(Integer idR5) {
        this.idR5 = idR5;
    }

    public Reshranapice getIdhranapice() {
        return idhranapice;
    }

    public void setIdhranapice(Reshranapice idhranapice) {
        this.idhranapice = idhranapice;
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
        hash += (idR5 != null ? idR5.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Relationship5)) {
            return false;
        }
        Relationship5 other = (Relationship5) object;
        if ((this.idR5 == null && other.idR5 != null) || (this.idR5 != null && !this.idR5.equals(other.idR5))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pz.jpa.Relationship5[ idR5=" + idR5 + " ]";
    }
    
}
