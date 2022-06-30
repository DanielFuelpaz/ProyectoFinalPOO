package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    public static final String usuario = "uvtrtmhl1kh3bgym";
    public static final String clave = "srpWdxh10ffLwT5WsyY0";
    public static final String url = "jdbc:mysql://bwlzwusixbbsd7oqhmvd-mysql.services.clever-cloud.com:3306/bwlzwusixbbsd7oqhmvd";

    public Connection getConexion() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, usuario, clave);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return con;
    }
}
