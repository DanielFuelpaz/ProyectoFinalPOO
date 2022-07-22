/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reporte;

import Conexion.MySQLComandos;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Reporte {

    //Propiedades de la Clase Reporte
    private JPanel panel = new JPanel();
    MySQLComandos m = new MySQLComandos();
    private JTable report = new JTable();

    public JPanel getPanel() {
        return this.panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public JTable getReport() {
        return this.report;
    }

    public void setReport(JTable report) {
        this.report = report;
    }

    public JPanel initialize() {

        panel.setBounds(200, 0, 575, 350);
        panel.setBackground(new Color(205, 224, 228));
        report.setPreferredScrollableViewportSize(new Dimension(200, 300));
        report.setBounds(20, 20, 475, 300);
        JScrollPane Scroll=new JScrollPane();
        Scroll.setViewportView(report);
        DefaultTableModel model = m.Reportes();
        report.setModel(model);
        panel.add(report);
        panel.setLayout(null);
        panel.setVisible(true);

        return this.panel;
    }

}
