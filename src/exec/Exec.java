/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exec;

import bbdd.dao.pojo.Jugador;
import bbdd.dao.variables.Nickname;
import dutch.optionsWindow.Options;
import exceptions.InvalidFormatException;
import java.awt.Color;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.Config;

/**
 *
 * @author migue
 */
public class Exec{
    public static void main(String[] args) {
        Options optionWindow = new Options();
//        presets();
        Dutch window = new Dutch();
        
    }
    private static void presets(){
        ArrayList<Jugador> players = new ArrayList<Jugador>();
        Jugador j;
        try {
            j = (new Jugador(new Nickname("Miguel")));
            j.setColor(Color.yellow);
            players.add(j);
        } catch (InvalidFormatException ex) {
            Logger.getLogger(Exec.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            j = (new Jugador(new Nickname("David")));
            j.setColor(Color.RED);
            players.add(j);
        } catch (InvalidFormatException ex) {
            Logger.getLogger(Exec.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            j = (new Jugador(new Nickname("Ingrid")));
            j.setColor(Color.BLUE);
            players.add(j);
        } catch (InvalidFormatException ex) {
            Logger.getLogger(Exec.class.getName()).log(Level.SEVERE, null, ex);
        }

        Config.players = players;
        Config.nGames = 15;
    }
}
