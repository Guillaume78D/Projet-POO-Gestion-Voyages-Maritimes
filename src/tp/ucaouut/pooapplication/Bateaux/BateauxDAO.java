/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp.ucaouut.pooapplication.Bateaux;

import java.sql.Connection;
import tp.ucaouut.pooapplication.DAO;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USER
 */
public class BateauxDAO extends DAO<Bateau> {

    public BateauxDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Bateau obj) {
        if (obj.getNbSieges() <= 0 || obj.getNom().isEmpty()) {
        return false; 
    }
        try {
            String sql = "INSERT INTO bateaux (nom, nbsieges, classe, vitesse,capitaine) VALUES (?, ?, ? ,? ,?)";
            PreparedStatement pstmt = this.connect.prepareStatement(sql);
            pstmt.setString(1, obj.getNom());
            pstmt.setInt(2, obj.getNbSieges());
            pstmt.setString(3, obj.getClasse());
            pstmt.setDouble(4, obj.getVitesse());
            pstmt.setString(5, obj.getCapitaine());
            pstmt.executeUpdate();
          //  conn.Close();
            return true;
        } catch (Exception e) { 
            e.printStackTrace(); 
            return false;
        }
        
    }

    @Override
    public boolean delete(Bateau obj) {
        try {
            String sql = "DELETE FROM bateaux  WHERE idBateau = ?";
            PreparedStatement pstmt = this.connect.prepareStatement(sql);
            pstmt.setInt(1, obj.getIdBateau());
            pstmt.executeUpdate();
          //  conn.Close();
            return true;
        } catch (Exception e) { e.printStackTrace(); }
        return false;
    }

    @Override
    public boolean update(Bateau obj) {
        try {
            String sql = "UPDATE bateaux  SET nom = ?, nbsieges =? , classe = ?, vitesse = ?,capitaine = ? WHERE idBateau = ?";
            PreparedStatement pstmt = this.connect.prepareStatement(sql);
            pstmt.setString(1, obj.getNom());
            pstmt.setInt(2, obj.getNbSieges());
            pstmt.setString(3, obj.getClasse());
            pstmt.setDouble(4, obj.getVitesse());
            pstmt.setString(5, obj.getCapitaine());
            pstmt.setLong(6, obj.getIdBateau());
            pstmt.executeUpdate();
          //  conn.Close();
            return true;
        } catch (Exception e) { e.printStackTrace(); };
        return false;
    }

    @Override
    public boolean find(long id) {
        Bateau bateau = new Bateau();      
    try {
        
        String sql = "SELECT * FROM bateaux WHERE id = ?";
         PreparedStatement pstmt = this.connect.prepareStatement(sql);
        pstmt.setLong(1, id);
        ResultSet rs = pstmt.executeQuery();
        
        if (rs.next()) {
            bateau.setIdBateau(rs.getInt(""));
            bateau.setNom(rs.getString("nom")); // 
            bateau.setNbSieges(rs.getInt(0)); // [cite: 15]
            bateau.setClasse(rs.getString("classe"));
            bateau.setVitesse(rs.getDouble(""));
            bateau.setCapitaine(rs.getString(""));
            return true;
        }
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
        return false;
   
    }
    
    public List<Bateau> findDisponibles(LocalDateTime dateT) {
    List<Bateau> liste = new ArrayList<>();
    // Requête : Sélectionne les bateaux qui ne sont pas en voyage à la date T
    String sql = "SELECT * FROM bateaux WHERE id NOT IN " +
                 "(SELECT id_bateau FROM voyage WHERE ? BETWEEN date_debut AND date_fin)";

    try {
        PreparedStatement pstmt = this.connect.prepareStatement(sql);
        pstmt.setObject(1, dateT); // On injecte la date saisie par l'utilisateur
        
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            Bateau b = new Bateau();
            b.setIdBateau(rs.getInt("id"));
            b.setNom(rs.getString("nom"));
            b.setNbSieges(rs.getInt("nbSieges")); //
            liste.add(b);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return liste;
}
    
}
