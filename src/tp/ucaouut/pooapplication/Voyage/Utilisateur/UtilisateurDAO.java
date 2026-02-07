/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp.ucaouut.pooapplication.Voyage.Utilisateur;


import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import tp.ucaouut.pooapplication.DAO;

/**
 *
 * @author USER
 */
public class UtilisateurDAO extends DAO<Utilisateur> {

    public UtilisateurDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Utilisateur obj) {
        try {
            String sql = "INSERT INTO utilisateurs (nom,prenom,password,mail) VALUES (?, ?, ? ,? )";
            PreparedStatement pstmt = this.connect.prepareStatement(sql);
            pstmt.setString(1, obj.getNom());
            pstmt.setString(2, obj.getPrenom());
            pstmt.setString(3, obj.getPassword());
            pstmt.setString(4, obj.getMail());
        
            pstmt.executeUpdate();
          //  conn.Close();
            return true;
        } catch (SQLException e) { e.printStackTrace(); }
        return false;
    }

    @Override
    public boolean delete(Utilisateur obj) {
        try {
            String sql = "DELETE FROM utilisateurs  WHERE id = ?";
            PreparedStatement pstmt = this.connect.prepareStatement(sql);
            pstmt.setLong(1, obj.getId());
            pstmt.executeUpdate();
          //  conn.Close();
            return true;
        } catch (SQLException e) { e.printStackTrace(); }
        return false;
    }

    @Override
    public boolean update(Utilisateur obj) {
        try{
         String sql = "UPDATE   utilisateurs SET  nom=?,prenom=?,password=?,mail=? WHERE id = ?";
            PreparedStatement pstmt = this.connect.prepareStatement(sql);
            pstmt.setString(1, obj.getNom());
            pstmt.setString(2, obj.getPrenom());
            pstmt.setString(3, obj.getPassword());
            pstmt.setString(4, obj.getMail());
            pstmt.setInt(5,obj.getId()) ;     
            pstmt.executeUpdate();
          //  conn.Close();
            return true;
        } catch (SQLException e) { e.printStackTrace(); }
         return false;
    }

    @Override
    public boolean find(long id) {
        Utilisateur user = new Utilisateur();
        try{
        String sql = "SELECT * FROM utilisateurs WHERE id = ?";
        PreparedStatement pstmt = this.connect.prepareStatement(sql);
        pstmt.setLong(1, id);
        ResultSet rs = pstmt.executeQuery();
        
        if (rs.next()) {
            user.setId(rs.getInt("Id"));
            user.setNom(rs.getString("nom"));
            user.setNom(rs.getString("prenom"));
            user.setMail(rs.getString("mail"));
            user.setPassword(rs.getString("password"));
          
        }return true;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
    }
    public List<Utilisateur> findAll() {
    List<Utilisateur> clients = new ArrayList<>();
    String sql = "SELECT * FROM utilisateurs";
     Utilisateur user = new Utilisateur();
    
    try ( 
         PreparedStatement ps = this.connect.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {
        
        while (rs.next()) {
            user.setId(rs.getInt("Id"));
           user.setNom( rs.getString("Nom"));
            user.setPrenom(rs.getString("prenom"));
            user.setMail(rs.getString("Mail"));
          
        }
        
       clients.add(user);
        
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return clients;
}
    public Utilisateur login(String login, String password) {
        
        try {
            
            String sql = "SELECT * FROM utilisateurs WHERE nom = ? AND password= ?";
            PreparedStatement pstmt = this.connect.prepareStatement(sql); 
            pstmt.setString(1, login);
            pstmt.setString(2, password); 
            
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Utilisateur(rs.getInt("id"), rs.getString("username"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Connexion échouée
    }
}

