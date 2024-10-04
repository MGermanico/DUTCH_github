/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bbdd.biz;

import bbdd.dao.implementation.JugadorDAOImpl;
import bbdd.dao.pojo.Jugador;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author migue
 */
public class DataBaseManager {
    public ArrayList<Jugador> getJugadoresToList() throws SQLException, Exception{
        JugadorDAOImpl jdi = new JugadorDAOImpl();
        ArrayList<Jugador> jugadores = jdi.getJugadores();
        return jugadores;
    }
}
