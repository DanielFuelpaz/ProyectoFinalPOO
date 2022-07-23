package Login;

import Conexion.MySQLComandos;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import Principal.Interfaz;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login implements ActionListener {

    // Propiedades del Metodo Creacion Cuneta
    private JFrame j2 = new JFrame();
    private JLabel cajacreacion = new JLabel("Nombre de Usuario: ");
    private JLabel cajacreacion2 = new JLabel("Contraseña: ");
    private JLabel cajacreacion3 = new JLabel("Repita la Contraseña:");
    private JTextField textocreacion = new JTextField("");
    private JPasswordField textocreacion2 = new JPasswordField("");
    private JPasswordField textocreacion3 = new JPasswordField("");
    private JButton botonguardar = new JButton("Guardar");

    // Propiedades del Metodo Login Acceso a la Cuenta
    private JFrame j = new JFrame();
    private JLabel caja = new JLabel();
    private JLabel caja2 = new JLabel();
    private JLabel caja3 = new JLabel();
    private JTextField texto = new JTextField();
    private JPasswordField texto2 = new JPasswordField();
    private JButton boton = new JButton();
    private JButton boton2 = new JButton();
    private MySQLComandos sql = new MySQLComandos();

    public JLabel getCajacreacion() {
        return this.cajacreacion;
    }

    public void setCajacreacion(JLabel cajacreacion) {
        this.cajacreacion = cajacreacion;
    }

    public JLabel getCajacreacion2() {
        return this.cajacreacion2;
    }

    public void setCajacreacion2(JLabel cajacreacion2) {
        this.cajacreacion2 = cajacreacion2;
    }

    public JLabel getCajacreacion3() {
        return this.cajacreacion3;
    }

    public void setCajacreacion3(JLabel cajacreacion3) {
        this.cajacreacion3 = cajacreacion3;
    }

    public JTextField getTextocreacion() {
        return this.textocreacion;
    }

    public void setTextocreacion(JTextField textocreacion) {
        this.textocreacion = textocreacion;
    }

    public JTextField getTextocreacion2() {
        return this.textocreacion2;
    }

    public void setTextocreacion2(JPasswordField textocreacion2) {
        this.textocreacion2 = textocreacion2;
    }

    public JPasswordField getTextocreacion3() {
        return this.textocreacion3;
    }

    public void setTextocreacion3(JPasswordField textocreacion3) {
        this.textocreacion3 = textocreacion3;
    }

    public JButton getBotonguardar() {
        return this.botonguardar;
    }

    public void setBotonguardar(JButton botonguardar) {
        this.botonguardar = botonguardar;
    }

    public JLabel getCaja() {
        return this.caja;
    }

    public void setCaja(JLabel caja) {
        this.caja = caja;
    }

    public JLabel getCaja2() {
        return this.caja2;
    }

    public void setCaja2(JLabel caja2) {
        this.caja2 = caja2;
    }

    public JTextField getTexto() {
        return this.texto;
    }

    public void setTexto(JTextField texto) {
        this.texto = texto;
    }

    public JTextField getTexto2() {
        return this.texto2;
    }

    public void setTexto2(JPasswordField texto2) {
        this.texto2 = texto2;
    }

    public JButton getBoton() {
        return this.boton;
    }

    public void setBoton(JButton boton) {
        this.boton = boton;
    }

    public JButton getBoton2() {
        return boton2;
    }

    public void setBoton2(JButton boton2) {
        this.boton2 = boton2;
    }

    public JFrame panelusuario() {

        this.caja.setText("Usuario :");
        this.caja2.setText("Contraseña :");
        this.boton.setText("Crear Cuenta");
        this.boton2.setText("INGRESAR");
        this.caja3.setText("=== REGISTRO CIVIL ===");
        this.j.setLayout(null);
        this.j.setBounds(400, 100, 500, 500);// Edicion del Frame lugar (x,y) (largo y Ancho)
        this.boton2.setBounds(195, 250, 100, 25);
        this.boton.setBounds(180, 300, 130, 25); // Edicion del Boton lugar (x,y) (largo,ancho)
        this.texto.setBounds(200, 130, 100, 25);
        this.texto2.setBounds(200, 180, 100, 25);
        this.caja.setBounds(120, 130, 50, 25);
        this.caja2.setBounds(100, 180, 75, 25);
        this.caja3.setBounds(180, -50, 200, 200);
        this.boton.addActionListener(this);
        this.boton2.addActionListener(this);

        this.j.add(caja);
        this.j.add(caja2);
        this.j.add(texto);
        this.j.add(texto2);
        this.j.add(boton);
        this.j.add(boton2);
        this.j.add(caja3);

        this.j.setBackground(Color.GRAY);
        this.j.show();
        this.j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.j.setResizable(false);

        return j;
    }

    //Metodo De Creacion Cuenta Retorna un Frame 
    public JFrame panelCreacionCuenta() {

        this.j2.setLayout(null);
        this.j2.setBounds(400, 200, 500, 300);
        this.cajacreacion.setBounds(120, 50, 150, 25);
        this.cajacreacion2.setBounds(160, 100, 100, 25);
        this.cajacreacion3.setBounds(110, 150, 130, 25);
        this.textocreacion.setBounds(250, 50, 100, 25);
        this.textocreacion2.setBounds(250, 100, 100, 25);
        this.textocreacion3.setBounds(250, 150, 100, 25);
        this.botonguardar.setBounds(200, 200, 100, 25);
        this.j2.add(cajacreacion);
        this.j2.add(cajacreacion2);
        this.j2.add(cajacreacion3);
        this.j2.add(textocreacion);
        this.j2.add(textocreacion2);
        this.j2.add(textocreacion3);
        this.j2.add(botonguardar);
        this.botonguardar.addActionListener(this);

        this.j2.setBackground(Color.GRAY);
        this.j2.show();
        this.j2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.j2.setResizable(false);

        return j2;

    }

    public static void main(String[] args) {
        Login l = new Login();
        l.panelusuario();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JButton but1 = (JButton) e.getSource();
        if (but1 == boton2) {
            try {
                if (sql.iniciosesion(texto, texto2) == true) {
                    j.hide();
                    Interfaz i = new Interfaz();
                    i.initialize();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (but1 == boton) {
            j.hide();
            panelCreacionCuenta();

        } else {
            if (sql.creacionusuario(textocreacion, textocreacion2,textocreacion3)) {
                j2.hide();
                j.show();
            }

        }

    }

}
