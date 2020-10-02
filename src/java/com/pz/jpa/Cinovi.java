/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pz.jpa;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author i5Killer
 */
@Entity
@Table(name = "cinovi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cinovi.findAll", query = "SELECT c FROM Cinovi c")
    , @NamedQuery(name = "Cinovi.findByIdcina", query = "SELECT c FROM Cinovi c WHERE c.idcina = :idcina")})
public class Cinovi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDCINA")
    private Integer idcina;
    @Lob
    @Size(max = 65535)
    @Column(name = "NAZIVCINA")
    private String nazivcina;
    @OneToMany(mappedBy = "idcina")
    private List<Oficir> oficirList;
    @OneToMany(mappedBy = "idcina")
    private List<Podoficir> podoficirList;
    @OneToMany(mappedBy = "idcina")
    private List<Vojnik> vojnikList;

    public Cinovi() {
    }

    public Cinovi(Integer idcina) {
        this.idcina = idcina;
    }

    public Integer getIdcina() {
        return idcina;
    }

    public void setIdcina(Integer idcina) {
        this.idcina = idcina;
    }

    public String getNazivcina() {
        return nazivcina;
    }

    public void setNazivcina(String nazivcina) {
        this.nazivcina = nazivcina;
    }

    @XmlTransient
    public List<Oficir> getOficirList() {
        return oficirList;
    }

    public void setOficirList(List<Oficir> oficirList) {
        this.oficirList = oficirList;
    }

    @XmlTransient
    public List<Podoficir> getPodoficirList() {
        return podoficirList;
    }

    public void setPodoficirList(List<Podoficir> podoficirList) {
        this.podoficirList = podoficirList;
    }

    @XmlTransient
    public List<Vojnik> getVojnikList() {
        return vojnikList;
    }

    public void setVojnikList(List<Vojnik> vojnikList) {
        this.vojnikList = vojnikList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcina != null ? idcina.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cinovi)) {
            return false;
        }
        Cinovi other = (Cinovi) object;
        if ((this.idcina == null && other.idcina != null) || (this.idcina != null && !this.idcina.equals(other.idcina))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nazivcina;
    }
    
}
