package Opcion3;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import java.awt.Dimension;
import javax.swing.JToggleButton;

public class Camara {
    private int largoCamara = 200;
    private int anchoCamara = 300;
    private int numeroFoto = 1;

    public int getLargoCamara() {
        return this.anchoCamara;
    }

    public void setLargoCamara(int largoCamara) {
        this.largoCamara = largoCamara;
    }

    public int getAnchoCamara() {
        return this.anchoCamara;
    }

    public void setAnchoCamara(int anchoCamara) {
        this.anchoCamara = anchoCamara;
    }

    private Dimension dimension = new Dimension(this.getLargoCamara(), this.getAnchoCamara());
    private Dimension dimension1 = WebcamResolution.VGA.getSize();
    private Webcam webcam = Webcam.getDefault();
    private WebcamPanel webcampnl = new WebcamPanel(webcam, dimension, false);

    public Dimension getDimension() {
        return this.dimension;
    }

    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
    }

    public Dimension getDimension1() {
        return this.dimension1;
    }

    public void setDimension1(Dimension dimension1) {
        this.dimension1 = dimension1;
    }

    public Webcam getWebcam() {
        return this.webcam;
    }

    public void setWebcam(Webcam webcam) {
        this.webcam = webcam;
    }

    public WebcamPanel getWebcampnl() {
        return this.webcampnl;
    }

    public void setWebcampnl(WebcamPanel webcampnl) {
        this.webcampnl = webcampnl;
    }

    public int getNumeroFoto() {
        return this.numeroFoto;
    }

    public void setNumeroFoto(int numeroFoto) {
        this.numeroFoto = numeroFoto;
    }

    public void ApagarBotones(JToggleButton a, JToggleButton b, JToggleButton c) {
        a.setEnabled(false);
        b.setEnabled(false);
        c.setEnabled(false);
    }

    public void EncenderBtn(JToggleButton a, JToggleButton b) {
        a.setEnabled(true);
        b.setEnabled(true);

    }

    public void CargarCamaraTexto(JToggleButton a, JToggleButton b, JToggleButton c, JToggleButton d) {
        a.setText("...");
        b.setText("...");
        c.setText("...");
        d.setText("...");
    }

    public void CargadaCamaraTexto(JToggleButton a, JToggleButton b, JToggleButton c, JToggleButton d) {
        a.setText("ENCENDER");
        b.setText("APAGAR");
        c.setText("TOMAR");
        d.setText("GUARDAR");
    }

}