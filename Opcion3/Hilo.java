package Opcion3;

import javax.swing.JToggleButton;

public class Hilo {
    public Thread cargarHilo(Camara cam, JToggleButton Apagarbtn, JToggleButton AbrirCamara,JToggleButton Tomarbtn, JToggleButton Guardarbtn ){
        Thread hilo = new Thread() {
            @Override
            public void run() {
                cam.getWebcampnl().start();
                cam.getWebcam().open();
                cam.EncenderBtn(Apagarbtn, Tomarbtn);
                cam.CargadaCamaraTexto(AbrirCamara, Apagarbtn, Tomarbtn, Guardarbtn);
            }

        };
        return hilo;
    }
}
