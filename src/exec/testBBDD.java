/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exec;

import dao.implementation.JugadorDAOImpl;
import dao.pojo.Jugador;
import dao.variables.Nickname;
import java.util.ArrayList;

/**
 *
 * @author migue
 */
public class testBBDD {
    public static void main(String[] args) {
        try(JugadorDAOImpl jdi = new JugadorDAOImpl();){
            ArrayList<Jugador> lista = jdi.getJugadoresByIdPartida(1);
            if (lista.size() == 0) {
                System.out.println("VACIO");
            }
            for (Jugador jugador : lista) {
                System.out.println(jugador);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
}
