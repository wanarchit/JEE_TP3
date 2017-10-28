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
public class PromotionDAO {

    @PersistenceContext(unitName = "DemoTP3PU")
    private EntityManager em;
    
    public List<Promotions> getAll(){
        Query query = em.createNamedQuery("Promotions.findAll");
        return query.getResultList();
    }
    
    public Promotions getOnePromotion(int id){
        Query query = em.createNamedQuery("Promotions.findById").setParameter("id", id);
        try{
            return (Promotions) query.getSingleResult();
        } catch (NoResultException e){
            System.err.println("pas de promotion avec cet id");
            return null;
        }
    }
    
    public void savePromotion(Promotions promo) {
        em.persist(promo);
        em.flush();
    }
    
    public void remove(int p){
        em.remove(getOnePromotion(p));
        em.flush();
    }
    
    public void updatePromo(Promotions p){
        em.merge(p);
        em.flush();
    }
}
