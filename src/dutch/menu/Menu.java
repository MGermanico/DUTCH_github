/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dutch.menu;

import bbdd.dao.pojo.Jugador;
import bbdd.dao.variables.Nickname;
import dutch.DutchManager;
import dutch.menu.DefaultMenu;
import dutch.menu.LogMenu;
import dutch.menu.MenuManager;
import dutch.optionsWindow.Options;
import exceptions.InvalidFormatException;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import dutch.back.table.Table;
import utils.Config;
import utils.Utils;

/**
 *
 * @author migue
 */
public class Menu extends JFrame implements Runnable{
    public static void main(String[] args) {
        (new Menu()).run();
    }
    
    public static final int DEFAULT_MENU = 1;
    
    public MenuManager manager = new MenuManager(this);
    
    Box back = Box.createHorizontalBox();
    
    int width = 600;
    int height = 500;
    
    @Override
    public void run() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        
        this.setBounds(
            (int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2 - width/2),
            (int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2 - height/2),
            width,
            height);
        this.setLayout(new GridBagLayout());
        
        setUp(1);
        
        this.setVisible(true);
    }
    
    public void setUp(int type){
        back.removeAll();
        
        if (type == DEFAULT_MENU) {
            DefaultMenu dm = new DefaultMenu(this);
            back.add(dm);
        }else{
            LogMenu lm = new LogMenu(this);
            back.add(lm);
        }
        
        this.add(back);
        this.setVisible(true);
    }

    private static void presets(){
        ArrayList<Jugador> players = new ArrayList<Jugador>();
        Jugador j;
        try {
            j = (new Jugador(new Nickname("Miguel")));
            j.setColor(Color.yellow);
            players.add(j);
        } catch (InvalidFormatException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            j = (new Jugador(new Nickname("David")));
            j.setColor(Color.RED);
            players.add(j);
        } catch (InvalidFormatException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            j = (new Jugador(new Nickname("Ingrid")));
            j.setColor(Color.BLUE);
            players.add(j);
        } catch (InvalidFormatException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }

        Config.players = players;
        Config.nGames = 15;
    }
    
}
