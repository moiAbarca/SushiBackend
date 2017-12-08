/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clasesinterface;

import CapaDTO.OfertaProducto;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author moi
 */
public interface OfertaProducDao {
    public List<OfertaProducto> obtenerOfertaProducto() throws SQLException;
    public void agregarOfertaProducto(OfertaProducto ofertaProducto) throws SQLException;
    public void modificarOfertaProducto(OfertaProducto ofertaProducto) throws SQLException;
    public void eliminarOfertaProducto(Integer id) throws SQLException;
    public OfertaProducto buscarOfertaProducto(Integer id) throws SQLException;
}
