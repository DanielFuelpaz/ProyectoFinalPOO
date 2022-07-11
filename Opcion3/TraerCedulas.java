package Opcion3;

import Conexion.MySQLComandos;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import Conexion.Conexion;

public class TraerCedulas {

    Conexion c = new Conexion();
    Connection co = c.getConexion();
    MySQLComandos comandos = new MySQLComandos();
    ArrayList<String> cedulas = new ArrayList();

    public ArrayList ObtenerCedulas() {

        comandos.setInstruccion("SELECT * FROM registro");
        try {
            comandos.setP(co.prepareStatement(comandos.getInstruccion()));
            comandos.setRs(comandos.getP().executeQuery(comandos.getInstruccion()));
            while (comandos.getRs().next()) {
                cedulas.add(comandos.getRs().getString("cedula"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cedulas;
    }
}
