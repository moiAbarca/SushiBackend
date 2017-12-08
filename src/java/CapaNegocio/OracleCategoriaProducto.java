package CapaNegocio;

import CapaConexion.Conecta;
import CapaDTO.CategoriaProducto;
import Clasesinterface.CategoriaProducDao;
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
public class OracleCategoriaProducto implements CategoriaProducDao{
    //llama a la clase conecta...para conectarse a la BD
    public Conecta db;    
    public OracleCategoriaProducto()
    {
        //constructor vacío
        db = new Conecta();
    }
    
    //Inicio de implementación de métodos de la Interface

    @Override
    public List<CategoriaProducto> obtenerCategoriaProducto() throws SQLException {
        //Crea una lista de tipo Acceso
        List<CategoriaProducto> cCategoriaProducto = new ArrayList<CategoriaProducto>();  
        //instancia la clase acceso
        CategoriaProducto bCategoriaProducto = new CategoriaProducto();
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
            sql = "{call FUKUSUKESUSHI.LISTAR_CATEGORIA_PRODUCTO(?)}";
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
                bCategoriaProducto = new CategoriaProducto();
                bCategoriaProducto.setCategoriaProductoId(rs.getInt(1));
                bCategoriaProducto.setNombreCategoria(rs.getString(2));                
                cCategoriaProducto.add(bCategoriaProducto);
            }
            rs.close();
            cs.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return cCategoriaProducto;
    }

    @Override
    public void agregarCategoriaProducto(CategoriaProducto categoriaProducto) throws SQLException {
        CategoriaProducto bCategoriaProducto = new CategoriaProducto();
        String sql = null;
        Connection con = null;
        CallableStatement cs = null;         
        try
        {            
            con = db.getConnection();
            //llama al insertar de la BD que tiene 3 parámetros de entrada 
            sql = "{call FUKUSUKESUSHI.CATEGORIA_PRODUCTO_tapi.ins(?, ?)}";
            cs = con.prepareCall(sql);
            //le seteo los 3 parámetros de entrada
            cs.setString(1, categoriaProducto.getNombreCategoria());
            cs.setInt(2, categoriaProducto.getCategoriaProductoId());                       
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
    public void modificarCategoriaProducto(CategoriaProducto categoriaProducto) throws SQLException {
        CategoriaProducto bCategoriaProducto = new CategoriaProducto();
        String sql = null;
        Connection con = null;
        CallableStatement cs = null;         
        try
        {            
            con = db.getConnection();
            //llama al update de la BD que tiene 3 parámetros de entrada 
            sql = "{call FUKUSUKESUSHI.CATEGORIA_PRODUCTO_tapi.upd(?, ?)}";
            cs = con.prepareCall(sql);
            cs.setString(1, categoriaProducto.getNombreCategoria());
            cs.setInt(2, categoriaProducto.getCategoriaProductoId());            
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
    public void eliminarCategoriaProducto(Integer id) throws SQLException {
        String sql = null;
        Connection con = null;
        CallableStatement cs = null;         
        try
        {            
            con = db.getConnection();
            //llama al eliminar que recibe 1 parámetro
            sql = "{call FUKUSUKESUSHI.CATEGORIA_PRODUCTO_tapi.del(?)}";
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
    public CategoriaProducto buscarCategoriaProducto(Integer id) throws SQLException {        
        CategoriaProducto bCategoriaProducto = new CategoriaProducto();
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
            sql = ("{call FUKUSUKESUSHI.BUSCAR_CATEGORIA_PRODUCTO(?,?)}");            
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
                bCategoriaProducto = new CategoriaProducto();
                bCategoriaProducto.setCategoriaProductoId(rs.getInt(1));
                bCategoriaProducto.setNombreCategoria(rs.getString(2));                
                
            }
            rs.close();
            
            cs.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return bCategoriaProducto;
    }
    
}
