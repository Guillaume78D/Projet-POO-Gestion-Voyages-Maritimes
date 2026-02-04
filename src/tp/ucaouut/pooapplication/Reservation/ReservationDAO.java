/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp.ucaouut.pooapplication.Reservation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import tp.ucaouut.pooapplication.DAO;

/**
 *
 * @author USER
 */
public class ReservationDAO extends DAO  <Reservation>{

    public ReservationDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Reservation obj) {
         try {
            String sql = "INSERT INTO reservation_client (nom_voyage,nom_bateau,statut) VALUES (?, ?, ?  )";
            PreparedStatement pstmt = this.connect.prepareStatement(sql);
            pstmt.setObject(1, obj.getNomVoyage());
            pstmt.setObject(2, obj.getNomBateau());
            pstmt.setString(3, obj.getStatut());
            
        
            pstmt.executeUpdate();
          //  conn.Close();
            return true;
        } catch (SQLException e) { e.printStackTrace(); }
              return false;
    }

  
    public boolean delete(Long id) {
        try {
            String sql = "DELETE FROM reservation_client  WHERE id_reservation = ?";
            PreparedStatement pstmt = this.connect.prepareStatement(sql);
            pstmt.setLong(1, id);
            pstmt.executeUpdate();
          //  conn.Close();
            return true;
        } catch (SQLException e) { e.printStackTrace(); }
        return false;
    }

    @Override
    public boolean update(Reservation obj) {
            try {
            String sql = "UPDATE   reservation_client  SET nom_voyage =?,nom_bateau =?,statut=?) VALUES ";
            PreparedStatement pstmt = this.connect.prepareStatement(sql);
            pstmt.setObject(1, obj.getNomVoyage());
            pstmt.setObject(2, obj.getNomBateau());
            pstmt.setString(3, obj.getStatut());
            
        
            pstmt.executeUpdate();
          //  conn.Close();
            return true;
        } catch (SQLException e) { e.printStackTrace(); }
              return false;
    }

    @Override
    public boolean find(long id) {
             Reservation bateau = new Reservation();      
    try {
        
        String sql = "SELECT * FROM reservation_client WHERE id_reservation = ?";
         PreparedStatement pstmt = this.connect.prepareStatement(sql);
        pstmt.setLong(1, id);
        ResultSet rs = pstmt.executeQuery();
        
        if (rs.next()) {
            bateau.setIdReservation(rs.getInt(""));
            bateau.setNomBateau(rs.getString("nom")); // 
            bateau.setNomVoyage(rs.getString(0)); // [cite: 15]
            bateau.setStatut(rs.getString("classe"));
            
            return true;
        }
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
        return false;
    }

    @Override
    public boolean delete(Reservation obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
