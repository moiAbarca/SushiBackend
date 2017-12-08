/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebService;


import CapaDTO.Oferta;
import CapaNegocio.OracleOferta;
import Clasesinterface.OfertaDao;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author moi
 */
@WebService(serviceName = "ServiceOferta")
public class ServiceOferta {

    List<Oferta> Oferta;
    
    //comienzo de los webServices    
    @WebMethod(operationName = "obtenerOferta")        
    public List<Oferta> obtenerOferta()  
    {
        try{        
        OfertaDao dao = new OracleOferta();      
        Oferta = dao.obtenerOferta();        
        }
        catch(Exception ex)
        {}
        return Oferta;
    }
    
    @WebMethod(operationName = "agregarOferta")        
    public void agregarOferta(@WebParam(name = "oferta") Oferta oferta)  
    {
        try{
        OfertaDao dao = new OracleOferta();      
        dao.agregarOferta(oferta);
        }
        catch(Exception ex)
        {}
    }
    

    
    @WebMethod(operationName = "modificarOferta")        
    public void modificarOferta(@WebParam(name = "oferta") Oferta oferta)  
    {
        try{
        OfertaDao dao = new OracleOferta();      
        dao.modificarOferta(oferta);
        }
        catch(Exception ex)
        {}
    }
    
    @WebMethod(operationName = "eliminarOferta")        
    public void eliminarOferta(@WebParam(name = "id") Integer id)  
    {
        try{
        OfertaDao dao = new OracleOferta();      
        dao.eliminarOferta(id);
        }
        catch(Exception ex)
        {}
    }
    
    @WebMethod(operationName = "buscarOferta")        
    public Oferta buscarOferta(@WebParam(name = "id") Integer id)  
    {
        Oferta of = new Oferta();
        try{
        OfertaDao dao = new OracleOferta();      
        of = dao.buscarOferta(id);
        }
        catch(Exception ex)
        {}
        return of;
    }
}
