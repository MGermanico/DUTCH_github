/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bbdd.dao.pojo;

import bbdd.dao.variables.Nickname;
import exceptions.InvalidFormatException;
import utils.StringUtils;

/**
 *
 * @author tarde
 */
public class Ronda {
    private int IdPartida ;
    private Nickname nickname;
    private int numero;
    private int puntos;
    private int puntosTotales;

    public Ronda(int IdPartida, Nickname nickname, int numero, int puntos, int puntosTotales) {
        this.IdPartida = IdPartida;
        this.nickname = nickname;
        this.numero = numero;
        this.puntos = puntos;
        this.puntosTotales = puntosTotales;
    }
    
    public int getIdPartida() {
        return IdPartida;
    }

    public void setIdPartida(int IdPartida) {
        this.IdPartida = IdPartida;
    }

    public Nickname getNickname() {
        return nickname;
    }

    public void setNickname(Nickname nickname) {
        this.nickname = nickname;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public int getPuntosTotales() {
        return puntosTotales;
    }

    public void setPuntosTotales(int puntosTotales) {
        this.puntosTotales = puntosTotales;
    }
    
    @Override
    public String toString(){
        return ":Ronda: " + 
                StringUtils.setLong(this.IdPartida+"", 4, false) + " , " + 
                StringUtils.setLong(this.nickname.toString(), 25, false)  + " , " + this.numero  + " , " + this.puntos + " , " + this.puntosTotales;
    }
}
