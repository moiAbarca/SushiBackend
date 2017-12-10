package CapaNegocio;

import CapaConexion.Conecta;
import CapaDTO.PedidoCabecera;
import Clasesinterface.PedidoCabeceraDao;
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
public class OraclePedidoCabecera implements PedidoCabeceraDao{
    public Conecta db;    
    public OraclePedidoCabecera()
    {
        //constructor 
        db = new Conecta();
    }

    @Override
    public List<PedidoCabecera> obtenerPedidoCabecera() throws SQLException {
        //Crea una lista de tipo Acceso
        List<PedidoCabecera> cPedidoCabecera = new ArrayList<PedidoCabecera>();  
        //instancia la clase acceso
        PedidoCabecera bPedidoCabecera = new PedidoCabecera();
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
            sql = "{call FUKUSUKESUSHI.LISTAR_PEDIDO_CABECERA(?)}";
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
                bPedidoCabecera = new PedidoCabecera();
                bPedidoCabecera.setPedidoCabeceraId(rs.getInt(1));
                bPedidoCabecera.setEstablecimientoId(rs.getInt(2));
                
                bPedidoCabecera.setClienteId(rs.getInt(3));
                bPedidoCabecera.setFechaPedido(rs.getString(4));
                bPedidoCabecera.setHoraPedido(rs.getString(5));
                bPedidoCabecera.setEstadoPedido(rs.getString(6));                
                cPedidoCabecera.add(bPedidoCabecera);
            }
            rs.close();
            cs.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return cPedidoCabecera;
    }

    @Override
    public void agregarPedidoCabecera(PedidoCabecera pedidoCabecera) throws SQLException {
        PedidoCabecera bPedidoCabecera = new PedidoCabecera();
        String sql = null;
        Connection con = null;
        CallableStatement cs = null;         
        try
        {            
            con = db.getConnection();
            //llama al insertar de la BD que tiene 3 parámetros de entrada 
            sql = "{call FUKUSUKESUSHI.PEDIDO_CABECERA_tapi.ins( ?,?, ?, ?,?)}";
            cs = con.prepareCall(sql);
            //le seteo los 3 parámetros de entrada
            //cs.setInt(1, pedidoCabecera.getPedidoCabeceraId());
            cs.setInt(1, pedidoCabecera.getEstablecimientoId());
            cs.setInt(2, pedidoCabecera.getClienteId());            
            cs.setString(3, pedidoCabecera.getHoraPedido());
            cs.setString(4, pedidoCabecera.getEstadoPedido());
            cs.setString(5, pedidoCabecera.getFechaPedido());            
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
    public void modificarPedidoCabecera(PedidoCabecera pedidoCabecera) throws SQLException {
        PedidoCabecera bPedidoCabecera = new PedidoCabecera();
        String sql = null;
        Connection con = null;
        CallableStatement cs = null;         
        try
        {            
            con = db.getConnection();
            //llama al update de la BD que tiene 3 parámetros de entrada 
            sql = "{call FUKUSUKESUSHI.PEDIDO_CABECERA_tapi.upd(?, ?, ?, ?, ?, ?)}";
            cs = con.prepareCall(sql);
            cs.setInt(1, pedidoCabecera.getPedidoCabeceraId());
            cs.setInt(2, pedidoCabecera.getEstablecimientoId());
            cs.setInt(3, pedidoCabecera.getClienteId());
            
            cs.setString(4, pedidoCabecera.getHoraPedido());
            cs.setString(5, pedidoCabecera.getEstadoPedido());
            cs.setString(6, pedidoCabecera.getFechaPedido());    
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
    public void eliminarPedidoCabecera(Integer id) throws SQLException {
        String sql = null;
        Connection con = null;
        CallableStatement cs = null;         
        try
        {            
            con = db.getConnection();
            //llama al eliminar que recibe 1 parámetro
            sql = "{call FUKUSUKESUSHI.PEDIDO_CABECERA_tapi.del(?)}";
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
    public PedidoCabecera buscarPedidoCabecera(Integer id) throws SQLException {
        
        PedidoCabecera bPedidoCabecera = new PedidoCabecera();
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
            sql = ("{call FUKUSUKESUSHI.BUSCAR_PEDIDO_CABECERA(?,?)}");            
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
                bPedidoCabecera = new PedidoCabecera();
                bPedidoCabecera.setPedidoCabeceraId(rs.getInt(1));
                bPedidoCabecera.setEstablecimientoId(rs.getInt(2));
                
                bPedidoCabecera.setClienteId(rs.getInt(3));
                bPedidoCabecera.setFechaPedido(rs.getString(4));
                bPedidoCabecera.setHoraPedido(rs.getString(5));
                bPedidoCabecera.setEstadoPedido(rs.getString(6));                 
                
            }
            rs.close();
            
            cs.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return bPedidoCabecera;
    }
}
