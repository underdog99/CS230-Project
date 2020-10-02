/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pz.jpa;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author i5Killer
 */
@Entity
@Table(name = "vazdusnovozilo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vazdusnovozilo.findAll", query = "SELECT v FROM Vazdusnovozilo v")
    , @NamedQuery(name = "Vazdusnovozilo.findByIdvozilo", query = "SELECT v FROM Vazdusnovozilo v WHERE v.vazdusnovoziloPK.idvozilo = :idvozilo")
    , @NamedQuery(name = "Vazdusnovozilo.findByIdvazvozila", query = "SELECT v FROM Vazdusnovozilo v WHERE v.vazdusnovoziloPK.idvazvozila = :idvazvozila")
    , @NamedQuery(name = "Vazdusnovozilo.findByTrosakservisa", query = "SELECT v FROM Vazdusnovozilo v WHERE v.trosakservisa = :trosakservisa")
    , @NamedQuery(name = "Vazdusnovozilo.findByPrioritetvozila", query = "SELECT v FROM Vazdusnovozilo v WHERE v.prioritetvozila = :prioritetvozila")
    , @NamedQuery(name = "Vazdusnovozilo.findByTrosakgoriva", query = "SELECT v FROM Vazdusnovozilo v WHERE v.trosakgoriva = :trosakgoriva")
    , @NamedQuery(name = "Vazdusnovozilo.findByIsplatljivostvozila", query = "SELECT v FROM Vazdusnovozilo v WHERE v.isplatljivostvozila = :isplatljivostvozila")
    , @NamedQuery(name = "Vazdusnovozilo.findByBrmotoravazvozila", query = "SELECT v FROM Vazdusnovozilo v WHERE v.brmotoravazvozila = :brmotoravazvozila")
    , @NamedQuery(name = "Vazdusnovozilo.findBySnagamotora", query = "SELECT v FROM Vazdusnovozilo v WHERE v.snagamotora = :snagamotora")
    , @NamedQuery(name = "Vazdusnovozilo.findByKapacitetvazvozila", query = "SELECT v FROM Vazdusnovozilo v WHERE v.kapacitetvazvozila = :kapacitetvazvozila")})
public class Vazdusnovozilo implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected VazdusnovoziloPK vazdusnovoziloPK;
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
    @Column(name = "BRMOTORAVAZVOZILA")
    private Integer brmotoravazvozila;
    @Column(name = "SNAGAMOTORA")
    private Integer snagamotora;
    @Lob
    @Size(max = 65535)
    @Column(name = "MODELMOTORA")
    private String modelmotora;
    @Column(name = "KAPACITETVAZVOZILA")
    private Integer kapacitetvazvozila;
    @Lob
    @Size(max = 65535)
    @Column(name = "TIPVAZVOZILA")
    private String tipvazvozila;

    public Vazdusnovozilo() {
    }

    public Vazdusnovozilo(VazdusnovoziloPK vazdusnovoziloPK) {
        this.vazdusnovoziloPK = vazdusnovoziloPK;
    }

    public Vazdusnovozilo(int idvozilo, int idvazvozila) {
        this.vazdusnovoziloPK = new VazdusnovoziloPK(idvozilo, idvazvozila);
    }

    public VazdusnovoziloPK getVazdusnovoziloPK() {
        return vazdusnovoziloPK;
    }

    public void setVazdusnovoziloPK(VazdusnovoziloPK vazdusnovoziloPK) {
        this.vazdusnovoziloPK = vazdusnovoziloPK;
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

    public Integer getBrmotoravazvozila() {
        return brmotoravazvozila;
    }

    public void setBrmotoravazvozila(Integer brmotoravazvozila) {
        this.brmotoravazvozila = brmotoravazvozila;
    }

    public Integer getSnagamotora() {
        return snagamotora;
    }

    public void setSnagamotora(Integer snagamotora) {
        this.snagamotora = snagamotora;
    }

    public String getModelmotora() {
        return modelmotora;
    }

    public void setModelmotora(String modelmotora) {
        this.modelmotora = modelmotora;
    }

    public Integer getKapacitetvazvozila() {
        return kapacitetvazvozila;
    }

    public void setKapacitetvazvozila(Integer kapacitetvazvozila) {
        this.kapacitetvazvozila = kapacitetvazvozila;
    }

    public String getTipvazvozila() {
        return tipvazvozila;
    }

    public void setTipvazvozila(String tipvazvozila) {
        this.tipvazvozila = tipvazvozila;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vazdusnovoziloPK != null ? vazdusnovoziloPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vazdusnovozilo)) {
            return false;
        }
        Vazdusnovozilo other = (Vazdusnovozilo) object;
        if ((this.vazdusnovoziloPK == null && other.vazdusnovoziloPK != null) || (this.vazdusnovoziloPK != null && !this.vazdusnovoziloPK.equals(other.vazdusnovoziloPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pz.jpa.Vazdusnovozilo[ vazdusnovoziloPK=" + vazdusnovoziloPK + " ]";
    }
    
}
