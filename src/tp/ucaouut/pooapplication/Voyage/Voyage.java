/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp.ucaouut.pooapplication.Voyage;

import java.time.LocalDateTime;

/**
 *
 * @author USER
 */
public class Voyage {
    private int num_Voyage;
    private LocalDateTime datedebut;
    private LocalDateTime datefin;
    private String lieudepart;
    private String lieuarrive;

    public Voyage() {
    }

    public Voyage(int num_Voyage, LocalDateTime datedebut, LocalDateTime datefin, String lieudepart, String lieuarrive) {
        this.num_Voyage = num_Voyage;
        this.datedebut = datedebut;
        this.datefin = datefin;
        this.lieudepart = lieudepart;
        this.lieuarrive = lieuarrive;
    }

    

    public int getNum_Voyage() {
        return num_Voyage;
    }

    public LocalDateTime getDatedebut() {
        return datedebut;
    }

    public LocalDateTime getDatefin() {
        return datefin;
    }

    public String getLieuarrive() {
        return lieuarrive;
    }

    public void setNum_Voyage(int num_Voyage) {
        this.num_Voyage = num_Voyage;
    }

    public void setDatedebut(LocalDateTime datedebut) {
        this.datedebut = datedebut;
    }

    public void setDatefin(LocalDateTime datefin) {
        this.datefin = datefin;
    }

    public void setLieuarrive(String lieuarrive) {
        this.lieuarrive = lieuarrive;
    }

    public String getLieudepart() {
        return lieudepart;
    }

    public void setLieudepart(String lieudepart) {
        this.lieudepart = lieudepart;
    }
    
}
