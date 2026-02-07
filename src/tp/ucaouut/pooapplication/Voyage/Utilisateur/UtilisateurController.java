/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java
 */
package tp.ucaouut.pooapplication.Voyage.Utilisateur;
import java.awt.event.ActionListener;
import java.util.List;
import tp.ucaouut.pooapplication.View.EnregistrerClient;
import tp.ucaouut.pooapplication.View.Menu;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author USER
 */
public class UtilisateurController {

 /*   private UtilisateurDAO utilisateurDAO;

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
    }*/
    
    private final Utilisateur model;
    private final EnregistrerClient view;
    private final UtilisateurDAO dao;
    private  final Menu menu;
    private final boolean estCreation;
    private final ActionListener onSuccess;

    public UtilisateurController(Utilisateur m, EnregistrerClient v, UtilisateurDAO d, boolean creation, ActionListener success, Menu menu) {
        this.model = m;
        this.view = v;
        this.dao = d;
        this.estCreation = creation;
        this.onSuccess = success;
        this.menu = menu;
        
        if (!estCreation) {
            remplirChamps();
        }
    }

    /**
     * Remplit l'interface avec les données du modèle (mode modification)
     */
    private void remplirChamps() {
        view.getNom().setText(model.getNom());
        view.getPrenom().setText(model.getPrenom());
        view.getEmail().setText(model.getMail());
        view.getEmail().setText(model.getPassword());
    }

    public void initController() {
        // Bouton ENREGISTRER
        view.getBtnenregistrer().addActionListener(e -> enregistrer());

        // Bouton ANNULER
        view.getBtnannuler().addActionListener(e -> view.dispose());
    }

    private void enregistrer() {
        // 1. Récupération et validation simple
        String nom = view.getNom().getText().trim();
        String prenoms = view.getPrenom().getText().trim();
        String email = view.getEmail().getText().trim();
        String password = new String(view.getPassword().getPassword());

        if (nom.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Le nom et l'email sont obligatoires.", "Erreur", JOptionPane.ERROR_MESSAGE);
            return;
        }

        
        model.setNom(nom);
        model.setPrenom(prenoms);
        model.setMail(email);
        model.setPassword(password);

        
        try {
            boolean succes;
            if (estCreation) {
                succes = dao.create(model);
            } else {
                succes = dao.update(model);
            }

            if (succes) {
                JOptionPane.showMessageDialog(view, "Client enregistré avec succès !");
                if (onSuccess != null) {
                    // Déclenche le rafraîchissement de la table parente
                    onSuccess.actionPerformed(null);
                }
                    refreshTable();
                view.dispose();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, "Erreur lors de l'enregistrement : " + ex.getMessage());
        }
    }
    public void refreshTable() {
        
    // 1. On récupère le modèle du tableau depuis la vue
    DefaultTableModel tableModel = (DefaultTableModel) menu.getTableClients().getModel();
    
    
    tableModel.setRowCount(0); 

  
    List<Utilisateur> liste = dao.findAll(); 

   
    for (Utilisateur c : liste) {
        
        Object[] ligne = {  c.getId(),c.getNom(), c.getPrenom(), c.getMail() };
        tableModel.addRow(ligne);
    }
}
}
    
  


