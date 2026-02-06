/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tp.ucaouut.pooapplication.View;
import java.sql.Connection;
import java.awt.Image;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import tp.ucaouut.pooapplication.ConnexionDB;
import tp.ucaouut.pooapplication.Voyage.Voyage;
import tp.ucaouut.pooapplication.Voyage.VoyageController;
import tp.ucaouut.pooapplication.Voyage.VoyageDAO;

/**
 *
 * @author USER
 */
public class Menu extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Menu.class.getName());

    private VoyageController controller;
    public Menu() {
        initComponents();
        Connection maConnexion = ConnexionDB.getInstance();
        VoyageDAO voyageDao = new VoyageDAO(maConnexion);
        this.controller = new VoyageController(voyageDao);
        chargerDonnes();
    }
    
    public ImageIcon resizeIcon(String path, int width, int height) {
    ImageIcon icon = new ImageIcon(path);
    Image img = icon.getImage();
    Image newImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
    return new ImageIcon(newImg);
}

public void chargerDonnes(){
    // On récupère le modèle du tableau et on le "cast" en DefaultTableModel
DefaultTableModel model = (DefaultTableModel) tableVoyages.getModel();

// On vide le tableau pour éviter les doublons à chaque actualisation
model.setRowCount(0);

// 3. On récupère la liste des voyages depuis le contrôleur
    List<Voyage> liste = controller.getTousLesVoyages();
    for (Voyage v : liste) {
        Object[] row = {
            v.getNum_Voyage(),
            v.getDatedebut(),
            v.getDatefin(),
            v.getLieudepart(),
            v.getLieuarrive()
        };
        model.addRow(row);
    }
}
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1142, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 638, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new Menu().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
