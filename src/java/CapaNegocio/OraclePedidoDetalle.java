package CapaNegocio;

import CapaConexion.Conecta;
import CapaDTO.PedidoDetalle;
import Clasesinterface.PedidoDetalleDao;
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
public class OraclePedidoDetalle implements PedidoDetalleDao{
    public Conecta db;    
    public OraclePedidoDetalle()
    {
        //constructor vacío
        db = new Conecta();
    }

    @Override
    public List<PedidoDetalle> obtenerPedidoDetalle() throws SQLException {
        //Crea una lista de tipo Acceso
        List<PedidoDetalle> cPedidoDetalle = new ArrayList<PedidoDetalle>();  
        //instancia la clase acceso
        PedidoDetalle bPedidoDetalle = new PedidoDetalle();
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
            sql = "{call FUKUSUKESUSHI.LISTAR_PEDIDO_DETALLE(?)}";
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
                bPedidoDetalle = new PedidoDetalle();
                bPedidoDetalle.setPedidoDetalleId(rs.getInt(1));
                bPedidoDetalle.setPedidoCabeceraId(rs.getInt(2));
                bPedidoDetalle.setProductoId(rs.getInt(3));
                bPedidoDetalle.setCantidad(rs.getInt(4));
                bPedidoDetalle.setFechaPedidoDetalle(rs.getString(5));
                bPedidoDetalle.setHoraPedidoDetalle(rs.getString(6));
                cPedidoDetalle.add(bPedidoDetalle);
            }
            rs.close();
            cs.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return cPedidoDetalle;
    }

    @Override
    public void agregarPedidoDetalle(PedidoDetalle pedidoDetalle) throws SQLException {
        PedidoDetalle bPedidoDetalle = new PedidoDetalle();
        String sql = null;
        Connection con = null;
        CallableStatement cs = null;         
        try
        {            
            con = db.getConnection();
            //llama al insertar de la BD que tiene 3 parámetros de entrada 
            sql = "{call FUKUSUKESUSHI.PEDIDO_DETALLE_tapi.ins(?, ?, ?, ?, ?)}";
            cs = con.prepareCall(sql);
            //le seteo los 3 parámetros de entrada
            cs.setInt(1, pedidoDetalle.getPedidoCabeceraId());
            //cs.setInt(2, pedidoDetalle.getPedidoDetalleId());
            cs.setString(2, pedidoDetalle.getHoraPedidoDetalle());
            cs.setInt(3, pedidoDetalle.getProductoId());
            cs.setInt(4, pedidoDetalle.getCantidad());
            cs.setString(5, pedidoDetalle.getFechaPedidoDetalle());
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
    public void modificarPedidoDetalle(PedidoDetalle pedidoDetalle) throws SQLException {
        PedidoDetalle bPedidoDetalle = new PedidoDetalle();
        String sql = null;
        Connection con = null;
        CallableStatement cs = null;         
        try
        {            
            con = db.getConnection();
            //llama al update de la BD que tiene 3 parámetros de entrada 
            sql = "{call FUKUSUKESUSHI.PEDIDO_DETALLE_tapi.upd(?, ?, ?, ?, ?, ?)}";
            cs = con.prepareCall(sql);
            cs.setInt(1, pedidoDetalle.getPedidoCabeceraId());
            cs.setInt(2, pedidoDetalle.getPedidoDetalleId());
            cs.setString(3, pedidoDetalle.getHoraPedidoDetalle());
            cs.setInt(4, pedidoDetalle.getProductoId());
            cs.setInt(5, pedidoDetalle.getCantidad());
            cs.setString(6, pedidoDetalle.getFechaPedidoDetalle());
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
    public void eliminarPedidoDetalle(Integer id) throws SQLException {
        String sql = null;
        Connection con = null;
        CallableStatement cs = null;         
        try
        {            
            con = db.getConnection();
            //llama al eliminar que recibe 1 parámetro
            sql = "{call FUKUSUKESUSHI.PEDIDO_DETALLE_tapi.del(?)}";
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
    public PedidoDetalle buscarPedidoDetalle(Integer id) throws SQLException {
        
        PedidoDetalle bPedidoDetalle = new PedidoDetalle();
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
            sql = ("{call FUKUSUKESUSHI.BUSCAR_PEDIDO_DETALLE(?,?)}");            
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
                bPedidoDetalle = new PedidoDetalle();
                bPedidoDetalle.setPedidoDetalleId(rs.getInt(1));
                bPedidoDetalle.setPedidoCabeceraId(rs.getInt(2));
                bPedidoDetalle.setProductoId(rs.getInt(3));
                bPedidoDetalle.setCantidad(rs.getInt(4));
                bPedidoDetalle.setFechaPedidoDetalle(rs.getString(5));
                bPedidoDetalle.setHoraPedidoDetalle(rs.getString(6));
                
            }
            rs.close();
            
            cs.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return bPedidoDetalle;
    }
}
