/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebService;

import CapaDTO.CategoriaProducto;
import CapaNegocio.OracleCategoriaProducto;
import Clasesinterface.CategoriaProducDao;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author moi
 */
@WebService(serviceName = "ServiceCategoriaProducto")
public class ServiceCategoriaProducto {

   List<CategoriaProducto> categoriaProducto;
   
    //comienzo de los webServices
    
    @WebMethod(operationName = "obtenerCategoriaProducto")        
    public List<CategoriaProducto> obtenerCategoriaProducto()  
    {
        try{        
        CategoriaProducDao dao = new OracleCategoriaProducto();      
        categoriaProducto = dao.obtenerCategoriaProducto();        
        }
        catch(Exception ex)
        {}
        return categoriaProducto;
    }
    
    @WebMethod(operationName = "agregarCategoriaProducto")        
    public void agregarCategoriaProducto(@WebParam(name = "categoriaProducto") CategoriaProducto categoriaProducto)  
    {
        try{
        CategoriaProducDao dao = new OracleCategoriaProducto();      
        dao.agregarCategoriaProducto(categoriaProducto);
        }
        catch(Exception ex)
        {}
    }
    

    
    @WebMethod(operationName = "modificarCategoriaProducto")        
    public void modificarCategoriaProducto(@WebParam(name = "categoriaProducto") CategoriaProducto categoriaProducto
                                         
            )  
    {
        try{
        CategoriaProducDao dao = new OracleCategoriaProducto();      
        dao.modificarCategoriaProducto(categoriaProducto);
        }
        catch(Exception ex)
        {}
    }
    
    @WebMethod(operationName = "eliminarCategoriaProducto")        
    public void eliminarCategoriaProducto(@WebParam(name = "id") Integer id)  
    {
        try{
        CategoriaProducDao dao = new OracleCategoriaProducto();      
        dao.eliminarCategoriaProducto(id);
        }
        catch(Exception ex)
        {}
    }
    
    @WebMethod(operationName = "buscarCategoriaProducto")        
    public CategoriaProducto buscarCategoriaProducto(@WebParam(name = "id") Integer id)  
    {
        CategoriaProducto cat = new CategoriaProducto();
        try{
        CategoriaProducDao dao = new OracleCategoriaProducto();      
        cat = dao.buscarCategoriaProducto(id);
        }
        catch(Exception ex)
        {}
        return cat;
    }
}
