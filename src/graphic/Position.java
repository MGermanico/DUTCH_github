/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graphic;

/**
 *
 * @author migue
 */
public class Position {
    double x;
    double y;

    public Position(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Position(double x, double y, boolean lane) {
        if (!lane) {
            this.x = Cell.proportionColumnToX(x);
            this.y = Cell.proportionRowToY(y);
        }else{
            this.x = x;
            this.y = y;
        }
    }
    
    @Override
    public String toString() {
        return "Position{" + "x=" + x + ", y=" + y + '}';
    }
    
    public String toString(boolean lanePos) {
        if (lanePos) {
            return "Position{" + "x=" + x + ", y=" + y + '}';
        }else{
            return "Position{" + "x=" + Cell.proportionXToColumn(x) + ", y=" + Cell.proportionYToRow(y) + '}';
        }
    }
    
    public double getColumn(){
        return Cell.proportionXToColumn(x);
    }
    
    public double getRow(){
        return Cell.proportionYToRow(y);
    }
}
