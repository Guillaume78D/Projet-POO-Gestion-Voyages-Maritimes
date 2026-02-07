/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp.ucaouut.pooapplication.Voyage;

/**
 *
 * @author USER
 */

import java.awt.event.ActionListener;
import tp.ucaouut.pooapplication.View.AjouterVoyage;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import tp.ucaouut.pooapplication.View.Menu;
import tp.ucaouut.pooapplication.Voyage.Utilisateur.Utilisateur;

public class VoyageController {
   /* private VoyageDAO voyageDAO;

    public VoyageController(VoyageDAO voyageDAO) {
        this.voyageDAO = voyageDAO;
    }
    
    public List<Voyage> getTousLesVoyages(){
        List<Voyage> voyages = voyageDAO.findAll();
    
        return  voyages;
    }
    public String ajouterVoyage(LocalDateTime depart, LocalDateTime arrivee, String lieuDep, String lieuArr) {
    if (lieuDep == null || lieuDep.trim().isEmpty() || lieuArr == null || lieuArr.trim().isEmpty()) {
        return "Erreur : Les lieux de départ et d'arrivée sont obligatoires.";
    }
    if (arrivee.isBefore(depart)) {
        return "Erreur : La date d'arrivée ne peut pas être avant le départ.";
    }
    Voyage nouveauVoyage = new Voyage();
    nouveauVoyage.setDatedebut(depart);
    nouveauVoyage.setDatefin(arrivee);
    nouveauVoyage.setLieudepart(lieuDep);
    nouveauVoyage.setLieuarrive(lieuArr);
    boolean succes = voyageDAO.create(nouveauVoyage);
   // return voyageDAO.create(nouveauVoyage);
   return succes ? "Voyage ajouté avec succès !" : "Erreur technique lors de l'ajout.";
}
   public void supprimerVoyage(long id) {
    try {
        voyageDAO.delete(id);
        JOptionPane.showMessageDialog(null, "Voyage supprimé !");
    } catch (SQLException e) {
      
        if (e.getErrorCode() == 1451) { 
            JOptionPane.showMessageDialog(null, 
                "Impossible de supprimer : ce voyage est lié à des réservations existantes.", 
                "Erreur de suppression", 
                JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Une erreur imprévue est survenue.");
        }
    }
}
    public boolean modifierVoyage(long id, LocalDateTime debut, LocalDateTime fin, String dep, String arr) {
   
    Voyage v = new Voyage();
    v.setNum_Voyage((int) id);
    v.setDatedebut(debut);
    v.setDatefin(fin);
    v.setLieudepart(dep);
    v.setLieuarrive(arr);
    
    
    return voyageDAO.update(v);
}
    public void mettreAJourVoyage(Voyage v) {
    try {
        // Supposons que nous avons modifié le DAO pour qu'il retourne l'entier
        boolean lignesModifiees = voyageDAO.updated(v); 

        if (lignesModifiees == true) {
            JOptionPane.showMessageDialog(null, "Voyage mis à jour avec succès ! ✅");
        } else {
            JOptionPane.showMessageDialog(null, "Attention : Aucun voyage trouvé avec cet identifiant. 🧐", "Avertissement", JOptionPane.WARNING_MESSAGE);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Erreur lors de la mise à jour : " + e.getMessage(), "Erreur SQL", JOptionPane.ERROR_MESSAGE);
    }
}
    public List<String> getPassagersDuVoyage(int idVoyage) {
    // On délègue la recherche au DAO
    List<String> passagers = voyageDAO.findPassagersParVoyage(idVoyage);
    
    // On pourrait ajouter une vérification ici, 
    // par exemple si la liste est vide, on peut logger l'information
    return passagers;
}*/
    private final Voyage model;
    private final AjouterVoyage view;
    private final VoyageDAO dao;
   private final Menu menu;
    private final boolean estCreation = false;
    private final ActionListener onSuccess = null;

   

    public VoyageController(Voyage m, AjouterVoyage v, VoyageDAO d, Menu menu) {
        this.model = m;
        this.view = v;
        this.dao = d;
        this.menu = menu;
       
       
    }

    public void initController() {
        // Liaison du bouton ENREGISTRER de l'interface
        view.getBtnenregistrer().addActionListener(e -> enregistrer());
        
        // Si vous avez un bouton annuler (non visible mais conseillé)
        if (view.getBtnannuler() != null) {
            view.getBtnannuler().addActionListener(e -> view.dispose());
        }
    }

    private void enregistrer() {
        try {
            // 1. Récupération des données des ComboBox (Lieux)
            model.setLieudepart(view.getDepart().getSelectedItem().toString());
            model.setLieuarrive(view.getArrive().getSelectedItem().toString());

            // 2. Récupération des dates des JSpinners
            // Conversion Date (Spinner) -> LocalDateTime (Java 8+)
            Date dateDep = (Date) view.getDatedep().getValue();
            Date dateArr = (Date) view.getDatear().getValue();
            
            model.setDatedebut(dateDep.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
            model.setDatefin(dateArr.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());

            // 3. Logique Métier simple : Vérification des dates
            if (model.getDatedebut().isBefore(model.getDatefin())) {
                JOptionPane.showMessageDialog(view, "La date d'arrivée ne peut pas être avant le départ.", "Erreur", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // 4. Persistance
            boolean succes = estCreation ? dao.create(model) : dao.update(model);

            if (succes) {
                JOptionPane.showMessageDialog(view, "Voyage enregistré avec succès !");
                if (onSuccess != null) onSuccess.actionPerformed(null);
               refreshTable();
                view.dispose();
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, "Erreur de saisie : " + ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void refreshTable() {
        
    // 1. On récupère le modèle du tableau depuis la vue
    DefaultTableModel tableModel = (DefaultTableModel) menu.getTableVoyages().getModel();  
    tableModel.setRowCount(0); 
    List<Voyage> liste = dao.findAll(); 

    for (Voyage c : liste) {       
        Object[] ligne = {  c.getNum_Voyage(),c.getNum_Voyage(), c.getDatedebut(), c.getDatefin(), c.getLieudepart(),c.getLieudepart() };
        tableModel.addRow(ligne);
    }
}
    
}