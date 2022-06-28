package Principal;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JToggleButton;

public class Interfaz implements ActionListener {

    public JFrame Fbase = new JFrame("Mostrar Imagen");
    public JToggleButton opcion1 = new JToggleButton("Buscar");
    public JToggleButton opcion2 = new JToggleButton("Buscar");
    public JToggleButton opcion3 = new JToggleButton("Buscar");
    public JToggleButton opcion4 = new JToggleButton("Buscar");

    public void initialize(){
        Fbase.setSize(600, 600);
        Fbase.setLocation(0, 0);
        Fbase.setBackground(Color.CYAN);
        Fbase.setLayout(new FlowLayout());
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {

    }
    public static void main(String[] args) {
        Interfaz i = new Interfaz();
        i.initialize();
    }

}
