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
import javax.persistence.Lob;
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
@Table(name = "saradnici")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Saradnici.findAll", query = "SELECT s FROM Saradnici s")
    , @NamedQuery(name = "Saradnici.findByIdclana", query = "SELECT s FROM Saradnici s WHERE s.idclana = :idclana")
    , @NamedQuery(name = "Saradnici.findByGodinarodjenjaclana", query = "SELECT s FROM Saradnici s WHERE s.godinarodjenjaclana = :godinarodjenjaclana")
    , @NamedQuery(name = "Saradnici.findByVisinaclana", query = "SELECT s FROM Saradnici s WHERE s.visinaclana = :visinaclana")
    , @NamedQuery(name = "Saradnici.findByKilazaclana", query = "SELECT s FROM Saradnici s WHERE s.kilazaclana = :kilazaclana")
    , @NamedQuery(name = "Saradnici.findByPlataclana", query = "SELECT s FROM Saradnici s WHERE s.plataclana = :plataclana")
    , @NamedQuery(name = "Saradnici.findByIdsaradnika", query = "SELECT s FROM Saradnici s WHERE s.idsaradnika = :idsaradnika")})
public class Saradnici implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDCLANA")
    private Integer idclana;
    @Lob
    @Size(max = 65535)
    @Column(name = "IMECLANA")
    private String imeclana;
    @Lob
    @Size(max = 65535)
    @Column(name = "PREZIMECLANA")
    private String prezimeclana;
    @Lob
    @Size(max = 65535)
    @Column(name = "JMBGCLANA")
    private String jmbgclana;
    @Column(name = "GODINARODJENJACLANA")
    @Temporal(TemporalType.DATE)
    private Date godinarodjenjaclana;
    @Lob
    @Size(max = 65535)
    @Column(name = "MESTORODJENJACLANA")
    private String mestorodjenjaclana;
    @Lob
    @Size(max = 65535)
    @Column(name = "KONTAKTCLANA")
    private String kontaktclana;
    @Column(name = "VISINACLANA")
    private Integer visinaclana;
    @Column(name = "KILAZACLANA")
    private Integer kilazaclana;
    @Lob
    @Size(max = 65535)
    @Column(name = "BOJAOCIUCLANA")
    private String bojaociuclana;
    @Lob
    @Size(max = 65535)
    @Column(name = "FOTOCLANA")
    private String fotoclana;
    @Lob
    @Size(max = 65535)
    @Column(name = "OTISAKPRSTACLANA")
    private String otisakprstaclana;
    @Lob
    @Size(max = 65535)
    @Column(name = "STATUSCLANA")
    private String statusclana;
    @Column(name = "PLATACLANA")
    private Long plataclana;
    @Column(name = "IDSARADNIKA")
    private Integer idsaradnika;
    @Lob
    @Size(max = 65535)
    @Column(name = "OBLAST")
    private String oblast;

    public Saradnici() {
    }

    public Saradnici(Integer idclana) {
        this.idclana = idclana;
    }

    public Integer getIdclana() {
        return idclana;
    }

    public void setIdclana(Integer idclana) {
        this.idclana = idclana;
    }

    public String getImeclana() {
        return imeclana;
    }

    public void setImeclana(String imeclana) {
        this.imeclana = imeclana;
    }

    public String getPrezimeclana() {
        return prezimeclana;
    }

    public void setPrezimeclana(String prezimeclana) {
        this.prezimeclana = prezimeclana;
    }

    public String getJmbgclana() {
        return jmbgclana;
    }

    public void setJmbgclana(String jmbgclana) {
        this.jmbgclana = jmbgclana;
    }

    public Date getGodinarodjenjaclana() {
        return godinarodjenjaclana;
    }

    public void setGodinarodjenjaclana(Date godinarodjenjaclana) {
        this.godinarodjenjaclana = godinarodjenjaclana;
    }

    public String getMestorodjenjaclana() {
        return mestorodjenjaclana;
    }

    public void setMestorodjenjaclana(String mestorodjenjaclana) {
        this.mestorodjenjaclana = mestorodjenjaclana;
    }

    public String getKontaktclana() {
        return kontaktclana;
    }

    public void setKontaktclana(String kontaktclana) {
        this.kontaktclana = kontaktclana;
    }

    public Integer getVisinaclana() {
        return visinaclana;
    }

    public void setVisinaclana(Integer visinaclana) {
        this.visinaclana = visinaclana;
    }

    public Integer getKilazaclana() {
        return kilazaclana;
    }

    public void setKilazaclana(Integer kilazaclana) {
        this.kilazaclana = kilazaclana;
    }

    public String getBojaociuclana() {
        return bojaociuclana;
    }

    public void setBojaociuclana(String bojaociuclana) {
        this.bojaociuclana = bojaociuclana;
    }

    public String getFotoclana() {
        return fotoclana;
    }

    public void setFotoclana(String fotoclana) {
        this.fotoclana = fotoclana;
    }

    public String getOtisakprstaclana() {
        return otisakprstaclana;
    }

    public void setOtisakprstaclana(String otisakprstaclana) {
        this.otisakprstaclana = otisakprstaclana;
    }

    public String getStatusclana() {
        return statusclana;
    }

    public void setStatusclana(String statusclana) {
        this.statusclana = statusclana;
    }

    public Long getPlataclana() {
        return plataclana;
    }

    public void setPlataclana(Long plataclana) {
        this.plataclana = plataclana;
    }

    public Integer getIdsaradnika() {
        return idsaradnika;
    }

    public void setIdsaradnika(Integer idsaradnika) {
        this.idsaradnika = idsaradnika;
    }

    public String getOblast() {
        return oblast;
    }

    public void setOblast(String oblast) {
        this.oblast = oblast;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idclana != null ? idclana.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Saradnici)) {
            return false;
        }
        Saradnici other = (Saradnici) object;
        if ((this.idclana == null && other.idclana != null) || (this.idclana != null && !this.idclana.equals(other.idclana))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pz.jpa.Saradnici[ idclana=" + idclana + " ]";
    }
    
}
