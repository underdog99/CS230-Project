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
@Table(name = "mrekit")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mrekit.findAll", query = "SELECT m FROM Mrekit m")
    , @NamedQuery(name = "Mrekit.findByIdmre", query = "SELECT m FROM Mrekit m WHERE m.idmre = :idmre")
    , @NamedQuery(name = "Mrekit.findByPrioritetmre", query = "SELECT m FROM Mrekit m WHERE m.prioritetmre = :prioritetmre")
    , @NamedQuery(name = "Mrekit.findByGodisnjitrosak", query = "SELECT m FROM Mrekit m WHERE m.godisnjitrosak = :godisnjitrosak")
    , @NamedQuery(name = "Mrekit.findByIsplatljivostmre", query = "SELECT m FROM Mrekit m WHERE m.isplatljivostmre = :isplatljivostmre")})
public class Mrekit implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDMRE")
    private Integer idmre;
    @Lob
    @Size(max = 65535)
    @Column(name = "NAZIVMRE")
    private String nazivmre;
    @Lob
    @Size(max = 65535)
    @Column(name = "SASTOJICIMRE")
    private String sastojicimre;
    @Column(name = "PRIORITETMRE")
    private Integer prioritetmre;
    @Column(name = "GODISNJITROSAK")
    private Long godisnjitrosak;
    @Column(name = "ISPLATLJIVOSTMRE")
    private Integer isplatljivostmre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idmre")
    private List<Relationship1> relationship1List;

    public Mrekit() {
    }

    public Mrekit(Integer idmre) {
        this.idmre = idmre;
    }

    public Integer getIdmre() {
        return idmre;
    }

    public void setIdmre(Integer idmre) {
        this.idmre = idmre;
    }

    public String getNazivmre() {
        return nazivmre;
    }

    public void setNazivmre(String nazivmre) {
        this.nazivmre = nazivmre;
    }

    public String getSastojicimre() {
        return sastojicimre;
    }

    public void setSastojicimre(String sastojicimre) {
        this.sastojicimre = sastojicimre;
    }

    public Integer getPrioritetmre() {
        return prioritetmre;
    }

    public void setPrioritetmre(Integer prioritetmre) {
        this.prioritetmre = prioritetmre;
    }

    public Long getGodisnjitrosak() {
        return godisnjitrosak;
    }

    public void setGodisnjitrosak(Long godisnjitrosak) {
        this.godisnjitrosak = godisnjitrosak;
    }

    public Integer getIsplatljivostmre() {
        return isplatljivostmre;
    }

    public void setIsplatljivostmre(Integer isplatljivostmre) {
        this.isplatljivostmre = isplatljivostmre;
    }

    @XmlTransient
    public List<Relationship1> getRelationship1List() {
        return relationship1List;
    }

    public void setRelationship1List(List<Relationship1> relationship1List) {
        this.relationship1List = relationship1List;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmre != null ? idmre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mrekit)) {
            return false;
        }
        Mrekit other = (Mrekit) object;
        if ((this.idmre == null && other.idmre != null) || (this.idmre != null && !this.idmre.equals(other.idmre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nazivmre;
    }
    
}
