/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dutch.menu;

import dutch.DutchManager;
import dutch.optionsWindow.Options;
import dutch.Dutch;
import dutch.back.table.Table;
import utils.Config;

/**
 *
 * @author migue
 */
public class MenuManager {
    
    public Menu owner;
    
    public MenuManager(Menu owner){
        this.owner = owner;
    }
    
    public void startGame(){
        Options optionWindow = new Options(this);
        if (Config.players == null) {
            owner.setVisible(true);
            owner.setLocation(optionWindow.getLocation());
        }else{
            Dutch game = new Dutch();
            endGame(game);
        }
    }
    
    public void endGame(Dutch game){
        DutchManager gameManager = game.dutchManager;
        Table table = gameManager.table;
    }
}
