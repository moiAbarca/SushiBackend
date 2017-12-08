package CapaNegocio;

import CapaConexion.Conecta;
import CapaDTO.Establecimiento;
import Clasesinterface.EstablecimientoDao;
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
//implementa la interfaz y los métodos creados en ella
public class OracleEstablecimiento implements EstablecimientoDao{
    //llama a la clase conecta...para conectarse a la BD
    public Conecta db;    
    public OracleEstablecimiento()
    {
        //constructor vacío
        db = new Conecta();
    }
    
    //Inicio de implementación de métodos de la Interface

    @Override
    public List<Establecimiento> obtenerEstablecimiento() throws SQLException {
        //Crea una lista de tipo Acceso
        List<Establecimiento> cEstablecimiento = new ArrayList<Establecimiento>();  
        //instancia la clase acceso
        Establecimiento bEstablecimiento = new Establecimiento();
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
            sql = "{call FUKUSUKESUSHI.LISTAR_ESTABLECIMIENTO(?)}";
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
                bEstablecimiento = new Establecimiento();
                bEstablecimiento.setEstablecimientoId(rs.getInt(1));
                bEstablecimiento.setComuna(rs.getString(2));
                bEstablecimiento.setNombreLocal(rs.getString(3));
                bEstablecimiento.setDireccion(rs.getString(4));
                cEstablecimiento.add(bEstablecimiento);
            }
            rs.close();
            cs.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return cEstablecimiento;
    }

    @Override
    public void agregarEstablecimiento(Establecimiento establecimiento) throws SQLException {
        Establecimiento bEstablecimiento = new Establecimiento();
        String sql = null;
        Connection con = null;
        CallableStatement cs = null;         
        try
        {            
            con = db.getConnection();
            //llama al insertar de la BD que tiene 3 parámetros de entrada 
            sql = "{call FUKUSUKESUSHI.ESTABLECIMIENTO_tapi.ins(?, ?, ?, ?)}";
            cs = con.prepareCall(sql);
            //le seteo los 3 parámetros de entrada
            cs.setString(1, establecimiento.getDireccion());
            cs.setInt(2, establecimiento.getEstablecimientoId());
            cs.setString(3, establecimiento.getComuna());
            cs.setString(4, establecimiento.getNombreLocal());
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
    public void modificarEstablecimiento(Establecimiento establecimiento) throws SQLException {
        Establecimiento bEstablecimiento = new Establecimiento();
        String sql = null;
        Connection con = null;
        CallableStatement cs = null;         
        try
        {            
            con = db.getConnection();
            //llama al update de la BD que tiene 3 parámetros de entrada 
            sql = "{call FUKUSUKESUSHI.ESTABLECIMIENTO_tapi.upd(?, ?, ?, ?)}";
            cs = con.prepareCall(sql);
            cs.setString(1, establecimiento.getDireccion());
            cs.setInt(2, establecimiento.getEstablecimientoId());
            cs.setString(3, establecimiento.getComuna());
            cs.setString(4, establecimiento.getNombreLocal());
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
    public void eliminarEstablecimiento(Integer id) throws SQLException {
        String sql = null;
        Connection con = null;
        CallableStatement cs = null;         
        try
        {            
            con = db.getConnection();
            //llama al eliminar que recibe 1 parámetro
            sql = "{call FUKUSUKESUSHI.ESTABLECIMIENTO_tapi.del(?)}";
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
    public Establecimiento buscarEstablecimiento(Integer id) throws SQLException {
        
        Establecimiento bEstablecimiento = new Establecimiento();
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
            sql = ("{call FUKUSUKESUSHI.BUSCAR_ESTABLECIMIENTO(?,?)}");            
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
                bEstablecimiento = new Establecimiento();
                bEstablecimiento.setEstablecimientoId(rs.getInt(1));
                bEstablecimiento.setComuna(rs.getString(2));
                bEstablecimiento.setNombreLocal(rs.getString(3));
                bEstablecimiento.setDireccion(rs.getString(4));
                
            }
            rs.close();
            
            cs.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return bEstablecimiento;
    }
    
}
