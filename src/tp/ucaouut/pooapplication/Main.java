/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp.ucaouut.pooapplication;

 import java.sql.Connection;
import tp.ucaouut.pooapplication.View.AjouterVoyage;
import tp.ucaouut.pooapplication.Voyage.Voyage;
import tp.ucaouut.pooapplication.Voyage.VoyageController;
import tp.ucaouut.pooapplication.Voyage.VoyageDAO;
import tp.ucaouut.pooapplication.ConnexionDB;
import tp.ucaouut.pooapplication.View.AjouterBateau;
import tp.ucaouut.pooapplication.View.Menu;

/**
 *
 * @author USER
 */
public class Main {
    public static void main(String[] args) {
    // On demande à Swing de lancer l'interface en toute sécurité
    
       
            try {
                // 1. On crée les objets du MVC
                Voyage model = new Voyage();
               Menu view = new Menu();
               AjouterVoyage bat = new  AjouterVoyage();
               Connection conn = (Connection) ConnexionDB.getInstance();
                VoyageDAO dao = new VoyageDAO(conn);
                
                // 2. On crée le contrôleur qui fait le lien
                VoyageController controller = new VoyageController(model,bat, dao,view);

                // 3. On initialise les boutons et on affiche la fenêtre
                controller.initController();
           //     view.setLocationRelativeTo(null); // Centre la fenêtre
                view.setVisible(true);
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    
}

