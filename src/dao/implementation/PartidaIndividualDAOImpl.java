/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.implementation;

import dao.interfaces.PartidaIndividualDAO;
import dao.pojo.PartidaIndividual;
import dao.variables.Nickname;
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public PartidaIndividual getPartidaById(Object idPartidaObj, Nickname nickname) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<PartidaIndividual> getPartidasByFiltro(Object idPartidaObj, Nickname nickname) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<PartidaIndividual> getPartidasIndivByIdPartida(Object idPartidaObj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public void close() throws IOException, SQLException {
        con.close();
    }
}
