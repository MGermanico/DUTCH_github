/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dutch.back.comprobator;

import dutch.Dutch;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.Config;
import utils.MathUtils;

/**
 *
 * @author migue
 */
public class SizeComprobator extends Thread{

    Dutch owner;
    BooleanThread isActivated = new BooleanThread(this);
    
    public SizeComprobator(int lastWidth, int lastHeight, Dutch owner) {
        this.owner = owner;
    }
    
    @Override
    public void run(){
        boolean com;
        for (;;) {
            com = comprobation();
            try {
//                Thread.sleep(1500);
                if (com) {
                    Thread.sleep(60);
                }else{
                    Thread.sleep(20);
                }
                
            } catch (InterruptedException ex) {
                Logger.getLogger(SizeComprobator.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public boolean comprobation(){
        boolean update = false;
        if (owner.width != owner.getWidth()) {
            owner.width = owner.getWidth();
            update = true;
        }
        
        if (owner.height != owner.getHeight()) {
            owner.height = owner.getHeight();
            update = true;
        }
        if (update) {
            update();
        }
        return update;
    }
    public void update(){
        System.out.println("UPDATEEEE");
        Config.thickness = owner.width*.000015;
        owner.setRCSize((int)(owner.height*0.34), (int)(owner.width*0.65));
        owner.dutchManager.table.remakeLanes();
    }
}
