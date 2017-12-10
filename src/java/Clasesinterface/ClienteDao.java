/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clasesinterface;

import CapaDTO.Cliente;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author moi
 */
public interface ClienteDao {
    public List<Cliente> obtenerCliente() throws SQLException;
    public void agregarCliente(Cliente cliente) throws SQLException;
    public void modificarCliente(Cliente cliente) throws SQLException;
    public void eliminarCliente(Integer id) throws SQLException;
    public Cliente buscarCliente(Integer id) throws SQLException;
    public Cliente buscarClienteRut(String rut) throws SQLException;
}
