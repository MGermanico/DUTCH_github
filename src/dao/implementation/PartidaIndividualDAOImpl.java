/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.implementation;

import com.sun.jdi.connect.spi.Connection;
import dao.interfaces.PartidaIndividualDAO;
import dao.pojo.PartidaIndividual;
import dao.variables.Nickname;
import java.io.IOException;
import java.util.ArrayList;

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
    
    public PartidaIndividualDAOImpl(){
//        con = DriverManager.getConnection(Config.PATH, Config.USER, Config.PASS);        
    }

    @Override
    public ArrayList<PartidaIndividual> getPartidasIndividuales() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public PartidaIndividual getPartidaById(int idPartida, Nickname nickname) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<PartidaIndividual> getPartidasByFiltro(int idPartida, Nickname nickname) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<PartidaIndividual> getPartidasIndivByIdPartida(int idPartida) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public void close() throws IOException {
        con.close();
    }
}
