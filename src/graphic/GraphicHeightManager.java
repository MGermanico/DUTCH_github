/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graphic;

import dutch.DutchManager;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import utils.Config;
import utils.Utils;

/**
 *
 * @author migue
 */
public class GraphicHeightManager extends JPanel{
    DutchManager managerParent;
    JSpinner gamesCounterSpinner;
    
    int yAdder = 1;
    int height = 1;
    
    public GraphicHeightManager(DutchManager parent){
        managerParent = parent;
        initHeightManager();
    }
    private void initHeightManager(){
        this.setVisible(true);
        
        gamesCounterSpinner = new JSpinner();
        gamesCounterSpinner.setValue(yAdder);
        gamesCounterSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                buttonAction();
            }
        });
        gamesCounterSpinner.setVisible(false);
    }
    private void buttonAction(){
        System.out.println("--");
        if ((int)gamesCounterSpinner.getValue() != height) {
            refreshYSize();
            System.out.println("..");
            
        }
        this.managerParent.table.remakeLanes();
    }
    public void refreshYSize(){
        int maxValue = this.managerParent.table.getMaxValue();
        yAdder = (int) this.gamesCounterSpinner.getValue() - maxValue;
        if (yAdder <= -maxValue) {
            yAdder = -maxValue + 1;
        }
        System.out.println(height + " = " + yAdder + " + " + maxValue);
        height = yAdder + maxValue;
        if (height <= maxValue) {
            height = maxValue + 1;
        }
        gamesCounterSpinner.setValue(height);
        Config.graphicyAdderSize = yAdder;
    }
}
