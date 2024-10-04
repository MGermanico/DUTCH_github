/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dutch.optionsWindow;

import bbdd.biz.DataBaseManager;
import bbdd.dao.pojo.Jugador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import utils.StringUtils;
import utils.Utils;

/**
 *
 * @author migue
 */
public class GetJugadorDialog extends JDialog{
    JPanel nicknamesToChoose;
    Box verticalBox = Box.createVerticalBox();
    int numberOfPlayer;
    Jugador jugadorSelected = null;
    
    public GetJugadorDialog(JDialog owner, int numberOfPlayer) throws Exception{
        super(owner, true);
        this.numberOfPlayer = numberOfPlayer;
//        this.setSize(400, 400);
        init();
        System.out.println(numberOfPlayer);
        this.setVisible(true);
    }
    
    public void init() throws Exception{
        nicknamesToChoose = new JPanel();
        initList();
        nicknamesToChoose.add(verticalBox);
        this.add(nicknamesToChoose);
    }
    
    public void initList() throws Exception{
        DataBaseManager dbm = new DataBaseManager();
        ArrayList<Jugador> jugadores = dbm.getJugadoresToList();
        JLabel actualName;
        JButton actualSelectButton;
        Box actualHorizontalBox;
        int maxWidth = 1;
        for (Jugador jugador : jugadores) {
            String name = jugador.getNickname().toString();
            if (name.length() > maxWidth) {
                maxWidth = name.length();
            }
        }
        for (Jugador jugador : jugadores) {
            System.out.println(jugador);
            actualHorizontalBox = Box.createHorizontalBox();
            
            String name = jugador.getNickname().toString();
            
            actualName = new JLabel(StringUtils.setLong(name, maxWidth + 3, false));
            actualName.setFont(new java.awt.Font("Padauk Book", 1, 24));
            actualHorizontalBox.add(actualName);
            
            actualSelectButton = new JButton();
            actualSelectButton.setIcon(Utils.resizeImageByPath("./src/data/img/flecha.png", 30, 30));
            actualSelectButton.setBorder(null);
            actualSelectButton.setOpaque(false);
            actualSelectButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    jugadorSelected = jugador;
                    dispose();
                }
            });
                    
            actualHorizontalBox.add(actualSelectButton);
            
            verticalBox.add(actualHorizontalBox);
        }
        this.setBounds(this.getOwner().getX() + 325, this.getOwner().getY() + 5 + this.numberOfPlayer*30, maxWidth*24 + 100, jugadores.size()*52);
    }
}
