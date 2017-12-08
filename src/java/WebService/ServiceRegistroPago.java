/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebService;

import CapaDTO.ResgistroPago;
import CapaNegocio.OracleRegistroPago;
import Clasesinterface.RegistroPagoDao;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author moi
 */
@WebService(serviceName = "ServiceRegistroPago")
public class ServiceRegistroPago {

    List<ResgistroPago> ResgistroPago;
    
    //comienzo de los webServices    
    @WebMethod(operationName = "obtenerResgistroPago")        
    public List<ResgistroPago> obtenerResgistroPago()  
    {
        try{        
        RegistroPagoDao dao = new OracleRegistroPago();      
        ResgistroPago = dao.obtenerResgistroPago();        
        }
        catch(Exception ex)
        {}
        return ResgistroPago;
    }
    
    @WebMethod(operationName = "agregarResgistroPago")        
    public void agregarResgistroPago(@WebParam(name = "resgistroPago") ResgistroPago resgistroPago)  
    {
        try{
        RegistroPagoDao dao = new OracleRegistroPago(); 
        dao.agregarResgistroPago(resgistroPago);
        }
        catch(Exception ex)
        {}
    }
    

    
    @WebMethod(operationName = "modificarResgistroPago")        
    public void modificarResgistroPago(@WebParam(name = "resgistroPago") ResgistroPago resgistroPago)  
    {
        try{
        RegistroPagoDao dao = new OracleRegistroPago(); 
        dao.modificarResgistroPago(resgistroPago);
        }
        catch(Exception ex)
        {}
    }
    
    @WebMethod(operationName = "eliminarResgistroPago")        
    public void eliminarResgistroPago(@WebParam(name = "id") Integer id)  
    {
        try{
        RegistroPagoDao dao = new OracleRegistroPago(); 
        dao.eliminarResgistroPago(id);
        }
        catch(Exception ex)
        {}
    }
    
    @WebMethod(operationName = "buscarResgistroPago")        
    public ResgistroPago buscarResgistroPago(@WebParam(name = "id") Integer id)  
    {
        ResgistroPago reg = new ResgistroPago();
        try{
        RegistroPagoDao dao = new OracleRegistroPago(); 
        reg = dao.buscarResgistroPago(id);
        }
        catch(Exception ex)
        {}
        return reg;
    }
}
