/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebService;

import CapaDTO.Seguimiento;
import CapaNegocio.OracleSeguimiento;
import Clasesinterface.SeguimientoDao;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author moi
 */
@WebService(serviceName = "ServiceSeguimiento")
public class ServiceSeguimiento {

    List<Seguimiento> Seguimiento;
    
    //comienzo de los webServices    
    @WebMethod(operationName = "obtenerSeguimiento")        
    public List<Seguimiento> obtenerSeguimiento()  
    {
        try{        
        SeguimientoDao dao = new OracleSeguimiento();      
        Seguimiento = dao.obtenerSeguimiento();        
        }
        catch(Exception ex)
        {}
        return Seguimiento;
    }
    
    @WebMethod(operationName = "agregarSeguimiento")        
    public void agregarSeguimiento(@WebParam(name = "seguimiento") Seguimiento seguimiento)  
    {
        try{
        SeguimientoDao dao = new OracleSeguimiento();
        dao.agregarSeguimiento(seguimiento);
        }
        catch(Exception ex)
        {}
    }
    

    
    @WebMethod(operationName = "modificarSeguimiento")        
    public void modificarSeguimiento(@WebParam(name = "seguimiento") Seguimiento seguimiento)  
    {
        try{
        SeguimientoDao dao = new OracleSeguimiento();
        dao.modificarSeguimiento(seguimiento);
        }
        catch(Exception ex)
        {}
    }
    
    @WebMethod(operationName = "eliminarSeguimiento")        
    public void eliminarSeguimiento(@WebParam(name = "id") Integer id)  
    {
        try{
        SeguimientoDao dao = new OracleSeguimiento();
        dao.eliminarSeguimiento(id);
        }
        catch(Exception ex)
        {}
    }
    
    @WebMethod(operationName = "buscarSeguimiento")        
    public Seguimiento buscarSeguimiento(@WebParam(name = "id") Integer id)  
    {
        Seguimiento seg = new Seguimiento();
        try{
        SeguimientoDao dao = new OracleSeguimiento();
        seg = dao.buscarSeguimiento(id);
        }
        catch(Exception ex)
        {}
        return seg;
    }
}
