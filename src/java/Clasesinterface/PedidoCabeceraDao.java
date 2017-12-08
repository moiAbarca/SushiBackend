/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clasesinterface;

import CapaDTO.PedidoCabecera;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author moi
 */
public interface PedidoCabeceraDao {
    public List<PedidoCabecera> obtenerPedidoCabecera() throws SQLException;
    public void agregarPedidoCabecera(PedidoCabecera pedidoCabecera) throws SQLException;
    public void modificarPedidoCabecera(PedidoCabecera pedidoCabecera) throws SQLException;
    public void eliminarPedidoCabecera(Integer id) throws SQLException;
    public PedidoCabecera buscarPedidoCabecera(Integer id) throws SQLException;
}
