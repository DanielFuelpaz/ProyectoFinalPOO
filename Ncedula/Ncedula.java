package Ncedula;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Ncedula implements ActionListener {

    private JPanel panelcedula(JLabel a) {
        JPanel Jp1 = new JPanel();
        Jp1.add(a);
        Jp1.setBounds(100, 100, 375, 150);
        Jp1.setBackground(Color.GREEN);
        return Jp1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
