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
@Table(name = "relationship_4")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Relationship4.findAll", query = "SELECT r FROM Relationship4 r")
    , @NamedQuery(name = "Relationship4.findByIdR4", query = "SELECT r FROM Relationship4 r WHERE r.idR4 = :idR4")})
public class Relationship4 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idR4")
    private Integer idR4;
    @JoinColumn(name = "IDKASARNA", referencedColumnName = "IDKASARNA")
    @ManyToOne
    private Kasarna idkasarna;
    @JoinColumn(name = "IDMEDRES", referencedColumnName = "IDMEDRES")
    @ManyToOne(optional = false)
    private Medresurs idmedres;

    public Relationship4() {
    }

    public Relationship4(Integer idR4) {
        this.idR4 = idR4;
    }

    public Integer getIdR4() {
        return idR4;
    }

    public void setIdR4(Integer idR4) {
        this.idR4 = idR4;
    }

    public Kasarna getIdkasarna() {
        return idkasarna;
    }

    public void setIdkasarna(Kasarna idkasarna) {
        this.idkasarna = idkasarna;
    }

    public Medresurs getIdmedres() {
        return idmedres;
    }

    public void setIdmedres(Medresurs idmedres) {
        this.idmedres = idmedres;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idR4 != null ? idR4.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Relationship4)) {
            return false;
        }
        Relationship4 other = (Relationship4) object;
        if ((this.idR4 == null && other.idR4 != null) || (this.idR4 != null && !this.idR4.equals(other.idR4))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pz.jpa.Relationship4[ idR4=" + idR4 + " ]";
    }
    
}
