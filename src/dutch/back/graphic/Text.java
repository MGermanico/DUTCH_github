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
public class Text {
    String text;
    int x;
    int y;
    int size;
    int xAlignment = Graphic.RIGHT;
    int yAlignment = Graphic.TOP;
    int nLettersByLane = 0;
    Color color;

    public Text(String text, int x, int y, int size, Color color) {
        this.text = text;
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = color;
    }
    public Text(String text, int x, int y, int size, Color color, int nLettersByLane) {
        this.text = text;
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = color;
        this.nLettersByLane = nLettersByLane;
    }
    public Text(String text, int x, int y, int size, Color color, int xAlignment, int yAlignment, int nLettersByLane) {
        this.text = text;
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = color;
        this.nLettersByLane = nLettersByLane;
        this.xAlignment = xAlignment;
        this.yAlignment = yAlignment;
    }
}
