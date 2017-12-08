/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clasesinterface;

import CapaDTO.CategoriaProducto;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author moi
 */
public interface CategoriaProducDao {
    public List<CategoriaProducto> obtenerCategoriaProducto() throws SQLException;
    public void agregarCategoriaProducto(CategoriaProducto categoriaProducto) throws SQLException;
    public void modificarCategoriaProducto(CategoriaProducto categoriaProducto) throws SQLException;
    public void eliminarCategoriaProducto(Integer id) throws SQLException;
    public CategoriaProducto buscarCategoriaProducto(Integer id) throws SQLException;
}
