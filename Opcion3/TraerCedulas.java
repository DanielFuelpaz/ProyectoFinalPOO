package Opcion3;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

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
