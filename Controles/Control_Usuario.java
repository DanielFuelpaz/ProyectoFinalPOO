/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controles;


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

import Conexion.MySQLComandos;
import java.sql.SQLException;


/**
 *
 * @author USUARIO
 */
public class Control_Usuario  {

    
   
    


    public void control_u() throws SQLException {
        MySQLComandos sql = new MySQLComandos();
        if (!(sql.accesologin("", "").next())) {
            
        }
    }

}
