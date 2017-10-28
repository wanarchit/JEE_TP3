/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


/**
 *
 * @author Paul
 */
@Stateless
public class EtudiantDAO {
    
    @PersistenceContext(unitName = "DemoTP3PU")
    private EntityManager em;
    
    public List<Etudiant> getAll(){
        Query query = em.createNamedQuery("Etudiant.findAll");
        return query.getResultList();
    }
    
    public Etudiant getOneEtudiant(int id){
        Query query = em.createNamedQuery("Etudiant.findById").setParameter("id", id);
        try{
            return (Etudiant) query.getSingleResult();
        } catch (NoResultException e){
            System.err.println("pas d'étudiant avec cet id");
            return null;
        }
    }
    
    public void saveEtudiant(Etudiant etudiant) {
        em.persist(etudiant);
        em.flush();
    }
    
    public void remove(int e){
        em.remove(getOneEtudiant(e));
        em.flush();
    }
    
    public void updateEtu(Etudiant e){
        em.merge(e);
        em.flush();
    }
}
