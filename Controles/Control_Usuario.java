/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controles;

<<<<<<< HEAD
import Conexion.*;
import Controles.*;
import Objetos.usuario;
import Login.*;
import Principal.Interfaz;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
=======
import Conexion.MySQLComandos;
import java.sql.SQLException;
>>>>>>> ef3163662657da1506b379442e72ef1b09a924dd

/**
 *
 * @author USUARIO
 */
public class Control_Usuario {
<<<<<<< HEAD
    
    public void consultarLogin(){
        
        Connection con;
        Conexion f = new Conexion();
        PreparedStatement ps;
        String sql = "Select * From usuarios where usuario=? and contraseña=?";
        Login l = new Login();
        usuario u = new usuario();
        try{
            con = f.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, l.caja.getText());
           ps.setString(2, l.caja2.getText());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Interfaz i = new Interfaz();
                i.initialize();
                //setVisible(false);
            }else{
                JOptionPane.showMessageDialog(null, "Ïngreso mal de clave");
            }
        }catch(Exception e){
            System.out.println("Error: "+e);
        }
    }
    
=======

    public void control_u() throws SQLException {
        MySQLComandos sql = new MySQLComandos();
        if (!(sql.accesologin("", "").next())) {
            
        }
    }
>>>>>>> ef3163662657da1506b379442e72ef1b09a924dd
}
