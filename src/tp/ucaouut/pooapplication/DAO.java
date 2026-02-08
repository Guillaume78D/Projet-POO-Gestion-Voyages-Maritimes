/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp.ucaouut.pooapplication;

import java.sql.Connection;

/**
 *
 * @author USER
 */
public abstract  class DAO<T> {
    protected Connection connect ;
    
    public DAO(Connection conn){
        this.connect = conn;
    }
    
    public abstract long create (T obj);
    public abstract boolean delete(T obj);
    public abstract boolean update (T obj);
    public abstract boolean  find (long id );
}
