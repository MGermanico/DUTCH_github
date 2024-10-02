/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.pojo;

import dao.variables.Nickname;
import exceptions.InvalidFormatException;

/**
 *
 * @author tarde
 */
public class PartidaIndividual {
    private int IdPartida;
    private Nickname nickname;

    public PartidaIndividual(int IdPartida, Nickname nickname) {
        this.IdPartida = IdPartida;
        this.nickname = nickname;
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

    public void setNickname(Nickname nickname)  {
        this.nickname = nickname;
    }
    
    
}
