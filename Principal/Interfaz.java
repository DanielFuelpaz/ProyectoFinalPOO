package Principal;

import Configuracion.Configuracion;
import DatosPersonales.DatosPersonales;
import Ncedula.Ncedula;
import Opcion3.*;
import Reporte.Reporte;

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
    public JToggleButton opcion5 = new JToggleButton("Configuracion");
    private Ncedula Ced = new Ncedula();
    private Panel3 foto = new Panel3();
    private DatosPersonales DP = new DatosPersonales();
    private Reporte r = new Reporte();
    private Configuracion c = new Configuracion();

    public void initialize() {

        Fbase.setLocation(0, 0);
        Fbase.setBackground(Color.CYAN);
        Fbase.setLayout(null);
        Fbase.setVisible(true);
        Fbase.setBounds(0, 0, 1280, 720);

        opcion1.setBounds(0, 0, 190, 30);
        opcion2.setBounds(0, 30, 190, 30);
        opcion3.setBounds(0, 60, 190, 30);
        opcion4.setBounds(0, 90, 190, 30);
        opcion5.setBounds(0, 120, 190, 30);

        Fbase.add(this.opcion1);
        Fbase.add(this.opcion2);
        Fbase.add(this.opcion3);
        Fbase.add(this.opcion4);
        Fbase.add(this.opcion5);
        this.opcion1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                int estado = ie.getStateChange();
                if (estado == ItemEvent.SELECTED) {
                    Fbase.add(DP.getFrame());
                    DP.initialize();
                } else {
                    DP.getFrame().setVisible(false);
                }
            }

        });
        this.opcion2.addItemListener((ItemEvent ie) -> {
            int estado = ie.getStateChange();
            if (estado == ItemEvent.SELECTED) {
                Fbase.add(Ced.getJp1());
                Ced.initialize();
            } else {
                Ced.getJp1().setVisible(false);
                Ced.getPersonas().removeAllItems();

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
                    Fbase.add(r.getPanel());
                    r.initialize();
                } else {
                    r.getPanel().setVisible(false);
                }
            }

        });
        this.opcion5.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                int estado = ie.getStateChange();
                if (estado == ItemEvent.SELECTED) {
                    Fbase.add(c.getFrame());
                    c.initialize();
                } else {
                    c.getFrame().setVisible(false);
                    c.getCb1().removeAllItems();
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
