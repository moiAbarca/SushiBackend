/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebService;


import CapaDTO.Producto;
import CapaNegocio.OracleProducto;
import Clasesinterface.ProductoDao;
import java.sql.SQLException;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author moi
 */
@WebService(serviceName = "ServiceProducto")
public class ServiceProducto {



    List<Producto> Producto;
    
    //comienzo de los webServices    
    @WebMethod(operationName = "obtenerProducto")        
    public List<Producto> obtenerProducto()  
    {
        try{        
        ProductoDao dao = new OracleProducto();      
        Producto = dao.obtenerProducto();        
        }
        catch(Exception ex)
        {}
        return Producto;
    }
    
    @WebMethod(operationName = "agregarProducto")        
    public void agregarProducto(@WebParam(name = "producto") Producto producto)  
    {
        try{
        ProductoDao dao = new OracleProducto();
        dao.agregarProducto(producto);
        }
        catch(Exception ex)
        {}
    }
    

    
    @WebMethod(operationName = "modificarProducto")        
    public void modificarProducto(@WebParam(name = "producto") Producto producto)  
    {
        try{
        ProductoDao dao = new OracleProducto();
        dao.modificarProducto(producto);
        }
        catch(Exception ex)
        {}
    }
    
    @WebMethod(operationName = "eliminarProducto")        
    public void eliminarProducto(@WebParam(name = "id") Integer id)  
    {
        try{
        ProductoDao dao = new OracleProducto();
        dao.eliminarProducto(id);
        }
        catch(Exception ex)
        {}
    }
    
    @WebMethod(operationName = "buscarProducto")        
    public Producto buscarProducto(@WebParam(name = "id") Integer id)  
    {
        Producto pro = new Producto();
        try{
        ProductoDao dao = new OracleProducto();
        pro = dao.buscarProducto(id);
        }
        catch(Exception ex)
        {}
        return pro;
    }
    
    @WebMethod(operationName = "buscarProductoNombre")        
    public Producto buscarProductoNombre(@WebParam(name = "nombre") String nombre)  
    {
        Producto pro = new Producto();
        try{
        ProductoDao dao = new OracleProducto();
        pro = dao.buscarProductoNombre(nombre);
        }
        catch(Exception ex)
        {}
        return pro;
    }
    
    
}
