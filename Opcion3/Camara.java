package Opcion3;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import java.awt.Dimension;
import javax.swing.JToggleButton;

public class Camara {
    private int largoCamara = 250;
    private int anchoCamara = 150;
    private int numeroFoto = 1;

    private int getLargoCamara() {
        return this.largoCamara;
    }

    private void setLargoCamara(int largoCamara) {
        this.largoCamara = largoCamara;
    }

    private int getAnchoCamara() {
        return this.anchoCamara;
    }

    private void setAnchoCamara(int anchoCamara) {
        this.anchoCamara = anchoCamara;
    }

    private Dimension dimension = new Dimension(this.getLargoCamara(), this.getAnchoCamara());
    private Dimension dimension1 = WebcamResolution.VGA.getSize();
    private Webcam webcam = Webcam.getDefault();
    private WebcamPanel webcampnl = new WebcamPanel(webcam, dimension, false);

    protected Dimension getDimension() {
        return this.dimension;
    }

    protected void setDimension(Dimension dimension) {
        this.dimension = dimension;
    }

    protected Dimension getDimension1() {
        return this.dimension1;
    }

    protected void setDimension1(Dimension dimension1) {
        this.dimension1 = dimension1;
    }

    protected Webcam getWebcam() {
        return this.webcam;
    }

    protected void setWebcam(Webcam webcam) {
        this.webcam = webcam;
    }

    protected WebcamPanel getWebcampnl() {
        return this.webcampnl;
    }

    protected void setWebcampnl(WebcamPanel webcampnl) {
        this.webcampnl = webcampnl;
    }

    protected int getNumeroFoto() {
        return this.numeroFoto;
    }

    protected void setNumeroFoto(int numeroFoto) {
        this.numeroFoto = numeroFoto;
    }

    protected void ApagarBotones(JToggleButton a, JToggleButton b, JToggleButton c) {
        a.setEnabled(false);
        b.setEnabled(false);
        c.setEnabled(false);
    }

    protected void EncenderBtn(JToggleButton a, JToggleButton b) {
        a.setEnabled(true);
        b.setEnabled(true);

    }

    protected void CargarCamaraTexto(JToggleButton a, JToggleButton b, JToggleButton c, JToggleButton d) {
        a.setText("...");
        b.setText("...");
        c.setText("...");
        d.setText("...");
    }

    protected void CargadaCamaraTexto(JToggleButton a, JToggleButton b, JToggleButton c, JToggleButton d) {
        a.setText("Abrir cámara");
        b.setText("APAGAR");
        c.setText("TOMAR");
        d.setText("GUARDAR");
    }

}