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
@Table(name = "korisnik")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Korisnik.findAll", query = "SELECT k FROM Korisnik k")
    , @NamedQuery(name = "Korisnik.findByIdkorisnik", query = "SELECT k FROM Korisnik k WHERE k.idkorisnik = :idkorisnik")
    , @NamedQuery(name = "Korisnik.findByUsername", query = "SELECT k FROM Korisnik k WHERE k.username = :username")})
public class Korisnik implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDKORISNIK")
    private Integer idkorisnik;
    @Lob
    @Size(max = 65535)
    @Column(name = "IMEKORISNIK")
    private String imekorisnik;
    @Lob
    @Size(max = 65535)
    @Column(name = "PREZIMEKORISNIK")
    private String prezimekorisnik;
    @Lob
    @Size(max = 65535)
    @Column(name = "USERNAME")
    private String username;
    @Lob
    @Size(max = 65535)
    @Column(name = "PASS")
    private String pass;
    @Lob
    @Size(max = 65535)
    @Column(name = "DOZVOLAKORISNIK")
    private String dozvolakorisnik;

    public Korisnik() {
    }

    public Korisnik(Integer idkorisnik) {
        this.idkorisnik = idkorisnik;
    }

    public Integer getIdkorisnik() {
        return idkorisnik;
    }

    public void setIdkorisnik(Integer idkorisnik) {
        this.idkorisnik = idkorisnik;
    }

    public String getImekorisnik() {
        return imekorisnik;
    }

    public void setImekorisnik(String imekorisnik) {
        this.imekorisnik = imekorisnik;
    }

    public String getPrezimekorisnik() {
        return prezimekorisnik;
    }

    public void setPrezimekorisnik(String prezimekorisnik) {
        this.prezimekorisnik = prezimekorisnik;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getDozvolakorisnik() {
        return dozvolakorisnik;
    }

    public void setDozvolakorisnik(String dozvolakorisnik) {
        this.dozvolakorisnik = dozvolakorisnik;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idkorisnik != null ? idkorisnik.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Korisnik)) {
            return false;
        }
        Korisnik other = (Korisnik) object;
        if ((this.idkorisnik == null && other.idkorisnik != null) || (this.idkorisnik != null && !this.idkorisnik.equals(other.idkorisnik))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pz.jpa.Korisnik[ idkorisnik=" + idkorisnik + " ]";
    }
    
}
