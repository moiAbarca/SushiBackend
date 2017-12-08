/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clasesinterface;

import CapaDTO.Pagina;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author moi
 */
public interface PaginaDao {
    public List<Pagina> obtenerPagina() throws SQLException;
    public void agregarPagina(Pagina pagina) throws SQLException;
    public void modificarPagina(Pagina pagina) throws SQLException;
    public void eliminarPagina(Integer id) throws SQLException;
    public Pagina buscarPagina(Integer id) throws SQLException;
}
