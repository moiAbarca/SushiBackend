/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebService;

import CapaDTO.PedidoDetalle;
import CapaNegocio.OraclePedidoDetalle;
import Clasesinterface.PedidoDetalleDao;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author moi
 */
@WebService(serviceName = "ServicePedidoDetalle")
public class ServicePedidoDetalle {

    List<PedidoDetalle> PedidoDetalle;
    
    //comienzo de los webServices    
    @WebMethod(operationName = "obtenerPedidoDetalle")        
    public List<PedidoDetalle> obtenerPedidoDetalle()  
    {
        try{        
        PedidoDetalleDao dao = new OraclePedidoDetalle();      
        PedidoDetalle = dao.obtenerPedidoDetalle();        
        }
        catch(Exception ex)
        {}
        return PedidoDetalle;
    }
    
    @WebMethod(operationName = "agregarPedidoDetalle")        
    public void agregarPedidoDetalle(@WebParam(name = "pedidoDetalle") PedidoDetalle pedidoDetalle)  
    {
        try{
        PedidoDetalleDao dao = new OraclePedidoDetalle();
        dao.agregarPedidoDetalle(pedidoDetalle);
        }
        catch(Exception ex)
        {}
    }
    

    
    @WebMethod(operationName = "modificarPedidoDetalle")        
    public void modificarPedidoDetalle(@WebParam(name = "pedidoDetalle") PedidoDetalle pedidoDetalle)  
    {
        try{
        PedidoDetalleDao dao = new OraclePedidoDetalle();
        dao.modificarPedidoDetalle(pedidoDetalle);
        }
        catch(Exception ex)
        {}
    }
    
    @WebMethod(operationName = "eliminarPedidoDetalle")        
    public void eliminarPedidoDetalle(@WebParam(name = "id") Integer id)  
    {
        try{
        PedidoDetalleDao dao = new OraclePedidoDetalle();
        dao.eliminarPedidoDetalle(id);
        }
        catch(Exception ex)
        {}
    }
    
    @WebMethod(operationName = "buscarPedidoDetalle")        
    public PedidoDetalle buscarPedidoDetalle(@WebParam(name = "id") Integer id)  
    {
        PedidoDetalle ped = new PedidoDetalle();
        try{
        PedidoDetalleDao dao = new OraclePedidoDetalle();
        ped = dao.buscarPedidoDetalle(id);
        }
        catch(Exception ex)
        {}
        return ped;
    }
}
