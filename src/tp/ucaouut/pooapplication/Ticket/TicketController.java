/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp.ucaouut.pooapplication.Ticket;

public class TicketController {

    private final TicketDAO ticketDAO;

    public TicketController(TicketDAO dao) {
        this.ticketDAO = dao;
    }

    public Ticket genererTicket(int idUtilisateur, int idVoyage) {
        return ticketDAO.genererTicket(idUtilisateur, idVoyage);
    }
}
