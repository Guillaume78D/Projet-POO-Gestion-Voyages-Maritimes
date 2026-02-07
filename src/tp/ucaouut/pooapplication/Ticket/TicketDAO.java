/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp.ucaouut.pooapplication.Ticket;

/**
 *
 * @author Lenovo
 */

import java.sql.*;
import java.util.Date;
import tp.ucaouut.pooapplication.DAO;


public class TicketDAO extends DAO<Ticket> {

    public TicketDAO(Connection conn) {
        super(conn);
    }

    public boolean genererTicket(int idUtilisateur, int idVoyage) {

        Tickets ticket = new Tickets();

        String sql = """
            SELECT 
                u.id AS idUtilisateur, u.nom, u.prenom, u.mail,
                v.id AS idVoyage, v.destination, v.date_depart,
                b.id AS idBateau, b.nom AS nomBateau
            FROM utilisateur u
            JOIN voyage v ON v.id = ?
            JOIN bateau b ON v.id_bateau = b.id
            WHERE u.id = ?
        """;

        try (PreparedStatement ps = this.connect.prepareStatement(sql)) {

            ps.setInt(1, idVoyage);
            ps.setInt(2, idUtilisateur);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                ticket.setIdTicket(rs.getInt("idUtilisateur"));
                ticket.setNomUtilisateur(rs.getString("nom"));
                ticket.setPrenomUtilisateur(rs.getString("prenom"));
                ticket.setEmailUtilisateur(rs.getString("mail"));

                ticket.setIdVoyage(rs.getInt("idVoyage"));
                ticket.setDestination(rs.getString("destination"));
                ticket.setDateDepart(rs.getDate("date_depart"));

                ticket.setIdBateau(rs.getInt("idBateau"));
                ticket.setNomBateau(rs.getString("nomBateau"));

                ticket.setDateEmission(new Date());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean create(Ticket obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(Ticket obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(Ticket obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean find(long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

