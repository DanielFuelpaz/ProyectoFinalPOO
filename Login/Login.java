package Login;

import Conexion.Conexion;
import Conexion.MySQLComandos;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import Objetos.*;
import Controles.*;
import javax.swing.JTextField;

public class Login implements ActionListener {

    // Propiedades del Metodo Creacion Cuneta
    private JFrame j2 = new JFrame();
    private JLabel cajacreacion = new JLabel("Nombre Usuario");
    private JLabel cajacreacion2 = new JLabel("Contraseña");
    private JLabel cajacreacion3 = new JLabel("Repita la Contraseña");
    private JTextField textocreacion = new JTextField("");
    private JTextField textocreacion2 = new JTextField("");
    private JTextField textocreacion3 = new JTextField("");
    private JButton botonguardar = new JButton("Guardar");

    // Propiedades del Metodo Login Acceso a la Cuenta
    private JFrame j = new JFrame();
    private JLabel caja = new JLabel("Usuario");
    private JLabel caja2 = new JLabel("Contraseña");
    private JTextField texto = new JTextField("");
    private JTextField texto2 = new JTextField("");
    private JButton boton = new JButton("Crear Usuario");
    private JButton boton2 = new JButton("Ingresar");
    private MySQLComandos sql = new MySQLComandos();

    // Propiedad de Conexion
    Conexion c = new Conexion();

    usuario o = new usuario();

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

    public void setTextocreacion2(JTextField textocreacion2) {
        this.textocreacion2 = textocreacion2;
    }

    public JTextField getTextocreacion3() {
        return this.textocreacion3;
    }

    public void setTextocreacion3(JTextField textocreacion3) {
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

    public void setTexto2(JTextField texto2) {
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

        this.caja.setText("Usuario");
        this.caja2.setText("Contraseña");
        this.boton.setText("Crear Cuenta");
        this.boton2.setText("INGRESAR");
        this.j.setLayout(null);
        this.j.setSize(400, 400);
        this.boton2.setBounds(30, 300, 100, 25);
        this.boton.setBounds(150, 300, 200, 25); // Edicion del Boton lugar (x,y) (largo,ancho)
        this.texto.setBounds(100, 200, 100, 25);
        this.texto2.setBounds(100, 250, 100, 25);
        this.caja.setBounds(35, 200, 50, 25);
        this.caja2.setBounds(25, 250, 75, 25);

        this.j.add(caja);
        this.j.add(caja2);
        this.j.add(texto);
        this.j.add(texto2);
        this.j.add(boton);
        this.j.add(boton2);

        this.j.setBackground(Color.GRAY);
        this.j.show();
        this.j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        return j;
    }


    //Metodo De Creacion Cuenta Retorna un Frame 
    public JFrame panelCreacionCuenta() {

        this.j2.setLayout(null);
        this.j2.setSize(600, 600);
        this.cajacreacion.setBounds(55, 100, 100, 25);
        this.cajacreacion2.setBounds(75, 200, 70, 25);
        this.cajacreacion3.setBounds(20, 300, 130, 25);
        this.textocreacion.setBounds(150, 100, 100, 25);
        this.textocreacion2.setBounds(150, 200, 100, 25);
        this.textocreacion3.setBounds(150, 300, 100, 25);
        this.botonguardar.setBounds(200, 350, 100, 25);
        this.j2.add(cajacreacion);
        this.j2.add(cajacreacion2);
        this.j2.add(cajacreacion3);
        this.j2.add(textocreacion);
        this.j2.add(textocreacion2);
        this.j2.add(textocreacion3);
        this.j2.add(botonguardar);

        this.j2.setBackground(Color.GRAY);
        this.j2.show();
        this.j2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        return j2;

    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
       
         JButton but1 = (JButton) e.getSource();
        if (but1 == boton2) {
           
         
            
        } else {

            

        }
    }
        
    
    
    

    public static void main(String[] args) {
        Control_Usuario c = new Control_Usuario();
        Login l = new Login();
        l.panelusuario();
        // l.panelCreacionCuenta();

        //l.panelCreacionCuenta();
    }

}
