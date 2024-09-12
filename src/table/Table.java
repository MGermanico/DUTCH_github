/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package table;

import dutch.DutchManager;
import exec.Dutch;
import graphic.Lane;
import graphic.Position;
import graphic.ShowingGraphic;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import utils.Config;
import utils.Utils;

/**
 *
 * @author migue
 */
public class Table extends JPanel{
    DutchManager managerParent;
    
    JPanel grid = new JPanel();
    JScrollPane scrollPane;
    Box tableBox = Box.createHorizontalBox();
    Map<Player, ArrayList<TableCell>> gameTable;
    
    public Table(int nGames, DutchManager parent){
        this.setBorder(BorderFactory.createLineBorder(Color.RED));
        gameTable = new HashMap<Player, ArrayList<TableCell>>();
        this.managerParent = parent;
        grid.setLayout(new GridLayout(this.managerParent.parent.players.size(), nGames + 1));
        initTable(Config.nRoundsActived, parent.parent.box14.getBounds());
    }
    private void initTable(int nGames, Rectangle r){
        this.grid.removeAll();
        this.tableBox.removeAll();
        this.grid.removeAll();
        
        ArrayList<TableCell> guyGame;
        
        int width = (int) r.getWidth() - 75;
        int height = (int) r.getHeight();
//        System.out.println(width + " , " + height);
        
        Dimension gridDimension;
//        System.out.println("=? " + height/3);
//        System.out.println("-- " + height/parent.players.size()*(Config.nRoundsActived+1));
        
        int nPlayers = managerParent.parent.players.size();
        int nRoundsActived = Config.nRoundsActived;
        int heightOfCell;
        
        if (nPlayers > 4) {
            heightOfCell = height/4;
        }else{
            heightOfCell = height/nPlayers;
        }
        
        int widthOfCell = heightOfCell;
        gridDimension = new Dimension(widthOfCell * (nRoundsActived+1), heightOfCell*nPlayers);
        
        Utils.setSize(grid, gridDimension);
        JLabel nameLabel;
        for (Player player : this.managerParent.parent.players) {
            guyGame = new ArrayList<TableCell>();
            
            nameLabel = new JLabel(player.name);
            Utils.centerLabel(nameLabel);
            grid.add(nameLabel);
            
            for (int i = 1; i < nGames + 1; i++) {
                TableCell cell;
                try{
                    cell = new TableCell(i, gameTable.get(player).get(i - 1).value);
                }catch(IndexOutOfBoundsException | NullPointerException ex){
                    cell = new TableCell(i, 0);
                }
                guyGame.add(cell);
                
            }
            gameTable.put(player, guyGame);
        }
        scrollPane = new JScrollPane(grid);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        int widthOfScrollPane = widthOfCell*(nRoundsActived+1) + 20;
        if (widthOfScrollPane > width) {
            widthOfScrollPane = width;
        }
        scrollPane.setBounds(0, 0, widthOfScrollPane, height);
        scrollPane.setBorder(null);
        JPanel contentPane = new JPanel(null);
        contentPane.setPreferredSize(new Dimension(widthOfScrollPane, height));
        contentPane.add(scrollPane);
        this.tableBox.add(contentPane);
        this.add(tableBox);
    }
    public void updateTable(){
        JButton button;
        
        
        grid.removeAll();
        for (int i = 1; i < tableBox.getComponentCount(); i++) {
             tableBox.remove(i);
        }
        
        JLabel nameLabel;
        
        for (Player player : gameTable.keySet()) {
             ArrayList<TableCell> row = gameTable.get(player);
             nameLabel = new JLabel(player.name+ " (" + getSummedPoints(player) + ")");
             nameLabel.setForeground(player.color);
             grid.add(nameLabel);
            for (TableCell cell : row) {
                button = new JButton(cell.value + "");
                button.setBackground(Color.WHITE);
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        buttonAction(cell, player);
                    }
                });
                grid.add(button);
            }
        }
        if (Config.nRoundsActived < Config.nGames) {
            button = new JButton("+");
            button.setBackground(new Color(215, 255, 215));
            Utils.setSize(button, new Dimension(50, this.tableBox.getHeight()));
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    addRoundButton();
                }
            });
            this.tableBox.add(button);
        }
        
    }
    public int getSummedPoints(Player player){
        ArrayList<TableCell> gamesOfPlayer = gameTable.get(player);
        int total = 0;
        for (TableCell tableCell : gamesOfPlayer) {
            total += tableCell.value;
        }
        return total;
    }
    private void addRoundButton(){
        Config.nRoundsActived++;
        initTable(Config.nRoundsActived, managerParent.parent.box14.getBounds());
        remakeLanes();
        this.managerParent.parent.updateComponents();
    }
    private void buttonAction(TableCell cell, Player player){
        int points = -666;
        boolean isNumber = false;
        do {
            try{
                points = Integer.parseInt(JOptionPane.showInputDialog("a"));
                isNumber = true;
            }catch(NumberFormatException ex){
            }
        } while (!isNumber);
        addPtsToGuy(player, cell.nGame, points);
        this.managerParent.refreshXYGraphicSize();
        remakeLanes();
        this.managerParent.parent.updateComponents();
    }
    
    private void addNewLane(TableCell cell, Player player){
        Map<Player, ArrayList<TableCell>> gameSummedTable = this.getSumTable();
        
        ArrayList<TableCell> playerSummedGames = gameSummedTable.get(player);
        
        int beforeNGame = cell.nGame - 1;
        int beforeValue;
        if (beforeNGame == 0) {
            beforeValue = 0;
        }else{
            beforeValue = playerSummedGames.get(beforeNGame - 1).value;
        }
        Position p1 = new Position(beforeNGame, beforeValue, false);
        
        TableCell playerSummedCell = playerSummedGames.get(cell.nGame - 1);
        int actualNGame = playerSummedCell.nGame;
        int actualValue = playerSummedCell.value;
        Position p2 = new Position(actualNGame, actualValue, false);
        
        managerParent.parent.addLane(p1, p2, 2, player.color);
    }
    public void remakeLanes(){
        
        this.managerParent.refreshXYGraphicSize();
        ArrayList<Lane> lanesToDo = new ArrayList<>();
        
        managerParent.parent.showingGraphic.updateMode = ShowingGraphic.UPDATE_MODE_DELETE_LANES;
        
        Position p1 = null;
        Position p2 = null;
        
        Map<Player, ArrayList<TableCell>> gameSummedTable = this.getSumTable();
                
        TableCell beforeCell;
        TableCell actualCell;
        
        ArrayList<TableCell> playerSummedGames;
        Lane actualLane;
        for (Player player : gameSummedTable.keySet()) {
            playerSummedGames = gameSummedTable.get(player);
            for (int i = 1; i < Config.nRoundsActived + 1; i++) {
//                System.out.println(i);
//                System.out.println(" si");
                if (i != 1) {
                    beforeCell = playerSummedGames.get(i - 2);
                }else{
                    beforeCell = new TableCell(i, 0);
                }
                actualCell = playerSummedGames.get(i - 1);
                p1 = new Position(i-1, beforeCell.value, false);
                p2 = new Position(i, actualCell.value, false);
                actualLane = new Lane(p1, p2, player.color);
                lanesToDo.add(actualLane);
            }
        }
        managerParent.parent.addLanes(lanesToDo, 2);
//        managerParent.showingGraphic.updateMode = ShowingGraphic.UPDATE_MODE_DELETE_NOTHING;
    }
    
    public Map<Player, ArrayList<TableCell>> getSumTable(){
        Map<Player, ArrayList<TableCell>> ret = new HashMap<Player, ArrayList<TableCell>>();
        ArrayList<TableCell> guyGame;
        TableCell newCell;
        int total;
        for (Player player : gameTable.keySet()) {
            guyGame = new ArrayList<TableCell>();
            total = 0;
            for (TableCell actualCell : gameTable.get(player)) {
                total += actualCell.value;
                newCell = new TableCell(actualCell.nGame, total);
                guyGame.add(newCell);
            }
            ret.put(player, guyGame);
        }
        return ret;
    }
    
    
    public void setGuyGame(String namePlayer, int index, int value){
        gameTable.get(namePlayer).set(index, new TableCell(index, value));
    }
    public void addPtsToGuy(Player player, int index, int value){
        TableCell cell = this.gameTable.get(player).get(index - 1);
        cell.value = value;
        
    }
    
    public void showTableOnLogger(){
        System.out.println("showTableOnLogger(DutchManager): ");
        for (Player player : this.managerParent.parent.players) {
            System.out.print("\t" + player + " : " + gameTable.get(player) + "\n");
        }
    }
    public void showSumTableOnLogger(){
        System.out.println("showSumTableOnLogger(DutchManager): ");
        Map<Player, ArrayList<TableCell>> summedGameTable = this.getSumTable();
        for (Player player : this.managerParent.parent.players) {
            System.out.print("\t" + player + " : " + summedGameTable.get(player) + "\n");
        }
    }
    public Dimension getDimension(){
        Dimension d = this.scrollPane.getSize();
        
        d.width += 70;
        return d;
    }
    public int getMaxValue(){
        int actualValue;
        int max = Integer.MIN_VALUE;
        
        Map<Player, ArrayList<TableCell>> gameSummedTable = this.getSumTable();
        
        for (Player player : gameSummedTable.keySet()) {
            for (TableCell tableCell : gameSummedTable.get(player)) {
                actualValue = tableCell.value;
                if (actualValue > max) {
                    max = actualValue;
                }
            }
        }
        return max;
    }
}
