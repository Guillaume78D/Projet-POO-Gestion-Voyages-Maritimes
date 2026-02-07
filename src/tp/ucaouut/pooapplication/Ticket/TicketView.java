/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp.ucaouut.pooapplication.Ticket;

import javax.swing.*;
import java.awt.*;

public class TicketView extends JFrame {

    private JTextArea zoneTicket;
    private JButton btnImprimer;

    public TicketView(Ticket ticket) {

        setTitle("🎫 Ticket de Voyage");
        setSize(400, 500);
        setLocationRelativeTo(null);

        zoneTicket = new JTextArea();
        zoneTicket.setEditable(false);

        zoneTicket.setText("""
        ===== TICKET DE VOYAGE =====
        
        Client :
        %s %s
        Email : %s
        
        Voyage :
        Destination : %s
        Date départ : %s
        
        Bateau :
        %s
        
        Date émission :
        %s
        """.formatted(
                ticket.getNomUtilisateur(),
                ticket.getPrenomUtilisateur(),
                ticket.getEmailUtilisateur(),
                ticket.getDestination(),
                ticket.getDateDepart(),
                ticket.getNomBateau(),
                ticket.getDateEmission()
        ));

        btnImprimer = new JButton("Imprimer");

        add(new JScrollPane(zoneTicket), BorderLayout.CENTER);
        add(btnImprimer, BorderLayout.SOUTH);

        setVisible(true);
    }
}

