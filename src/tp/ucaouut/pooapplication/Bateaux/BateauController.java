/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java
 */
package tp.ucaouut.pooapplication.Bateaux;

import java.time.LocalDateTime;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class BateauController {

    private BateauxDAO bateauxDAO;

    public BateauController(BateauxDAO bateauxDAO) {
        this.bateauxDAO = bateauxDAO;
    }

    // 🔹 Récupérer tous les bateaux
    public List<Bateau> getTousLesBateaux() {
        return bateauxDAO.findAll();
    }

    // 🔹 Ajouter un bateau
    public String ajouterBateau(String nom, int nbSieges, String classe,
                                double vitesse, String capitaine) {

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

    // 🔹 Supprimer un bateau
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

    // 🔹 Modifier un bateau
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

    // 🔹 Mise à jour avec message (comme VoyageController)
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

    // 🔹 Bateaux disponibles à une date donnée
    public List<Bateau> getBateauxDisponibles(LocalDateTime date) {
        return bateauxDAO.findDisponibles(date);
    }
}
