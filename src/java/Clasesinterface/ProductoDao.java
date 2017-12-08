/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clasesinterface;

import CapaDTO.Producto;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author moi
 */
public interface ProductoDao {
    public List<Producto> obtenerProducto() throws SQLException;
    public void agregarProducto(Producto producto) throws SQLException;
    public void modificarProducto(Producto producto) throws SQLException;
    public void eliminarProducto(Integer id) throws SQLException;
    public Producto buscarProducto(Integer id) throws SQLException;
}
