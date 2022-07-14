package Ncedula;

import Conexion.Conexion;
import Conexion.MySQLComandos;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Stack;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ncedula implements ActionListener {

    private JPanel Jp1 = new JPanel();
    private JLabel ApNom = new JLabel();
    private JLabel Ced = new JLabel();
    private JComboBox personas = new JComboBox();
    private JTextField Rced = new JTextField();
    private JButton GenCedula = new JButton();
    private JButton Guardar = new JButton();
    Conexion c = new Conexion();
    private MySQLComandos sql = new MySQLComandos();

    public JPanel getJp1() {
        return this.Jp1;
    }

    public JPanel panelcedula(JFrame a) {
        a.add(Jp1);
        getJp1().setBounds(200, 0, 575, 350);
        getJp1().setBackground(new Color(205, 224, 228));
        getJp1().setLayout(null);

        getJp1().add(ApNom);
        ApNom.setText("Apellidos y nombres");
        ApNom.setSize(125, 20);
        ApNom.setLocation(240, 0);

        getJp1().add(personas);
        sql.listaper(personas);
        personas.setSize(180, 20);
        personas.setLocation(395, 0);

        getJp1().add(Ced);
        Ced.setText("Cédula");
        Ced.setSize(40, 20);
        Ced.setLocation(240, 200);

        getJp1().add(Rced);
        Rced.setSize(100, 20);
        Rced.setLocation(Ced.getX() + Ced.getWidth(), 200);

        getJp1().add(GenCedula);
        GenCedula.setText("Generar");
        GenCedula.addActionListener(this);
        GenCedula.setSize(100, 20);
        GenCedula.setLocation(200, 220);

        getJp1().add(Guardar);
        Guardar.setText("Guardar");
        Guardar.setSize(100, 20);
        Guardar.setLocation(300, 220);
        Guardar.addActionListener(this);
        getJp1().setVisible(true);

        return Jp1;
    }

    public void vaciar() {
        this.personas.removeAllItems();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton but1 = (JButton) e.getSource();
        if (but1 == GenCedula) {
            int pos = 0;
            Random rnd = new Random();
            for (int i = 0; i < 20; i++) {
                pos = rnd.nextInt(7999 + 1000) + 1000;
                while (sql.traerced(Integer.toString(pos))) {
                    pos = rnd.nextInt(7999 + 1000) + 1000;
                }
            }

            Rced.setText(String.valueOf("180500" + pos));
        } else {

            sql.addced(personas, Rced);
            Rced.setText("");
            personas.removeAllItems();
            sql.listaper(personas);

        }
    }

}
