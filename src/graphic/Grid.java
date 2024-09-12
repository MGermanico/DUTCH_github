/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graphic;

import java.awt.Color;

/**
 *
 * @author migue
 */
public class Grid {
    double factorX;
    double factorY;
    int x;
    int y;
    int xSize;
    int ySize;
    Color color;

    public Grid(double factorX, double factorY, int x, int y, int xSize, int ySize, Color color) {
        this.factorX = factorX;
        this.factorY = factorY;
        this.x = x;
        this.y = y;
        this.xSize = xSize;
        this.ySize = ySize;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Grid{" + "factorX=" + factorX + ", factorY=" + factorY + ", x=" + x + ", y=" + y + ", xSize=" + xSize + ", ySize=" + ySize + ", color=" + color + '}';
    }
    
    
}
