/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dutch.optionsWindow;

import bbdd.biz.DataBaseManager;
import bbdd.dao.pojo.Jugador;
import bbdd.dao.variables.MyColor;
import bbdd.dao.variables.Nickname;
import dutch.menu.MenuManager;
import exceptions.InvalidFormatException;
import utils.Utils;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import utils.Config;
import static utils.Utils.randomizer;

/**
 *
 * @author migue
 */
public class Options extends JDialog{
    MenuManager menuManager;
    
    public Options(MenuManager mm){
        this.menuManager = mm;
        init();
    }
    
    int nGames = 15;
    JSpinner gamesCounterSpinner = new JSpinner();
    
    ArrayList<Jugador> players;
    
    Dimension box1Dimension = new Dimension(300, 300);
    Box box1 = Box.createVerticalBox();
    Box box11 = Box.createHorizontalBox();
    Box box12 = Box.createVerticalBox();
    Box box13 = Box.createVerticalBox();
    Box box14 = Box.createVerticalBox();
    
    Box box2 = Box.createVerticalBox();
    Box box21 = Box.createHorizontalBox();
    Box box22 = Box.createHorizontalBox();
    
    JSeparator separator = new JSeparator(SwingConstants.VERTICAL);
    
    private void init(){
        players = new ArrayList<>();
        gamesCounterSpinner.setValue(nGames);
        this.setModal(true);
        int width = 600;
        int height = 500;
        this.setBounds(0,0,width,height);
        this.setLocation(menuManager.owner.getLocation());
        this.setResizable(false);
//        this.setSize(600, 500);
//        this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
//        this.setUndecorated(true);
        initOptionWindow();
    }
    private void initBoxes(){
//        box1.setBorder(BorderFactory.createLineBorder(Color.BLUE));
//        box11.setBorder(BorderFactory.createLineBorder(Color.GREEN));
//        box12.setBorder(BorderFactory.createLineBorder(Color.GREEN));
//        box13.setBorder(BorderFactory.createLineBorder(Color.GREEN));
//        box14.setBorder(BorderFactory.createLineBorder(Color.GREEN));
//        
//        box2.setBorder(BorderFactory.createLineBorder(Color.BLUE));
//        box21.setBorder(BorderFactory.createLineBorder(Color.GREEN));
//        box22.setBorder(BorderFactory.createLineBorder(Color.GREEN));
        
        
        Utils.setSize(box1, box1Dimension);
        
//        setSize(box11, new Dimension(150, 50));
//        setSize(box12, new Dimension(300, 250));
//        setSize(box13, new Dimension(150, 50););
//        setSize(box14, new Dimension(150, 50););
//        setSize(box2, new Dimension(150, 50););
//        setSize(box21, new Dimension(150, 50););

        box1.add(box11);
        box1.add(box12);
        box1.add(box13);
        box1.add(box14);
        
        box2.add(box21);
        box2.add(box22);
    }
    private void initOptionWindow(){
        nGames = (int) this.gamesCounterSpinner.getValue();
        initBoxes();
            box1.add(Box.createVerticalStrut(15), 0);

                JLabel jugadoresLabel = new JLabel("JUGADORES");
                box11.add(jugadoresLabel);

            box1.add(Box.createVerticalStrut(15), 2);

                Dimension textDimension = new Dimension(150, 30);
                
                for (Jugador player : players) {
                    Box Box12X = Box.createHorizontalBox();
                    JLabel playerLabel = new JLabel(player.getName(), SwingConstants.CENTER);
                    playerLabel.setSize(textDimension);
                    playerLabel.setMinimumSize(textDimension);
                    playerLabel.setPreferredSize(textDimension);
                    playerLabel.setMaximumSize(textDimension);
                    Box12X.add(playerLabel);
                    
                    JButton changeColor = new JButton();
                    Utils.setSize(changeColor, new Dimension(15, 15));
                    System.out.println(player);
                    if(player.getUltimoColor().getStr() == null){
                        player.setColor(Utils.getRandomColor());
                    }
                    changeColor.setBackground(player.getColor());
                    changeColor.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            changeColor(player);
                        }
                    });
                    Box12X.add(changeColor);
                    box12.add(Box12X);
                }
            box1.add(Box.createVerticalStrut(15), 4);
                
                Box horizontalBox = Box.createHorizontalBox();

                    JButton addButton = new JButton();
                    addButton.setIcon(Utils.resizeImageByPath("./src/data/img/anyadir.png", 85, 25));
                    addButton.setBackground(Color.WHITE);
                    addButton.setBorder(null);
                    addButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            addPlayer();
                        }
                    });

                horizontalBox.add(addButton);
                box13.add(horizontalBox);
            box1.add(Box.createVerticalGlue(), 6);
            
                Box horizontalBox141 = Box.createHorizontalBox();

                    JButton acceptButton = new JButton("Aceptar");
                    if (players.size() < 2) {
                        acceptButton.setEnabled(false);
                    }
                    acceptButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            close();
                        }
                    });

                horizontalBox141.add(acceptButton);
                box14.add(horizontalBox141);
            box1.add(Box.createVerticalStrut(15));
        
        this.add(box1);
        
        this.add(separator);
        
            box2.add(Box.createVerticalStrut(15), 0);
            
                JLabel opcionesLabel = new JLabel("OPCIONES");
                box21.add(opcionesLabel);
            
            box2.add(Box.createVerticalStrut(12), 2);
            
                JLabel cuantasRondasLabel = new JLabel("Número de rondas:");
                box22.add(cuantasRondasLabel, 0);
                
                box22.add(Box.createHorizontalStrut(15), 1);
                
                this.gamesCounterSpinner.setValue(nGames);
                Utils.setSize(this.gamesCounterSpinner, new Dimension(50, 20));
                
                box22.add(gamesCounterSpinner);
            
            box2.add(Box.createVerticalStrut(15), 4);
            
        this.add(box2);
            
        this.setLayout(new FlowLayout());
        update();
        this.setVisible(true);
    }
    private void changeColor(Jugador player){
        player.setColor( JColorChooser.showDialog(this, "Elige un color", player.getColor(), false) );
        refresh();
    }
    public void addPlayer(){
        this.box13.remove(0);
        
            Box box131 = Box.createHorizontalBox();

            JButton closeButton = new JButton("");
            closeButton.setOpaque(false);
            closeButton.setIcon(Utils.resizeImageByPath("./src/data/img/cerrar.png", 35, 35));
            closeButton.setBackground(Color.WHITE);
            closeButton.setBorder(null);
            Utils.setSize(closeButton, new Dimension(35, 35));
            closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setPlayer("");
            }
            });

            JTextField textField = new JTextField();
            Utils.setSize(textField, new Dimension(165, 25));
            textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setPlayer(textField.getText());
            }
            });

            JButton downloadButton = new JButton();
            downloadButton.setOpaque(false);
            downloadButton.setIcon(Utils.resizeImageByPath("./src/data/img/descargar.png", 35, 35));
            downloadButton.setBackground(Color.WHITE);
            downloadButton.setBorder(null);
            Utils.setSize(downloadButton, new Dimension(35, 35));
            downloadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Jugador jugador = getPlayer();
                if (jugador != null) {
                    setPlayer(jugador);
                }
            }
            });
            
            JButton addButton = new JButton();
            addButton.setOpaque(false);
            addButton.setIcon(Utils.resizeImageByPath("./src/data/img/siguiente.png", 35, 35));
            addButton.setBackground(Color.WHITE);
            addButton.setBorder(null);
            Utils.setSize(addButton, new Dimension(35, 35));
            addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setPlayer(textField.getText());
            }
            });

            box131.add(closeButton);
            box131.add(Box.createHorizontalGlue());
            box131.add(textField);
            box131.add(Box.createHorizontalGlue());
            box131.add(downloadButton);
            box131.add(Box.createHorizontalGlue());
            box131.add(addButton);
        
        this.box13.add(box131);
            
        update();
    }
    public Jugador getPlayer(){
        try {
            GetJugadorDialog gjd = new GetJugadorDialog(this, box12.getComponentCount());
            Jugador jugador = gjd.jugadorSelected;
            return jugador;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
    public void setPlayer(String name){
        if (name != null && !name.equals("")) {
            try {
                DataBaseManager dbm = new DataBaseManager();
                Jugador j = dbm.getJugadorByName(name);
                if(j == null){
                    j = new Jugador(new Nickname(name));
                    j.setColor(new Color((int)randomizer(0d, 255d), (int)randomizer(0d, 255d), (int)randomizer(0d, 255d)));
                }
                setPlayer(j);
            } catch (InvalidFormatException ex) {
                Logger.getLogger(Options.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(Options.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (players.size() >= 6) {
                addSize(box1Dimension, 0, 30);
            }
        }
        refresh();
    }
    public void setPlayer(Jugador jugador){
        if (!isAlreadyOnList(jugador)) {
            players.add(jugador);
        }
        refresh();
    }
    public void refresh(){
        this.box1.removeAll();
        this.box11.removeAll();
        this.box12.removeAll();
        this.box13.removeAll();
        this.box14.removeAll();
        this.box2.removeAll();
        this.box21.removeAll();
        this.box22.removeAll();
        initOptionWindow();
        update();
    }
    public void setColorToPlayer(Color color, String name){
        for (Jugador player : players) {
            if (player.getName().equals(name)) {
                player.setColor(color);
            }
        }
    }
    public void update(){
        this.pack();
        separator.setPreferredSize(new Dimension(10, (int)(this.getHeight()/1.5)));
        this.pack();
    }
    
    private void addSize(Dimension d, int widthAdder, int heightAdder){
        d.width += widthAdder;
        d.height += heightAdder;
    }
    public void close(){
        Config.players = players;
        Config.nGames = (int) this.gamesCounterSpinner.getValue();
        this.dispose();
    }
    public boolean isAlreadyOnList(Jugador j){
        for (Jugador player : players) {
            if (player.getName().equals(j.getName())) {
                return true;
            }
        }
        return false;
    }
}
