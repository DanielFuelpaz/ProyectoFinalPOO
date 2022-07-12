package Conexion;

import Ncedula.Ncedula;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;

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
        String sql = "Select * from usuarios where usuario=? and clave=?";
        Connection co = c.getConexion();
        PreparedStatement ps;
        ps = co.prepareStatement(sql);
        ps.setString(1, u);
        ps.setString(2, clave);
        ResultSet rs = ps.executeQuery();
        return rs;
    }

    public void listaper(JComboBox per) {

        try {
            Connection co = c.getConexion();
            String instruccionsql = "SELECT * FROM registro WHERE cedula = '0'";
            PreparedStatement st = co.prepareStatement(instruccionsql);
            ResultSet rs = st.executeQuery(instruccionsql);

            while (rs.next()) {
                per.addItem(rs.getString("apellidos") + " " + rs.getString("nombres"));

            }

        } catch (SQLException ex) {
            Logger.getLogger(Ncedula.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ResultSet ConexionCedulas() {
        Connection co = c.getConexion();
        this.setInstruccion("SELECT * FROM registro");
        try {
            this.setP(co.prepareStatement(this.getInstruccion()));
            this.setRs(this.getP().executeQuery(this.getInstruccion()));
        } catch (SQLException ex) {
            Logger.getLogger(MySQLComandos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.getRs();
    }

}
