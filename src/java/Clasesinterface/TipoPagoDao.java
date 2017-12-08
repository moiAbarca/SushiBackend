/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clasesinterface;

import CapaDTO.TipoPago;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author moi
 */
public interface TipoPagoDao {
    public List<TipoPago> obtenerTipoPago() throws SQLException;
    public void agregarTipoPago(TipoPago tipoPago) throws SQLException;
    public void modificarTipoPago(TipoPago tipoPago) throws SQLException;
    public void eliminarTipoPago(Integer id) throws SQLException;
    public TipoPago buscarTipoPago(Integer id) throws SQLException;
}
