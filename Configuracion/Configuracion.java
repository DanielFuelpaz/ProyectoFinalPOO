package Configuracion;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import Conexion.MySQLComandos;
import Opcion3.JOption3;
import Objetos.ingresociudad;
import Objetos.provincia;

public class Configuracion implements ActionListener {

    public JPanel frame = new JPanel();
    public JLabel op1 = new JLabel("Seleccione la Opcion");
    public JLabel op2 = new JLabel("Nombre Ciudad");
    public JLabel op3 = new JLabel("Nombre Provincia");
    public String[] dat1 = {"Opcion", "Ciudad", "Provincia"};
    public JComboBox cb1 = new JComboBox(dat1);
    public JComboBox<Object> cb2 = new JComboBox();
    public JTextField txtop2 = new JTextField();
    public JButton guardar = new JButton("Guardar");
    private MySQLComandos sql = new MySQLComandos();
    private JOption3 datos = new JOption3();

    public JPanel getFrame() {
        return frame;
    }

    public void initialize() {
        frame.setBounds(205, 0, 575, 350);
        frame.setBackground(Color.LIGHT_GRAY);
        frame.add(this.op1);
        frame.setLayout(null);
        op1.setBounds(15, 30, 215, 15);
        frame.add(this.cb1);
        cb1.setBounds(150, 30, 200, 20);
        frame.add(this.guardar);
        guardar.setBounds(135, 200, 100, 20);
        sql.cargarprovincias(cb2);
        this.cb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {

                if (cb1.getSelectedItem().toString().equals("Ciudad")) {

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
                    frame.show();
                } else if (cb1.getSelectedItem().toString().equals("Provincia")) {
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

        }
        );
        frame.setVisible(true);

        this.guardar.addActionListener(this);

    }

    public void resetCB(JComboBox cb) {
        cb.removeAllItems();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if ((cb1.getSelectedItem().toString().equals("Ciudad")) && (txtop2.getText().isEmpty() != true)) {
            provincia prov = (provincia) cb2.getSelectedItem();
            int idciu = prov.getIdpro();
            ingresociudad cid = new ingresociudad(idciu);
            sql.InsCiud(txtop2, cid.getIdprov());

        } else if (("Provincia".equals(cb1.getSelectedItem().toString())) && (txtop2.getText().isEmpty() != true)) {
            
            sql.InsProv(txtop2,cb2);

        } else {
            datos.mostrar("No se ha seleccionado ningun item");
        }
    }

}
