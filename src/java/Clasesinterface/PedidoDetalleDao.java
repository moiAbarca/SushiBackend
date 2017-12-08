/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clasesinterface;

import CapaDTO.PedidoDetalle;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author moi
 */
public interface PedidoDetalleDao {
    public List<PedidoDetalle> obtenerPedidoDetalle() throws SQLException;
    public void agregarPedidoDetalle(PedidoDetalle pedidoDetalle) throws SQLException;
    public void modificarPedidoDetalle(PedidoDetalle pedidoDetalle) throws SQLException;
    public void eliminarPedidoDetalle(Integer id) throws SQLException;
    public PedidoDetalle buscarPedidoDetalle(Integer id) throws SQLException;
}
