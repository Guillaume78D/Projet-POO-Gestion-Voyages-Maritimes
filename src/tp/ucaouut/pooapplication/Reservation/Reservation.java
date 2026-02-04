/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp.ucaouut.pooapplication.Reservation;

/**
 *
 * @author USER
 */
public class Reservation {
    private int idReservation;
    private String nomVoyage;
    private String nomBateau;
    private String statut;

    public Reservation(int idReservation, String nomVoyage, String nomBateau, String statut) {
        this.idReservation = idReservation;
        this.nomVoyage = nomVoyage;
        this.nomBateau = nomBateau;
        this.statut = statut;
    }

    public Reservation() {
    }

    public int getIdReservation() {
        return idReservation;
    }

    public String getNomVoyage() {
        return nomVoyage;
    }

    public String getNomBateau() {
        return nomBateau;
    }

    public String getStatut() {
        return statut;
    }

    public void setIdReservation(int idReservation) {
        this.idReservation = idReservation;
    }

    public void setNomVoyage(String nomVoyage) {
        this.nomVoyage = nomVoyage;
    }

    public void setNomBateau(String nomBateau) {
        this.nomBateau = nomBateau;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }
    
}
