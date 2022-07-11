package Login;

import Conexion.Conexion;
import java.awt.Color;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Login implements ActionListener {

    public JLabel caja = new JLabel("Usuario");
    public JLabel caja2 = new JLabel("Usuario");

    public TextField texto = new TextField("");
    public TextField texto2 = new TextField("");

    public JButton boton = new JButton("Crear Usuario");
    private JFrame j = new JFrame();
    Conexion c = new Conexion();

    public JFrame panelusuario() {

        caja.setText("Usuario");
        caja2.setText("Contraseña");
        boton.setText("Crear Cuenta");
        j.setLayout(null);
        j.setSize(400, 400);
        boton.setBounds(150, 300, 150, 25); // Edicion del Boton lugar (x,y) (largo,ancho)
        texto.setBounds(100, 200, 200, 25);
        texto2.setBounds(100, 250, 200, 25);
        caja.setBounds(35, 200, 50, 25);
        caja2.setBounds(25, 250, 75, 25);

        j.add(caja);
        j.add(caja2);
        j.add(texto);
        j.add(texto2);
        j.add(boton);

        j.setBackground(Color.GRAY);
        j.show();
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        return j;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void main(String[] args) {

        Login l = new Login();
        l.panelusuario();

    }

}
