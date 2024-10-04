/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exec;

import bbdd.dao.implementation.JugadorDAOImpl;
import bbdd.dao.implementation.PartidaDAOImpl;
import bbdd.dao.implementation.PartidaIndividualDAOImpl;
import bbdd.dao.implementation.RondaDAOImpl;
import bbdd.dao.pojo.Jugador;
import bbdd.dao.pojo.Partida;
import bbdd.dao.pojo.PartidaIndividual;
import bbdd.dao.pojo.Ronda;
import bbdd.dao.variables.Nickname;
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
        System.out.println("-----");
        try(RondaDAOImpl jdi = new RondaDAOImpl();){
            ArrayList<Ronda> lista = jdi.getRondaByFiltro(null, null, null, null, null);
            if (lista.isEmpty()) {
                System.out.println("VACIO");
            }
            for (Ronda ronda : lista) {
                System.out.println(ronda);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
}
