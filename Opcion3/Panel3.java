package Opcion3;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.util.ArrayList;
public class Panel3 {
    private JPanel panel = new JPanel();
    private JLabel cedulaTitulo = new JLabel("cédula:");
    private JComboBox listaCedulas = new JComboBox();
    private JLabel imagenTitulo = new JLabel("Imagen");
    private JButton tomarFoto = new JButton("Tomar Foto");
    private JLabel espacioParaImagen = new JLabel();
    private JButton guardar = new JButton("Guardar");

    public JPanel getPanel() {
        return this.panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
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

    public JButton getGuardar() {
        return this.guardar;
    }

    public void setGuardar(JButton guardar) {
        this.guardar = guardar;
    }

    public JPanel getPanel3(JFrame frame) {
        frame.add(this.getPanel());
        this.getPanel().setLayout(null);
        this.getPanel().setBounds(200, 0, 570, 350);
        this.getPanel().setBackground(Color.cyan);
        this.getCedulaTitulo().setBounds(125, 20, 50, 20);
        this.getListaCedulas().setBounds(this.getCedulaTitulo().getWidth() + 125, 20, 270, 20);
        this.getImagenTitulo().setBounds(125,
                this.getCedulaTitulo().getHeight() + this.getCedulaTitulo().getY() + 50, 50, 20);
        this.getTomarFoto().setBounds(270,
                this.getCedulaTitulo().getHeight() + this.getCedulaTitulo().getY() + 50, 100, 20);
        this.getEspacioParaImagen().setBounds(125,
                this.getTomarFoto().getHeight() + this.getTomarFoto().getY() + 50, 270, 100);
        this.getGuardar().setBounds(255,
                this.getEspacioParaImagen().getHeight() + this.getEspacioParaImagen().getY() + 50,
                100, 20);
        this.getPanel().add(this.getCedulaTitulo());
        this.getPanel().add(this.getListaCedulas());
        this.getPanel().add(this.getImagenTitulo());
        this.getPanel().add(this.getTomarFoto());
        this.getPanel().add(this.getEspacioParaImagen());
        this.getListaCedulas().removeAllItems();
        TraerCedulas cedulasBase = new TraerCedulas();
        ArrayList<String> cedulas = cedulasBase.ObtenerCedulas();
        for (int i = 0; i < cedulas.size(); i++) {
            this.getListaCedulas().addItem(cedulas.get(i));
        }
        this.getPanel().add(this.getGuardar());
        this.getPanel().setVisible(true);
        return this.getPanel();
    }

}
