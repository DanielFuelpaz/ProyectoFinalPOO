package Principal;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JFrame;
import javax.swing.JToggleButton;

public class Interfaz implements ActionListener {

    public JFrame Fbase = new JFrame("Mostrar Imagen");
    public JToggleButton opcion1 = new JToggleButton("Datos Personales");
    public JToggleButton opcion2 = new JToggleButton("Generación del número de cédula");
    public JToggleButton opcion3 = new JToggleButton("Tomar Fotografía");
    public JToggleButton opcion4 = new JToggleButton("Reporte de cedulados");

    public void initialize() {
        Fbase.setSize(600, 600);
        Fbase.setLocation(0, 0);
        Fbase.setBackground(Color.CYAN);
        Fbase.setLayout(new FlowLayout());
        Fbase.add(this.opcion1);
        Fbase.add(this.opcion2);
        Fbase.add(this.opcion3);
        Fbase.add(this.opcion4);
        this.opcion1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {

            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }

    public static void main(String[] args) {
        Interfaz i = new Interfaz();
        i.initialize();
    }

}
