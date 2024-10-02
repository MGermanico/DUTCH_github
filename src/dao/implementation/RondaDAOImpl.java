/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.implementation;

import com.sun.jdi.connect.spi.Connection;
import dao.interfaces.RondaDAO;
import dao.pojo.Ronda;
import dao.variables.Nickname;
import java.io.IOException;
import java.util.ArrayList;
import utils.Config;

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
    
    public RondaDAOImpl(){
//        con = DriverManager.getConnection(Config.PATH, Config.USER, Config.PASS);
    }

    @Override
    public ArrayList<Ronda> getRondas() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Ronda getRondaById(int idPartida, Nickname nickname, int numero) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Ronda> getRondaByFiltro(int idPartida, Nickname nickname, int numero, int puntos, int puntosTotales) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Ronda> getRondasByIdPartidaAndNickname(int idPartida, Nickname nickname) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void close() throws IOException {
        con.close();
    }
    
}
