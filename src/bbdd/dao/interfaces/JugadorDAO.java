/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bbdd.dao.interfaces;

import bbdd.dao.pojo.Jugador;
import bbdd.dao.variables.MyColor;
import bbdd.dao.variables.Nickname;
import java.util.ArrayList;

/**
 *
 * @author tarde
 */
public interface JugadorDAO {
    //getters
    public ArrayList<Jugador> getJugadores() throws Exception;
    public Jugador            getJugadorByWId(Nickname nickname) throws Exception;
    public ArrayList<Jugador> getJugadoresByFiltro(Nickname nickname, MyColor ultimoColor,
            Object numeroVictorias, Object numeroPuntosTotales, Object numeroPartidasJugadas) throws Exception;
    
    //redundant getters
    public ArrayList<Jugador> getJugadoresByIdPartida(Object idPartida) throws Exception;
}
