/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.implementation;

import com.sun.jdi.connect.spi.Connection;
import dao.interfaces.PartidaDAO;
import dao.pojo.Partida;
import dao.variables.MyDate;
import dao.variables.Nickname;
import java.io.IOException;
import java.util.ArrayList;

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
    
    public PartidaDAOImpl(){
//        con = DriverManager.getConnection(Config.PATH, Config.USER, Config.PASS);        
    }

    @Override
    public ArrayList<Partida> getPartidas() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Partida getPartidaById(int idPartida) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Partida> getPartidasByFiltro(int idPartida, MyDate fecha, Nickname nickGanador) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public void close() throws IOException {
        con.close();
    }
    
}
