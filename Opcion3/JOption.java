package Opcion3;

import javax.swing.JOptionPane;

public class JOption {

    public int preguntar(String s, String t) {
        int r = JOptionPane.showConfirmDialog(null, s, t, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        return r;
    }

    public String ingreso(String s, String t) {
        return JOptionPane.showInputDialog(null, s, t);
    }

    public void mostar(String s) {
        JOptionPane.showMessageDialog(null, s);
    }
}
