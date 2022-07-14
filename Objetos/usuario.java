/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;
import Conexion.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author USUARIO
 */
public class usuario {
    
    public ResultSet consultarLoguin(String u, String clave) throws SQLException
    {
        Conexion c = new Conexion();
        String sql="Select * from usuarios where usuario=? and clave=?";
        Connection co = c.getConexion();
        PreparedStatement ps;
        ps = co.prepareStatement(sql);
        ps.setString(1,u);
        ps.setString(2, clave);
        ResultSet rs = ps.executeQuery();
        return rs;
    }
    
}
