package Opcion3;

import Conexion.MySQLComandos;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JOption {

    private JPanel panel = new JPanel();
    private JLabel cedulaTitulo = new JLabel("cédula:");
    private JComboBox listaCedulas = new JComboBox();
    private JLabel imagenTitulo = new JLabel("Imagen");
    private JButton tomarFoto = new JButton("Abrir Cámara");
    private JLabel espacioParaImagen = new JLabel();
    private MySQLComandos comandos = new MySQLComandos();

    public JPanel getPanel() {
        return this.panel;
    }

    public int preguntar(String s, String t) {
        int r = JOptionPane.showConfirmDialog(null, s, t, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        return r;
    }

    public String ingreso(String s, String t) {
        return JOptionPane.showInputDialog(null, s, t);
    }

    public JLabel getCedulaTitulo() {
        return this.cedulaTitulo;
    }

    public void setCedulaTitulo(JLabel cedulaTitulo) {
        this.cedulaTitulo = cedulaTitulo;
    }

    public JComboBox getListaCedulas() {
        return this.listaCedulas;
    }

    public void setListaCedulas(JComboBox listaCedulas) {
        this.listaCedulas = listaCedulas;
    }

    public JLabel getImagenTitulo() {
        return this.imagenTitulo;
    }

    public void setImagenTitulo(JLabel imagenTitulo) {
        this.imagenTitulo = imagenTitulo;
    }

    public JButton getTomarFoto() {
        return this.tomarFoto;
    }

    public void setTomarFoto(JButton tomarFoto) {
        this.tomarFoto = tomarFoto;
    }

    public JLabel getEspacioParaImagen() {
        return this.espacioParaImagen;
    }

    public void setEspacioParaImagen(JLabel espacioParaImagen) {
        this.espacioParaImagen = espacioParaImagen;
    }

    public JPanel getPanel3(JFrame frame) {
        frame.add(this.getPanel());
        this.getPanel().setLayout(null);
        this.getPanel().setBounds(200, 0, 570, 600);
        this.getPanel().setBackground(Color.cyan);
        this.getCedulaTitulo().setBounds(125, 20, 50, 20);
        this.getListaCedulas().setBounds(this.getCedulaTitulo().getWidth() + 125, 20, 270, 20);
        this.getImagenTitulo().setBounds(125,
                this.getCedulaTitulo().getHeight() + this.getCedulaTitulo().getY() + 50, 50, 20);
        this.getTomarFoto().setBounds(270,
                this.getCedulaTitulo().getHeight() + this.getCedulaTitulo().getY() + 50, 150, 20);
        this.getEspacioParaImagen().setBounds(125,
                this.getTomarFoto().getHeight() + this.getTomarFoto().getY() + 50, 270, 100);
        this.getPanel().add(this.getCedulaTitulo());
        this.getPanel().add(this.getListaCedulas());
        this.getPanel().add(this.getImagenTitulo());
        this.getPanel().add(this.getTomarFoto());
        this.getPanel().add(this.getEspacioParaImagen());
        this.comandos.ConexionCedulas(this.getListaCedulas());
        this.getPanel().setVisible(true);
        this.getTomarFoto().addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Camarapnl cam = new Camarapnl();
                panel.add(cam, BorderLayout.CENTER);
                panel.revalidate();
                panel.repaint();
            }

        }
        );
        return this.getPanel();
    }

    public void mostar(String s) {
        JOptionPane.showMessageDialog(null, s);

    }

}
