/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dutch.menu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import utils.Utils;

/**
 *
 * @author migue
 */
public class DefaultMenu extends JPanel{
    
    Menu owner;
    
    JButton startButton;
    JButton seeLogButton;
    JButton stadisticButton;
    
    JPanel panelBag = new JPanel();
    
    public DefaultMenu(Menu owner){
        this.owner = owner;
        panelBag.setLayout(new GridLayout(3, 1, 15, 15));
        Utils.setSize(panelBag, new Dimension(400, 300));
        initStartButton();
        initSeeLogButton();
        initStadisticButton();
        setContainers();
    }
    
    public void setContainers(){
        panelBag.add(startButton);
        panelBag.add(seeLogButton);
        panelBag.add(stadisticButton);
        this.add(panelBag);
    }
    
    public void seeLogAction(){
        owner.setUp(2);
    }
    
    public void startGameAction(){
        owner.setVisible(false);
        owner.manager.startGame();
        
    }
    
    public void initStartButton(){
        startButton = new JButton("NUEVA PARTIDA");
        startButton.setFont(new java.awt.Font("Dialog", 1, 17));
        startButton.setForeground(Color.LIGHT_GRAY);
        startButton.setBackground(Color.BLACK);
        startButton.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 10));
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startGameAction();
            }
        });
    }
    
    public void initSeeLogButton(){
        seeLogButton = new JButton("VER HISTORIAL");
        seeLogButton.setFont(new java.awt.Font("Dialog", 1, 17));
        seeLogButton.setForeground(Color.LIGHT_GRAY);
        seeLogButton.setBackground(Color.BLACK);
        seeLogButton.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 10));
        seeLogButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seeLogAction();
            }
        });
    }
    
    public void initStadisticButton(){
        stadisticButton = new JButton("ESTADÍSTICAS");
        stadisticButton.setFont(new java.awt.Font("Dialog", 1, 17));
        stadisticButton.setForeground(Color.LIGHT_GRAY);
        stadisticButton.setBackground(Color.BLACK);
        stadisticButton.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 10));
        stadisticButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        stadisticButton.setEnabled(false);
    }
}
