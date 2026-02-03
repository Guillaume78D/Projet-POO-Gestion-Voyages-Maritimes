/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp.ucaouut.pooapplication.Bateaux;

/**
 *
 * @author USER
 */
class Bateau {
    private int idBateau;
    private String nom;
    private  int nbSieges;
    private String Classe;
    private double Vitesse;
    private String capitaine;

    public Bateau() {
    }

    public Bateau(int idBateau, String nom, int nbSieges, String Classe, double Vitesse, String capitaine) {
        this.idBateau = idBateau;
        this.nom = nom;
        this.nbSieges = nbSieges;
        this.Classe = Classe;
        this.Vitesse = Vitesse;
        this.capitaine = capitaine;
    }

    public int getIdBateau() {
        return idBateau;
    }

    public String getNom() {
        return nom;
    }

    public int getNbSieges() {
        return nbSieges;
    }

    public String getClasse() {
        return Classe;
    }

    public double getVitesse() {
        return Vitesse;
    }

    public String getCapitaine() {
        return capitaine;
    }

    public void setIdBateau(int idBateau) {
        this.idBateau = idBateau;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setNbSieges(int nbSieges) {
        this.nbSieges = nbSieges;
    }

    public void setClasse(String Classe) {
        this.Classe = Classe;
    }

    public void setVitesse(double Vitesse) {
        this.Vitesse = Vitesse;
    }

    public void setCapitaine(String capitaine) {
        this.capitaine = capitaine;
    }
    
}
