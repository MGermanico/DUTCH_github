/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.implementation;

import com.sun.jdi.connect.spi.Connection;
import dao.interfaces.JugadorDAO;
import dao.pojo.Jugador;
import dao.variables.MyColor;
import dao.variables.Nickname;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author tarde
 */
public class JugadorDAOImpl implements JugadorDAO, AutoCloseable{
    
    static{
        try{
            
        }catch(Exception ex){
            System.out.println("ERROR AL CARGAR EL DRIVER");
            System.exit(1);
        }
    }
    
    Connection con = null;
    
    public JugadorDAOImpl(){
//        con = DriverManager.getConnection(Config.PATH, Config.USER, Config.PASS);        
    }
    
    @Override
    public ArrayList<Jugador> getJugadores() throws Exception{
        ArrayList<Jugador> list = new ArrayList<Jugador>();
        String sql = "SELECT Nickname, UltimoColor, NumeroVictorias, NumeroPuntosTotales, NumeroPartidasJugadas "
                + "FROM Jugador";
        try
//            (PreparedStatement pstm = con.prepareStatement(sql))
        {
            
        }catch(Exception ex){
            throw ex;
        }
        return list;
    }

    @Override
    public Jugador getJugadorById(String nickname) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Jugador> getJugadoresByFiltro(Nickname nickname, MyColor ultimoColor, int numeroVictorias, int numeroPuntosTotales, int numeroPartidasJugadas) throws Exception {
        ArrayList<Jugador> list = new ArrayList<Jugador>();
        String sql = "SELECT Nickname, UltimoColor, NumeroVictorias, NumeroPuntosTotales, NumeroPartidasJugadas "
                + "FROM Jugador "
                + "WHERE 1 = 1 ";
        if (nickname != null) {
            
        }
        try
//            (PreparedStatement pstm = con.prepareStatement(sql))
        {
            
        }catch(Exception ex){
            throw ex;
        }
        return list;
    }

    @Override
    public ArrayList<Jugador> getJugadoresByIdPartida(int idPartida) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public void close() throws IOException {
        con.close();
    }
}
