package CapaNegocio;

import CapaConexion.Conecta;
import CapaDTO.Cliente;
import Clasesinterface.ClienteDao;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author moi
 */
public class OracleCliente implements ClienteDao{
    //llama a la clase conecta...para conectarse a la BD
    public Conecta db;    
    public OracleCliente()
    {
        //constructor vacío
        db = new Conecta();
    }

    @Override
    public List<Cliente> obtenerCliente() throws SQLException {        
        List<Cliente> cCliente = new ArrayList<Cliente>();          
        Cliente bCliente = new Cliente();
        String sql = null;
        Connection con = null;          
        CallableStatement cs = null;        
        ResultSet rs;
        try
        {            
            con = db.getConnection();            
            sql = "{call FUKUSUKESUSHI.LISTAR_CLIENTE(?)}";            
            cs = con.prepareCall(sql);
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.execute();            
            rs = (ResultSet)cs.getObject(1);            
            while(rs.next())
            {
                bCliente = new Cliente();
                bCliente.setClienteId(rs.getInt(1));
                bCliente.setUsuarioId(rs.getInt(2));
                bCliente.setComuna(rs.getString(3));
                bCliente.setRut(rs.getString(4));
                bCliente.setNombre(rs.getString(5));
                bCliente.setApellido(rs.getString(6));
                bCliente.setDireccion(rs.getString(7));
                bCliente.setFechaNacimiento(rs.getString(8));
                bCliente.setSexo(rs.getString(9));
                bCliente.setEmail(rs.getString(10));
                bCliente.setTelefono(rs.getInt(11));                
                cCliente.add(bCliente);
            }
            rs.close();
            cs.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return cCliente;
    }

    @Override
    public void agregarCliente(Cliente cliente) throws SQLException {        
        Cliente bCliente = new Cliente();
        String sql = null;
        Connection con = null;
        CallableStatement cs = null;    
        
        try
        {            
            con = db.getConnection();            
            sql = "{call FUKUSUKESUSHI.CLIENTE_tapi.ins(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
            cs = con.prepareCall(sql);            
            
            /*
            DateFormat format = new SimpleDateFormat("dd-MMM-yyyy");
            String dateInString = cliente.getFechaNacimiento();        
            Date date = (Date) format.parse(dateInString);
            */      
            cs.setString(1, cliente.getRut());
            cs.setString(2, cliente.getDireccion());
            cs.setString(3, cliente.getApellido());
            //cs.setInt(4, cliente.getClienteId());            
            cs.setString(4, cliente.getComuna());
            cs.setInt(5, cliente.getTelefono());
            cs.setString(6, cliente.getEmail());
            cs.setInt(7, cliente.getUsuarioId());
            cs.setString(8, cliente.getNombre());
            cs.setString(9, cliente.getFechaNacimiento());
            cs.setString(10, cliente.getSexo());
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
    public void modificarCliente(Cliente cliente) throws SQLException {
        Cliente bCliente = new Cliente();
        String sql = null;
        Connection con = null;
        CallableStatement cs = null;         
        try
        {            
            con = db.getConnection();
            //llama al update de la BD que tiene 3 parámetros de entrada 
            sql = "{call FUKUSUKESUSHI.CLIENTE_tapi.upd(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
            cs = con.prepareCall(sql);
            cs.setString(1, cliente.getRut());
            cs.setString(2, cliente.getDireccion());
            cs.setString(3, cliente.getApellido());
            cs.setInt(4, cliente.getClienteId());            
            cs.setString(5, cliente.getComuna());
            cs.setInt(6, cliente.getTelefono());
            cs.setString(7, cliente.getEmail());
            cs.setInt(8, cliente.getUsuarioId());
            cs.setString(9, cliente.getNombre());
            cs.setString(10, cliente.getFechaNacimiento());
            cs.setString(11, cliente.getSexo());
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
    public void eliminarCliente(Integer id) throws SQLException {
        String sql = null;
        Connection con = null;
        CallableStatement cs = null;         
        try
        {            
            con = db.getConnection();
            //llama al eliminar que recibe 1 parámetro
            sql = "{call FUKUSUKESUSHI.CLIENTE_tapi.del(?)}";
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
    public Cliente buscarCliente(Integer id) throws SQLException {
        
        Cliente bCliente = new Cliente();
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
            sql = ("{call FUKUSUKESUSHI.BUSCAR_CLIENTE(?,?)}");            
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
                bCliente = new Cliente();
                bCliente.setClienteId(rs.getInt(1));
                bCliente.setUsuarioId(rs.getInt(2));
                bCliente.setComuna(rs.getString(3));
                bCliente.setRut(rs.getString(4));
                bCliente.setNombre(rs.getString(5));
                bCliente.setApellido(rs.getString(6));
                bCliente.setDireccion(rs.getString(7));
                bCliente.setFechaNacimiento(rs.getString(8));
                bCliente.setSexo(rs.getString(9));
                bCliente.setEmail(rs.getString(10));
                bCliente.setTelefono(rs.getInt(11));                
                
            }
            rs.close();
            
            cs.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return bCliente;
    }

    @Override
    public Cliente buscarClienteRut(String rut) throws SQLException {
        Cliente bCliente = new Cliente();
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
            sql = ("{call FUKUSUKESUSHI.BUSCAR_CLIENTE_RUT(?,?)}");            
            cs = con.prepareCall(sql);
            //seteo el primer parámetro
            cs.setString(1, rut); 
            //defino el tipo de dato que debe devolver
            cs.registerOutParameter(2, OracleTypes.CURSOR);
            cs.execute();
            
            //creo un resultset con todos los datos de la tabla Acceso
            //devuelve el objeto OUT que se encuentra en el 2 parámetro
            rs = (ResultSet)cs.getObject(2);
            if(rs.next())
            {
                bCliente = new Cliente();
                bCliente.setClienteId(rs.getInt(1));
                bCliente.setUsuarioId(rs.getInt(2));
                bCliente.setComuna(rs.getString(3));
                bCliente.setRut(rs.getString(4));
                bCliente.setNombre(rs.getString(5));
                bCliente.setApellido(rs.getString(6));
                bCliente.setDireccion(rs.getString(7));
                bCliente.setFechaNacimiento(rs.getString(8));
                bCliente.setSexo(rs.getString(9));
                bCliente.setEmail(rs.getString(10));
                bCliente.setTelefono(rs.getInt(11));                
                
            }
            rs.close();
            
            cs.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return bCliente;
    }
}
