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
@Table(name = "kopnenovozilo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kopnenovozilo.findAll", query = "SELECT k FROM Kopnenovozilo k")
    , @NamedQuery(name = "Kopnenovozilo.findByIdkopnenovozilo", query = "SELECT k FROM Kopnenovozilo k WHERE k.idkopnenovozilo = :idkopnenovozilo")
    , @NamedQuery(name = "Kopnenovozilo.findByTrosakservisa", query = "SELECT k FROM Kopnenovozilo k WHERE k.trosakservisa = :trosakservisa")
    , @NamedQuery(name = "Kopnenovozilo.findByPrioritetvozila", query = "SELECT k FROM Kopnenovozilo k WHERE k.prioritetvozila = :prioritetvozila")
    , @NamedQuery(name = "Kopnenovozilo.findByTrosakgoriva", query = "SELECT k FROM Kopnenovozilo k WHERE k.trosakgoriva = :trosakgoriva")
    , @NamedQuery(name = "Kopnenovozilo.findByIsplatljivostvozila", query = "SELECT k FROM Kopnenovozilo k WHERE k.isplatljivostvozila = :isplatljivostvozila")
    , @NamedQuery(name = "Kopnenovozilo.findByKskopnenogvozila", query = "SELECT k FROM Kopnenovozilo k WHERE k.kskopnenogvozila = :kskopnenogvozila")
    , @NamedQuery(name = "Kopnenovozilo.findByCckopnenogvozila", query = "SELECT k FROM Kopnenovozilo k WHERE k.cckopnenogvozila = :cckopnenogvozila")})
public class Kopnenovozilo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDKOPNENOVOZILO")
    private Integer idkopnenovozilo;
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
    @Lob
    @Size(max = 65535)
    @Column(name = "TIPVOZILA")
    private String tipvozila;
    @Lob
    @Size(max = 65535)
    @Column(name = "TIPMOTORA")
    private String tipmotora;
    @Column(name = "KSKOPNENOGVOZILA")
    private Integer kskopnenogvozila;
    @Column(name = "CCKOPNENOGVOZILA")
    private Integer cckopnenogvozila;
    @Lob
    @Size(max = 65535)
    @Column(name = "REGBRVOZILA")
    private String regbrvozila;

    public Kopnenovozilo() {
    }

    public Kopnenovozilo(Integer idkopnenovozilo) {
        this.idkopnenovozilo = idkopnenovozilo;
    }

    public Integer getIdkopnenovozilo() {
        return idkopnenovozilo;
    }

    public void setIdkopnenovozilo(Integer idkopnenovozilo) {
        this.idkopnenovozilo = idkopnenovozilo;
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

    public String getTipvozila() {
        return tipvozila;
    }

    public void setTipvozila(String tipvozila) {
        this.tipvozila = tipvozila;
    }

    public String getTipmotora() {
        return tipmotora;
    }

    public void setTipmotora(String tipmotora) {
        this.tipmotora = tipmotora;
    }

    public Integer getKskopnenogvozila() {
        return kskopnenogvozila;
    }

    public void setKskopnenogvozila(Integer kskopnenogvozila) {
        this.kskopnenogvozila = kskopnenogvozila;
    }

    public Integer getCckopnenogvozila() {
        return cckopnenogvozila;
    }

    public void setCckopnenogvozila(Integer cckopnenogvozila) {
        this.cckopnenogvozila = cckopnenogvozila;
    }

    public String getRegbrvozila() {
        return regbrvozila;
    }

    public void setRegbrvozila(String regbrvozila) {
        this.regbrvozila = regbrvozila;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idkopnenovozilo != null ? idkopnenovozilo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kopnenovozilo)) {
            return false;
        }
        Kopnenovozilo other = (Kopnenovozilo) object;
        if ((this.idkopnenovozilo == null && other.idkopnenovozilo != null) || (this.idkopnenovozilo != null && !this.idkopnenovozilo.equals(other.idkopnenovozilo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pz.jpa.Kopnenovozilo[ idkopnenovozilo=" + idkopnenovozilo + " ]";
    }
    
}
