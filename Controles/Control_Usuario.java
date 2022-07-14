/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controles;

import Conexion.MySQLComandos;
import java.sql.SQLException;

/**
 *
 * @author USUARIO
 */
public class Control_Usuario {

    public void control_u() throws SQLException {
        MySQLComandos sql = new MySQLComandos();
        if (!(sql.accesologin("", "").next())) {
            
        }
    }
}
