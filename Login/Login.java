package Login;

import Conexion.Conexion;
import java.awt.Color;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import Objetos.*;
import Controles.*;

public class Login implements ActionListener {

    // Propiedades del Metodo Creacion Cuneta
    private JFrame j2 = new JFrame();
    public JLabel cajacreacion = new JLabel("Nombre Usuario");
    public JLabel cajacreacion2 = new JLabel("Contraseña");
    public JLabel cajacreacion3 = new JLabel("Repita la Contraseña");
    public TextField textocreacion = new TextField("");
    public TextField textocreacion2 = new TextField("");
    public TextField textocreacion3 = new TextField("");
    public JButton botonguardar = new JButton("Guardar");

    // Propiedades del Metodo Login Acceso a la Cuenta
    private JFrame j = new JFrame();
    public JLabel caja = new JLabel("Usuario");
    public JLabel caja2 = new JLabel("Contraseña");
    public TextField texto = new TextField("");
    public TextField texto2 = new TextField("");
    public JButton boton = new JButton("Crear Usuario");
    public JButton boton2 = new JButton("Ingresar");

    // Propiedad de Conexion
    Conexion c = new Conexion();

    usuario o = new usuario();

    public JFrame panelusuario() {

        caja.setText("Usuario");
        caja2.setText("Contraseña");
        boton.setText("Crear Cuenta");
        boton2.setText("INGRESAR");
        j.setLayout(null);
        j.setSize(400, 400);
        boton2.setBounds(30, 300, 100, 25);
        boton.setBounds(150, 300, 200, 25); // Edicion del Boton lugar (x,y) (largo,ancho)
        texto.setBounds(100, 200, 100, 25);
        texto2.setBounds(100, 250, 100, 25);
        caja.setBounds(35, 200, 50, 25);
        caja2.setBounds(25, 250, 75, 25);

        j.add(caja);
        j.add(caja2);
        j.add(texto);
        j.add(texto2);
        j.add(boton);
        j.add(boton2);

        j.setBackground(Color.GRAY);
        j.show();
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        return j;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //Metodo De Creacion Cuenta Retorna un Frame 
    public JFrame panelCreacionCuenta() {

        j2.setLayout(null);
        j2.setSize(600, 600);
        cajacreacion.setBounds(55, 100, 100, 25);
        cajacreacion2.setBounds(75, 200, 70, 25);
        cajacreacion3.setBounds(20, 300, 130, 25);
        textocreacion.setBounds(150, 100, 100, 25);
        textocreacion2.setBounds(150, 200, 100, 25);
        textocreacion3.setBounds(150, 300, 100, 25);
        botonguardar.setBounds(200, 350, 100, 25);
        j2.add(cajacreacion);
        j2.add(cajacreacion2);
        j2.add(cajacreacion3);
        j2.add(textocreacion);
        j2.add(textocreacion2);
        j2.add(textocreacion3);
        j2.add(botonguardar);

        j2.setBackground(Color.GRAY);
        j2.show();
        j2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        return j2;
        
        
       
        
        
    }
    
    

    public static void main(String[] args) {
        Control_Usuario c = new Control_Usuario();
        Login l = new Login();
        l.panelusuario();
        // l.panelCreacionCuenta();
        
    }

}
