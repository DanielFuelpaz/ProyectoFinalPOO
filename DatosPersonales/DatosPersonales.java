/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatosPersonales;

import Conexion.Conexion;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author g4to1
 */
public class DatosPersonales implements ActionListener {

    public JFrame frame = new JFrame("Datos personales");
    public JLabel jl1 = new JLabel("Nombres");
    public JTextField txtnombres = new JTextField("");
    public JLabel jl2 = new JLabel("Apellidos");
    public JTextField txtapellidos = new JTextField();
    public JLabel jl3 = new JLabel("Dirección");
    public JTextField txtdireccion = new JTextField();
    public JLabel jl4 = new JLabel("Telefono");
    public JTextField txttelefono = new JTextField();

    public JLabel jl5 = new JLabel("Provincia");
    public JComboBox cb1 = new JComboBox();
    public JLabel jl6 = new JLabel("Ciudad");
    public JComboBox cb2 = new JComboBox();
    public JButton bg = new JButton("Guardar");
    private Conexion objCon = new Conexion();
    private Connection conn = objCon.getConexion();

    public void initialize() {

        frame.setBounds(750, 300, 400, 400);
        frame.setBackground(Color.LIGHT_GRAY);
        frame.setLayout(null);
        jl1.setBounds(35, 30, 60, 15);
        frame.add(this.jl1);
        txtnombres.setBounds(100, 27, 200, 25);
        frame.add(this.txtnombres);
        jl2.setBounds(35, 69, 60, 15);
        frame.add(this.jl2);
        txtapellidos.setBounds(100, 64, 200, 25);
        frame.add(this.txtapellidos);
        jl3.setBounds(35, 105, 60, 15);
        frame.add(this.jl3);
        txtdireccion.setBounds(100, 101, 200, 25);
        frame.add(this.txtdireccion);
        jl4.setBounds(35, 144, 60, 15);
        frame.add(this.jl4);
        txttelefono.setBounds(100, 140, 200, 25);
        frame.add(this.txttelefono);
        jl5.setBounds(35, 179, 60, 15);
        frame.add(this.jl5);
        cb1.setBounds(100, 175, 200, 25);
        frame.add(this.cb1);
        jl6.setBounds(35, 218, 60, 15);
        frame.add(this.jl6);
        cb2.setBounds(100, 214, 200, 25);
        frame.add(this.cb2);
        bg.setBounds(150, 263, 100, 25);
        frame.add(this.bg);
        cargarprovincias();
        cargarciudades();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.show();

        this.bg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent g) {
                PreparedStatement ps = null;
                try {
                    ps = conn.prepareStatement("INSERT INTO datospersonales (nombre,apellido,direccion,telefono,provincia,ciudad) VALUES (?,?,?,?,?,?)");
                    ps.setString(1, txtnombres.getText());
                    ps.setString(2, txtapellidos.getText());
                    ps.setString(3, txtdireccion.getText());
                    ps.setString(4, txttelefono.getText());
                    ps.setString(5, cb1.getSelectedItem().toString());
                    ps.setString(6, cb2.getSelectedItem().toString());
                    ps.execute();

                    JOptionPane.showMessageDialog(null, "Elementos guardados");

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error al Guardar");
                }

            }
        });

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void cargarprovincias() {
        int contador = 0;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {

            ps = conn.prepareStatement("SELECT provincias FROM provincias");
            rs = ps.executeQuery();
            while (rs.next()) {

                cb1.addItem(rs.getString("provincias"));
                contador++;
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    public void cargarciudades() {
        int contador = 0;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {

            ps = conn.prepareStatement("SELECT ciudades FROM ciudades");
            rs = ps.executeQuery();
            while (rs.next()) {

                cb2.addItem(rs.getString("ciudades"));
                contador++;
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    public static void main(String[] args) {
        DatosPersonales v = new DatosPersonales();
        v.initialize();
    }
}
