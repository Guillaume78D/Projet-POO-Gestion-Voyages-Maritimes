/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp.ucaouut.pooapplication.View2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import tp.ucaouut.pooapplication.View2.Addvoyage;
import tp.ucaouut.pooapplication.Voyage.Voyage;
import tp.ucaouut.pooapplication.Voyage.VoyageController;
import tp.ucaouut.pooapplication.Voyage.VoyageDAO;

public class EnregistrerVoyageController {
   private final  Voyage model;
   private final Addvoyage view;
   private final VoyageDAO dao;
   private final boolean isCreateForm;
   private final ActionListener onSucess;
   
   public EnregistrerVoyageController(  Voyage m, Addvoyage v, VoyageDAO d, boolean isCreateForm, ActionListener onSucess){
       this.model = m;
       this.view = v;
       this.dao = d;
       this.isCreateForm = isCreateForm;
       this.onSucess = onSucess;
       initView();
   }
   
   public void initView(){
       view.getDatedep().setValue(model.getDatedebut());
       view.getDatear().setValue(model.getDatefin());
       view.getArrive().setSelectedItem(model.getLieuarrive());
       view.getDepart().setSelectedItem(model.getLieudepart());
   }
   
   public void initController(){
       view.getBtnvoyage().addActionListener(e -> enregistrer());
   }
   
   private void enregistrer() {
       model.setDatedebut((LocalDateTime) view.getDatedep().getValue());
       model.setDatefin((LocalDateTime) view.getDatear().getValue());
       model.setLieudepart((String) view.getDepart().getSelectedItem());
       model.setLieuarrive((String) view.getArrive().getSelectedItem());
       try {
           // Contrôle de validation
           validationControl(model);
           // Enregistrement
           if(isCreateForm) {
               // Création
               model.setNum_Voyage(dao.create(model));
               JOptionPane.showMessageDialog(null, "Enregistrement du bateau " + " effectué avec succès",  "Enregistrement",JOptionPane.INFORMATION_MESSAGE);
           } else {
               // Modification
               dao.update(model);
               JOptionPane.showMessageDialog(null, "Modification du bateau " +  " effectué avec succès",  "Enregistrement",JOptionPane.INFORMATION_MESSAGE);
           }
           view.setVisible(false);
           if(Objects.nonNull(onSucess)) {
               onSucess.actionPerformed(new ActionEvent(this, 0, null));
           }
       } catch(RuntimeException ex) {
           JOptionPane.showMessageDialog(null, ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
       }
   }
   
   private void validationControl(Voyage model) {
     /*  if(Objects.isNull(model.getDatedebut()) || model.getDatefin().isBlank()) {
           throw new RuntimeException("Le nom est obligatoire...");
       }*/
       if(Objects.isNull(model.getLieuarrive()) || model.getLieudepart().isBlank()) {
           throw new RuntimeException("La numérotation du siège est obligatoire...");
       }
      
   }

    public Voyage getModel() {
        return model;
    }
    
}

