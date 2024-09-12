/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exec;

import dutch.DutchManager;
import table.Player;
import graphic.Position;
import graphic.ShowingGraphic;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import utils.Config;

/**
 *
 * @author migue
 */
public class TestExec {
    private static JFrame back;
    private static Box backBox;
    private static DutchManager dutchManager;
    private static ShowingGraphic showingGraphic;
    private static JTable table;
    
    private static JButton addTextB;
            
    public static void main(String[] args) {
        init();
//        addTestLane();
    }
    private static void addTestLane(){
        showingGraphic.graphicClass.addLane(new Position(0, 0, false), new Position(3, 5, false), Color.black);
        showingGraphic.updateImage();
    }
    public static void init(){
        compInit();
        
        backInit();
        
        addComps();
        
        back.pack();
    }
    private static void compInit(){
        backBox = Box.createVerticalBox();
        
        dutchInit();
        
        tableInit();
        
//        showingGraphic = new ShowingGraphic();
        
        showingGraphic.updateImage();
        
        addTextB = new JButton("SI");
        
        addTextB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addTestLane();
                update();
            }
        });
    }
    private static void dutchInit(){
        ArrayList<Player> players = new ArrayList<Player>();
//        players.add("Miguel");
//        players.add("Ingrid");
//        players.add("David");
        
//        dutchManager = new DutchManager(15, players);
    }
    private static void backInit(){
        back = new JFrame();
        back.setVisible(true);
        back.setSize(900, 600);
        back.setLayout(new FlowLayout());
    }
    private static void addComps(){
        backBox.add(showingGraphic);
        backBox.add(Box.createVerticalStrut(40));
        backBox.add(table);
        backBox.add(Box.createVerticalStrut(40));
        backBox.add(addTextB);
        back.add(backBox);
    }
    private static void tableInit(){
        table = new JTable(3, 15);
    }
    private static void update(){
        back.removeAll();
        backBox.removeAll();
        
        back.setVisible(true);
        back.setSize(900, 600);
        back.setLayout(new FlowLayout());
        
        showingGraphic.updateImage();
        
        addComps();
        
        back.pack();
    }
}
