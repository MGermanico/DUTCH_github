/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bbdd.dao.pojo;

import bbdd.dao.variables.MyDate;
import bbdd.dao.variables.Nickname;

/**
 *
 * @author tarde
 */
public class Partida {
    private int idPartida;
    private MyDate fecha;
    private Nickname nickGanador;

    public Partida(int idPartida) {
        this.idPartida = idPartida;
    }
    
    public int getIdPartida() {
        return idPartida;
    }

    public void setIdPartida(int idPartida) {
        this.idPartida = idPartida;
    }

    public MyDate getFecha() {
        return fecha;
    }

    public void setFecha(MyDate fecha) {
        this.fecha = fecha;
    }
    
    public Nickname getNickGanador() {
        return nickGanador;
    }

    public void setNickGanador(Nickname nickGanador) {
        this.nickGanador = nickGanador;
    }
    
    public String toString(){
        return ":Partida: " + this.idPartida + " , " + this.fecha + " , " + this.nickGanador;
    }
}
