/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exec;

import dutch.Options;
import table.Player;
import java.awt.Color;
import java.util.ArrayList;
import utils.Config;

/**
 *
 * @author migue
 */
public class Exec{
    public static void main(String[] args) {
//        Options optionWindow = new Options();
        presets();
        Dutch window = new Dutch();
        
    }
    private static void presets(){
        ArrayList<Player> players = new ArrayList<Player>();
        players.add(new Player("a", Color.magenta));
        players.add(new Player("b", Color.red));
        players.add(new Player("c", Color.blue));
        players.add(new Player("c", Color.blue));
        players.add(new Player("c", Color.blue));
        players.add(new Player("c", Color.blue));
        players.add(new Player("c", Color.blue));
        players.add(new Player("c", Color.blue));
        players.add(new Player("c", Color.blue));

        Config.players = players;
        Config.nGames = 15;
    }
}
