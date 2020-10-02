/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pz.jpa;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "jedinica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Jedinica.findAll", query = "SELECT j FROM Jedinica j")
    , @NamedQuery(name = "Jedinica.findByIdjedinice", query = "SELECT j FROM Jedinica j WHERE j.idjedinice = :idjedinice")
    , @NamedQuery(name = "Jedinica.findByTrosakjedinice", query = "SELECT j FROM Jedinica j WHERE j.trosakjedinice = :trosakjedinice")
    , @NamedQuery(name = "Jedinica.findByPrioritetjedinice", query = "SELECT j FROM Jedinica j WHERE j.prioritetjedinice = :prioritetjedinice")
    , @NamedQuery(name = "Jedinica.findByIsplatljivostjedinice", query = "SELECT j FROM Jedinica j WHERE j.isplatljivostjedinice = :isplatljivostjedinice")})
public class Jedinica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDJEDINICE")
    private Integer idjedinice;
    @Lob
    @Size(max = 65535)
    @Column(name = "GRBJEDINICE")
    private String grbjedinice;
    @Lob
    @Size(max = 65535)
    @Column(name = "NAZIVJEDINICE")
    private String nazivjedinice;
    @Lob
    @Size(max = 65535)
    @Column(name = "OPISJEDINICE")
    private String opisjedinice;
    @Column(name = "TROSAKJEDINICE")
    private Long trosakjedinice;
    @Column(name = "PRIORITETJEDINICE")
    private Integer prioritetjedinice;
    @Column(name = "ISPLATLJIVOSTJEDINICE")
    private Integer isplatljivostjedinice;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idjedinice")
    private List<Oficir> oficirList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idjedinice")
    private List<Podoficir> podoficirList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idjedinice")
    private List<Relationship3> relationship3List;
    @OneToMany(mappedBy = "idjedinice")
    private List<Vojnik> vojnikList;

    public Jedinica() {
    }

    public Jedinica(Integer idjedinice) {
        this.idjedinice = idjedinice;
    }

    public Integer getIdjedinice() {
        return idjedinice;
    }

    public void setIdjedinice(Integer idjedinice) {
        this.idjedinice = idjedinice;
    }

    public String getGrbjedinice() {
        return grbjedinice;
    }

    public void setGrbjedinice(String grbjedinice) {
        this.grbjedinice = grbjedinice;
    }

    public String getNazivjedinice() {
        return nazivjedinice;
    }

    public void setNazivjedinice(String nazivjedinice) {
        this.nazivjedinice = nazivjedinice;
    }

    public String getOpisjedinice() {
        return opisjedinice;
    }

    public void setOpisjedinice(String opisjedinice) {
        this.opisjedinice = opisjedinice;
    }

    public Long getTrosakjedinice() {
        return trosakjedinice;
    }

    public void setTrosakjedinice(Long trosakjedinice) {
        this.trosakjedinice = trosakjedinice;
    }

    public Integer getPrioritetjedinice() {
        return prioritetjedinice;
    }

    public void setPrioritetjedinice(Integer prioritetjedinice) {
        this.prioritetjedinice = prioritetjedinice;
    }

    public Integer getIsplatljivostjedinice() {
        return isplatljivostjedinice;
    }

    public void setIsplatljivostjedinice(Integer isplatljivostjedinice) {
        this.isplatljivostjedinice = isplatljivostjedinice;
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
    public List<Relationship3> getRelationship3List() {
        return relationship3List;
    }

    public void setRelationship3List(List<Relationship3> relationship3List) {
        this.relationship3List = relationship3List;
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
        hash += (idjedinice != null ? idjedinice.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Jedinica)) {
            return false;
        }
        Jedinica other = (Jedinica) object;
        if ((this.idjedinice == null && other.idjedinice != null) || (this.idjedinice != null && !this.idjedinice.equals(other.idjedinice))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nazivjedinice;
    }
    
}
