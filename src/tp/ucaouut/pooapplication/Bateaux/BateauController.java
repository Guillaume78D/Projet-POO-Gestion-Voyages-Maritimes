/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java
 */
package tp.ucaouut.pooapplication.Bateaux;

import tp.ucaouut.pooapplication.View.AjouterBateau;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import tp.ucaouut.pooapplication.View.Menu;
import tp.ucaouut.pooapplication.Voyage.Voyage;

/**
 *
 * @author USER
 */
public class BateauController {

   /* private BateauxDAO bateauxDAO;

    public BateauController(BateauxDAO bateauxDAO) {
        this.bateauxDAO = bateauxDAO;
    }

    //  Récupérer tous les bateaux
    public List<Bateau> getTousLesBateaux() {
        return bateauxDAO.findAll();
    }

    //  Ajouter un bateau
    public String ajouterBateau(String nom, int nbSieges, String classe,double vitesse, String capitaine) {

        if (nom == null || nom.trim().isEmpty()) {
            return "Erreur : le nom du bateau est obligatoire.";
        }

        if (nbSieges <= 0) {
            return "Erreur : le nombre de sièges doit être supérieur à zéro.";
        }

        if (vitesse <= 0) {
            return "Erreur : la vitesse doit être positive.";
        }

        Bateau b = new Bateau();
        b.setNom(nom);
        b.setNbSieges(nbSieges);
        b.setClasse(classe);
        b.setVitesse(vitesse);
        b.setCapitaine(capitaine);

        boolean succes = bateauxDAO.create(b);
        return succes ? "Bateau ajouté avec succès !" : "Erreur lors de l'ajout du bateau.";
    }

    //  Supprimer un bateau
    public void supprimerBateau(int idBateau) {
        try {
            Bateau b = new Bateau();
            b.setIdBateau(idBateau);

            boolean ok = bateauxDAO.delete(b);

            if (ok) {
                JOptionPane.showMessageDialog(null, "Bateau supprimé avec succès !");
            } else {
                JOptionPane.showMessageDialog(null, "Impossible de supprimer le bateau.");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Impossible de supprimer : ce bateau est peut-être lié à un voyage.",
                    "Erreur",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
     public void initComponents(){
       
    }
    

    //  Modifier un bateau
    public boolean modifierBateau(int id, String nom, int nbSieges,
                                  String classe, double vitesse, String capitaine) {

        if (nom == null || nom.trim().isEmpty() || nbSieges <= 0) {
            return false;
        }

        Bateau b = new Bateau();
        b.setIdBateau(id);
        b.setNom(nom);
        b.setNbSieges(nbSieges);
        b.setClasse(classe);
        b.setVitesse(vitesse);
        b.setCapitaine(capitaine);

        return bateauxDAO.update(b);
    }

    //  Mise à jour avec message 
    public void mettreAJourBateau(Bateau b) {
        boolean succes = bateauxDAO.update(b);

        if (succes) {
            JOptionPane.showMessageDialog(null, "Bateau mis à jour avec succès ! ✅");
        } else {
            JOptionPane.showMessageDialog(null,
                    "Aucun bateau trouvé avec cet identifiant.",
                    "Avertissement",
                    JOptionPane.WARNING_MESSAGE);
        }
    }


    //  Bateaux disponibles à une date donnée
    public List<Bateau> getBateauxDisponibles(LocalDateTime date) {
        return bateauxDAO.findDisponibles(date);
    }*/
    private final Bateau model ;
    private final AjouterBateau view; // L'interface de votre capture d'écran
    private final BateauxDAO dao;
    private final Menu menu;
    private final boolean estCreation;
    private final ActionListener onSucess;

    public BateauController(Bateau m, AjouterBateau  v, BateauxDAO d, boolean creation, ActionListener success,Menu menu) {
        this.model = m;
        this.view = v;
        this.dao = d;
        this.estCreation = creation;
        this.onSucess = success;
        this.menu = menu;
        remplirChamps();
        
    }

    private void remplirChamps() {
        if (!estCreation) {
            view.getNombateau().setText(model.getNom());
            view.getNbsieges().setValue(model.getNbSieges());
            view.getVitessechamp().setValue(model.getVitesse());
            view.getCapitainechamp().setText(model.getCapitaine());
            if ("BUSINESS".equals(model.getClasse())) view.getBuscheck().setSelected(true);
            else view.getEcocheck().setSelected(true);
        }
    }

    public void initController() {
        // C'est ici qu'on branche le bouton orange "ENREGISTRER" de votre photo
        view.getBtnenregistrer().addActionListener(e -> enregistrer());
    }

    private void enregistrer() {
        // 1. Mise à jour du modèle avec les données de la vue
        model.setNom(view.getNombateau().getText());
        model.setNbSieges((int) view.getNbsieges().getValue());
        model.setVitesse((double) view.getVitessechamp().getValue());
        model.setCapitaine(view.getCapitainechamp().getText());
        model.setClasse(view.getBuscheck().isSelected() ? "BUSINESS" : "ECONOMIQUE");

        // 2. Persistance via le DAO
        boolean succes;
        if (estCreation) {
            succes = dao.create(model);
            refreshTable();
        } else {
            succes = dao.update(model);
        }

        // 3. Feedback et fermeture
        if (succes) {
            JOptionPane.showMessageDialog(view, "Enregistrement réussi !");
            onSucess.actionPerformed(null); // Notifier le controller parent
        //    view.dispose(); // Fermer la fenêtre
        } else {
            JOptionPane.showMessageDialog(view, "Erreur lors de l'enregistrement", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }
    
      public void refreshTable() {
        
    // 1. On récupère le modèle du tableau depuis la vue
    DefaultTableModel tableModel = (DefaultTableModel) menu.getTableVoyages().getModel();  
    tableModel.setRowCount(0); 
    List<Bateau> liste = dao.findAll(); 

    for (Bateau c : liste) {       
        Object[] ligne = {  c.getIdBateau(),c.getNom(), c.getNbSieges(), c.getClasse(), c.getVitesse(), };
        tableModel.addRow(ligne);
    }
      }
}

