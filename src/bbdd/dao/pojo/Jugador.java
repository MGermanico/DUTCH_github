/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bbdd.dao.pojo;

import bbdd.dao.variables.MyColor;
import bbdd.dao.variables.Nickname;
import exceptions.InvalidFormatException;

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
    
    @Override
    public String toString(){
        return ":Jugador: " + this.getNickname() + " , " + this.getUltimoColor() + " , " + this.getNumeroVictorias() + " , " + this.getNumeroPuntosTotales() + " , " + this.getNumeroPartidasJugadas();
    }
}
