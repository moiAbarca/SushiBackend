/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clasesinterface;

import CapaDTO.Oferta;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author moi
 */
public interface OfertaDao {
    public List<Oferta> obtenerOferta() throws SQLException;
    public void agregarOferta(Oferta oferta) throws SQLException;
    public void modificarOferta(Oferta oferta) throws SQLException;
    public void eliminarOferta(Integer id) throws SQLException;
    public Oferta buscarOferta(Integer id) throws SQLException;
}
