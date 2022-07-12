package Opcion3;

import Conexion.MySQLComandos;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import Conexion.Conexion;

public class TraerCedulas {
    ArrayList<String> cedulas = new ArrayList();

    public ArrayList<String> getCedulas() {
        return this.cedulas;
    }

    public void setCedulas(String cedula) {
        this.cedulas.add(cedula);
    }
    
    public ArrayList<String> ObtenerCedulas(ResultSet rs) {        
        try {
            while (rs.next()) {
                this.setCedulas(rs.getString("cedula"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TraerCedulas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cedulas;
    }
}
