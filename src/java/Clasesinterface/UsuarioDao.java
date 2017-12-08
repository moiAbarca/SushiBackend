/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clasesinterface;

import CapaDTO.Usuario;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author moi
 */
public interface UsuarioDao {
    public List<Usuario> obtenerUsuario() throws SQLException;
    public void agregarUsuario(Usuario usuario) throws SQLException;
    public void modificarUsuario(Usuario usuario) throws SQLException;
    public void eliminarUsuario(Integer id) throws SQLException;
    public Usuario buscarUsuario(Integer id) throws SQLException;
    public Usuario buscarLogin(String usuario) throws SQLException;
}
