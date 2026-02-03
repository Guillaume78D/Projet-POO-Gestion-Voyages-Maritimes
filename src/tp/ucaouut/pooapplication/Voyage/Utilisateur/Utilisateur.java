/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp.ucaouut.pooapplication.Voyage.Utilisateur;

/**
 *
 * @author USER
 */
public class Utilisateur {
     private int  id;
    private String nom;
    private String password;
    private String mail ;
    private String prenom;

    public Utilisateur() {
    }

    public Utilisateur(int id, String nom, String password, String mail, String prenom) {
        this.id = id;
        this.nom = nom;
        this.password = password;
        this.mail = mail;
        this.prenom = prenom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Utilisateur(int id, String password) {
        this.id = id;
        this.password = password;
    }

  

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPassword() {
        return password;
    }

    public String getMail() {
        return mail;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
    
}
