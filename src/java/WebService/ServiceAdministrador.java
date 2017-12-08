/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebService;


import CapaDTO.Administrador;
import CapaNegocio.OracleAdministrador;
import Clasesinterface.AdministradorDao;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author moi
 */
@WebService(serviceName = "ServiceAdministrador")
public class ServiceAdministrador {

    /**
     * This is a sample web service operation
     */
    
    List<Administrador> administrador;
    
    @WebMethod(operationName = "agregarAdministrador")        
    public void agregarAdministrador(@WebParam(name = "administrador") Administrador administrador)  
    {
        try{
        AdministradorDao dao = new OracleAdministrador();
        dao.agregarAdministrador(administrador);
        }
        catch(Exception ex)
        {}
    }
    
        @WebMethod(operationName = "obtenerAdministrador")        
    public List<Administrador> obtenerAdministrador()  
    {
        try{
        
        AdministradorDao dao = new OracleAdministrador();      
        administrador = dao.obtenerAdministrador();        
        }
        catch(Exception ex)
        {}
        return administrador;
    }
    
        @WebMethod(operationName = "modificarAdministrador")        
    public void modificarAdministrador(@WebParam(name = "administrador") Administrador administrador)  
    {
        try{
        AdministradorDao dao = new OracleAdministrador();
        dao.modificarAdministrador(administrador);
        }
        catch(Exception ex)
        {}
    }
    
    @WebMethod(operationName = "eliminarAdministrador")        
    public void eliminarAdministrador(@WebParam(name = "id") Integer id)  
    {
        try{
        AdministradorDao dao = new OracleAdministrador();      
        dao.eliminarAdministrador(id);
        }
        catch(Exception ex)
        {}
    }
    
    @WebMethod(operationName = "buscarAdministrador")        
    public Administrador buscarAdministrador(@WebParam(name = "id") Integer id)  
    {
        Administrador adm = new Administrador();
        try{
        AdministradorDao dao = new OracleAdministrador();      
        adm = dao.buscarAdministrador(id);
        }
        catch(Exception ex)
        {}
        return adm;
    }
}
