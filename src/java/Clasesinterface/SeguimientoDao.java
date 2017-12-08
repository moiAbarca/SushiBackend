/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clasesinterface;

import CapaDTO.Seguimiento;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author moi
 */
public interface SeguimientoDao {
    public List<Seguimiento> obtenerSeguimiento() throws SQLException;
    public void agregarSeguimiento(Seguimiento seguimiento) throws SQLException;
    public void modificarSeguimiento(Seguimiento seguimiento) throws SQLException;
    public void eliminarSeguimiento(Integer id) throws SQLException;
    public Seguimiento buscarSeguimiento(Integer id) throws SQLException;
}
