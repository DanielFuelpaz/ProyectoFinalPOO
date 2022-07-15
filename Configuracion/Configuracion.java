package Configuracion;

import Conexion.Conexion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author g4to1
 */
public class Configuracion implements ActionListener {

    public JFrame frame = new JFrame("Configuracion");
    public JLabel op1 = new JLabel("Seleccione la Opcion");
    public JLabel op2 = new JLabel("Nombre Ciudad");
    public JLabel op3 = new JLabel("Nombre Provincia");
    public JComboBox cb1 = new JComboBox();
    public JComboBox cb2 = new JComboBox();
    public JTextField txtop2 = new JTextField();
    public JButton guardar = new JButton("Guardar");
    Conexion objCon = new Conexion();
    Connection conn = objCon.getConexion();

    DefaultTableModel modelo = new DefaultTableModel();

    public void initialize() {
        frame.setBounds(750, 300, 400, 400);
        frame.add(this.op1);
        frame.setLayout(null);
        op1.setBounds(15, 30, 215, 15);
        frame.add(this.cb1);
        cb1.setBounds(150, 30, 200, 20);
        frame.add(this.guardar);
        guardar.setBounds(135, 200, 100, 20);

        this.cb1.addItem("Opcion");
        this.cb1.addItem("Ciudad");
        this.cb1.addItem("Provincia");

        this.cb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                if (cb1.getSelectedItem().toString() == "Ciudad") {
                    op3.show(false);
                    op2.show(true);
                    txtop2.show(true);
                    cb2.show(true);
                    frame.add(op2);
                    op2.setBounds(15, 100, 215, 15);
                    frame.add(cb2);
                    cb2.setBounds(150, 70, 200, 20);
                    frame.add(txtop2);
                    txtop2.setBounds(150, 100, 200, 20);
                    cargarprovincias();
                } else if (cb1.getSelectedItem().toString() == "Provincia") {
                    op2.show(false);
                    cb2.show(false);
                    op3.show(true);
                    txtop2.show(true);
                    frame.add(op3);
                    op3.setBounds(15, 70, 215, 15);
                    frame.add(txtop2);
                    txtop2.setBounds(150, 70, 200, 20);
                } else {
                    op3.show(false);
                    op2.show(false);
                    txtop2.show(false);
                    cb2.show(false);
                }

            }
        });

        this.guardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent g) {
                if ((cb1.getSelectedItem().toString() == "Ciudad") && (txtop2.getText().isEmpty()!=true)) {
                    PreparedStatement ps = null;
                    
                    try {
                        ps = conn.prepareStatement("INSERT INTO ciudades (ciudades,provincias) VALUES (?,?)");
                        ps.setString(1, txtop2.getText());
                        ps.setString(2, cb2.getSelectedItem().toString());
                        ps.execute();
                        JOptionPane.showMessageDialog(null, "Elementos guardados");
                        limpiar();
                    } catch (SQLException ex) {
                        Logger.getLogger(Configuracion.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } else if ((cb1.getSelectedItem().toString() == "Provincia") && (txtop2.getText().isEmpty()!=true)) {
                    PreparedStatement ps = null;
                    Conexion objCon = new Conexion();
                    Connection conn = objCon.getConexion();
                    try {
                        ps = conn.prepareStatement("INSERT INTO provincias (provincias) VALUES (?)");
                        ps.setString(1, txtop2.getText());
                        ps.execute();
                        JOptionPane.showMessageDialog(null, "Elementos guardados");
                        limpiar();
                    } catch (SQLException ex) {
                        Logger.getLogger(Configuracion.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No se ha seleccionado ningun item");
                }
            }
        });
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.show();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void main(String[] args) {
        Configuracion cf = new Configuracion();
        cf.initialize();
    }
    
    public void cargarprovincias(){
        int contador=0;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Conexion objCon = new Conexion();
            Connection conn = objCon.getConexion();

            ps = conn.prepareStatement("SELECT provincias FROM provincias");
            rs = ps.executeQuery();
            while (rs.next()) {

                cb2.addItem(rs.getString("provincias"));
                contador++;
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }   
        }
    
    private void limpiar() {
        txtop2.setText("");

    }
}
