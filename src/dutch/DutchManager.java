/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dutch;

import table.Table;
import graphic.GraphicHeightManager;
import exec.Dutch;
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
        int xSize = table.getMaxValue()+Config.graphicyAdderSize;
        if (xSize < 1) {
            xSize = 1;
        }
        graphicHeightManager.refreshYSize();
        parent.setxSize(xSize);
        parent.setySize(Config.nRoundsActived+Config.graphicxAdderSize);
    }
}
