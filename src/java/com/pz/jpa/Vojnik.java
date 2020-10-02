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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "vojnik")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vojnik.findAll", query = "SELECT v FROM Vojnik v")
    , @NamedQuery(name = "Vojnik.findByIdvojnika", query = "SELECT v FROM Vojnik v WHERE v.idvojnika = :idvojnika")
    , @NamedQuery(name = "Vojnik.findByGodinarodjenjaclana", query = "SELECT v FROM Vojnik v WHERE v.godinarodjenjaclana = :godinarodjenjaclana")
    , @NamedQuery(name = "Vojnik.findByVisinaclana", query = "SELECT v FROM Vojnik v WHERE v.visinaclana = :visinaclana")
    , @NamedQuery(name = "Vojnik.findByKilazaclana", query = "SELECT v FROM Vojnik v WHERE v.kilazaclana = :kilazaclana")
    , @NamedQuery(name = "Vojnik.findByPlataclana", query = "SELECT v FROM Vojnik v WHERE v.plataclana = :plataclana")
    , @NamedQuery(name = "Vojnik.findByPocetaksluzbe", query = "SELECT v FROM Vojnik v WHERE v.pocetaksluzbe = :pocetaksluzbe")
    , @NamedQuery(name = "Vojnik.findByKrajsluzbe", query = "SELECT v FROM Vojnik v WHERE v.krajsluzbe = :krajsluzbe")
    , @NamedQuery(name = "Vojnik.findByJedinica", query = "SELECT v FROM Vojnik v WHERE v.idjedinice = :idjedinice")
    , @NamedQuery(name = "Vojnik.findByCin", query = "SELECT v FROM Vojnik v WHERE v.idcina = :idcina")})
public class Vojnik implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDVOJNIKA")
    private Integer idvojnika;
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "POCETAKSLUZBE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pocetaksluzbe;
    @Column(name = "KRAJSLUZBE")
    @Temporal(TemporalType.DATE)
    private Date krajsluzbe;
    @JoinColumn(name = "IDCINA", referencedColumnName = "IDCINA")
    @ManyToOne
    private Cinovi idcina;
    @JoinColumn(name = "IDJEDINICE", referencedColumnName = "IDJEDINICE")
    @ManyToOne
    private Jedinica idjedinice;
    @JoinColumn(name = "IDKASARNA", referencedColumnName = "IDKASARNA")
    @ManyToOne
    private Kasarna idkasarna;

    public Vojnik() {
    }

    public Vojnik(Integer idvojnika) {
        this.idvojnika = idvojnika;
    }

    public Vojnik(Integer idvojnika, Date pocetaksluzbe) {
        this.idvojnika = idvojnika;
        this.pocetaksluzbe = pocetaksluzbe;
    }

    public Integer getIdvojnika() {
        return idvojnika;
    }

    public void setIdvojnika(Integer idvojnika) {
        this.idvojnika = idvojnika;
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

    public Date getPocetaksluzbe() {
        return pocetaksluzbe;
    }

    public void setPocetaksluzbe(Date pocetaksluzbe) {
        this.pocetaksluzbe = pocetaksluzbe;
    }

    public Date getKrajsluzbe() {
        return krajsluzbe;
    }

    public void setKrajsluzbe(Date krajsluzbe) {
        this.krajsluzbe = krajsluzbe;
    }

    public Cinovi getIdcina() {
        return idcina;
    }

    public void setIdcina(Cinovi idcina) {
        this.idcina = idcina;
    }

    public Jedinica getIdjedinice() {
        return idjedinice;
    }

    public void setIdjedinice(Jedinica idjedinice) {
        this.idjedinice = idjedinice;
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
        hash += (idvojnika != null ? idvojnika.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vojnik)) {
            return false;
        }
        Vojnik other = (Vojnik) object;
        if ((this.idvojnika == null && other.idvojnika != null) || (this.idvojnika != null && !this.idvojnika.equals(other.idvojnika))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pz.jpa.Vojnik[ idvojnika=" + idvojnika + " ]";
    }
    
}
