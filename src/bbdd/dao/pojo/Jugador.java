/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bbdd.dao.pojo;

import bbdd.dao.variables.MyColor;
import bbdd.dao.variables.Nickname;
import exceptions.InvalidFormatException;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.StringUtils;

/**
 *
 * @author tarde
 */
public class Jugador {
    private Nickname nickname;
    private MyColor ultimoColor;
    private int numeroVictorias;
    private int numeroPuntosTotales;
    private int NumeroPartidasJugadas;

    public Jugador(Nickname nickname) {
        this.nickname = nickname;
    }
    
    public Nickname getNickname() {
        return nickname;
    }

    public void setNickname(Nickname nickname)  {
        this.nickname = nickname;
    }

    public MyColor getUltimoColor() {
        return ultimoColor;
    }

    public void setUltimoColor(MyColor ultimoColor) {
        this.ultimoColor = ultimoColor;
    }

    public int getNumeroVictorias() {
        return numeroVictorias;
    }

    public void setNumeroVictorias(int numeroVictorias) {
        this.numeroVictorias = numeroVictorias;
    }

    public int getNumeroPuntosTotales() {
        return numeroPuntosTotales;
    }

    public void setNumeroPuntosTotales(int numeroPuntosTotales) {
        this.numeroPuntosTotales = numeroPuntosTotales;
    }

    public int getNumeroPartidasJugadas() {
        return NumeroPartidasJugadas;
    }

    public void setNumeroPartidasJugadas(int NumeroPartidasJugadas) {
        this.NumeroPartidasJugadas = NumeroPartidasJugadas;
    }
    
    public void setName(String name) throws InvalidFormatException{
        this.setNickname(new Nickname(name));
    }
            
    public String getName(){
        return this.getNickname().getStr();
    }
    
    public void setColor(Color color){
        int r = color.getRed();
        int g = color.getGreen();
        int b = color.getBlue();
        try {
            this.setUltimoColor(new MyColor(r + "," + g + "," + b));
        } catch (InvalidFormatException ex) {
            Logger.getLogger(Jugador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Color getColor(){
        String rgb[] = this.getUltimoColor().getStr().split(",");
        return new Color(Integer.parseInt(rgb[0]), Integer.parseInt(rgb[1]), Integer.parseInt(rgb[2]));
    }
    
    @Override
    public String toString(){
        return ":Jugador: " + 
                StringUtils.setLong(this.getNickname().toString(), 25, true) + " , " +
                StringUtils.setLong(this.getUltimoColor().getStr(), 12, true) + " , " + 
                StringUtils.setLong(this.getNumeroVictorias() + "", 4, true) + " , " + 
                StringUtils.setLong(this.getNumeroPuntosTotales()+"", 4, true) + " , " + 
                StringUtils.setLong(this.getNumeroPartidasJugadas() + "", 4, true);
    }
}
