/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dutch;

import dutch.back.table.Table;
import dutch.back.graphic.GraphicHeightManager;
import javax.swing.JSpinner;
import utils.Config;

/**
 *
 * @author migue
 */
public class DutchManager {
    public Dutch parent;
    
    public Table table;
    public GraphicHeightManager graphicHeightManager;
    
    
    public DutchManager(int nGames, Dutch parent){
        this.parent = parent;
        table = new Table(nGames, this);
        graphicHeightManager = new GraphicHeightManager(this);
    }
    public void refreshXYGraphicSize(){
//        System.out.println("siiiiiiiii");novabien
        System.out.println(table.getMaxValue());
        int ySize = table.getMaxValue() + 1;
        if (ySize < 1) {
            ySize = 1;
        }
        parent.setyxSize(Config.nRoundsActived+Config.graphicxAdderSize, ySize);
    }
}
