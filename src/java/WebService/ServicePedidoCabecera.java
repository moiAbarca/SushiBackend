/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebService;

import CapaDTO.PedidoCabecera;
import CapaNegocio.OraclePedidoCabecera;
import Clasesinterface.PedidoCabeceraDao;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author moi
 */
@WebService(serviceName = "ServicePedidoCabecera")
public class ServicePedidoCabecera {

    List<PedidoCabecera> PedidoCabecera;
    
    //comienzo de los webServices    
    @WebMethod(operationName = "obtenerPedidoCabecera")        
    public List<PedidoCabecera> obtenerPedidoCabecera()  
    {
        try{        
        PedidoCabeceraDao dao = new OraclePedidoCabecera();      
        PedidoCabecera = dao.obtenerPedidoCabecera();        
        }
        catch(Exception ex)
        {}
        return PedidoCabecera;
    }
    
    @WebMethod(operationName = "agregarPedidoCabecera")        
    public void agregarPedidoCabecera(@WebParam(name = "pedidoCabecera") PedidoCabecera pedidoCabecera)  
    {
        try{
        PedidoCabeceraDao dao = new OraclePedidoCabecera();      
        dao.agregarPedidoCabecera(pedidoCabecera);
        }
        catch(Exception ex)
        {}
    }
    

    
    @WebMethod(operationName = "modificarPedidoCabecera")        
    public void modificarPedidoCabecera(@WebParam(name = "pedidoCabecera") PedidoCabecera pedidoCabecera)  
    {
        try{
        PedidoCabeceraDao dao = new OraclePedidoCabecera();      
        dao.modificarPedidoCabecera(pedidoCabecera);
        }
        catch(Exception ex)
        {}
    }
    
    @WebMethod(operationName = "eliminarPedidoCabecera")        
    public void eliminarPedidoCabecera(@WebParam(name = "id") Integer id)  
    {
        try{
        PedidoCabeceraDao dao = new OraclePedidoCabecera();      
        dao.eliminarPedidoCabecera(id);
        }
        catch(Exception ex)
        {}
    }
    
    @WebMethod(operationName = "buscarPedidoCabecera")        
    public PedidoCabecera buscarPedidoCabecera(@WebParam(name = "id") Integer id)  
    {
        PedidoCabecera pec = new PedidoCabecera();
        try{
        PedidoCabeceraDao dao = new OraclePedidoCabecera();      
        pec = dao.buscarPedidoCabecera(id);
        }
        catch(Exception ex)
        {}
        return pec;
    }
}
