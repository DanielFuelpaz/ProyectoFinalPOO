package Opcion3;

import java.sql.SQLException;
import javax.swing.JOptionPane;

public abstract class JOption {
    public abstract int preguntar(String s, String t);
    public abstract String ingreso(String s, String t);
    public abstract void mostrar(String s);
    public abstract void mostrar(SQLException e);
    public abstract void mostrar(Exception e);
}
