/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clasesinterface;

import CapaDTO.Perfil;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author moi
 */
public interface PerfilDao {
    public List<Perfil> obtenerPerfil() throws SQLException;
    public void agregarPerfil(Perfil perfil) throws SQLException;
    public void modificarPerfil(Perfil perfil) throws SQLException;
    public void eliminarPerfil(Integer id) throws SQLException;
    public Perfil buscarPerfil(Integer id) throws SQLException;
}
