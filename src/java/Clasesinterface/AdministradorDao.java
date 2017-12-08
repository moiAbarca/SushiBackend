/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clasesinterface;


import java.sql.SQLException;
import java.util.List;
import CapaDTO.Administrador;
/**
 *
 * @author moi
 */
public interface AdministradorDao {
    public List<Administrador> obtenerAdministrador() throws SQLException;
    public void agregarAdministrador(Administrador administrador) throws SQLException;
    public void modificarAdministrador(Administrador administrador) throws SQLException;
    public void eliminarAdministrador(Integer id) throws SQLException;
    public Administrador buscarAdministrador(Integer id) throws SQLException;
}
