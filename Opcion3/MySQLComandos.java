package Opcion3;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQLComandos {
    private String instruccion;
    private PreparedStatement p;
    private ResultSet rs;

    public String getInstruccion() {
        return this.instruccion;
    }

    public void setInstruccion(String instruccion) {
        this.instruccion = instruccion;
    }

    public PreparedStatement getP() {
        return this.p;
    }

    public void setP(PreparedStatement p) {
        this.p = p;
    }

    public ResultSet getRs() {
        return this.rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }
    
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
