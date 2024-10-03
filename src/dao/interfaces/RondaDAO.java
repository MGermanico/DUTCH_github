/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.interfaces;

import dao.pojo.Ronda;
import dao.variables.Nickname;
import java.util.ArrayList;

/**
 *
 * @author tarde
 */
public interface RondaDAO {
    //getters
    public ArrayList<Ronda> getRondas() throws Exception;
    public Ronda            getRondaById(Object idPartida, Nickname nickname, Object numero) throws Exception;
    public ArrayList<Ronda> getRondaByFiltro(Object idPartida, Nickname nickname,
            Object numero, Object puntos, Object puntosTotales) throws Exception;
    
    //redundant getters
    public ArrayList<Ronda> getRondasByIdPartidaAndNickname(Object idPartida, Nickname nickname) throws Exception;
}
