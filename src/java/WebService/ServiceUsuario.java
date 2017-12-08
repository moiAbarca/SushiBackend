/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebService;

import CapaDTO.Usuario;
import CapaNegocio.OracleUsuario;
import Clasesinterface.UsuarioDao;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author moi
 */
@WebService(serviceName = "ServiceUsuario")
public class ServiceUsuario {

    List<Usuario> Usuario;
    
    //comienzo de los webServices    
    @WebMethod(operationName = "obtenerUsuario")        
    public List<Usuario> obtenerUsuario()  
    {
        try{        
        UsuarioDao dao = new OracleUsuario();      
        Usuario = dao.obtenerUsuario();        
        }
        catch(Exception ex)
        {}
        return Usuario;
    }
    
    @WebMethod(operationName = "agregarUsuario")        
    public void agregarUsuario(@WebParam(name = "usuario") Usuario usuario)  
    {
        try{
        UsuarioDao dao = new OracleUsuario();
        dao.agregarUsuario(usuario);
        }
        catch(Exception ex)
        {}
    }
    

    
    @WebMethod(operationName = "modificarUsuario")        
    public void modificarUsuario(@WebParam(name = "usuario") Usuario usuario)  
    {
        try{
        UsuarioDao dao = new OracleUsuario();
        dao.modificarUsuario(usuario);
        }
        catch(Exception ex)
        {}
    }
    
    @WebMethod(operationName = "eliminarUsuario")        
    public void eliminarUsuario(@WebParam(name = "id") Integer id)  
    {
        try{
        UsuarioDao dao = new OracleUsuario();
        dao.eliminarUsuario(id);
        }
        catch(Exception ex)
        {}
    }
    
    @WebMethod(operationName = "buscarUsuario")        
    public Usuario buscarUsuario(@WebParam(name = "id") Integer id)  
    {
        Usuario us = new Usuario();
        try{
        UsuarioDao dao = new OracleUsuario();
        us = dao.buscarUsuario(id);
        }
        catch(Exception ex)
        {}
        return us;
    }
    
    @WebMethod(operationName = "buscarLogin")        
    public Usuario buscarLogin(@WebParam(name = "usuario") String usuario)  
    {
        Usuario us = new Usuario();
        try{
        UsuarioDao dao = new OracleUsuario();
        us = dao.buscarLogin(usuario);
        }
        catch(Exception ex)
        {}
        return us;
    }
}
