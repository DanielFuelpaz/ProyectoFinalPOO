/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Opcion1;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author g4to1
 */
public class DatosPersonales implements ActionListener{
    
        public JFrame frame= new JFrame("Datos Personales");
        public JLabel jl1=new JLabel("Nombres");
        public JTextField txtnombres=new JTextField("");
        public JLabel jl2=new JLabel("Apellidos");
        public JTextField txtapellidos=new JTextField();
        public JLabel jl3=new JLabel("Dirección");
        public JTextField txtdireccion=new JTextField();
        public JLabel jl4=new JLabel("Telefono");
        public JTextField txttelefono=new JTextField();
        
        public JLabel jl5=new JLabel("Provincia");
        public JComboBox cb1=new JComboBox();
        public JLabel jl6=new JLabel("Ciudad");
        public JComboBox cb2=new JComboBox();
        public JButton bg=new JButton("Guardar");
        
        public void initialize(){
            frame.setSize(400, 400);
            frame.setLocation(750,250);
            frame.setBackground(Color.CYAN); // Color de fondo
            frame.setLayout(null);
            jl1.setBounds(35, 30, 60, 15);
            frame.add(this.jl1);
            txtnombres.setBounds(100,27,200,25);
            frame.add(this.txtnombres);
            jl2.setBounds(35, 69, 60, 15);
            frame.add(this.jl2);
            txtapellidos.setBounds(100,64,200,25);
            frame.add(this.txtapellidos);
            jl3.setBounds(35, 105, 60, 15);
            frame.add(this.jl3);
            txtdireccion.setBounds(100,101,200,25);
            frame.add(this.txtdireccion);
            jl4.setBounds(35, 144, 60, 15);
            frame.add(this.jl4);
            txttelefono.setBounds(100,140,200,25);
            frame.add(this.txttelefono);
            jl5.setBounds(35, 179, 60, 15);
            frame.add(jl5);
            cb1.setBounds(100, 175, 200, 25);
            frame.add(cb1);
            jl6.setBounds(35, 218, 60, 15);
            frame.add(jl6);
            cb2.setBounds(100, 214, 200, 25);
            frame.add(cb2);
            bg.setBounds(150, 263, 100, 25);
            frame.add(bg);
            
            cb1.addItem("Seleccionar");
            cb2.addItem("Seleccionar");
            
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.show();
            
        }
        
        
        @Override
        public void actionPerformed(ActionEvent ae) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        public static void main(String[] args) {
        DatosPersonales v=new DatosPersonales();
        v.initialize();
    }
}
