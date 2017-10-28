/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Paul
 */
@Entity
@Table(name = "promotions")
@NamedQueries({
    @NamedQuery(name = "Promotions.findAll", query = "SELECT p FROM Promotions p")
    , @NamedQuery(name = "Promotions.findById", query = "SELECT p FROM Promotions p WHERE p.id = :id")
    , @NamedQuery(name = "Promotions.findByNom", query = "SELECT p FROM Promotions p WHERE p.nom = :nom")
    , @NamedQuery(name = "Promotions.findByAnnee", query = "SELECT p FROM Promotions p WHERE p.annee = :annee")})
public class Promotions implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "promo")
    private Collection<Etudiant> etudiantCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nom;
    private int annee;

    public Promotions() {
    }

    public Promotions(Integer id) {
        this.id = id;
    }

    public Promotions(Integer id, String nom, int annee) {
        this.id = id;
        this.nom = nom;
        this.annee = annee;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Promotions)) {
            return false;
        }
        Promotions other = (Promotions) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "demo.Promotions[ id=" + id + " ]";
    }

    public Collection<Etudiant> getEtudiantCollection() {
        return etudiantCollection;
    }

    public void setEtudiantCollection(Collection<Etudiant> etudiantCollection) {
        this.etudiantCollection = etudiantCollection;
    }
    
}
