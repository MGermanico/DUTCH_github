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
    public Ronda            getRondaById(int idPartida, Nickname nickname, int numero) throws Exception;
    public ArrayList<Ronda> getRondaByFiltro(int idPartida, Nickname nickname,
            int numero, int puntos, int puntosTotales) throws Exception;
    
    //redundant getters
    public ArrayList<Ronda> getRondasByIdPartidaAndNickname(int idPartida, Nickname nickname) throws Exception;
}
