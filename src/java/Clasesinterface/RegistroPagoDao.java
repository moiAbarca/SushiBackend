/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clasesinterface;

import CapaDTO.ResgistroPago;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author moi
 */
public interface RegistroPagoDao {
    public List<ResgistroPago> obtenerResgistroPago() throws SQLException;
    public void agregarResgistroPago(ResgistroPago resgistroPago) throws SQLException;
    public void modificarResgistroPago(ResgistroPago resgistroPago) throws SQLException;
    public void eliminarResgistroPago(Integer id) throws SQLException;
    public ResgistroPago buscarResgistroPago(Integer id) throws SQLException;
}
