/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bbdd.dao.implementation;

import bbdd.dao.interfaces.PartidaDAO;
import bbdd.dao.pojo.Jugador;
import bbdd.dao.pojo.Partida;
import bbdd.dao.variables.MyColor;
import bbdd.dao.variables.MyDate;
import bbdd.dao.variables.Nickname;
import java.io.IOException;
import java.io.StringReader;
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
public class PartidaDAOImpl implements PartidaDAO, AutoCloseable{
    
    static{
        try{
            
        }catch(Exception ex){
            System.out.println("ERROR AL CARGAR EL DRIVER");
            System.exit(1);
        }
    }
    
    Connection con = null;
    
    public PartidaDAOImpl() throws SQLException{
        con = DriverManager.getConnection(Config.URL);
    }

    @Override
    public ArrayList<Partida> getPartidas() throws Exception {
        return getPartidasByFiltro(null, null, null);
    }

    @Override
    public Partida getPartidaByWId(Object idPartidaObj) throws Exception {
        ArrayList<Partida> partidas= this.getPartidasByFiltro(idPartidaObj, null, null);;
        if (!partidas.isEmpty()) {
            return partidas.get(0);
        }else{
            return null;
        }
    }

    @Override
    public ArrayList<Partida> getPartidasByFiltro(Object idPartidaObj, MyDate fecha, Nickname nickGanador) throws Exception {
        int idPartida;
        ArrayList<Partida> list = new ArrayList<Partida>();
        String sql = "SELECT IdPartida, Fecha, NickGanador "
                + "FROM Partida "
                + "WHERE 1 = 1 ";
        
        if (idPartidaObj != null) {
            sql += "AND IdPartida = ? ";
        }
        if (fecha != null) {
            sql += "AND Fecha like ? ";
        }
        if (nickGanador != null) {
            sql += "AND NickGanador like ? ";
        }
        System.out.println(sql);
        int nFilter = 0;
        ResultSet rs = null;
        try(PreparedStatement pstm = con.prepareStatement(sql)){
            if (idPartidaObj != null) {
                nFilter++;
                idPartida = (int)idPartidaObj;
//                System.out.println(4 + "?   " + numeroPuntosTotales);
                pstm.setInt(nFilter, idPartida);
            }
            if (fecha != null) {
                nFilter++;
//                System.out.println(2 + "?   " + ultimoColor.getStr());
                pstm.setString(nFilter, fecha.getStr());
            }
            if (nickGanador != null) {
                nFilter++;
//                System.out.println(3 + "?   " + numeroVictorias);
                pstm.setString(nFilter, nickGanador.getStr());
            }
            rs = pstm.executeQuery();
            Partida partidaActual;
            while(rs.next()){
                partidaActual = new Partida(rs.getInt(1));
                partidaActual.setFecha(new MyDate(rs.getString(2)));
                partidaActual.setNickGanador(new Nickname(rs.getString(3)));
                list.add(partidaActual);
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
