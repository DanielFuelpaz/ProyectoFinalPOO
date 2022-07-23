package Opcion3;

import java.sql.SQLException;
import javax.swing.JOptionPane;

public class JOption3 extends JOption {

    @Override
    public int preguntar(String s, String t) {
        return JOptionPane.showOptionDialog(null, s,
                t,
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                new Object[]{"Sí", "No"},
                "Sí");
    }

    @Override
    public String ingreso(String s, String t) {
        return JOptionPane.showInputDialog(null, s, t);
    }

    @Override
    public void mostrar(String s) {
        JOptionPane.showMessageDialog(null, s);
    }

    @Override
    public void mostrar(SQLException e) {
        JOptionPane.showMessageDialog(null, e);
    }

    @Override
    public void mostrar(Exception e) {
        JOptionPane.showMessageDialog(null, e);
    }

}
