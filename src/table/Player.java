/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package table;

import java.awt.Color;

/**
 *
 * @author migue
 */
public class Player {
    public String name;
    public Color color;

    public Player(String name, Color color) {
        this.name = name;
        this.color = color;
    }
    
    public Player(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Player{" + "name=" + name + ", color=" + color + '}';
    }
    
    
}
