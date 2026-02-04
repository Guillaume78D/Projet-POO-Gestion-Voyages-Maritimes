/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp.ucaouut.pooapplication.Voyage;

/**
 *
 * @author USER
 */


import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import javax.swing.JOptionPane;

public class VoyageController {
    private VoyageDAO voyageDAO;

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
}
    
}