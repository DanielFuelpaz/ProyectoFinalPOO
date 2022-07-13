package Conexion;

import Ncedula.Ncedula;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class MySQLComandos {

    private String instruccion;
    private PreparedStatement p;
    private ResultSet rs;
    private Conexion c = new Conexion();

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

    public ResultSet accesologin(String u, String clave) throws SQLException {
        this.setInstruccion("Select * from usuarios where usuario=? and clave=?");
        Connection co = c.getConexion();
        this.setP(co.prepareStatement(this.getInstruccion()));
        this.getP().setString(1, u);
        this.getP().setString(2, clave);
        this.setRs(this.getP().executeQuery());
        return this.getRs();
    }

    public void listaper(JComboBox per) {

        try {
            Connection co = c.getConexion();
            this.setInstruccion("SELECT * FROM datospersonales WHERE cedula IS NULL");
            this.setP(co.prepareStatement(this.getInstruccion()));
            this.setRs(this.getP().executeQuery(this.getInstruccion()));

            while (this.getRs().next()) {
                per.addItem(this.getRs().getString("apellido") + " " + this.getRs().getString("nombre"));

            }

        } catch (SQLException ex) {
            Logger.getLogger(Ncedula.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void addced(JComboBox personas, JTextField Rced) {
        try {

            Connection co = c.getConexion();
            String partes[] = personas.getSelectedItem().toString().split(" ");
            this.setInstruccion("UPDATE datospersonales SET cedula = ? WHERE datospersonales.apellido = ? AND datospersonales.nombre = ? ;");
            this.setP(co.prepareStatement(this.getInstruccion()));
            this.getP().setInt(1, Integer.valueOf(Rced.getText()));
            this.getP().setString(2, partes[0]);
            this.getP().setString(3, partes[1]);
            this.getP().executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Ncedula.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ResultSet ConexionCedulas() {
        Connection co = c.getConexion();
        this.setInstruccion("SELECT * FROM datospersonales");
        try {
            this.setP(co.prepareStatement(this.getInstruccion()));
            this.setRs(this.getP().executeQuery(this.getInstruccion()));
        } catch (SQLException ex) {
            Logger.getLogger(MySQLComandos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.getRs();
    }

}
