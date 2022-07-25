/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reporte;

import Conexion.MySQLComandos;
import Objetos.Imagen;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JTable;

public class Reporte  {

    //Propiedades de la Clase Reporte
    private JPanel panel = new JPanel();
    MySQLComandos m = new MySQLComandos();
    private JTable report = new JTable();
    Imagen ci1;
    
    public JPanel getpanel() {
        return panel;
    }
    
    public void initialize() {
        panel.setBounds(200, 0, 1080, 720);
        panel.setBackground(new Color(205, 224, 228));
        panel.add(report);
        m.Reportes(report);
        report.setEnabled(false);
        report.setBounds(315, 0, 375, 50 * report.getRowCount());
        panel.setVisible(true);
        
    }
        
}
