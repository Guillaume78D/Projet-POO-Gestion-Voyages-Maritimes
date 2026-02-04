/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java
 */
package tp.ucaouut.pooapplication.Voyage.Utilisateur;

import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class UtilisateurController {

    private UtilisateurDAO utilisateurDAO;

    public UtilisateurController(UtilisateurDAO utilisateurDAO) {
        this.utilisateurDAO = utilisateurDAO;
    }

    // 🔹 Ajouter un utilisateur
    public String ajouterUtilisateur(String nom, String prenom, String mail, String password) {

        if (nom == null || nom.trim().isEmpty()
                || prenom == null || prenom.trim().isEmpty()
                || mail == null || mail.trim().isEmpty()
                || password == null || password.trim().isEmpty()) {

            return "Erreur : Tous les champs sont obligatoires.";
        }

        Utilisateur u = new Utilisateur();
        u.setNom(nom);
        u.setPrenom(prenom);
        u.setMail(mail);
        u.setPassword(password);

        boolean succes = utilisateurDAO.create(u);
        return succes ? "Utilisateur ajouté avec succès !" : "Erreur lors de l'ajout de l'utilisateur.";
    }

    // 🔹 Supprimer un utilisateur
    public void supprimerUtilisateur(int id) {
        try {
            Utilisateur u = new Utilisateur();
            u.setId(id);

            boolean ok = utilisateurDAO.delete(u);

            if (ok) {
                JOptionPane.showMessageDialog(null, "Utilisateur supprimé avec succès !");
            } else {
                JOptionPane.showMessageDialog(null, "Impossible de supprimer l'utilisateur.");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Erreur lors de la suppression de l'utilisateur.",
                    "Erreur",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    // 🔹 Modifier un utilisateur
    public boolean modifierUtilisateur(int id, String nom, String prenom,
                                        String mail, String password) {

        if (nom == null || nom.trim().isEmpty()
                || prenom == null || prenom.trim().isEmpty()
                || mail == null || mail.trim().isEmpty()) {
            return false;
        }

        Utilisateur u = new Utilisateur();
        u.setId(id);
        u.setNom(nom);
        u.setPrenom(prenom);
        u.setMail(mail);
        u.setPassword(password);

        return utilisateurDAO.update(u);
    }

    // 🔹 Mise à jour avec message (même style que les autres controllers)
    public void mettreAJourUtilisateur(Utilisateur u) {
        boolean succes = utilisateurDAO.update(u);

        if (succes) {
            JOptionPane.showMessageDialog(null, "Utilisateur mis à jour avec succès ✅");
        } else {
            JOptionPane.showMessageDialog(null,
                    "Aucun utilisateur trouvé avec cet identifiant.",
                    "Avertissement",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    // 🔹 Connexion (login)
    public Utilisateur connecterUtilisateur(String login, String password) {

        if (login == null || login.trim().isEmpty()
                || password == null || password.trim().isEmpty()) {

            JOptionPane.showMessageDialog(null,
                    "Veuillez saisir le login et le mot de passe.",
                    "Champs manquants",
                    JOptionPane.WARNING_MESSAGE);
            return null;
        }

        Utilisateur user = utilisateurDAO.login(login, password);

        if (user == null) {
            JOptionPane.showMessageDialog(null,
                    "Login ou mot de passe incorrect.",
                    "Erreur de connexion",
                    JOptionPane.ERROR_MESSAGE);
        }

        return user;
    }
}
