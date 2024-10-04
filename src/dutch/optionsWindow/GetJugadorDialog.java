/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dutch.optionsWindow;

import bbdd.biz.DataBaseManager;
import bbdd.dao.pojo.Jugador;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author migue
 */
public class GetJugadorDialog extends JDialog{
    JPanel nicknamesToChoose;
    Box verticalBox = Box.createVerticalBox();
    
    public GetJugadorDialog(JDialog owner) throws Exception{
        super(owner, true);
        this.setSize(400, 400);
        init();
        this.setVisible(true);
    }
    
    public void init() throws Exception{
        System.out.println("???");
        nicknamesToChoose = new JPanel();
        System.out.println("???");
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
        System.out.println("si");
        for (Jugador jugador : jugadores) {
            System.out.println(jugador);
            actualHorizontalBox = Box.createHorizontalBox();
            
            actualName = new JLabel(jugador.getNickname().toString());
            actualHorizontalBox.add(actualName);
            
            actualSelectButton = new JButton();
            actualHorizontalBox.add(actualSelectButton);
            
            verticalBox.add(actualHorizontalBox);
        }
    }
}
