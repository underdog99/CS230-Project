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
@Table(name = "oficir")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Oficir.findAll", query = "SELECT o FROM Oficir o")
    , @NamedQuery(name = "Oficir.findByIdoficira", query = "SELECT o FROM Oficir o WHERE o.idoficira = :idoficira")
    , @NamedQuery(name = "Oficir.findByGodinarodjenjaclana", query = "SELECT o FROM Oficir o WHERE o.godinarodjenjaclana = :godinarodjenjaclana")
    , @NamedQuery(name = "Oficir.findByVisinaclana", query = "SELECT o FROM Oficir o WHERE o.visinaclana = :visinaclana")
    , @NamedQuery(name = "Oficir.findByKilazaclana", query = "SELECT o FROM Oficir o WHERE o.kilazaclana = :kilazaclana")
    , @NamedQuery(name = "Oficir.findByPlataclana", query = "SELECT o FROM Oficir o WHERE o.plataclana = :plataclana")
    , @NamedQuery(name = "Oficir.findByCin", query = "SELECT o FROM Oficir o WHERE o.idcina = :idcina")})
public class Oficir implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDOFICIRA")
    private Integer idoficira;
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
    @Lob
    @Size(max = 65535)
    @Column(name = "POCETAKSLUZBEOFICIRA")
    private String pocetaksluzbeoficira;
    @Lob
    @Size(max = 65535)
    @Column(name = "KRAJSLUZBEOFICIRA")
    private String krajsluzbeoficira;
    @JoinColumn(name = "IDKASARNA", referencedColumnName = "IDKASARNA")
    @ManyToOne
    private Kasarna idkasarna;
    @JoinColumn(name = "IDCINA", referencedColumnName = "IDCINA")
    @ManyToOne
    private Cinovi idcina;
    @JoinColumn(name = "IDJEDINICE", referencedColumnName = "IDJEDINICE")
    @ManyToOne(optional = false)
    private Jedinica idjedinice;

    public Oficir() {
    }

    public Oficir(Integer idoficira) {
        this.idoficira = idoficira;
    }

    public Integer getIdoficira() {
        return idoficira;
    }

    public void setIdoficira(Integer idoficira) {
        this.idoficira = idoficira;
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

    public String getPocetaksluzbeoficira() {
        return pocetaksluzbeoficira;
    }

    public void setPocetaksluzbeoficira(String pocetaksluzbeoficira) {
        this.pocetaksluzbeoficira = pocetaksluzbeoficira;
    }

    public String getKrajsluzbeoficira() {
        return krajsluzbeoficira;
    }

    public void setKrajsluzbeoficira(String krajsluzbeoficira) {
        this.krajsluzbeoficira = krajsluzbeoficira;
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
        hash += (idoficira != null ? idoficira.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Oficir)) {
            return false;
        }
        Oficir other = (Oficir) object;
        if ((this.idoficira == null && other.idoficira != null) || (this.idoficira != null && !this.idoficira.equals(other.idoficira))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pz.jpa.Oficir[ idoficira=" + idoficira + " ]";
    }
    
}
