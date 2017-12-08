/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaNegocio;

import CapaConexion.Conecta;
import CapaDTO.ResgistroPago;
import Clasesinterface.RegistroPagoDao;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author moi
 */
public class OracleRegistroPago implements RegistroPagoDao{
    public Conecta db;    
    public OracleRegistroPago()
    {
        //constructor 
        db = new Conecta();
    }

    @Override
    public List<ResgistroPago> obtenerResgistroPago() throws SQLException {
        List<ResgistroPago> cResgistroPago = new ArrayList<ResgistroPago>();  
        //instancia la clase acceso
        ResgistroPago bResgistroPago = new ResgistroPago();
        String sql = null;
        Connection con = null;  
        //CallableStatement = me permite ejecutar sentencias SQL
        CallableStatement cs = null;
        //ResultSet = proporciona varios métodos para obtener los datos de columna correspondientes a un fila
        ResultSet rs;
        try
        {
            //se conecta a la BD
            con = db.getConnection();
            //el SP tiene solo un parámetro de salida
            //por eso solo tiene un ?
            sql = "{call FUKUSUKESUSHI.LISTAR_REGISTRO_PAGO(?)}";
            //le paso al CallableStatement la sentencia SQL
            cs = con.prepareCall(sql);
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.execute();
            //creo un resultset con todos los datos de la tabla Acceso
            rs = (ResultSet)cs.getObject(1);
            //el resulset por defecto comienza en un índice antes que mi resultado
            //por lo que debo ponerlo en NEXT para que me devuelva desde el primer valor en adelante
            //cuando se que v aa devolver varios valores ocupo while
            //cuando se que va a devolver uno, ocupo un IF
            while(rs.next())
            {
                bResgistroPago = new ResgistroPago();
                bResgistroPago.setRegistroPagoId(rs.getInt(1));
                bResgistroPago.setTipoPagoId(rs.getInt(2));
                bResgistroPago.setPedidoCabeceraId(rs.getInt(3));
                bResgistroPago.setEstadoPago(rs.getString(4));
                bResgistroPago.setCodigoAutorizacion(rs.getInt(5));
                bResgistroPago.setNumeroCuotas(rs.getInt(6));
                bResgistroPago.setMontoTotal(rs.getInt(7));                
                cResgistroPago.add(bResgistroPago);
            }
            rs.close();
            cs.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return cResgistroPago;
    }

    @Override
    public void agregarResgistroPago(ResgistroPago resgistroPago) throws SQLException {
        ResgistroPago bResgistroPago = new ResgistroPago();
        String sql = null;
        Connection con = null;
        CallableStatement cs = null;         
        try
        {            
            con = db.getConnection();
            //llama al insertar de la BD que tiene 3 parámetros de entrada 
            sql = "{call FUKUSUKESUSHI.REGISTRO_PAGO_tapi.ins(?, ?, ?, ?, ?, ?, ?)}";
            cs = con.prepareCall(sql);
            //le seteo los 3 parámetros de entrada
            cs.setInt(1, resgistroPago.getNumeroCuotas());
            cs.setInt(2, resgistroPago.getMontoTotal());
            cs.setInt(3, resgistroPago.getPedidoCabeceraId());
            cs.setInt(4, resgistroPago.getCodigoAutorizacion());
            cs.setString(5, resgistroPago.getEstadoPago());
            cs.setInt(6, resgistroPago.getRegistroPagoId());
            cs.setInt(7, resgistroPago.getTipoPagoId());           
            cs.execute();          
            cs.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println("No se pudo agregar: " + e);
        }
    }

    @Override
    public void modificarResgistroPago(ResgistroPago resgistroPago) throws SQLException {
        ResgistroPago bResgistroPago = new ResgistroPago();
        String sql = null;
        Connection con = null;
        CallableStatement cs = null;         
        try
        {            
            con = db.getConnection();
            //llama al update de la BD que tiene 3 parámetros de entrada 
            sql = "{call FUKUSUKESUSHI.REGISTRO_PAGO_tapi.upd(?, ?, ?, ?, ?, ?, ?)}";
            cs = con.prepareCall(sql);
            cs.setInt(1, resgistroPago.getNumeroCuotas());
            cs.setInt(2, resgistroPago.getMontoTotal());
            cs.setInt(3, resgistroPago.getPedidoCabeceraId());
            cs.setInt(4, resgistroPago.getCodigoAutorizacion());
            cs.setString(5, resgistroPago.getEstadoPago());
            cs.setInt(6, resgistroPago.getRegistroPagoId());
            cs.setInt(7, resgistroPago.getTipoPagoId());      
            cs.execute();          
            cs.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println("No se pudo agregar: " + e);
        }
    }

    @Override
    public void eliminarResgistroPago(Integer id) throws SQLException {
        String sql = null;
        Connection con = null;
        CallableStatement cs = null;         
        try
        {            
            con = db.getConnection();
            //llama al eliminar que recibe 1 parámetro
            sql = "{call FUKUSUKESUSHI.REGISTRO_PAGO_tapi.del(?)}";
            cs = con.prepareCall(sql);
            //entrego el parámetro de entrada de la función 
            //y si existe en la BD lo borro
            cs.setInt(1, id);
            cs.execute();          
            cs.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public ResgistroPago buscarResgistroPago(Integer id) throws SQLException {
        
        ResgistroPago bResgistroPago = new ResgistroPago();
        String sql = null;
        Connection con = null;        
        CallableStatement cs = null;
        ResultSet rs;
        try
        {
            con = db.getConnection();   
            //llama a la función de tiene dos parámetros
            //el primero de entrada
            //y el segundo de salida
            sql = ("{call FUKUSUKESUSHI.BUSCAR_REGISTRO_PAGO(?,?)}");            
            cs = con.prepareCall(sql);
            //seteo el primer parámetro
            cs.setInt(1, id); 
            //defino el tipo de dato que debe devolver
            cs.registerOutParameter(2, OracleTypes.CURSOR);
            cs.execute();
            
            //creo un resultset con todos los datos de la tabla Acceso
            //devuelve el objeto OUT que se encuentra en el 2 parámetro
            rs = (ResultSet)cs.getObject(2);
            if(rs.next())
            {
                bResgistroPago = new ResgistroPago();
                bResgistroPago.setRegistroPagoId(rs.getInt(1));
                bResgistroPago.setTipoPagoId(rs.getInt(2));
                bResgistroPago.setPedidoCabeceraId(rs.getInt(3));
                bResgistroPago.setEstadoPago(rs.getString(4));
                bResgistroPago.setCodigoAutorizacion(rs.getInt(5));
                bResgistroPago.setNumeroCuotas(rs.getInt(6));
                bResgistroPago.setMontoTotal(rs.getInt(7));                
                
            }
            rs.close();
            
            cs.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return bResgistroPago;
    }
}
