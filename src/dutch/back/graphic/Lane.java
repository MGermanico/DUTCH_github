/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dutch.back.graphic;

import java.awt.Color;

/**
 *
 * @author migue
 */
public class Lane {
    Position p1;
    Position p2;
    Color color;
    
    public Lane(Position p1, Position p2, Color color){
        this.p1 = p1;
        this.p2 = p2;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Lane{" + "p1=" + p1 + ", p2=" + p2 + ", color=" + color + '}';
    }
}
