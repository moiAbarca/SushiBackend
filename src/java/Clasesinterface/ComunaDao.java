/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clasesinterface;

import CapaDTO.Comuna;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author moi
 */
public interface ComunaDao {
    public List<Comuna> obtenerComuna() throws SQLException;
    public void agregarComuna(Comuna comuna) throws SQLException;
    public void modificarComuna(Comuna comuna) throws SQLException;
    public void eliminarComuna(Integer id) throws SQLException;
    public Comuna buscarComuna(Integer id) throws SQLException;
}
