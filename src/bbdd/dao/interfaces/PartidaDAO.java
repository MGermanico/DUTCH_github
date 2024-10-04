/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bbdd.dao.interfaces;

import bbdd.dao.pojo.Partida;
import bbdd.dao.variables.MyDate;
import bbdd.dao.variables.Nickname;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 *
 * @author tarde
 */
public interface PartidaDAO {
    //getters
    public ArrayList<Partida> getPartidas() throws Exception;
    public Partida            getPartidaByWId(Object idPartida) throws Exception;
    public ArrayList<Partida> getPartidasByFiltro(Object idPartida, MyDate fecha, Nickname nickGanador) throws Exception; 
    
    //redundant getters
}
