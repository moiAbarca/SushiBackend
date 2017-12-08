/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebService;

import CapaDTO.TipoPago;
import CapaNegocio.OracleTipoPago;
import Clasesinterface.TipoPagoDao;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author moi
 */
@WebService(serviceName = "ServiceTipoPago")
public class ServiceTipoPago {

    List<TipoPago> TipoPago;
    
    //comienzo de los webServices    
    @WebMethod(operationName = "obtenerTipoPago")        
    public List<TipoPago> obtenerTipoPago()  
    {
        try{        
        TipoPagoDao dao = new OracleTipoPago();      
        TipoPago = dao.obtenerTipoPago();        
        }
        catch(Exception ex)
        {}
        return TipoPago;
    }
    
    @WebMethod(operationName = "agregarTipoPago")        
    public void agregarTipoPago(@WebParam(name = "tipoPago") TipoPago tipoPago)  
    {
        try{
        TipoPagoDao dao = new OracleTipoPago();   
        dao.agregarTipoPago(tipoPago);
        }
        catch(Exception ex)
        {}
    }
    

    
    @WebMethod(operationName = "modificarTipoPago")        
    public void modificarTipoPago(@WebParam(name = "tipoPago") TipoPago tipoPago)  
    {
        try{
        TipoPagoDao dao = new OracleTipoPago();   
        dao.modificarTipoPago(tipoPago);
        }
        catch(Exception ex)
        {}
    }
    
    @WebMethod(operationName = "eliminarTipoPago")        
    public void eliminarTipoPago(@WebParam(name = "id") Integer id)  
    {
        try{
        TipoPagoDao dao = new OracleTipoPago();   
        dao.eliminarTipoPago(id);
        }
        catch(Exception ex)
        {}
    }
    
    @WebMethod(operationName = "buscarTipoPago")        
    public TipoPago buscarTipoPago(@WebParam(name = "id") Integer id)  
    {
        TipoPago tip = new TipoPago();
        try{
        TipoPagoDao dao = new OracleTipoPago();   
        tip = dao.buscarTipoPago(id);
        }
        catch(Exception ex)
        {}
        return tip;
    }
}
