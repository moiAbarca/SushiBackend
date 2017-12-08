/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebService;

import CapaDTO.Cliente;
import CapaNegocio.OracleCliente;
import Clasesinterface.ClienteDao;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author moi
 */
@WebService(serviceName = "ServiceCliente")
public class ServiceCliente {

    List<Cliente> Cliente;
    //comienzo de los webServices
    
    @WebMethod(operationName = "obtenerCliente")        
    public List<Cliente> obtenerCliente()  
    {
        try{        
        ClienteDao dao = new OracleCliente();      
        Cliente = dao.obtenerCliente();        
        }
        catch(Exception ex)
        {}
        return Cliente;
    }
    
    @WebMethod(operationName = "agregarCliente")        
    public void agregarCliente(@WebParam(name = "cliente") Cliente cliente)  
    {
        try{
        ClienteDao dao = new OracleCliente();      
        dao.agregarCliente(cliente);
        }
        catch(Exception ex)
        {}
    }
    

    
    @WebMethod(operationName = "modificarCliente")        
    public void modificarCliente(@WebParam(name = "cliente") Cliente cliente)  
    {
        try{
        ClienteDao dao = new OracleCliente();      
        dao.modificarCliente(cliente);
        }
        catch(Exception ex)
        {}
    }
    
    @WebMethod(operationName = "eliminarCliente")        
    public void eliminarCliente(@WebParam(name = "id") Integer id)  
    {
        try{
        ClienteDao dao = new OracleCliente();      
        dao.eliminarCliente(id);
        }
        catch(Exception ex)
        {}
    }
    
    @WebMethod(operationName = "buscarCliente")        
    public Cliente buscarCliente(@WebParam(name = "id") Integer id)  
    {
        Cliente cl = new Cliente();
        try{
        ClienteDao dao = new OracleCliente();      
        cl = dao.buscarCliente(id);
        }
        catch(Exception ex)
        {}
        return cl;
    }
}
