/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exec;

import dutch.DutchManager;
import dutch.Options;
import table.Player;
import graphic.Cell;
import graphic.Graphic;
import graphic.Lane;
import graphic.Position;
import graphic.ShowingGraphic;
import graphic.Text;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import utils.Config;
import utils.Utils;

/**
 *
 * @author migue
 */
public class Dutch extends JFrame{
    
    JLabel separation0t1 = new JLabel();
    JLabel separation1t2 = new JLabel();
    JLabel separation2t0 = new JLabel();
    JLabel separation1t11 = new JLabel();
    JLabel separation11t12 = new JLabel();
    JLabel separation12t13 = new JLabel();
    JLabel separation13t131 = new JLabel();
    JLabel separation13t14 = new JLabel();
    JLabel separation14t1 = new JLabel();
    
    DutchManager dutchManager;
    
    public ArrayList<Player> players;
    
    public ShowingGraphic showingGraphic;
    
    Box box0 = Box.createHorizontalBox();
    Box box1 = Box.createVerticalBox();
    Box box11 = Box.createHorizontalBox();
    Box box12 = Box.createHorizontalBox();
    public Box box13 = Box.createHorizontalBox();
    public Box box14 = Box.createHorizontalBox();
    Box box2 = Box.createVerticalBox();
    
    JSeparator separator131t132 = new JSeparator(SwingConstants.VERTICAL);
    
    public Dutch(){
        initComponents();
        
        createBackGroundGrid();
        
        setySize(1);
        setxSize(1);
        
//        test();
    }
    
    private void initComponents(){
        this.setVisible(true);
        this.setSize(1400, 900);
        
        initBoxes();
        
        separator131t132.setBackground(Color.GRAY);
        Utils.setSize(separator131t132, new Dimension(5, (int) (box13.getHeight()*0.85)));
        
        players = new ArrayList<>();
        players = Config.players;
        
        dutchManager = new DutchManager(Config.nGames, this);
        
        showingGraphic = new ShowingGraphic((int)(750*0.50), (int)(1100*0.7), 10, 10, 2);// (y, x) IMPORTANTE, SE PONE EN ESE ORDEN
        
        updateComponents();
    }
    
    private void initBoxes(){// y tengo que hacer la tabla
        box0.setBorder(BorderFactory.createLineBorder(Color.RED));
        box1.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        box2.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        box11.setBorder(BorderFactory.createLineBorder(Color.GREEN));
        box12.setBorder(BorderFactory.createLineBorder(Color.GREEN));
        box13.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
        box14.setBorder(BorderFactory.createLineBorder(Color.GREEN));
        
        Rectangle r = this.getBounds();
        double width = r.getWidth();
        double height = r.getHeight();

        Utils.setSize(box11, new Dimension((int)(width*0.68), (int)(height*0.13)));
        this.box1.add(box11);
        
        Utils.setSize(box12, new Dimension((int)(width*0.68), (int)(height*0.44)));
        this.box1.add(box12);
        
        Utils.setSize(box13, new Dimension((int)(width*0.68), (int)(height*0.14)));
        this.box1.add(box13);
        
        Utils.setSize(box14, new Dimension((int)(width*0.68), (int)(height*0.24)));
        this.box1.add(box14);
        
        Utils.setSize(box1, new Dimension((int)(width*0.7), (int)(height*1)));
        this.box0.add(box1);
        
        Utils.setSize(box2, new Dimension((int)(width*0.28), (int)(height*1)));
        this.box0.add(box2);
    }
    
    public void updateComponents(){
        this.setSize(1400, 900);
        
        this.box1.removeAll();
        this.box11.removeAll();
        this.box12.removeAll();
        this.box13.removeAll();
        this.box14.removeAll();
        this.box2.removeAll();
        
        initBoxes();
        
        showingGraphic.updateImage();
        box12.add(showingGraphic);
        
        
//        box13.add();
        
        box13.add(this.dutchManager.graphicHeightManager);
        
        box13.add(separator131t132);
        
        box14.add(this.dutchManager.table);
        Utils.setSize(this.dutchManager.table, this.dutchManager.table.getDimension());
        
        addSeparators();
        
//        dutchManager.graphicHeightManager.updatePanel();
        
        dutchManager.table.updateTable();
        
        this.add(box0);
        this.repaint();
        this.pack();
    }
    private void addSeparators(){
        
        Rectangle r = this.getBounds();
        double width = r.getWidth();
        double height = r.getHeight();
        
        Utils.setSize(separation0t1, new Dimension((int)(width*0.01), (int)(height*0.01)));
        box0.add(separation0t1, 0);
        
        Utils.setSize(separation1t2, new Dimension((int)(width*0.01), (int)(height*0.01)));
        box0.add(separation1t2, 3);
        
        Utils.setSize(separation2t0, new Dimension((int)(width*0.01), (int)(height*0.01)));
        box0.add(separation2t0, 4);
        
        Utils.setSize(separation1t11, new Dimension((int)(width*0.01), (int)(height*0.01)));
        box1.add(separation1t11, 0);
        
        Utils.setSize(separation11t12, new Dimension((int)(width*0.01), (int)(height*0.01)));
        box1.add(separation11t12, 2);
        
        Utils.setSize(separation12t13, new Dimension((int)(width*0.01), (int)(height*0.01)));
        box1.add(separation12t13, 4);
        
        Utils.setSize(separation13t14, new Dimension((int)(width*0.01), (int)(height*0.01)));
        box1.add(separation13t14, 6);
        
        
        
        Utils.setSize(separation13t131, new Dimension(5, 5));
        box13.add(separation13t131, 0);
        
        Utils.setSize(separation14t1, new Dimension((int)(width*0.01), (int)(height*0.01)));
        box1.add(separation14t1, 8);
    }
    public void addLane(Position p1, Position p2, double factorThickness, Color color){
        this.addLane(new Lane(p1, p2, color), factorThickness);
    }
    public void addLane(Lane lane, double factorThickness){
        this.showingGraphic.addLane(lane, factorThickness);
        updateComponents();
    }
    public void addLanes(ArrayList<Lane> lanes, double factorThickness){
        this.showingGraphic.addLanes(lanes, factorThickness);
        updateComponents();
    }
    
    public void addText(Text text){
        this.showingGraphic.addText(text);
        updateComponents();
    }
    
    private void createBackGroundGrid(){
        showingGraphic.addBackGrid(showingGraphic.getxSize(), showingGraphic.getySize(), new Color(232, 232, 232), 1);
        showingGraphic.graphicClass.addAxes();
        updateComponents();
    }
    
    public void setySize(int y){
        showingGraphic.setySize(y);
        updateComponents();
    }
    
    public void setxSize(int x){
        showingGraphic.setxSize(x);
        updateComponents();
    }
    
    private void test(){
        addText(new Text("Penes Mondongo ABCDEFGHIJ "
                , (int) Cell.proportionYToRow(2), (int) Cell.proportionXToColumn(1.5), 2, Color.BLUE, 20));
        
        addLane(new Position(0, 0, false), new Position(2, 1.5, false), 8, Color.GREEN);
        
        setySize(5);
        setxSize(7);
    }
}