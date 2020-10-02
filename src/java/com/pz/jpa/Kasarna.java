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


@Entity
@Table(name = "kasarna")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kasarna.findAll", query = "SELECT k FROM Kasarna k")
    , @NamedQuery(name = "Kasarna.findByIdkasarna", query = "SELECT k FROM Kasarna k WHERE k.idkasarna = :idkasarna")})
public class Kasarna implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDKASARNA")
    private Integer idkasarna;
    @Lob
    @Size(max = 65535)
    @Column(name = "NAZIVKASARNA")
    private String nazivkasarna;
    @Lob
    @Size(max = 65535)
    @Column(name = "ULICAKASARNA")
    private String ulicakasarna;
    @Lob
    @Size(max = 65535)
    @Column(name = "KONTAKTKASARNA")
    private String kontaktkasarna;
    @OneToMany(mappedBy = "idkasarna")
    private List<Oficir> oficirList;
    @OneToMany(mappedBy = "idkasarna")
    private List<Podoficir> podoficirList;
    @OneToMany(mappedBy = "idkasarna")
    private List<Kolicina> kolicinaList;
    @OneToMany(mappedBy = "idkasarna")
    private List<Relationship5> relationship5List;
    @OneToMany(mappedBy = "idkasarna")
    private List<Relationship4> relationship4List;
    @OneToMany(mappedBy = "idkasarna")
    private List<Unutran> unutranList;
    @OneToMany(mappedBy = "idkasarna")
    private List<Relationship3> relationship3List;
    @OneToMany(mappedBy = "idkasarna")
    private List<Relationship2> relationship2List;
    @OneToMany(mappedBy = "idkasarna")
    private List<Relationship1> relationship1List;
    @OneToMany(mappedBy = "idkasarna")
    private List<Vojnik> vojnikList;
    @OneToMany(mappedBy = "idkasarna")
    private List<Unutran2> unutran2List;

    public Kasarna() {
    }

    public Kasarna(Integer idkasarna) {
        this.idkasarna = idkasarna;
    }

    public Integer getIdkasarna() {
        return idkasarna;
    }

    public void setIdkasarna(Integer idkasarna) {
        this.idkasarna = idkasarna;
    }

    public String getNazivkasarna() {
        return nazivkasarna;
    }

    public void setNazivkasarna(String nazivkasarna) {
        this.nazivkasarna = nazivkasarna;
    }

    public String getUlicakasarna() {
        return ulicakasarna;
    }

    public void setUlicakasarna(String ulicakasarna) {
        this.ulicakasarna = ulicakasarna;
    }

    public String getKontaktkasarna() {
        return kontaktkasarna;
    }

    public void setKontaktkasarna(String kontaktkasarna) {
        this.kontaktkasarna = kontaktkasarna;
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
    public List<Kolicina> getKolicinaList() {
        return kolicinaList;
    }

    public void setKolicinaList(List<Kolicina> kolicinaList) {
        this.kolicinaList = kolicinaList;
    }

    @XmlTransient
    public List<Relationship5> getRelationship5List() {
        return relationship5List;
    }

    public void setRelationship5List(List<Relationship5> relationship5List) {
        this.relationship5List = relationship5List;
    }

    @XmlTransient
    public List<Relationship4> getRelationship4List() {
        return relationship4List;
    }

    public void setRelationship4List(List<Relationship4> relationship4List) {
        this.relationship4List = relationship4List;
    }

    @XmlTransient
    public List<Unutran> getUnutranList() {
        return unutranList;
    }

    public void setUnutranList(List<Unutran> unutranList) {
        this.unutranList = unutranList;
    }

    @XmlTransient
    public List<Relationship3> getRelationship3List() {
        return relationship3List;
    }

    public void setRelationship3List(List<Relationship3> relationship3List) {
        this.relationship3List = relationship3List;
    }

    @XmlTransient
    public List<Relationship2> getRelationship2List() {
        return relationship2List;
    }

    public void setRelationship2List(List<Relationship2> relationship2List) {
        this.relationship2List = relationship2List;
    }

    @XmlTransient
    public List<Relationship1> getRelationship1List() {
        return relationship1List;
    }

    public void setRelationship1List(List<Relationship1> relationship1List) {
        this.relationship1List = relationship1List;
    }

    @XmlTransient
    public List<Vojnik> getVojnikList() {
        return vojnikList;
    }

    public void setVojnikList(List<Vojnik> vojnikList) {
        this.vojnikList = vojnikList;
    }

    @XmlTransient
    public List<Unutran2> getUnutran2List() {
        return unutran2List;
    }

    public void setUnutran2List(List<Unutran2> unutran2List) {
        this.unutran2List = unutran2List;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idkasarna != null ? idkasarna.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kasarna)) {
            return false;
        }
        Kasarna other = (Kasarna) object;
        if ((this.idkasarna == null && other.idkasarna != null) || (this.idkasarna != null && !this.idkasarna.equals(other.idkasarna))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nazivkasarna;
    }
    
}
