/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp.ucaouut.pooapplication.View;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Model_Menu {
    
    String icon;
    String name;
    MenuType type; 
    
    public void setName(String name) {
        this.name = name;
    }
    public MenuType getType() {
        return type;
    }
    public void setType(MenuType type) {
        this.type = type;
    }
    
    public Model_Menu(String icon, String name, MenuType type) {
        this.icon=icon;
        this.name=name;
        this.type=type;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
    
    public Model_Menu() {
        
    }
    
    
    public Icon toIcon(){
        return new ImageIcon(getClass().getResource("/com/raven/icon"+icon+"png"));
    }
    
    public static enum Menutype {
        TITLE, MENU, EMPTY
    }
}
