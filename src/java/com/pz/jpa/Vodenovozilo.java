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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author i5Killer
 */
@Entity
@Table(name = "vodenovozilo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vodenovozilo.findAll", query = "SELECT v FROM Vodenovozilo v")
    , @NamedQuery(name = "Vodenovozilo.findByIdvodenogvozila", query = "SELECT v FROM Vodenovozilo v WHERE v.idvodenogvozila = :idvodenogvozila")
    , @NamedQuery(name = "Vodenovozilo.findByTrosakservisa", query = "SELECT v FROM Vodenovozilo v WHERE v.trosakservisa = :trosakservisa")
    , @NamedQuery(name = "Vodenovozilo.findByPrioritetvozila", query = "SELECT v FROM Vodenovozilo v WHERE v.prioritetvozila = :prioritetvozila")
    , @NamedQuery(name = "Vodenovozilo.findByTrosakgoriva", query = "SELECT v FROM Vodenovozilo v WHERE v.trosakgoriva = :trosakgoriva")
    , @NamedQuery(name = "Vodenovozilo.findByIsplatljivostvozila", query = "SELECT v FROM Vodenovozilo v WHERE v.isplatljivostvozila = :isplatljivostvozila")
    , @NamedQuery(name = "Vodenovozilo.findByBrmotoravodvozila", query = "SELECT v FROM Vodenovozilo v WHERE v.brmotoravodvozila = :brmotoravodvozila")
    , @NamedQuery(name = "Vodenovozilo.findBySnagamotoravodvozila", query = "SELECT v FROM Vodenovozilo v WHERE v.snagamotoravodvozila = :snagamotoravodvozila")
    , @NamedQuery(name = "Vodenovozilo.findByKapacitetvodvozila", query = "SELECT v FROM Vodenovozilo v WHERE v.kapacitetvodvozila = :kapacitetvodvozila")})
public class Vodenovozilo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDVODENOGVOZILA")
    private Integer idvodenogvozila;
    @Lob
    @Size(max = 65535)
    @Column(name = "MARKAVOZILA")
    private String markavozila;
    @Lob
    @Size(max = 65535)
    @Column(name = "MODELVOZILO")
    private String modelvozilo;
    @Lob
    @Size(max = 65535)
    @Column(name = "SLIKAVOZILO")
    private String slikavozilo;
    @Column(name = "TROSAKSERVISA")
    private Long trosakservisa;
    @Column(name = "PRIORITETVOZILA")
    private Integer prioritetvozila;
    @Lob
    @Size(max = 65535)
    @Column(name = "OPISVOZILA")
    private String opisvozila;
    @Column(name = "TROSAKGORIVA")
    private Long trosakgoriva;
    @Column(name = "ISPLATLJIVOSTVOZILA")
    private Integer isplatljivostvozila;
    @Column(name = "BRMOTORAVODVOZILA")
    private Integer brmotoravodvozila;
    @Lob
    @Size(max = 65535)
    @Column(name = "TIPMOTORAVODVOZILA")
    private String tipmotoravodvozila;
    @Column(name = "SNAGAMOTORAVODVOZILA")
    private Integer snagamotoravodvozila;
    @Column(name = "KAPACITETVODVOZILA")
    private Integer kapacitetvodvozila;
    @Lob
    @Size(max = 65535)
    @Column(name = "TIPVODVOZILA")
    private String tipvodvozila;

    public Vodenovozilo() {
    }

    public Vodenovozilo(Integer idvodenogvozila) {
        this.idvodenogvozila = idvodenogvozila;
    }

    public Integer getIdvodenogvozila() {
        return idvodenogvozila;
    }

    public void setIdvodenogvozila(Integer idvodenogvozila) {
        this.idvodenogvozila = idvodenogvozila;
    }

    public String getMarkavozila() {
        return markavozila;
    }

    public void setMarkavozila(String markavozila) {
        this.markavozila = markavozila;
    }

    public String getModelvozilo() {
        return modelvozilo;
    }

    public void setModelvozilo(String modelvozilo) {
        this.modelvozilo = modelvozilo;
    }

    public String getSlikavozilo() {
        return slikavozilo;
    }

    public void setSlikavozilo(String slikavozilo) {
        this.slikavozilo = slikavozilo;
    }

    public Long getTrosakservisa() {
        return trosakservisa;
    }

    public void setTrosakservisa(Long trosakservisa) {
        this.trosakservisa = trosakservisa;
    }

    public Integer getPrioritetvozila() {
        return prioritetvozila;
    }

    public void setPrioritetvozila(Integer prioritetvozila) {
        this.prioritetvozila = prioritetvozila;
    }

    public String getOpisvozila() {
        return opisvozila;
    }

    public void setOpisvozila(String opisvozila) {
        this.opisvozila = opisvozila;
    }

    public Long getTrosakgoriva() {
        return trosakgoriva;
    }

    public void setTrosakgoriva(Long trosakgoriva) {
        this.trosakgoriva = trosakgoriva;
    }

    public Integer getIsplatljivostvozila() {
        return isplatljivostvozila;
    }

    public void setIsplatljivostvozila(Integer isplatljivostvozila) {
        this.isplatljivostvozila = isplatljivostvozila;
    }

    public Integer getBrmotoravodvozila() {
        return brmotoravodvozila;
    }

    public void setBrmotoravodvozila(Integer brmotoravodvozila) {
        this.brmotoravodvozila = brmotoravodvozila;
    }

    public String getTipmotoravodvozila() {
        return tipmotoravodvozila;
    }

    public void setTipmotoravodvozila(String tipmotoravodvozila) {
        this.tipmotoravodvozila = tipmotoravodvozila;
    }

    public Integer getSnagamotoravodvozila() {
        return snagamotoravodvozila;
    }

    public void setSnagamotoravodvozila(Integer snagamotoravodvozila) {
        this.snagamotoravodvozila = snagamotoravodvozila;
    }

    public Integer getKapacitetvodvozila() {
        return kapacitetvodvozila;
    }

    public void setKapacitetvodvozila(Integer kapacitetvodvozila) {
        this.kapacitetvodvozila = kapacitetvodvozila;
    }

    public String getTipvodvozila() {
        return tipvodvozila;
    }

    public void setTipvodvozila(String tipvodvozila) {
        this.tipvodvozila = tipvodvozila;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idvodenogvozila != null ? idvodenogvozila.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vodenovozilo)) {
            return false;
        }
        Vodenovozilo other = (Vodenovozilo) object;
        if ((this.idvodenogvozila == null && other.idvodenogvozila != null) || (this.idvodenogvozila != null && !this.idvodenogvozila.equals(other.idvodenogvozila))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pz.jpa.Vodenovozilo[ idvodenogvozila=" + idvodenogvozila + " ]";
    }
    
}
