/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dutch.back.graphic;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.List;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import utils.Config;

/**
 *
 * @author migue
 */
public class ShowingGraphic extends JPanel{
    public Graphic graphicClass;
    public int updateMode = UPDATE_MODE_DELETE_NOTHING;
    
    public static int UPDATE_MODE_DELETE_NOTHING = 0;
    public static int UPDATE_MODE_DELETE_LANES = 1;
    public static int UPDATE_MODE_DELETE_TEXTS = 2;
    public static int UPDATE_MODE_DELETE_BACKGROUNDS = 5;
    public static int UPDATE_MODE_DELETE_TEXTS_AND_LANES = 3;
    public static int UPDATE_MODE_DELETE_BACKGROUNDS_AND_LANES = 6;
    public static int UPDATE_MODE_DELETE_BACKGROUNDS_AND_TEXTS = 7;
    public static int UPDATE_MODE_DELETE_ALL = 8;
            
    int nTimesXResized = 0;
    
    public ArrayList<Lane> lanes;
    public ArrayList<Text> texts;
    public ArrayList<Grid> grids;
            
    private Box b = Box.createHorizontalBox();

    public ShowingGraphic(int columnSize, int rowSize, int imageSizeFactor, int ySize, int xSize) {
        lanes = new ArrayList<Lane>();
        texts = new ArrayList<Text>();
        grids = new ArrayList<Grid>();
//        System.out.println("ShowingGraphic(ShowingGraphic): " + ySize + ", " + xSize + ", " + columnSize + ", " + rowSize);
        graphicClass = new Graphic(ySize, xSize, columnSize, rowSize, 1);
        updateImage();
    }
    
    private void init(){
//        System.out.println("init(ShowingGraphic): " + graphicClass.ySize + ", " + graphicClass.xSize + ", " + graphicClass.columnSize + ", " + graphicClass.rowSize);
        graphicClass = new Graphic(graphicClass.ySize, graphicClass.xSize, graphicClass.columnSize, graphicClass.rowSize, 1);
    }
    public void addBackGrid(int columns, int rows, Color color, double factorThickness){
        double proportionToColumns = columns*1.0/graphicClass.xSize;
//        System.out.println("\naddBackGrid(Graphic):" +proportionToColumns + " * " + xSize + " = " + columns + " / " + xSize);
        double proportionToRows = rows*1.0/graphicClass.ySize;
//        System.out.println("addBackGrid(Graphic):" +proportionToRows + " * " + ySize + " = " + rows + " / " + ySize + "\n");

        Grid grid = new Grid(1/proportionToColumns,  1/proportionToRows, 0, 0, (int)(proportionToRows*graphicClass.ySize), (int)proportionToColumns*graphicClass.xSize, color);
        addGrid(grid, factorThickness);
    }
    public void addGrid(Grid grid,  double factorThickness){
        Config.thickness *= factorThickness;
//        System.out.println("addGrid (ShowingGraphic): " + grid);
        graphicClass.addGrid(grid);
        grids.add(grid);
        Config.thickness /= factorThickness;
    }
    
    public void addLane(Lane lane, double factorThickness){
        Config.thickness *= factorThickness;
//        System.out.println("addLane(ShowingGraphic): " + lane.p1.toString(false) + lane.p2.toString(false));
        graphicClass.addLane(lane.p1, lane.p2, lane.color);
        lanes.add(lane);
        Config.thickness /= factorThickness;
    }
    public void addLanes(ArrayList<Lane> lanes, double factorThickness){
        Config.thickness *= factorThickness;
        int nLanes = lanes.size();
        Lane lane;
        for (int i = 0; i < nLanes; i++) {
            lane = lanes.get(i);
            //        System.out.println("addLane(ShowingGraphic): " + lane.p1.toString(false) + lane.p2.toString(false));
            graphicClass.addLane(lane.p1, lane.p2, lane.color);
            lanes.add(lane);
        }
        Config.thickness /= factorThickness;
    }
    
    public void updateImage(){
        BufferedImage buffImg = this.graphicClass.getBufferedImage();
        ImageIcon img = new ImageIcon(buffImg);
        JLabel labelImg = new JLabel();
        labelImg.setIcon(img);
        
        b.removeAll();
        b.add(labelImg);
        this.removeAll();
        this.add(b);
    }
    
    public void addText(Text text){
//        System.out.println("addText(ShowingGraphic): " + text);
        graphicClass.addText(text.text, text.x, text.y, text.color, text.size ,text.nLettersByLane, text.xAlignment, text.yAlignment);
        texts.add(text);
    }

    public void showLanesOnLogger(){
        int i = 0;
        for (Lane lane : lanes) {
            i++;
            System.out.println(" -- lane " + i + " --");
            System.out.println("XY: " + lane.p1.toString(false) + " : " + lane.p2.toString(false));
            System.out.println("CR: " + lane.p1.toString(true) + " : " + lane.p2.toString(true));
            System.out.println("--");
        }
    }
    public void showTextsOnLogger(){
        int i = 0;
        for (Text text : texts) {
            i++;
            System.out.println(" -- text " + i + " --");
            System.out.println("Text: " + text.text + " | Size: " + text.size + "| Color: " + text.color);
            System.out.println(new Position(text.x, text.y, false));
            System.out.println("--");
        }
    }
    
    public int getySize() {
        return graphicClass.ySize;
    }

    public void setySize(int ySize) {
//        nTimesXResized++;
//        System.out.println("setySize(ShowingGraphic): " + this.graphicClass.ySize + " to " + ySize);
        double yFactor = ySize*1.0/this.graphicClass.ySize;
//        System.out.println("\t yFactor = " + yFactor);
        this.graphicClass.ySize = ySize;
        update(1, yFactor);
    }

    public int getxSize() {
        return graphicClass.xSize;
    }

    public void setxSize(int xSize) {
        nTimesXResized++;
//        System.out.println("setxSize(ShowingGraphic): " + this.graphicClass.xSize + " to " + xSize);
        double xFactor = xSize*1.0/this.graphicClass.xSize;
//        System.out.println("\t xFactor = " + xFactor);
        this.graphicClass.xSize = xSize;
        update(xFactor, 1);
    }
    public void setYXSize(int y, int x){
        setYXSize(new Dimension(x, y));
    }
    public void setYXSize(Dimension d){
        int xSize = d.width;
        int ySize = d.height;
        
        nTimesXResized++;
//        System.out.println("setxSize(ShowingGraphic): " + this.graphicClass.xSize + " to " + xSize);
        double yFactor = ySize*700.0;
        double xFactor = xSize*700.0;
//        System.out.println("\t xFactor = " + xFactor);
        this.graphicClass.xSize = xSize;
        this.graphicClass.ySize = ySize;
        update(xFactor, yFactor);
    }
    
    public void setColumnsSize(int columnsSize){
        this.graphicClass.rowSize = columnsSize;
        int beforeUpdate = this.updateMode;
        this.updateMode = UPDATE_MODE_DELETE_NOTHING;
        double yFactor = graphicClass.ySize*700.0;
        double xFactor = graphicClass.xSize*700.0;
        update(xFactor, yFactor);
        this.updateMode = beforeUpdate;
    }
    
    public void setRowsSize(int rowSize){
        this.graphicClass.columnSize = rowSize;
        int beforeUpdate = this.updateMode;
        this.updateMode = UPDATE_MODE_DELETE_NOTHING;
        double yFactor = graphicClass.ySize*700.0;
        double xFactor = graphicClass.xSize*700.0;
        update(xFactor, yFactor);
        this.updateMode = beforeUpdate;
    }
    public void setRCSize(int row, int column){
        setCRSize(new Dimension(column, row));
    }
    public void setCRSize(Dimension d){
        this.graphicClass.rowSize = d.width;
        this.graphicClass.columnSize = d.height;
        int beforeUpdate = this.updateMode;
        this.updateMode = UPDATE_MODE_DELETE_NOTHING;
        update(1, 1);
        this.updateMode = beforeUpdate;
    }
    
    public void update(double xFactor, double yFactor){
        init();
//        System.out.println("update(ShowingGraphic)1: ");
//        showLanesOnLogger();

        
        if (!(updateMode == UPDATE_MODE_DELETE_TEXTS
                || updateMode == UPDATE_MODE_DELETE_TEXTS_AND_LANES
                || updateMode == UPDATE_MODE_DELETE_ALL
                || updateMode == UPDATE_MODE_DELETE_BACKGROUNDS_AND_TEXTS)) {
            updateTexts(xFactor, yFactor);
        }
        
        if (!(updateMode == UPDATE_MODE_DELETE_BACKGROUNDS
                || updateMode == UPDATE_MODE_DELETE_BACKGROUNDS_AND_LANES
                || updateMode == UPDATE_MODE_DELETE_ALL
                || updateMode == UPDATE_MODE_DELETE_BACKGROUNDS_AND_TEXTS)) {
            updateBackgrounds(xFactor, yFactor);
        }
        
        if (!(updateMode == UPDATE_MODE_DELETE_LANES
                || updateMode == UPDATE_MODE_DELETE_TEXTS_AND_LANES
                || updateMode == UPDATE_MODE_DELETE_ALL
                || updateMode == UPDATE_MODE_DELETE_BACKGROUNDS_AND_LANES)) {
            updateLanes(xFactor, yFactor);
        }
    }
    private void updateLanes(double xFactor, double yFactor){
        int nLanes = lanes.size();
    //        System.out.println("Lanes Array Size : " + nLanes);
            for (int i = 0; i < nLanes; i++) {
                Lane actualLane = lanes.get(i);

                actualLane.p1.x *= xFactor;
                actualLane.p1.y *= yFactor;
                actualLane.p2.x *= xFactor;
                actualLane.p2.y *= yFactor;
    //            System.out.println("puttingLane(" + i + "): " + actualLane);

                graphicClass.addLane(actualLane.p1, actualLane.p2, actualLane.color);
    //            System.out.println("OK");
            }
    }
    private void updateTexts(double xFactor, double yFactor){
        int nTexts = texts.size();
            for (int i = 0; i < nTexts; i++) {
                Text actualText = texts.get(i);

                actualText.x /= yFactor;
                actualText.y /= xFactor;
    //            System.out.println("puttingText(" + i + "): " + actualText);

                graphicClass.addText(actualText.text, actualText.x, actualText.y, actualText.color, actualText.size ,actualText.nLettersByLane, actualText.xAlignment, actualText.yAlignment);
    //            System.out.println("OK");
            }
    }
    private void updateBackgrounds(double xFactor, double yFactor){
        int nGrids = grids.size();
            for (int i = 0; i < nGrids; i++) {
                Grid actualGrid = grids.get(i);

                actualGrid.xSize *= yFactor;
                actualGrid.ySize *= xFactor;
    //            System.out.println("puttingGrid(" + i + "): " + actualGrid);

                graphicClass.addGrid(actualGrid);
    //            System.out.println("OK");
            }
    }
}
