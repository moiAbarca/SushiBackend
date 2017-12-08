/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebService;

import CapaDTO.OfertaProducto;
import CapaNegocio.OracleOfertaProducto;
import Clasesinterface.OfertaProducDao;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author moi
 */
@WebService(serviceName = "ServiceOfertaProducto")
public class ServiceOfertaProducto {

    List<OfertaProducto> OfertaProducto;
    
    //comienzo de los webServices    
    @WebMethod(operationName = "obtenerOfertaProducto")        
    public List<OfertaProducto> obtenerOfertaProducto()  
    {
        try{        
        OfertaProducDao dao = new OracleOfertaProducto();      
        OfertaProducto = dao.obtenerOfertaProducto();        
        }
        catch(Exception ex)
        {}
        return OfertaProducto;
    }
    
    @WebMethod(operationName = "agregarOfertaProducto")        
    public void agregarOfertaProducto(@WebParam(name = "ofertaProducto") OfertaProducto ofertaProducto)  
    {
        try{
        OfertaProducDao dao = new OracleOfertaProducto();      
        dao.agregarOfertaProducto(ofertaProducto);
        }
        catch(Exception ex)
        {}
    }
    

    
    @WebMethod(operationName = "modificarOfertaProducto")        
    public void modificarOfertaProducto(@WebParam(name = "ofertaProducto") OfertaProducto ofertaProducto)  
    {
        try{
        OfertaProducDao dao = new OracleOfertaProducto();      
        dao.modificarOfertaProducto(ofertaProducto);
        }
        catch(Exception ex)
        {}
    }
    
    @WebMethod(operationName = "eliminarOfertaProducto")        
    public void eliminarOfertaProducto(@WebParam(name = "id") Integer id)  
    {
        try{
        OfertaProducDao dao = new OracleOfertaProducto();      
        dao.eliminarOfertaProducto(id);
        }
        catch(Exception ex)
        {}
    }
    
    @WebMethod(operationName = "buscarOfertaProducto")        
    public OfertaProducto buscarOfertaProducto(@WebParam(name = "id") Integer id)  
    {
        OfertaProducto ofp = new OfertaProducto();
        try{
        OfertaProducDao dao = new OracleOfertaProducto();      
        ofp = dao.buscarOfertaProducto(id);
        }
        catch(Exception ex)
        {}
        return ofp;
    }
}
