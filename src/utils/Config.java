/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import bbdd.dao.pojo.Jugador;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author migue
 */
public class Config {
    //Connection bbdd:
    private static String driver;
    private static String url;
    
    static{
        File configurationFile = new File("./configuration.csv");
        try(Scanner scFile = new Scanner(configurationFile)){
            url = scFile.nextLine();
            driver = scFile.nextLine();
        }catch(Exception ex){
            System.out.println("Error al cargar el archivo de configuración");
            System.exit(1);
        }
    }
    public static final String DRIVER = driver;
    
    public static final String URL = url;
    
    //ParticularConfig
    
    public static double thickness = 0.015;
    public static  ArrayList<Jugador> players = null;
    public static int nGames = 15;
    public static int nRoundsActived = 1;
    public static int tableSizeAdder = 0;
    public static int graphicxAdderSize = 0;
    public static int graphicyAdderSize = 1;
    
}
