/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bbdd.dao.implementation;

import bbdd.dao.interfaces.PartidaIndividualDAO;
import bbdd.dao.pojo.Jugador;
import bbdd.dao.pojo.PartidaIndividual;
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
public class PartidaIndividualDAOImpl implements PartidaIndividualDAO, AutoCloseable{
    
    static{
        try{
            
        }catch(Exception ex){
            System.out.println("ERROR AL CARGAR EL DRIVER");
            System.exit(1);
        }
    }
    
    Connection con = null;
    
    public PartidaIndividualDAOImpl() throws SQLException{
        con = DriverManager.getConnection(Config.URL);
    }

    @Override
    public ArrayList<PartidaIndividual> getPartidasIndividuales() throws Exception {
        return getPartidasByFiltro(null, null);
    }

    @Override
    public PartidaIndividual getPartidaByWId(Object idPartidaObj, Nickname nickname) throws Exception {
        ArrayList<PartidaIndividual> partidasIndividuales= this.getPartidasByFiltro(nickname, nickname);
        if (!partidasIndividuales.isEmpty()) {
            return partidasIndividuales.get(0);
        }else{
            return null;
        }
    }

    @Override
    public ArrayList<PartidaIndividual> getPartidasByFiltro(Object idPartidaObj, Nickname nickname) throws Exception {
        int idPartida;
        ArrayList<PartidaIndividual> list = new ArrayList<PartidaIndividual>();
        String sql = "SELECT IdPartida, Nickname "
                + "FROM Partida_Individual "
                + "WHERE 1 = 1 ";
        
        if (idPartidaObj != null) {
            sql += "AND IdPartida = ? ";
        }
        if (nickname != null) {
            sql += "AND Nickname like ? ";
        }
        System.out.println(sql);
        int nFilter = 0;
        ResultSet rs = null;
        try(PreparedStatement pstm = con.prepareStatement(sql)){
            if (idPartidaObj != null) {
                nFilter++;
                idPartida = (int)idPartidaObj;
//                System.out.println(1 + "?   " + nickname.getStr());
                pstm.setInt(nFilter, idPartida);
            }
            if (nickname != null) {
                nFilter++;
//                System.out.println(2 + "?   " + ultimoColor.getStr());
                pstm.setString(nFilter, nickname.getStr());
            }
            rs = pstm.executeQuery();
            PartidaIndividual partidaIndividual;
            while(rs.next()){
                partidaIndividual = new PartidaIndividual(rs.getInt(1), new Nickname(rs.getString(2)));
                list.add(partidaIndividual);
            }
        }catch(Exception ex){
            throw ex;
        }
        return list;
    }

    @Override
    public ArrayList<PartidaIndividual> getPartidasIndivByIdPartida(Object idPartidaObj) throws Exception {
        return this.getPartidasByFiltro(idPartidaObj, null);
    }
    
    @Override
    public void close() throws IOException, SQLException {
        con.close();
    }
}
