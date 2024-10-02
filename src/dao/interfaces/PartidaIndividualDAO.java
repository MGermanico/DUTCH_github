/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.interfaces;

import dao.pojo.PartidaIndividual;
import dao.variables.Nickname;
import java.util.ArrayList;

/**
 *
 * @author tarde
 */
public interface PartidaIndividualDAO {
    //getters
    public ArrayList<PartidaIndividual> getPartidasIndividuales() throws Exception;
    public PartidaIndividual            getPartidaById(int idPartida, Nickname nickname) throws Exception;
    public ArrayList<PartidaIndividual> getPartidasByFiltro(int idPartida, Nickname nickname) throws Exception;
    
    //redundant getters
    public ArrayList<PartidaIndividual> getPartidasIndivByIdPartida(int idPartida) throws Exception;
    
}
