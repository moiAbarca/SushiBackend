/*
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebService;

import CapaDTO.Establecimiento;
import CapaNegocio.OracleEstablecimiento;
import Clasesinterface.EstablecimientoDao;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author moi
 */
@WebService(serviceName = "ServiceEstablecimiento")
public class ServiceEstablecimiento {

    List<Establecimiento> Establecimiento;
    //comienzo de los webServices
    
    @WebMethod(operationName = "obtenerEstablecimiento")        
    public List<Establecimiento> obtenerEstablecimiento()  
    {
        try{        
        EstablecimientoDao dao = new OracleEstablecimiento();      
        Establecimiento = dao.obtenerEstablecimiento();        
        }
        catch(Exception ex)
        {}
        return Establecimiento;
    }
    
    @WebMethod(operationName = "agregarEstablecimiento")        
    public void agregarEstablecimiento(@WebParam(name = "establecimiento") Establecimiento establecimiento)  
    {
        try{
        EstablecimientoDao dao = new OracleEstablecimiento();      
        dao.agregarEstablecimiento(establecimiento);
        }
        catch(Exception ex)
        {}
    }
    

    
    @WebMethod(operationName = "modificarEstablecimiento")        
    public void modificarEstablecimiento(@WebParam(name = "establecimiento") Establecimiento establecimiento)  
    {
        try{
        EstablecimientoDao dao = new OracleEstablecimiento();      
        dao.modificarEstablecimiento(establecimiento);
        }
        catch(Exception ex)
        {}
    }
    
    @WebMethod(operationName = "eliminarEstablecimiento")        
    public void eliminarEstablecimiento(@WebParam(name = "id") Integer id)  
    {
        try{
        EstablecimientoDao dao = new OracleEstablecimiento();      
        dao.eliminarEstablecimiento(id);
        }
        catch(Exception ex)
        {}
    }
    
    @WebMethod(operationName = "buscarEstablecimiento")        
    public Establecimiento buscarEstablecimiento(@WebParam(name = "id") Integer id)  
    {
        Establecimiento es = new Establecimiento();
        try{
        EstablecimientoDao dao = new OracleEstablecimiento();      
        es = dao.buscarEstablecimiento(id);
        }
        catch(Exception ex)
        {}
        return es;
    }
}
