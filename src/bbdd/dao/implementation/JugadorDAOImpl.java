/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bbdd.dao.implementation;

import bbdd.dao.interfaces.JugadorDAO;
import bbdd.dao.pojo.Jugador;
import bbdd.dao.variables.MyColor;
import bbdd.dao.variables.Nickname;
import java.io.IOException;
import java.util.ArrayList;
import utils.Config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author tarde
 */
public class JugadorDAOImpl implements JugadorDAO, AutoCloseable{
    
    static{
        try{
            Class.forName(Config.DRIVER);
        }catch(Exception ex){
            System.out.println("ERROR AL CARGAR EL DRIVER");
            System.exit(1);
        }
    }
    
    private Connection con = null;
    
    public JugadorDAOImpl() throws SQLException{
        con = DriverManager.getConnection(Config.URL);
    }
    
    @Override
    public ArrayList<Jugador> getJugadores() throws Exception{
        return this.getJugadoresByFiltro(null, null, null, null, null);
    }

    @Override
    public Jugador getJugadorByWId(Nickname nickname) throws Exception {
        ArrayList<Jugador> jugadores= this.getJugadoresByFiltro(nickname, null, null, null, null);;
        if (!jugadores.isEmpty()) {
            return jugadores.get(0);
        }else{
            return null;
        }
    }
    
    @Override
    public ArrayList<Jugador> getJugadoresByIdPartida(Object idPartidaObj) throws Exception {
        int idPartida;
        ArrayList<Jugador> list = new ArrayList<Jugador>();
        String sql = "SELECT Jugador.Nickname, UltimoColor, NumeroVictorias, NumeroPuntosTotales, NumeroPartidasJugadas "
                + "FROM Jugador "
                + "JOIN Partida_Individual "
                + "WHERE IdPartida = ? AND Jugador.Nickname LIKE Partida_Individual.Nickname";
        System.out.println(sql);
        ResultSet rs = null;
        try(PreparedStatement pstm = con.prepareStatement(sql)){
            idPartida = (int)idPartidaObj;
//            System.out.println(3 + "?   " + numeroVictorias);
            pstm.setInt(1, idPartida);
            rs = pstm.executeQuery();
            Jugador jugadorActual;
            while(rs.next()){
                jugadorActual = new Jugador(new Nickname(rs.getString(1)));
                jugadorActual.setUltimoColor(new MyColor(rs.getString(2)));
                jugadorActual.setNumeroVictorias(rs.getInt(3));
                jugadorActual.setNumeroPuntosTotales(rs.getInt(4));
                jugadorActual.setNumeroPartidasJugadas(rs.getInt(5));
                list.add(jugadorActual);
            }
        }catch(Exception ex){
            throw ex;
        }
        return list;
    }

    @Override
    public ArrayList<Jugador> getJugadoresByFiltro(Nickname nickname, MyColor ultimoColor,
        Object numeroVictoriasObj, Object numeroPuntosTotalesObj, Object numeroPartidasJugadasObj) throws Exception {
        int numeroVictorias, numeroPuntosTotales, numeroPartidasJugadas;
        ArrayList<Jugador> list = new ArrayList<Jugador>();
        String sql = "SELECT Nickname, UltimoColor, NumeroVictorias, NumeroPuntosTotales, NumeroPartidasJugadas "
                + "FROM Jugador "
                + "WHERE 1 = 1 ";
        
        if (nickname != null) {
            sql += "AND Nickname like ? ";
        }
        if (ultimoColor != null) {
            sql += "AND UltimoColor like ? ";
        }
        if (numeroVictoriasObj != null) {
            sql += "AND NumeroVictorias = ? ";
        }
        if (numeroPuntosTotalesObj != null) {
            sql += "AND NumeroPuntosTotales = ? ";
        }
        if (numeroPartidasJugadasObj != null) {
            sql += "AND NumeroPartidasJugadas = ? ";
        }
        System.out.println(sql);
        int nFilter = 0;
        ResultSet rs = null;
        try(PreparedStatement pstm = con.prepareStatement(sql)){
            if (nickname != null) {
                nFilter++;
//                System.out.println(1 + "?   " + nickname.getStr());
                pstm.setString(nFilter, nickname.getStr());
            }
            if (ultimoColor != null) {
                nFilter++;
//                System.out.println(2 + "?   " + ultimoColor.getStr());
                pstm.setString(nFilter, ultimoColor.getStr());
            }
            if (numeroVictoriasObj != null) {
                nFilter++;
                numeroVictorias = (int)numeroVictoriasObj;
//                System.out.println(3 + "?   " + numeroVictorias);
                pstm.setInt(nFilter, numeroVictorias);
            }
            if (numeroPuntosTotalesObj != null) {
                nFilter++;
                numeroPuntosTotales = (int)numeroPuntosTotalesObj;
//                System.out.println(4 + "?   " + numeroPuntosTotales);
                pstm.setInt(nFilter, numeroPuntosTotales);
            }
            if (numeroPartidasJugadasObj != null) {
                nFilter++;
                numeroPartidasJugadas = (int)numeroPartidasJugadasObj;
//                System.out.println(5 + "?   " + numeroPartidasJugadas);
                pstm.setInt(nFilter, numeroPartidasJugadas);
            }
            rs = pstm.executeQuery();
            Jugador jugadorActual;
            while(rs.next()){
                jugadorActual = new Jugador(new Nickname(rs.getString(1)));
                jugadorActual.setUltimoColor(new MyColor(rs.getString(2)));
                jugadorActual.setNumeroVictorias(rs.getInt(3));
                jugadorActual.setNumeroPuntosTotales(rs.getInt(4));
                jugadorActual.setNumeroPartidasJugadas(rs.getInt(5));
                list.add(jugadorActual);
            }
        }catch(Exception ex){
            throw ex;
        }
        return list;
    }
    
    @Override
    public void close() throws IOException, SQLException {
        con.close();
    }
}
