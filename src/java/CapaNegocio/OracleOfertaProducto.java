package CapaNegocio;

import CapaConexion.Conecta;
import CapaDTO.OfertaProducto;
import Clasesinterface.OfertaProducDao;
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
public class OracleOfertaProducto implements OfertaProducDao{
    public Conecta db;    
    public OracleOfertaProducto()
    {
        //constructor vacío
        db = new Conecta();
    }

    @Override
    public List<OfertaProducto> obtenerOfertaProducto() throws SQLException {
        //Crea una lista de tipo Acceso
        List<OfertaProducto> cOfertaProducto = new ArrayList<OfertaProducto>();  
        //instancia la clase acceso
        OfertaProducto bOfertaProducto = new OfertaProducto();
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
            sql = "{call FUKUSUKESUSHI.LISTAR_OFERTAS_PRODUCTOS(?)}";
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
                bOfertaProducto = new OfertaProducto();
                bOfertaProducto.setOfertaId(rs.getInt(1));
                bOfertaProducto.setProductoId(rs.getInt(2));
                bOfertaProducto.setOfertas_producto_Id(rs.getInt(3));                
                cOfertaProducto.add(bOfertaProducto);
            }
            rs.close();
            cs.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return cOfertaProducto;
    }

    @Override
    public void agregarOfertaProducto(OfertaProducto ofertaProducto) throws SQLException {
        OfertaProducto bOfertaProducto = new OfertaProducto();
        String sql = null;
        Connection con = null;
        CallableStatement cs = null;         
        try
        {            
            con = db.getConnection();
            //llama al insertar de la BD que tiene 3 parámetros de entrada 
            sql = "{call FUKUSUKESUSHI.OFERTAS_PRODUCTO_tapi.ins(?, ?, ?)}";
            cs = con.prepareCall(sql);
            //le seteo los 3 parámetros de entrada
            cs.setInt(1, ofertaProducto.getOfertaId());
            cs.setInt(2, ofertaProducto.getProductoId()); 
            cs.setInt(3, ofertaProducto.getOfertas_producto_Id());
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
    public void modificarOfertaProducto(OfertaProducto ofertaProducto) throws SQLException {
        OfertaProducto bOfertaProducto = new OfertaProducto();
        String sql = null;
        Connection con = null;
        CallableStatement cs = null;         
        try
        {            
            con = db.getConnection();
            //llama al update de la BD que tiene 3 parámetros de entrada 
            sql = "{call FUKUSUKESUSHI.OFERTAS_PRODUCTO_tapi.upd(?, ?, ?)}";
            cs = con.prepareCall(sql);
            cs.setInt(1, ofertaProducto.getOfertaId());
            cs.setInt(2, ofertaProducto.getProductoId()); 
            cs.setInt(3, ofertaProducto.getOfertas_producto_Id());
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
    public void eliminarOfertaProducto(Integer id) throws SQLException {
        String sql = null;
        Connection con = null;
        CallableStatement cs = null;         
        try
        {            
            con = db.getConnection();
            //llama al eliminar que recibe 1 parámetro
            sql = "{call FUKUSUKESUSHI.OFERTAS_PRODUCTO_tapi.del(?)}";
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
    public OfertaProducto buscarOfertaProducto(Integer id) throws SQLException {
        
        OfertaProducto bOfertaProducto = new OfertaProducto();
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
            sql = ("{call FUKUSUKESUSHI.BUSCAR_OFERTAS_PRODUCTO(?,?)}");            
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
                bOfertaProducto = new OfertaProducto();
                bOfertaProducto.setOfertaId(rs.getInt(1));
                bOfertaProducto.setProductoId(rs.getInt(2));                
                bOfertaProducto.setOfertas_producto_Id(rs.getInt(3));      
            }
            rs.close();
            
            cs.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return bOfertaProducto;
    }
}
