/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp.ucaouut.pooapplication.Voyage;

import java.sql.Connection;
import java.sql.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import tp.ucaouut.pooapplication.DAO;

/**
 *
 * @author USER
 */
public class VoyageDAO extends DAO<Voyage> {

    public VoyageDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Voyage obj) {
        try {
            String sql = "INSERT INTO voyage (date_debut,date_fin,lieu_depart,lieu_arrive) VALUES (?, ?, ? ,? )";
            PreparedStatement pstmt = this.connect.prepareStatement(sql);
            pstmt.setObject(1, obj.getDatedebut());
            pstmt.setObject(2, obj.getDatefin());
            pstmt.setString(3, obj.getLieudepart());
            pstmt.setString(4, obj.getLieuarrive());
        
            pstmt.executeUpdate();
          //  conn.Close();
            return true;
        } catch (SQLException e) { e.printStackTrace(); }
              return false;
    }

    public boolean delete(Long id) throws SQLException  {
        try {
            String sql = "DELETE FROM voyage  WHERE num_voyage = ?";
            PreparedStatement pstmt = this.connect.prepareStatement(sql);
            pstmt.setLong(1, id);
            pstmt.executeUpdate();
          //  conn.Close();
            return true;
        } catch (SQLException e) { e.printStackTrace(); }
        return false;
    }

   
    public boolean updated(Voyage obj) throws SQLException   {
        try {
            String sql = "UPDATE  voyage SET  date_debut = ?,date_fin = ?,lieu_depart = ? ,lieu_arrive= ? ";
            PreparedStatement pstmt = this.connect.prepareStatement(sql);
            pstmt.setObject(1, obj.getDatedebut());
            pstmt.setObject(2, obj.getDatefin());
            pstmt.setString(3, obj.getLieudepart());
            pstmt.setString(4, obj.getLieuarrive());
            pstmt.setLong(5, obj.getNum_Voyage());
        
            pstmt.executeUpdate();
          //  conn.Close();
            return true;
        } catch (SQLException e) {}
        return false;
    }

    @Override
    public boolean find(long id) {
             Voyage voyage = new Voyage();      
    try {
        
        String sql = "SELECT * FROM Voyage WHERE num_voyage = ?";
        PreparedStatement pstmt = this.connect.prepareStatement(sql);
        pstmt.setLong(1, id);
        ResultSet rs = pstmt.executeQuery();
        
        if (rs.next()) {
            voyage.setNum_Voyage(rs.getInt("num_voyage"));
            voyage.setDatedebut((LocalDateTime) rs.getObject("date_debut")); // 
            voyage.setDatefin((LocalDateTime) rs.getObject("")); // [cite: 15]
            voyage.setLieudepart(rs.getString("classe"));
            voyage.setLieuarrive(rs.getString("lieu_fin"));
            
          }
        return true;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
        }
    public String calculerDuree(LocalDateTime depart, LocalDateTime arrivee) {
    if (depart == null || arrivee == null) return "Données manquantes";
    
 
    Duration duree = Duration.between(depart, arrivee);
    
    long heures = duree.toHours();
    long minutes = duree.toMinutesPart(); 
    
    return heures + "h " + minutes + "min";
    }
    public List<Voyage> findAll() {
    List<Voyage> liste = new ArrayList<>();
    String sql = "SELECT * FROM voyage"; 
    try {
        PreparedStatement pstmt = this.connect.prepareStatement(sql); 
        ResultSet rs = pstmt.executeQuery();
        
        while (rs.next()) {
            Voyage v = new Voyage();
            v.setNum_Voyage(rs.getInt("num_voyage")); 
            v.setDatedebut(rs.getObject("date_debut", LocalDateTime.class)); 
            v.setLieudepart(rs.getString("lieu_depart")); 
            v.setLieuarrive(rs.getString("lieu_arrive"));
            liste.add(v);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return liste;
}
    public List<String> findPassagersParVoyage(int numVoyage) {
    List<String> passagers = new ArrayList<>();
    // Requête de jointure entre les passagers et leurs réservations
    String sql = "SELECT u.nom, u.prenom FROM utilisateurs u " +
                 "JOIN reservations r ON u.id = r.id_utilisateur " +
                 "WHERE r.num_voyage = ?";
    try {
        PreparedStatement pstmt = this.connect.prepareStatement(sql); //
        pstmt.setInt(1, numVoyage); // On filtre par le numéro du voyage sélectionné
        
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            passagers.add(rs.getString("nom") + " " + rs.getString("prenom"));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return passagers;
}

    @Override
    public boolean delete(Voyage obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(Voyage obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    }
    

