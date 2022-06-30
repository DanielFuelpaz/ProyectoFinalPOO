package Ncedula;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ncedula implements ActionListener {

    JPanel Jp1 = new JPanel();

    public JPanel panelcedula(JFrame a) {
        a.add(Jp1);
        Jp1.setBounds(200, 0, 375, 350);
        Jp1.setBackground(Color.white);
        Jp1.setVisible(true);
        return Jp1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
