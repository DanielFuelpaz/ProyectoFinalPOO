package Ncedula;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ncedula implements ActionListener {

    private JPanel Jp1 = new JPanel();
    private JLabel ApNom = new JLabel();
    private JLabel Ced = new JLabel();
    private JComboBox personas = new JComboBox();
    private JTextField Rced = new JTextField();

    public JPanel getJp1() {
        return this.Jp1;
    }

    public JPanel panelcedula(JFrame a) {
        a.add(Jp1);
        getJp1().setBounds(200, 0, 575, 350);
        getJp1().setBackground(new Color(205, 224, 228));
        getJp1().setLayout(null);

        getJp1().add(ApNom);
        ApNom.setText("Apellidos y nombres");
        ApNom.setSize(125, 20);
        ApNom.setLocation(240, 0);

        getJp1().add(personas);
        personas.addItem("Ortiz Edison");
        personas.setSize(180, 20);
        personas.setLocation(395, 0);

        getJp1().add(Ced);
        Ced.setText("Cédula");
        Ced.setSize(40, 20);
        Ced.setLocation(240, 200);

        getJp1().add(Rced);
        Rced.setText("");
        Rced.setSize(100, 20);
        Rced.setLocation(Ced.getX() + Ced.getWidth(), 200);

        getJp1().setVisible(true);

        return Jp1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
