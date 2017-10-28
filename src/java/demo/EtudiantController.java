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
@Named(value = "etuCtrl")
@ViewScoped
public class EtudiantController implements Serializable{
    
    @EJB
    private EtudiantDAO dao;
    private Etudiant selectedEtu;
    
    
    /**
     * Creates a new instance of EtudiantController
     */
    public EtudiantController() {
    }

    public List<Etudiant> getEtudiants() {
        return dao.getAll();
    }
    
    public void addEtu(Etudiant etu){
        dao.saveEtudiant(etu);
    }
    
    public void removeEtu(int i){
        dao.remove(i);
    }
    
    public Etudiant getSelectedEtu() {
        return selectedEtu;
    }

    public void setSelectedEtu(Etudiant selectedEtu) {
        this.selectedEtu = selectedEtu;
    }
    
    public void updateEtu(Etudiant etu){
        dao.updateEtu(etu);
    }
    
    
    
}
