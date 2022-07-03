/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Configuracion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author g4to1
 */
public class Configuracion implements ActionListener{
    public JFrame frame=new JFrame("Configuracion");
    public JLabel op1=new JLabel("Seleccione la Opcion");
    public JLabel op2=new JLabel("Nombre Ciudad");
    public JLabel op3=new JLabel("Nombre Provincia");
    public JComboBox cb1=new JComboBox();
    public JTextField txtop2=new JTextField();
    public JButton guardar=new JButton("Guardar");
    
    public void initialize(){
        frame.setBounds(750,300, 400, 400);
        frame.add(this.op1);
        frame.setLayout(null);
        op1.setBounds(15, 30, 215, 15);
        frame.add(this.cb1);
        cb1.setBounds(150,30,200,20);
        frame.add(this.guardar);
        guardar.setBounds(135,200,100,20);
        
        this.cb1.addItem("Opcion");
        this.cb1.addItem("Ciudad");
        this.cb1.addItem("Provincia");
        
        this.cb1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent a){
                if(cb1.getSelectedItem().toString()=="Ciudad"){
                    op3.show(false);
                    op2.show(true);
                    txtop2.show(true);
                    frame.add(op2);
                    op2.setBounds(15, 70, 215, 15);
                    frame.add(txtop2);
                    txtop2.setBounds(150,70,200,20);
                }else if(cb1.getSelectedItem().toString()=="Provincia"){
                    op2.show(false);
                    op3.show(true);
                    txtop2.show(true);
                    frame.add(op3);       
                    op3.setBounds(15, 70, 215, 15);
                    frame.add(txtop2);
                    txtop2.setBounds(150,70,200,20);
                }else{
                    op3.show(false);
                    op2.show(false);
                    txtop2.show(false);
                }
                
            }   
        });

        this.guardar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent g){
                if((cb1.getSelectedItem().toString()=="Ciudad")&&(txtop2.getText()!="")){
                    System.out.println(txtop2.getText());
                }else if((cb1.getSelectedItem().toString()=="Provincia")&&(txtop2.getText()!="")){
                    System.out.println(txtop2.getText());
                }else{
                    JOptionPane.showMessageDialog(null, "No se ha seleccionado ningun item");
                }
            }
        });
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.show();
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public static void main(String[] args) {
        Configuracion cf=new Configuracion();
        cf.initialize();
    }
    
}
