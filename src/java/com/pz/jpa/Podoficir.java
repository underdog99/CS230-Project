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
@Table(name = "podoficir")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Podoficir.findAll", query = "SELECT p FROM Podoficir p")
    , @NamedQuery(name = "Podoficir.findByIdpodoficir", query = "SELECT p FROM Podoficir p WHERE p.idpodoficir = :idpodoficir")
    , @NamedQuery(name = "Podoficir.findByGodinarodjenjaclana", query = "SELECT p FROM Podoficir p WHERE p.godinarodjenjaclana = :godinarodjenjaclana")
    , @NamedQuery(name = "Podoficir.findByVisinaclana", query = "SELECT p FROM Podoficir p WHERE p.visinaclana = :visinaclana")
    , @NamedQuery(name = "Podoficir.findByKilazaclana", query = "SELECT p FROM Podoficir p WHERE p.kilazaclana = :kilazaclana")
    , @NamedQuery(name = "Podoficir.findByPlataclana", query = "SELECT p FROM Podoficir p WHERE p.plataclana = :plataclana")
    , @NamedQuery(name = "Podoficir.findByPocetaksluzbepodoficira", query = "SELECT p FROM Podoficir p WHERE p.pocetaksluzbepodoficira = :pocetaksluzbepodoficira")
    , @NamedQuery(name = "Podoficir.findByKrajsluzbepodoficira", query = "SELECT p FROM Podoficir p WHERE p.krajsluzbepodoficira = :krajsluzbepodoficira")
    , @NamedQuery(name = "Podoficir.findByCin", query = "SELECT p FROM Podoficir p WHERE p.idcina = :idcina")})
public class Podoficir implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDPODOFICIR")
    private Integer idpodoficir;
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
    @Column(name = "POCETAKSLUZBEPODOFICIRA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pocetaksluzbepodoficira;
    @Column(name = "KRAJSLUZBEPODOFICIRA")
    @Temporal(TemporalType.DATE)
    private Date krajsluzbepodoficira;
    @JoinColumn(name = "IDKASARNA", referencedColumnName = "IDKASARNA")
    @ManyToOne
    private Kasarna idkasarna;
    @JoinColumn(name = "IDCINA", referencedColumnName = "IDCINA")
    @ManyToOne
    private Cinovi idcina;
    @JoinColumn(name = "IDJEDINICE", referencedColumnName = "IDJEDINICE")
    @ManyToOne(optional = false)
    private Jedinica idjedinice;

    public Podoficir() {
    }

    public Podoficir(Integer idpodoficir) {
        this.idpodoficir = idpodoficir;
    }

    public Podoficir(Integer idpodoficir, Date pocetaksluzbepodoficira) {
        this.idpodoficir = idpodoficir;
        this.pocetaksluzbepodoficira = pocetaksluzbepodoficira;
    }

    public Integer getIdpodoficir() {
        return idpodoficir;
    }

    public void setIdpodoficir(Integer idpodoficir) {
        this.idpodoficir = idpodoficir;
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

    public Date getPocetaksluzbepodoficira() {
        return pocetaksluzbepodoficira;
    }

    public void setPocetaksluzbepodoficira(Date pocetaksluzbepodoficira) {
        this.pocetaksluzbepodoficira = pocetaksluzbepodoficira;
    }

    public Date getKrajsluzbepodoficira() {
        return krajsluzbepodoficira;
    }

    public void setKrajsluzbepodoficira(Date krajsluzbepodoficira) {
        this.krajsluzbepodoficira = krajsluzbepodoficira;
    }

    public Kasarna getIdkasarna() {
        return idkasarna;
    }

    public void setIdkasarna(Kasarna idkasarna) {
        this.idkasarna = idkasarna;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpodoficir != null ? idpodoficir.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Podoficir)) {
            return false;
        }
        Podoficir other = (Podoficir) object;
        if ((this.idpodoficir == null && other.idpodoficir != null) || (this.idpodoficir != null && !this.idpodoficir.equals(other.idpodoficir))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pz.jpa.Podoficir[ idpodoficir=" + idpodoficir + " ]";
    }
    
}
