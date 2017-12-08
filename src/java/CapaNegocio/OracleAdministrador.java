/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaNegocio;


import CapaConexion.Conecta;
import CapaDTO.Administrador;
import Clasesinterface.AdministradorDao;
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
public class OracleAdministrador implements AdministradorDao{
    //llama a la clase conecta...para conectarse a la BD
    public Conecta db;    
    public OracleAdministrador()
    {
        //constructor vacío
        db = new Conecta();
    }

    @Override
    public List<Administrador> obtenerAdministrador() throws SQLException {
        //Crea una lista de tipo Acceso
        List<Administrador> cAdministrador = new ArrayList<Administrador>();  
        //instancia la clase acceso
        Administrador bAdministrador = new Administrador();
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
            sql = "{call FUKUSUKESUSHI.LISTAR_ADMINISTRADOR(?)}";
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
                bAdministrador = new Administrador();
                bAdministrador.setAdministradorId(rs.getInt(1));
                bAdministrador.setNombreAdmin(rs.getString(2));
                bAdministrador.setApellidoAdmin(rs.getString(3));
                bAdministrador.setCorrreoAdmin(rs.getString(4));
                bAdministrador.setTelefonoAdmin(rs.getString(5));
                bAdministrador.setUsuarioId(rs.getInt(6));
                cAdministrador.add(bAdministrador);
            }
            rs.close();
            cs.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return cAdministrador;
    }

    @Override
    public void agregarAdministrador(Administrador administrador) throws SQLException {
        Administrador bAdministrador = new Administrador();
        String sql = null;
        Connection con = null;
        CallableStatement cs = null;         
        try
        {            
            con = db.getConnection();
            //llama al insertar de la BD que tiene 6 parámetros de entrada 
            sql = "{call FUKUSUKESUSHI.ADMINISTRADOR_tapi.ins(?, ?, ?, ?, ?, ?)}";
            cs = con.prepareCall(sql);
            //le seteo los 3 parámetros de entrada
            cs.setInt(1, administrador.getAdministradorId());
            cs.setString(2, administrador.getNombreAdmin());
            cs.setString(3, administrador.getCorrreoAdmin());
            cs.setString(4, administrador.getTelefonoAdmin());
            cs.setString(5, administrador.getApellidoAdmin());
            cs.setInt(6, administrador.getUsuarioId());
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
    public void modificarAdministrador(Administrador administrador) throws SQLException {
        Administrador bAdministrador = new Administrador();
        String sql = null;
        Connection con = null;
        CallableStatement cs = null;         
        try
        {            
            con = db.getConnection();
            //llama al update de la BD que tiene 3 parámetros de entrada 
            sql = "{call FUKUSUKESUSHI.ADMINISTRADOR_tapi.upd(?, ?, ?,?, ?, ?)}";
            cs = con.prepareCall(sql);
            cs.setInt(1, administrador.getAdministradorId());
            cs.setString(2, administrador.getNombreAdmin());
            cs.setString(3, administrador.getCorrreoAdmin());
            cs.setString(4, administrador.getTelefonoAdmin());
            cs.setString(5, administrador.getApellidoAdmin());
            cs.setInt(6, administrador.getUsuarioId());
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
    public void eliminarAdministrador(Integer id) throws SQLException {
        String sql = null;
        Connection con = null;
        CallableStatement cs = null;         
        try
        {            
            con = db.getConnection();
            //llama al eliminar que recibe 1 parámetro
            sql = "{call FUKUSUKESUSHI.ADMINISTRADOR_tapi.del(?)}";
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
    public Administrador buscarAdministrador(Integer id) throws SQLException {
        
        Administrador bAdministrador = new Administrador();
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
            sql = ("{call FUKUSUKESUSHI.BUSCAR_ADMINISTRADOR(?,?)}");            
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
                bAdministrador = new Administrador();
                bAdministrador.setAdministradorId(rs.getInt(1));
                bAdministrador.setNombreAdmin(rs.getString(2));
                bAdministrador.setApellidoAdmin(rs.getString(3));
                bAdministrador.setCorrreoAdmin(rs.getString(4));
                bAdministrador.setTelefonoAdmin(rs.getString(5));
                bAdministrador.setUsuarioId(rs.getInt(6));
                
            }
            rs.close();
            
            cs.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return bAdministrador;
    
    }
    
}
