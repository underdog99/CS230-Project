/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pz.jpa;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author i5Killer
 */
@Entity
@Table(name = "unutran")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Unutran.findAll", query = "SELECT u FROM Unutran u")
    , @NamedQuery(name = "Unutran.findByIdunutran", query = "SELECT u FROM Unutran u WHERE u.idunutran = :idunutran")
    , @NamedQuery(name = "Unutran.findByKolicinaunutran", query = "SELECT u FROM Unutran u WHERE u.kolicinaunutran = :kolicinaunutran")
    , @NamedQuery(name = "Unutran.findByTrosakunutran", query = "SELECT u FROM Unutran u WHERE u.trosakunutran = :trosakunutran")
    , @NamedQuery(name = "Unutran.findByPrioritetunutran", query = "SELECT u FROM Unutran u WHERE u.prioritetunutran = :prioritetunutran")
    , @NamedQuery(name = "Unutran.findByIsplatljivostunutran", query = "SELECT u FROM Unutran u WHERE u.isplatljivostunutran = :isplatljivostunutran")
    , @NamedQuery(name = "Unutran.findByKreiranjeunutran", query = "SELECT u FROM Unutran u WHERE u.kreiranjeunutran = :kreiranjeunutran")
    , @NamedQuery(name = "Unutran.findByDatumisporucivanjaunutran", query = "SELECT u FROM Unutran u WHERE u.datumisporucivanjaunutran = :datumisporucivanjaunutran")
    , @NamedQuery(name = "Unutran.findByStatus", query = "SELECT u FROM Unutran u WHERE u.statusunutran = :statusunutran")})
public class Unutran implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDUNUTRAN")
    private Integer idunutran;
    @Lob
    @Size(max = 65535)
    @Column(name = "NAZIVUNUTRAN")
    private String nazivunutran;
    @Lob
    @Size(max = 65535)
    @Column(name = "ODUNUTRA")
    private String odunutra;
    @Lob
    @Size(max = 65535)
    @Column(name = "DOUNUTRA")
    private String dounutra;
    @Lob
    @Size(max = 65535)
    @Column(name = "STAUNUTRAN")
    private String staunutran;
    @Column(name = "KOLICINAUNUTRAN")
    private Integer kolicinaunutran;
    @Column(name = "TROSAKUNUTRAN")
    private Long trosakunutran;
    @Column(name = "PRIORITETUNUTRAN")
    private Integer prioritetunutran;
    @Column(name = "ISPLATLJIVOSTUNUTRAN")
    private Integer isplatljivostunutran;
    @Basic(optional = false)
    @NotNull
    @Column(name = "KREIRANJEUNUTRAN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date kreiranjeunutran;
    @Column(name = "DATUMISPORUCIVANJAUNUTRAN")
    @Temporal(TemporalType.DATE)
    private Date datumisporucivanjaunutran;
    @Lob
    @Size(max = 65535)
    @Column(name = "STATUSUNUTRAN")
    private String statusunutran;
    @JoinColumn(name = "IDKASARNA", referencedColumnName = "IDKASARNA")
    @ManyToOne
    private Kasarna idkasarna;

    public Unutran() {
    }

    public Unutran(Integer idunutran) {
        this.idunutran = idunutran;
    }

    public Unutran(Integer idunutran, Date kreiranjeunutran) {
        this.idunutran = idunutran;
        this.kreiranjeunutran = kreiranjeunutran;
    }

    public Integer getIdunutran() {
        return idunutran;
    }

    public void setIdunutran(Integer idunutran) {
        this.idunutran = idunutran;
    }

    public String getNazivunutran() {
        return nazivunutran;
    }

    public void setNazivunutran(String nazivunutran) {
        this.nazivunutran = nazivunutran;
    }

    public String getOdunutra() {
        return odunutra;
    }

    public void setOdunutra(String odunutra) {
        this.odunutra = odunutra;
    }

    public String getDounutra() {
        return dounutra;
    }

    public void setDounutra(String dounutra) {
        this.dounutra = dounutra;
    }

    public String getStaunutran() {
        return staunutran;
    }

    public void setStaunutran(String staunutran) {
        this.staunutran = staunutran;
    }

    public Integer getKolicinaunutran() {
        return kolicinaunutran;
    }

    public void setKolicinaunutran(Integer kolicinaunutran) {
        this.kolicinaunutran = kolicinaunutran;
    }

    public Long getTrosakunutran() {
        return trosakunutran;
    }

    public void setTrosakunutran(Long trosakunutran) {
        this.trosakunutran = trosakunutran;
    }

    public Integer getPrioritetunutran() {
        return prioritetunutran;
    }

    public void setPrioritetunutran(Integer prioritetunutran) {
        this.prioritetunutran = prioritetunutran;
    }

    public Integer getIsplatljivostunutran() {
        return isplatljivostunutran;
    }

    public void setIsplatljivostunutran(Integer isplatljivostunutran) {
        this.isplatljivostunutran = isplatljivostunutran;
    }

    public Date getKreiranjeunutran() {
        return kreiranjeunutran;
    }

    public void setKreiranjeunutran(Date kreiranjeunutran) {
        this.kreiranjeunutran = kreiranjeunutran;
    }

    public Date getDatumisporucivanjaunutran() {
        return datumisporucivanjaunutran;
    }

    public void setDatumisporucivanjaunutran(Date datumisporucivanjaunutran) {
        this.datumisporucivanjaunutran = datumisporucivanjaunutran;
    }

    public String getStatusunutran() {
        return statusunutran;
    }

    public void setStatusunutran(String statusunutran) {
        this.statusunutran = statusunutran;
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
        hash += (idunutran != null ? idunutran.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Unutran)) {
            return false;
        }
        Unutran other = (Unutran) object;
        if ((this.idunutran == null && other.idunutran != null) || (this.idunutran != null && !this.idunutran.equals(other.idunutran))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pz.jpa.Unutran[ idunutran=" + idunutran + " ]";
    }
    
}
