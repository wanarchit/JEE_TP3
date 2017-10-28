/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Paul
 */
@Named(value = "promotionController")
@ViewScoped
public class PromotionController implements Serializable{

    @EJB
    private PromotionDAO dao;
    private Promotions selectedPromo;
    
    /**
     * Creates a new instance of PromotionController
     */
    public PromotionController() {
    }

    public List<Promotions> getPromotions() {
        return dao.getAll();
    }
    
    public void addPromo(Promotions promo){
        dao.savePromotion(promo);
    }
    
    public void removePromo(int i){
        dao.remove(i);
    }
    
    public Promotions getSelectedPromo() {
        return selectedPromo;
    }

    public void setSelectedEtu(Promotions selectedPromo) {
        this.selectedPromo = selectedPromo;
    }
    
    public void updateEtu(Promotions promo){
        dao.updatePromo(promo);
    }
}
