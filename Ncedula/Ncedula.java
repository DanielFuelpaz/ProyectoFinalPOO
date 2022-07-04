package Ncedula;

import Conexion.Conexion;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        listaper(personas);
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

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton but1 = (JButton) e.getSource();
        if (but1 == GenCedula) {
            int pos;
            Random rnd = new Random();
            Stack< Integer> pCartas = new Stack<>();
            for (int i = 0; i < 20; i++) {
                pos = rnd.nextInt(7999 + 1000) + 1000;
                while (pCartas.contains(pos)) {
                    pos = rnd.nextInt(7999 + 1000) + 1000;
                }
                pCartas.push(pos);
            }

            Rced.setText(String.valueOf("180500" + pCartas.get(1)));
        } else {

            try {

                Connection co = c.getConexion();
                String partes[] = personas.getSelectedItem().toString().split(" ");
                String instruccionSql = "UPDATE registro SET cedula = ? WHERE registro.apellidos = ? AND registro.nombres = ? ;";
                PreparedStatement st = co.prepareStatement(instruccionSql);
                st.setInt(1, Integer.valueOf(Rced.getText()));
                st.setString(2, partes[0]);
                st.setString(3, partes[1]);
                st.executeUpdate();

            } catch (SQLException ex) {
                Logger.getLogger(Ncedula.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
