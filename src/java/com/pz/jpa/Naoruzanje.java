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
@Table(name = "naoruzanje")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Naoruzanje.findAll", query = "SELECT n FROM Naoruzanje n")
    , @NamedQuery(name = "Naoruzanje.findByIdnaoruzanja", query = "SELECT n FROM Naoruzanje n WHERE n.idnaoruzanja = :idnaoruzanja")
    , @NamedQuery(name = "Naoruzanje.findByPrioritetnaoruzanja", query = "SELECT n FROM Naoruzanje n WHERE n.prioritetnaoruzanja = :prioritetnaoruzanja")
    , @NamedQuery(name = "Naoruzanje.findByTrosaknaoruzanja", query = "SELECT n FROM Naoruzanje n WHERE n.trosaknaoruzanja = :trosaknaoruzanja")
    , @NamedQuery(name = "Naoruzanje.findByIsplatljivostnaoruzanja", query = "SELECT n FROM Naoruzanje n WHERE n.isplatljivostnaoruzanja = :isplatljivostnaoruzanja")
    , @NamedQuery(name = "Naoruzanje.findByTip", query = "SELECT n FROM Naoruzanje n WHERE n.tipnaoruzanja = :tipnaoruzanja")}) 
public class Naoruzanje implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDNAORUZANJA")
    private Integer idnaoruzanja;
    @Lob
    @Size(max = 65535)
    @Column(name = "MODELNAORUZANJA")
    private String modelnaoruzanja;
    @Lob
    @Size(max = 65535)
    @Column(name = "MARKANAORUZANJA")
    private String markanaoruzanja;
    @Lob
    @Size(max = 65535)
    @Column(name = "KALIBARNAORUZANJA")
    private String kalibarnaoruzanja;
    @Lob
    @Size(max = 65535)
    @Column(name = "TIPNAORUZANJA")
    private String tipnaoruzanja;
    @Lob
    @Size(max = 65535)
    @Column(name = "OPISNAORUZANJA")
    private String opisnaoruzanja;
    @Column(name = "PRIORITETNAORUZANJA")
    private Integer prioritetnaoruzanja;
    @Column(name = "TROSAKNAORUZANJA")
    private Long trosaknaoruzanja;
    @Column(name = "ISPLATLJIVOSTNAORUZANJA")
    private Integer isplatljivostnaoruzanja;
    @Lob
    @Size(max = 65535)
    @Column(name = "SLIKANAORUZANJA")
    private String slikanaoruzanja;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idnaoruzanja")
    private List<Relationship2> relationship2List;

    public Naoruzanje() {
    }

    public Naoruzanje(Integer idnaoruzanja) {
        this.idnaoruzanja = idnaoruzanja;
    }

    public Integer getIdnaoruzanja() {
        return idnaoruzanja;
    }

    public void setIdnaoruzanja(Integer idnaoruzanja) {
        this.idnaoruzanja = idnaoruzanja;
    }

    public String getModelnaoruzanja() {
        return modelnaoruzanja;
    }

    public void setModelnaoruzanja(String modelnaoruzanja) {
        this.modelnaoruzanja = modelnaoruzanja;
    }

    public String getMarkanaoruzanja() {
        return markanaoruzanja;
    }

    public void setMarkanaoruzanja(String markanaoruzanja) {
        this.markanaoruzanja = markanaoruzanja;
    }

    public String getKalibarnaoruzanja() {
        return kalibarnaoruzanja;
    }

    public void setKalibarnaoruzanja(String kalibarnaoruzanja) {
        this.kalibarnaoruzanja = kalibarnaoruzanja;
    }

    public String getTipnaoruzanja() {
        return tipnaoruzanja;
    }

    public void setTipnaoruzanja(String tipnaoruzanja) {
        this.tipnaoruzanja = tipnaoruzanja;
    }

    public String getOpisnaoruzanja() {
        return opisnaoruzanja;
    }

    public void setOpisnaoruzanja(String opisnaoruzanja) {
        this.opisnaoruzanja = opisnaoruzanja;
    }

    public Integer getPrioritetnaoruzanja() {
        return prioritetnaoruzanja;
    }

    public void setPrioritetnaoruzanja(Integer prioritetnaoruzanja) {
        this.prioritetnaoruzanja = prioritetnaoruzanja;
    }

    public Long getTrosaknaoruzanja() {
        return trosaknaoruzanja;
    }

    public void setTrosaknaoruzanja(Long trosaknaoruzanja) {
        this.trosaknaoruzanja = trosaknaoruzanja;
    }

    public Integer getIsplatljivostnaoruzanja() {
        return isplatljivostnaoruzanja;
    }

    public void setIsplatljivostnaoruzanja(Integer isplatljivostnaoruzanja) {
        this.isplatljivostnaoruzanja = isplatljivostnaoruzanja;
    }

    public String getSlikanaoruzanja() {
        return slikanaoruzanja;
    }

    public void setSlikanaoruzanja(String slikanaoruzanja) {
        this.slikanaoruzanja = slikanaoruzanja;
    }

    @XmlTransient
    public List<Relationship2> getRelationship2List() {
        return relationship2List;
    }

    public void setRelationship2List(List<Relationship2> relationship2List) {
        this.relationship2List = relationship2List;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idnaoruzanja != null ? idnaoruzanja.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Naoruzanje)) {
            return false;
        }
        Naoruzanje other = (Naoruzanje) object;
        if ((this.idnaoruzanja == null && other.idnaoruzanja != null) || (this.idnaoruzanja != null && !this.idnaoruzanja.equals(other.idnaoruzanja))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idnaoruzanja.toString();
    }
    
}
