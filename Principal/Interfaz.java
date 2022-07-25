package Principal;

import Conexion.MySQLComandos;
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
import java.awt.BorderLayout;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Interfaz {

    private Image icono = new ImageIcon(getClass().getResource("Icono/icono.png")).getImage();
    public JFrame Fbase = new JFrame("RegistroCivil");
    public JToggleButton opcion1 = new JToggleButton("Datos Personales");
    public JToggleButton opcion2 = new JToggleButton("Generación del número de cédula");
    public JToggleButton opcion3 = new JToggleButton("Tomar Fotografía");
    public JToggleButton opcion4 = new JToggleButton("Reporte de cedulados");
    public JToggleButton opcion5 = new JToggleButton("Configuracion");
    public JToggleButton opcion6 = new JToggleButton("Salir");
    private Ncedula Ced = new Ncedula();
    private Panel3s foto = new Panel3s();
    private DatosPersonales DP = new DatosPersonales();
    private Reporte r = new Reporte();
    private Configuracion c = new Configuracion();

    public void initialize() {

        Fbase.setIconImage(icono);
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
        opcion6.setBounds(0, 150, 190, 30);

        Fbase.add(this.opcion1);
        Fbase.add(this.opcion2);
        Fbase.add(this.opcion3);
        Fbase.add(this.opcion4);
        Fbase.add(this.opcion5);
        Fbase.add(this.opcion6);
        this.opcion1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                int estado = ie.getStateChange();
                if (estado == ItemEvent.SELECTED) {
                    Fbase.add(DP.getFrame());
                    DP.initialize();
                } else {
                    DP.getFrame().setVisible(false);
                    DP.cb1.removeAllItems();
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
                    Fbase.add(foto, BorderLayout.CENTER);
                    Fbase.revalidate();
                    Fbase.repaint();
                    foto.setVisible(true);
                } else {
                    foto.setVisible(false);
                }
            }

        });
        this.opcion4.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                int estado = ie.getStateChange();
                if (estado == ItemEvent.SELECTED) {

                    Fbase.add(r.getpanel());
                    r.initialize();
                } else {
                    r.getpanel().setVisible(false);
                    r.getpanel().removeAll();
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
                    c.resetCB(c.cb2);

                }
            }

        });

        this.opcion6.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                int estado = ie.getStateChange();
                if (estado == ItemEvent.SELECTED) {
                    System.exit(0);
                }
            }

        });
        Fbase.setDefaultCloseOperation(0);
        Fbase.setResizable(false);
        Fbase.show();
    }

    public static void main(String[] args) {
        Interfaz i = new Interfaz();
        i.initialize();
    }

}
