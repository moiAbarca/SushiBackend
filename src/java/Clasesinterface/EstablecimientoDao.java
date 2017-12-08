/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clasesinterface;

import CapaDTO.Establecimiento;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author moi
 */
public interface EstablecimientoDao {
    public List<Establecimiento> obtenerEstablecimiento() throws SQLException;
    public void agregarEstablecimiento(Establecimiento establecimiento) throws SQLException;
    public void modificarEstablecimiento(Establecimiento establecimiento) throws SQLException;
    public void eliminarEstablecimiento(Integer id) throws SQLException;
    public Establecimiento buscarEstablecimiento(Integer id) throws SQLException;
}
