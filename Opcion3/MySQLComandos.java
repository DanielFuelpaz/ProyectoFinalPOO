package Opcion3;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

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

}
