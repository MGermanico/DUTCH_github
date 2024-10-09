/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dutch.back.comprobator;

import dutch.Dutch;
import java.util.Scanner;

/**
 *
 * @author migue
 */
public class ReadCommands extends Thread{
    Dutch owner;
    Scanner sc;
    public ReadCommands(Dutch owner){
        this.owner = owner;
    }
    public void run(){
        sc = new Scanner(System.in);
        String inp;
        for (;;) {
            inp = sc.nextLine();
            if (inp.contains("setSize")) {
                if (inp.matches("setSize\\(\\d*, ?\\d*\\)")) {
                    setSize(inp);
                }else{
                    System.out.println("ERROR:\t\tsetSize('numero','numero)");
                }
            }
        }
    }
    public void setSize(String str){
        str = str.replace("setSize", "").replace("\\)", "");
        str = str.substring(1, str.length() - 1);
        String parts[] = str.split(",");
        this.owner.setRCSize(
        Integer.parseInt(parts[0].trim()),
        Integer.parseInt(parts[1].trim()));
        this.owner.dutchManager.table.remakeLanes();
    }
}
