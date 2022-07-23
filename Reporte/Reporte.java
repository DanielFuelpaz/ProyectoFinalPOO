/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reporte;

import Conexion.MySQLComandos;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumnModel;

public class Reporte {

    //Propiedades de la Clase Reporte
    private JPanel panel = new JPanel();
    private JPanel cuadrito = new JPanel();
    MySQLComandos m = new MySQLComandos();
    private JTable report = new JTable();
    TableColumnModel columna;

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

        panel.setBounds(200, 0, 1080, 720);
        panel.setBackground(new Color(205, 224, 228));
        cuadrito.setBounds(400, 20, 200, 300);
        cuadrito.setBackground(Color.BLACK);
        report.setBounds(20, 20, 500, 300);
        report.setLayout(null);
        m.Reportes(report);
        JScrollPane jscrollpane = new JScrollPane(report);
        panel.add(cuadrito);
        panel.add(report);
        panel.add(jscrollpane, BorderLayout.CENTER);
        panel.setVisible(true);

        return this.panel;
    }

}
