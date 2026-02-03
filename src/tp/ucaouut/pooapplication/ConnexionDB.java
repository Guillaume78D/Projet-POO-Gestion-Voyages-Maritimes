/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp.ucaouut.pooapplication;

import java.sql.*;

/**
 *
 * @author USER
 */
public   class ConnexionDB{
     private static String url = "jdbc:postgresql://localhost:5432/voyagesmaritimes";
    private static String user = "postgres";
    private static String passwd = "pooprojet";
    private static Connection connect;

    public static Connection getInstance(){
        if(connect == null){
            try {
                connect = DriverManager.getConnection(url, user, passwd);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connect;
    }
}
