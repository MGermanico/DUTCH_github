/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exec;

import dao.implementation.JugadorDAOImpl;
import dao.implementation.PartidaDAOImpl;
import dao.implementation.PartidaIndividualDAOImpl;
import dao.pojo.Jugador;
import dao.pojo.Partida;
import dao.pojo.PartidaIndividual;
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
            if (lista.isEmpty()) {
                System.out.println("VACIO");
            }
            for (Jugador jugador : lista) {
                System.out.println(jugador);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        System.out.println("-----");
        try(PartidaDAOImpl jdi = new PartidaDAOImpl();){
            ArrayList<Partida> lista = jdi.getPartidasByFiltro(null, null, null);
            if (lista.isEmpty()) {
                System.out.println("VACIO");
            }
            for (Partida partida : lista) {
                System.out.println(partida);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        System.out.println("-----");
        try(PartidaIndividualDAOImpl jdi = new PartidaIndividualDAOImpl();){
            ArrayList<PartidaIndividual> lista = jdi.getPartidasIndividuales();
            if (lista.isEmpty()) {
                System.out.println("VACIO");
            }
            for (PartidaIndividual partidaIndiv : lista) {
                System.out.println(partidaIndiv);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
}
