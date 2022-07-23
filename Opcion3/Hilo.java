/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Opcion3;

import javax.swing.JToggleButton;

/**
 *
 * @author pc
 */
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
