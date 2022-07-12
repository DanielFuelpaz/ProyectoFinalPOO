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
            String instruccionsql = "SELECT * FROM datospersonales WHERE cedula IS NULL";
            PreparedStatement st = co.prepareStatement(instruccionsql);
            ResultSet rs = st.executeQuery(instruccionsql);

            while (rs.next()) {
                per.addItem(rs.getString("apellido") + " " + rs.getString("nombre"));

            }

        } catch (SQLException ex) {
            Logger.getLogger(Ncedula.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void addced(JComboBox personas, JTextField Rced) {
        try {

            Connection co = c.getConexion();
            String partes[] = personas.getSelectedItem().toString().split(" ");
            String instruccionSql = "UPDATE datospersonales SET cedula = ? WHERE datospersonales.apellido = ? AND datospersonales.nombre = ? ;";
            PreparedStatement st = co.prepareStatement(instruccionSql);
            st.setInt(1, Integer.valueOf(Rced.getText()));
            st.setString(2, partes[0]);
            st.setString(3, partes[1]);
            st.executeUpdate();

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
