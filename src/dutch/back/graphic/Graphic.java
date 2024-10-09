/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dutch.back.graphic;

import dutch.back.graphic.Cell;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author migue
 */
public class Graphic {
    
    Cell[][] graph;
    public int imageSizeFactor;
    public int columnSize;
    public int rowSize;
    public int xSize;
    public int ySize;
    
//    public Graphic(int x, int y){
//        Graphic(x, y, 400, 200, 1);
//    }
//    public Graphic(int x, int y){
//        Graphic(x, y, 400, 200, 1);
//    }
    public Graphic(int y, int x, int columnSize, int rowSize, int imageSizeFactor){
        this.columnSize = columnSize;
        this.rowSize = rowSize;
        graph = new Cell[columnSize][rowSize];
        xSize = x;
        ySize = y;
        this.imageSizeFactor = imageSizeFactor;
        clearGraph();
    }
    public void clearGraph(){
        Cell actualCell;
        for (int column = 0; column < columnSize; column++) {
            for (int row = 0; row < rowSize; row++) {
                actualCell = new Cell(column, row,this);
                actualCell.positionXY = new Position(column, row, false);
                graph[column][row] = actualCell;
            }
        }
    }
    public void addAxes(){
        Cell actualCell;
        for (int column = 0; column < columnSize; column++) {
            for (int row = 0; row < rowSize; row++) {
                actualCell = graph[column][row];
                if (column == 0 || row == 0) {
                    actualCell.enabled = true;
                    actualCell.color = Color.BLACK;
                }
            }
        }
    }
    public void addLaneFunction(double xFactor, double xSum, Color color){
        addLaneFunction(xFactor, xSum, 0, 0, color);
    }
    public void addLaneFunction(double xFactor, double xSum, double minColumn, double maxColumn, Color color){
//        System.out.println("\naddLaneFunction(Graphic): " + xFactor + " : " + xSum + " : " + minColumn + " : " + maxColumn + " : " + color + "\n");
        Cell actualCell;
        for (int column = 0; column < columnSize; column++) {
            for (int row = 0; row < rowSize; row++) {
                actualCell = graph[column][row];
                double x = actualCell.positionXY.y;
                double y = actualCell.positionXY.x;
                if (Cell.CequalsR(xFactor * x + xSum, y) &&
                        x >= minColumn &&
                        maxColumn >= x) {
                    actualCell.color = color;
                    actualCell.enabled = true;
                }
            }
        }
    }
    public void addLane(Position beforePos, Position afterPos, Color color){
        double beforeX = beforePos.x;
        double beforeY = beforePos.y;
        double afterX = afterPos.x;
        double afterY = afterPos.y;
        
        double minColumn;
        double maxColumn;
        
//        System.out.println("addLane(Graphic): " + beforePos.toString(false) + " : " + afterPos.toString(false) + " : " + color + "\n");
        
        if (beforeX != afterX) {
            Position director = new Position(afterX-beforeX, afterY-beforeY);

            double m = (Cell.proportionYToRow(director.y)/Cell.proportionXToColumn(director.x));
            double n = (Cell.proportionYToRow(beforeY) - m * Cell.proportionXToColumn(beforeX));

            if (afterX > beforeX) {
                minColumn = beforeX;
                maxColumn = afterX;
            }else{
                maxColumn = beforeX;
                minColumn = afterX;
            }
            addLaneFunction(m, n, Cell.proportionXToColumn(minColumn), Cell.proportionXToColumn(maxColumn), color);
        }else{
            if (afterY > beforeY) {
                minColumn = beforeY;
                maxColumn = afterY;
            }else{
                maxColumn = beforeY;
                minColumn = afterY;
            }
            this.addColumn(beforeX, Cell.proportionYToRow(minColumn), Cell.proportionYToRow(maxColumn), color);
        }
    }
    public void addParaboloidFunction(double xxFactor, double xFactor, double xSum){
        Cell actualCell;
        for (int column = 0; column < columnSize; column++) {
            for (int row = 0; row < rowSize; row++) {
                actualCell = graph[column][row];
                double x = actualCell.positionXY.y;
                double y = actualCell.positionXY.x;
                if (Cell.CequalsR(x*x*xxFactor + xFactor * x + xSum, y)) {
                    actualCell.color = Color.lightGray;
                    actualCell.enabled = true;
                }
            }
        }
    }
    public void addGrid(Grid grid){
        double factorX = grid.factorX;
        double factorY = grid.factorY;
        int x = grid.x;
        int y = grid.y;
        int xSize = grid.xSize;
        int ySize = grid.ySize;
        Color color = grid.color;
        for (int i = x; i < ySize + x + 1; i++) {
            addRow(i*factorY, y* factorX , (xSize + y) * factorX, color);
        }
        for (int i = y; i < (xSize + y + 1); i++) {
            addColumn(i*factorX, x * factorY , (ySize + x) * factorY, color);
        }
        addAxes();
    }
    
    public void addColumn(double y, double xMin, double xMax, Color color){
        Cell actualCell;
        for (int column = 0; column < columnSize; column++) {
            for (int row = 0; row < rowSize; row++) {
                actualCell = graph[column][row];
                double x = actualCell.positionXY.y;
                if (Cell.CequalsR(x, y) &&
                    actualCell.positionXY.x >= xMin && 
                    actualCell.positionXY.x <= xMax) {
                    if (color != null) {
                        actualCell.color = color;
                    }else{
                        actualCell.color = Color.lightGray;
                    }
                    actualCell.enabled = true;
                }
            }
        }
    }
    public void addRow(double x, double yMin, double yMax, Color color){
        Cell actualCell;
        for (int column = 0; column < columnSize; column++) {
            for (int row = 0; row < rowSize; row++) {
                actualCell = graph[column][row];
                double y = actualCell.positionXY.x;
                if (Cell.CequalsR(x, y) &&
                    actualCell.positionXY.y >= yMin && 
                    actualCell.positionXY.y <= yMax) {
                    if (color != null) {
                        actualCell.color = color;
                    }else{
                        actualCell.color = Color.lightGray;
                    }
                    actualCell.enabled = true;
                }
            }
        }
    }
    public BufferedImage getBufferedImage(){
        int factor = imageSizeFactor;
        BufferedImage buffImg = new BufferedImage(rowSize*factor, columnSize*factor, BufferedImage.TYPE_INT_RGB);
        Cell actualCell;
        for (int column = 0, columnImg = (columnSize - 1)*factor; column < columnSize; column += 1, columnImg -= 1*factor) {
            for (int row = 0, rowImg = 0; row < rowSize; row += 1, rowImg += 1*factor) {
                actualCell = graph[column][row];
                for (int i = 0; i < factor; i++) {
                    for (int j = 0; j < factor; j++) {
                        if (actualCell.enabled) {
                            buffImg.setRGB(rowImg + i, columnImg + j, actualCell.color.getRGB());
                        }else{
                            buffImg.setRGB(rowImg + i, columnImg + j, Color.WHITE.getRGB());
                        }
                    }
                }
            }
        }
        return buffImg;
    }
    
    public void addText(String text, int x, int y, Color color, int factor, int nLettersByLane, int xAlignment, int yAlignment){
        double maxX;
        if (nLettersByLane == 0) {
            maxX = (this.columnSize*2 - factor*5.5) - x;
        }else{
            maxX = factor*5.5*nLettersByLane;
        }
        double xSize = maxX - x;
        if (xAlignment == LEFT) {
            x -= xSize;
        }else if (xAlignment == CENTER) {
            x-= xSize/2;
        }else if (xAlignment == RIGHT); 
        
        int nLanes = Math.ceilDiv(text.length(), nLettersByLane);
        y += factor*8*(nLanes - 1);
        
        if (yAlignment == CENTER) {
            y -= factor*8*(nLanes/2);
        }else if (yAlignment == BOTTOM) {
            y -= factor*8*(nLanes);
        }else if (yAlignment == TOP);
        
        addText(text, x, y, color, factor, maxX);
    }
    
    public void addText(String text, int x, int y, Color color, int factor, double maxX){
//        System.out.println("addText(Graphic): text " + text);
        int xAdder = 0;
        int yAdder = 0;
        char actualChar;
        
        for (int nLetter = 0; nLetter < text.length(); nLetter++) {
            if (xAdder >= maxX) {
                xAdder = 0;
                yAdder -= 8*factor;
            }
            actualChar = text.charAt(nLetter);
            if (actualChar != ' ') {
                addLetter(actualChar + "", x+xAdder, y+yAdder, color, factor);
            }
            xAdder += 5.5*factor;
        }
    }
    public void addLetter(String letter, int x, int y, Color color, int factor){
        String path;
        if (Character.isLowerCase(letter.charAt(0))) {
            path = "src/data/letters/" + letter + "_1.txt";
            if (letter.replaceAll("[g,p,q,y]", "").equalsIgnoreCase("")) {
                y -= factor*2;
            }
        }else{
            path = "src/data/letters/" + letter + ".txt";
        }
//        System.out.println("addLetter(Graphic): path " + path);
        File letterTxt = new File(path);
        
        try(Scanner scFile = new Scanner(letterTxt)){
            int yAdder = 0;
            boolean print;
            String actualLane;
            ArrayList<String> lanes = new ArrayList<String>();
            while(scFile.hasNext()){
                lanes.add(scFile.nextLine());
            }
            for (int lane = lanes.size() - 1; lane >= 0 ; lane--) {
                actualLane = lanes.get(lane).replaceAll(" ", "");
                for (int xAdder = 0; xAdder < actualLane.length(); xAdder += 1) {
                    print = Character.getNumericValue(actualLane.charAt(xAdder)) == 1;
//                    System.out.println("addLetter(Graphic): print " + print + " : number " + actualLane.charAt(xAdder));
                    if (print) {
                        for (int xFactorAdder = 0; xFactorAdder < factor; xFactorAdder++) {
                            for (int yFactorAdder = 0; yFactorAdder < factor; yFactorAdder++) {
                                try{
                                    this.setRGB( y + yAdder*factor + yFactorAdder, x + xAdder*factor + xFactorAdder, color);
                                }catch(ArrayIndexOutOfBoundsException ex){
                                }
                            }
                        }
                    }
                }
                yAdder += 1;
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public void setRGB(int x, int y, Color color){
        this.graph[x][y].color = color;
        this.graph[x][y].enabled = true;
    }
    
    public static int CENTER = 0;
    
    public static int TOP = 1;
    public static int BOTTOM = -1;
    
    public static int RIGHT = 1;
    public static int LEFT = -1;
}
