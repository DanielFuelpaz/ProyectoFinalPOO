package Principal;

import Ncedula.Ncedula;
import Opcion3.*;

import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JFrame;
import javax.swing.JToggleButton;

public class Interfaz {

    public JFrame Fbase = new JFrame("RegistroCivil");
    public JToggleButton opcion1 = new JToggleButton("Datos Personales");
    public JToggleButton opcion2 = new JToggleButton("Generación del número de cédula");
    public JToggleButton opcion3 = new JToggleButton("Tomar Fotografía");
    public JToggleButton opcion4 = new JToggleButton("Reporte de cedulados");
    private Ncedula Ced = new Ncedula();
    public Panel3 foto = new Panel3();

    public Ncedula getCed() {
        return Ced;
    }

    public void initialize() {

        Fbase.setSize(600, 600);
        Fbase.setLocation(0, 0);
        Fbase.setBackground(Color.CYAN);
        Fbase.setLayout(null);
        Fbase.setVisible(true);
        Fbase.setBounds(0, 0, 800, 600);

        opcion1.setBounds(0, 0, 190, 30);
        opcion2.setBounds(0, 30, 190, 30);
        opcion3.setBounds(0, 60, 190, 30);
        opcion4.setBounds(0, 90, 190, 30);

        Fbase.add(this.opcion1);
        Fbase.add(this.opcion2);
        Fbase.add(this.opcion3);
        Fbase.add(this.opcion4);

        this.opcion1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                int estado = ie.getStateChange();
                if (estado == ItemEvent.SELECTED) {
                    System.out.println("seleccionado op1");// aca en estas va a estar la instancia de cada uno de
                                                           // nuestras partes
                } else {
                    System.out.println("deseleccionado op1");// aca solo ponemos la parte pa cerrar la visualizacion de
                                                             // las cosas
                }
            }

        });
        this.opcion2.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                int estado = ie.getStateChange();
                if (estado == ItemEvent.SELECTED) {

                    Ced.panelcedula(Fbase);
                } else {
                    Ced.getJp1().setVisible(false);

                }
            }

        });
        this.opcion3.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                int estado = ie.getStateChange();
                if (estado == ItemEvent.SELECTED) {
                    foto.getPanel3(Fbase);
                } else {
                    foto.getPanel().setVisible(false);
                }
            }

        });
        this.opcion4.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                int estado = ie.getStateChange();
                if (estado == ItemEvent.SELECTED) {
                    System.out.println("seleccionado op4");
                } else {
                    System.out.println("deseleccionado op4");
                }
            }

        });

        Fbase.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Fbase.show();
    }

    public static void main(String[] args) {
        Interfaz i = new Interfaz();

        i.initialize();
    }

}
