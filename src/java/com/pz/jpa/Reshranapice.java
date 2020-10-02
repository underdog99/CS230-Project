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
@Table(name = "reshranapice")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reshranapice.findAll", query = "SELECT r FROM Reshranapice r")
    , @NamedQuery(name = "Reshranapice.findByIdhranapice", query = "SELECT r FROM Reshranapice r WHERE r.idhranapice = :idhranapice")
    , @NamedQuery(name = "Reshranapice.findByPrioritethranapice", query = "SELECT r FROM Reshranapice r WHERE r.prioritethranapice = :prioritethranapice")
    , @NamedQuery(name = "Reshranapice.findByTrosakhranapice", query = "SELECT r FROM Reshranapice r WHERE r.trosakhranapice = :trosakhranapice")
    , @NamedQuery(name = "Reshranapice.findByIsplatljivosthranapice", query = "SELECT r FROM Reshranapice r WHERE r.isplatljivosthranapice = :isplatljivosthranapice")})
public class Reshranapice implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDHRANAPICE")
    private Integer idhranapice;
    @Lob
    @Size(max = 65535)
    @Column(name = "NAZIVHRANAPICE")
    private String nazivhranapice;
    @Lob
    @Size(max = 65535)
    @Column(name = "TIPHRANAPICE")
    private String tiphranapice;
    @Lob
    @Size(max = 65535)
    @Column(name = "OPISHRANAPICE")
    private String opishranapice;
    @Column(name = "PRIORITETHRANAPICE")
    private Integer prioritethranapice;
    @Column(name = "TROSAKHRANAPICE")
    private Long trosakhranapice;
    @Column(name = "ISPLATLJIVOSTHRANAPICE")
    private Integer isplatljivosthranapice;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idhranapice")
    private List<Relationship5> relationship5List;

    public Reshranapice() {
    }

    public Reshranapice(Integer idhranapice) {
        this.idhranapice = idhranapice;
    }

    public Integer getIdhranapice() {
        return idhranapice;
    }

    public void setIdhranapice(Integer idhranapice) {
        this.idhranapice = idhranapice;
    }

    public String getNazivhranapice() {
        return nazivhranapice;
    }

    public void setNazivhranapice(String nazivhranapice) {
        this.nazivhranapice = nazivhranapice;
    }

    public String getTiphranapice() {
        return tiphranapice;
    }

    public void setTiphranapice(String tiphranapice) {
        this.tiphranapice = tiphranapice;
    }

    public String getOpishranapice() {
        return opishranapice;
    }

    public void setOpishranapice(String opishranapice) {
        this.opishranapice = opishranapice;
    }

    public Integer getPrioritethranapice() {
        return prioritethranapice;
    }

    public void setPrioritethranapice(Integer prioritethranapice) {
        this.prioritethranapice = prioritethranapice;
    }

    public Long getTrosakhranapice() {
        return trosakhranapice;
    }

    public void setTrosakhranapice(Long trosakhranapice) {
        this.trosakhranapice = trosakhranapice;
    }

    public Integer getIsplatljivosthranapice() {
        return isplatljivosthranapice;
    }

    public void setIsplatljivosthranapice(Integer isplatljivosthranapice) {
        this.isplatljivosthranapice = isplatljivosthranapice;
    }

    @XmlTransient
    public List<Relationship5> getRelationship5List() {
        return relationship5List;
    }

    public void setRelationship5List(List<Relationship5> relationship5List) {
        this.relationship5List = relationship5List;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idhranapice != null ? idhranapice.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reshranapice)) {
            return false;
        }
        Reshranapice other = (Reshranapice) object;
        if ((this.idhranapice == null && other.idhranapice != null) || (this.idhranapice != null && !this.idhranapice.equals(other.idhranapice))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nazivhranapice;
    }
    
}
