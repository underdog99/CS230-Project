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
@Table(name = "medresurs")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Medresurs.findAll", query = "SELECT m FROM Medresurs m")
    , @NamedQuery(name = "Medresurs.findByIdmedres", query = "SELECT m FROM Medresurs m WHERE m.idmedres = :idmedres")
    , @NamedQuery(name = "Medresurs.findByTrosakmedres", query = "SELECT m FROM Medresurs m WHERE m.trosakmedres = :trosakmedres")
    , @NamedQuery(name = "Medresurs.findByPrioritetmedres", query = "SELECT m FROM Medresurs m WHERE m.prioritetmedres = :prioritetmedres")
    , @NamedQuery(name = "Medresurs.findByIsplatljivostmedres", query = "SELECT m FROM Medresurs m WHERE m.isplatljivostmedres = :isplatljivostmedres")})
public class Medresurs implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDMEDRES")
    private Integer idmedres;
    @Lob
    @Size(max = 65535)
    @Column(name = "NAZIVMEDRES")
    private String nazivmedres;
    @Lob
    @Size(max = 65535)
    @Column(name = "TIPMEDRES")
    private String tipmedres;
    @Column(name = "TROSAKMEDRES")
    private Long trosakmedres;
    @Column(name = "PRIORITETMEDRES")
    private Integer prioritetmedres;
    @Column(name = "ISPLATLJIVOSTMEDRES")
    private Integer isplatljivostmedres;
    @Lob
    @Size(max = 65535)
    @Column(name = "OPISMEDRES")
    private String opismedres;
    @Lob
    @Size(max = 65535)
    @Column(name = "SLIKAMEDRES")
    private String slikamedres;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idmedres")
    private List<Relationship4> relationship4List;

    public Medresurs() {
    }

    public Medresurs(Integer idmedres) {
        this.idmedres = idmedres;
    }

    public Integer getIdmedres() {
        return idmedres;
    }

    public void setIdmedres(Integer idmedres) {
        this.idmedres = idmedres;
    }

    public String getNazivmedres() {
        return nazivmedres;
    }

    public void setNazivmedres(String nazivmedres) {
        this.nazivmedres = nazivmedres;
    }

    public String getTipmedres() {
        return tipmedres;
    }

    public void setTipmedres(String tipmedres) {
        this.tipmedres = tipmedres;
    }

    public Long getTrosakmedres() {
        return trosakmedres;
    }

    public void setTrosakmedres(Long trosakmedres) {
        this.trosakmedres = trosakmedres;
    }

    public Integer getPrioritetmedres() {
        return prioritetmedres;
    }

    public void setPrioritetmedres(Integer prioritetmedres) {
        this.prioritetmedres = prioritetmedres;
    }

    public Integer getIsplatljivostmedres() {
        return isplatljivostmedres;
    }

    public void setIsplatljivostmedres(Integer isplatljivostmedres) {
        this.isplatljivostmedres = isplatljivostmedres;
    }

    public String getOpismedres() {
        return opismedres;
    }

    public void setOpismedres(String opismedres) {
        this.opismedres = opismedres;
    }

    public String getSlikamedres() {
        return slikamedres;
    }

    public void setSlikamedres(String slikamedres) {
        this.slikamedres = slikamedres;
    }

    @XmlTransient
    public List<Relationship4> getRelationship4List() {
        return relationship4List;
    }

    public void setRelationship4List(List<Relationship4> relationship4List) {
        this.relationship4List = relationship4List;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmedres != null ? idmedres.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medresurs)) {
            return false;
        }
        Medresurs other = (Medresurs) object;
        if ((this.idmedres == null && other.idmedres != null) || (this.idmedres != null && !this.idmedres.equals(other.idmedres))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idmedres.toString();
    }
    
}
