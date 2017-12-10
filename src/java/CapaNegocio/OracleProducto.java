package CapaNegocio;

import CapaConexion.Conecta;

import CapaDTO.Producto;
import Clasesinterface.ProductoDao;
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
public class OracleProducto implements ProductoDao{
    //llama a la clase conecta...para conectarse a la BD
    public Conecta db;    
    public OracleProducto()
    {
        //constructor vacío
        db = new Conecta();
    }
    
    //Inicio de implementación de métodos de la Interface

    @Override
    public List<Producto> obtenerProducto() throws SQLException {       
        List<Producto> cProducto = new ArrayList<Producto>();          
        Producto bProducto = new Producto();
        String sql = null;
        Connection con = null;          
        CallableStatement cs = null;        
        ResultSet rs;
        try
        {            
            con = db.getConnection();         
            sql = "{call FUKUSUKESUSHI.LISTAR_PRODUCTO(?)}";            
            cs = con.prepareCall(sql);
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.execute();            
            rs = (ResultSet)cs.getObject(1);            
            while(rs.next())
            {
                bProducto = new Producto();
                bProducto.setProductoId(rs.getInt(1));
                bProducto.setCategoriaProductoId(rs.getInt(2));
                bProducto.setNombreProducto(rs.getString(3));
                bProducto.setPorcionesProdcuto(rs.getInt(4));
                bProducto.setPrecioProducto(rs.getInt(5));
                bProducto.setDescripcionProducto(rs.getString(6));
                bProducto.setImagenProdcuto(rs.getString(7));
                bProducto.setDisponibilidadProducto(rs.getBoolean(8));
                
                cProducto.add(bProducto);
            }
            rs.close();
            cs.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return cProducto;
    }

    @Override
    public void agregarProducto(Producto producto) throws SQLException {        
        String sql = null;
        Connection con = null;
        CallableStatement cs = null;         
        try
        {            
            con = db.getConnection();
            //llama al insertar de la BD que tiene 3 parámetros de entrada 
            sql = "{call FUKUSUKESUSHI.PRODUCTO_tapi.ins(?, ?, ?, ?,  ?, ?, ?)}";
            cs = con.prepareCall(sql);
            //le seteo los 7 parámetros de entrada
            cs.setString(1, producto.getImagenProdcuto());
            cs.setString(2, producto.getNombreProducto());
            cs.setString(3, producto.getDescripcionProducto());
            cs.setInt(4, producto.getCategoriaProductoId());
            cs.setBoolean(5, producto.isDisponibilidadProducto());
            cs.setInt(6, producto.getPorcionesProdcuto());
            cs.setInt(7, producto.getPrecioProducto());
            //cs.setInt(8, producto.getProductoId());            
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
    public void modificarProducto(Producto producto) throws SQLException {
        Producto bProducto = new Producto();
        String sql = null;
        Connection con = null;
        CallableStatement cs = null;         
        try
        {            
            con = db.getConnection();
            //llama al update de la BD que tiene 3 parámetros de entrada 
            sql = "{call FUKUSUKESUSHI.PRODUCTO_tapi.upd(?, ?, ?,?, ?, ?,?, ?)}";
            cs = con.prepareCall(sql);
            cs.setString(1, producto.getImagenProdcuto());
            cs.setString(2, producto.getNombreProducto());
            cs.setString(3, producto.getDescripcionProducto());
            cs.setInt(4, producto.getCategoriaProductoId());            
            cs.setBoolean(5, producto.isDisponibilidadProducto());       
            cs.setInt(6, producto.getPorcionesProdcuto());
            cs.setInt(7, producto.getPrecioProducto());
            cs.setInt(8, producto.getProductoId());            
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
    public void eliminarProducto(Integer id) throws SQLException {
        String sql = null;
        Connection con = null;
        CallableStatement cs = null;         
        try
        {            
            con = db.getConnection();
            //llama al eliminar que recibe 1 parámetro
            sql = "{call FUKUSUKESUSHI.PRODUCTO_tapi.del(?)}";
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
    public Producto buscarProducto(Integer id) throws SQLException {
        
        Producto bProducto = new Producto();
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
            sql = ("{call FUKUSUKESUSHI.BUSCAR_PRODUCTO(?,?)}");            
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
                bProducto = new Producto();
                bProducto.setProductoId(rs.getInt(1));
                bProducto.setCategoriaProductoId(rs.getInt(2));
                bProducto.setNombreProducto(rs.getString(3));
                bProducto.setPorcionesProdcuto(rs.getInt(4));
                bProducto.setPrecioProducto(rs.getInt(5));
                bProducto.setDescripcionProducto(rs.getString(6));
                bProducto.setImagenProdcuto(rs.getString(7));
                bProducto.setDisponibilidadProducto(rs.getBoolean(8));
                
            }
            rs.close();
            
            cs.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return bProducto;
    }

    @Override
    public Producto buscarProductoNombre(String nombre) throws SQLException {
        Producto bProducto = new Producto();
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
            sql = ("{call FUKUSUKESUSHI.BUSCAR_PRODUCTO_NOMBRE(?,?)}");            
            cs = con.prepareCall(sql);
            //seteo el primer parámetro
            cs.setString(1, nombre); 
            //defino el tipo de dato que debe devolver
            cs.registerOutParameter(2, OracleTypes.CURSOR);
            cs.execute();
            
            //creo un resultset con todos los datos de la tabla Acceso
            //devuelve el objeto OUT que se encuentra en el 2 parámetro
            rs = (ResultSet)cs.getObject(2);
            if(rs.next())
            {
                bProducto = new Producto();
                bProducto.setProductoId(rs.getInt(1));
                bProducto.setCategoriaProductoId(rs.getInt(2));
                bProducto.setNombreProducto(rs.getString(3));
                bProducto.setPorcionesProdcuto(rs.getInt(4));
                bProducto.setPrecioProducto(rs.getInt(5));
                bProducto.setDescripcionProducto(rs.getString(6));
                bProducto.setImagenProdcuto(rs.getString(7));
                bProducto.setDisponibilidadProducto(rs.getBoolean(8));
                
            }
            rs.close();
            
            cs.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return bProducto;
    }
    
}
