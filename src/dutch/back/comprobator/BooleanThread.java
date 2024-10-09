/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dutch.back.comprobator;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author migue
 */
public class BooleanThread extends Thread{
    SizeComprobator owner;
    
    public BooleanThread(SizeComprobator owner){
        this.owner = owner;
    }
    
    @Override
    public void run(){
        try {
            System.out.println("ON");
            Thread.sleep(1500);
            System.out.println("OFF");
        } catch (InterruptedException ex) {
            Logger.getLogger(BooleanThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        owner.update();
    }
}
