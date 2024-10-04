/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bbdd.dao.interfaces;

import bbdd.dao.pojo.PartidaIndividual;
import bbdd.dao.variables.Nickname;
import java.util.ArrayList;

/**
 *
 * @author tarde
 */
public interface PartidaIndividualDAO {
    //getters
    public ArrayList<PartidaIndividual> getPartidasIndividuales() throws Exception;
    public PartidaIndividual            getPartidaByWId(Object idPartida, Nickname nickname) throws Exception;
    public ArrayList<PartidaIndividual> getPartidasByFiltro(Object idPartida, Nickname nickname) throws Exception;
    
    //redundant getters
    public ArrayList<PartidaIndividual> getPartidasIndivByIdPartida(Object idPartida) throws Exception;
    
}
