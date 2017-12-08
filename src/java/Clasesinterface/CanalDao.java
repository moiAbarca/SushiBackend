/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clasesinterface;

import CapaDTO.Canal;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author moi
 */
public interface CanalDao {
    public List<Canal> obtenerCanal() throws SQLException;
    public void agregarCanal(Canal canal) throws SQLException;
    public void modificarCanal(Canal canal) throws SQLException;
    public void eliminarCanal(Integer id) throws SQLException;
    public Canal buscarCanal(Integer id) throws SQLException;
}
