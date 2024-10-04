/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bbdd.dao.implementation;

import bbdd.dao.interfaces.RondaDAO;
import bbdd.dao.pojo.Partida;
import bbdd.dao.pojo.Ronda;
import bbdd.dao.variables.MyDate;
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
public class RondaDAOImpl implements RondaDAO, AutoCloseable{
    
    static{
        try{
            
        }catch(Exception ex){
            System.out.println("ERROR AL CARGAR EL DRIVER");
            System.exit(1);
        }
    }
    
    Connection con = null;
    
    public RondaDAOImpl() throws SQLException{
        con = DriverManager.getConnection(Config.URL);
    }

    @Override
    public ArrayList<Ronda> getRondas() throws Exception {
        return this.getRondaByFiltro(null, null, null, null, null);
    }

    @Override
    public Ronda getRondaByWId(Object idPartidaObj, Nickname nickname, Object numeroObj) throws Exception {
        ArrayList<Ronda> rondas = this.getRondaByFiltro(idPartidaObj, nickname, numeroObj, null, null);
        if (!rondas.isEmpty()) {
            return rondas.get(0);
        }else{
            return null;
        }
    }

    @Override
    public ArrayList<Ronda> getRondaByFiltro(Object idPartidaObj, Nickname nickname, Object numeroObj, Object puntosObj, Object puntosTotalesObj) throws Exception {
        int idPartida, numero, puntos, puntosTotales;
        ArrayList<Ronda> list = new ArrayList<Ronda>();
        String sql = "SELECT IdPartida, Nickname, Numero, Puntos, PuntosTotales "
                + "FROM Ronda "
                + "WHERE 1 = 1 ";
        
        if (idPartidaObj != null) {
            sql += "AND IdPartida = ? ";
        }
        if (nickname != null) {
            sql += "AND Nickname LIKE ? ";
        }
        if (numeroObj != null) {
            sql += "AND Numero = ? ";
        }
        if (puntosObj != null) {
            sql += "AND Puntos = ? ";
        }
        if (puntosTotalesObj != null) {
            sql += "AND PuntosTotales = ? ";
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
            if (nickname != null) {
                nFilter++;
//                System.out.println(2 + "?   " + ultimoColor.getStr());
                pstm.setString(nFilter, nickname.getStr());
            }
            if (numeroObj != null) {
                nFilter++;
                numero = (int)numeroObj;
//                System.out.println(4 + "?   " + numeroPuntosTotales);
                pstm.setInt(nFilter, numero);
            }
            if (puntosObj != null) {
                nFilter++;
                puntos = (int)puntosObj;
//                System.out.println(4 + "?   " + numeroPuntosTotales);
                pstm.setInt(nFilter, puntos);
            }
            if (puntosTotalesObj != null) {
                nFilter++;
                puntosTotales = (int)puntosTotalesObj;
//                System.out.println(4 + "?   " + numeroPuntosTotales);
                pstm.setInt(nFilter, puntosTotales);
            }
            rs = pstm.executeQuery();
            Ronda rondaActual;
            while(rs.next()){
                rondaActual = new Ronda(rs.getInt(1), new Nickname(rs.getString(2)), rs.getInt(3), rs.getInt(4), rs.getInt(5));
                list.add(rondaActual);
            }
        }catch(Exception ex){
            throw ex;
        }
        return list;
    }

    @Override
    public ArrayList<Ronda> getRondasByIdPartidaAndNickname(Object idPartidaObj, Nickname nickname) throws Exception {
        return this.getRondaByFiltro(idPartidaObj, nickname, null, null, null);
    }

    @Override
    public void close() throws IOException, SQLException {
        con.close();
    }
    
}
