/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clasesinterface;

import CapaDTO.Provincia;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author moi
 */
public interface ProvinciaDao {
    public List<Provincia> obtenerProvincia() throws SQLException;
    public void agregarProvincia(Provincia provincia) throws SQLException;
    public void modificarProvincia(Provincia provincia) throws SQLException;
    public void eliminarProvincia(Integer id) throws SQLException;
    public Provincia buscarProvincia(Integer id) throws SQLException;
}
