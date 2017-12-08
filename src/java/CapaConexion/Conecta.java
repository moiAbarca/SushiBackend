/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaConexion;

/**
 *
 * @author moi
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conecta {
    public Connection getConnection()
    {
        Connection con= null;
        try
        {
            //driver jdbc...se debe descargar ojdbc7
            Class.forName("oracle.jdbc.driver.OracleDriver");
            //string de conexion, usuario system, contreña usuario system
            con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "moi11");
        }
        catch(SQLException ex)
        { 
            System.out.println("Error: " + ex.getMessage());
        }
        catch (Exception e1)
        {
            System.out.println("Error: " + e1.getMessage());
        }
        return con;
   }
}
