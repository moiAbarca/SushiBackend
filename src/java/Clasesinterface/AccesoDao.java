/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clasesinterface;

import java.sql.SQLException;
import java.util.List;
import CapaDTO.Acceso;

/**
 *
 * @author moi
 */
public interface AccesoDao {
    //métodos abstractos que se van a sobreescribir en la capaNegocio
    public List<Acceso> obtenerAcceso() throws SQLException;
    public void agregarAcceso(Acceso acceso) throws SQLException;
    public void modificarAcceso(Acceso acceso) throws SQLException;
    public void eliminarAcceso(Integer id) throws SQLException;
    public Acceso buscarAcceso(Integer id) throws SQLException;
}
