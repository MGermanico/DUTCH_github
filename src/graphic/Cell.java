/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graphic;

import java.awt.Color;
import utils.Config;
/**
 *
 * @author migue
 */
public class Cell {
    static Graphic father;
    
    Position positionCR;
    Position positionXY;
    boolean enabled = false;
    Color color = Color.BLACK;

    public Cell(int column, int row, Graphic father){
        positionCR = new Position(row, column);
        positionXY = new Position(0, 0);
        this.father = father;
    }

    @Override
    public String toString() {
        return "Cell{" + "positionCR=" + positionCR + ", enabled=" + enabled + ", color=" + color + '}';
    }
    
    public boolean imOnXY(Position pos){
        return isOn(positionXY, pos);
    }
    
    public static boolean isOn(Position pos1, Position pos2){
        return CequalsR(pos1.x, pos2.x) && 
                CequalsR(pos1.y, pos2.y);
    }
    
    public static boolean CequalsR(double x1, double x2){
        return x1 > (x2 - Config.thickness) && (x2 + Config.thickness) > x1;
    }
    
    public void setXByColumn(int column){
        positionCR.x = column;
        positionXY.x = proportionLaneXY(column, this.father.xSize, this.father.columnSize);
    }
    
    public void setXByX(int x){
        positionCR.x = proportionXYLane(x, this.father.xSize, this.father.columnSize);
        positionXY.x = x;
    }
    
    public void setYByRow(int row){
        positionCR.y = row;
        positionXY.y = proportionLaneXY(row, this.father.ySize, this.father.rowSize);
    }
    
    public void setYByY(int y){
        positionCR.y = proportionXYLane(y, this.father.ySize, this.father.rowSize);
        positionXY.y = y;
    }
    
    public static double proportionLaneXY(double nLane, int xySize, int columnRowSize){
        return nLane*xySize*1.0/columnRowSize*1.0;
    }
    public static double proportionXYLane(double nXY, int xySize, int columnRowSize){
        return columnRowSize*1.0*nXY*1.0/xySize*1.0;
    }
    
    public static double proportionColumnToX(double nLane){
        return proportionLaneXY(nLane, father.xSize, father.columnSize);
    }
    public static double proportionXToColumn(double nLane){
        return proportionXYLane(nLane, father.xSize, father.columnSize);
    }
    
    public static double proportionRowToY(double nLane){
        return proportionLaneXY(nLane, father.ySize, father.rowSize);
    }
    public static double proportionYToRow(double nLane){
        return proportionXYLane(nLane, father.ySize, father.rowSize);
    }
}
