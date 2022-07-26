
package Utilitarios;

import Objetos.Personas;
import Opcion3.Imagen;
import Opcion3.JFChooser;
import Opcion3.JOption3;
import java.io.File;

public class Ciclos {
    public File ImagenDesicion(JOption3 datos, String rutaDispositivo,Personas comprobador){
        File imagenRuta = null;
        do{
                String nombreFoto = datos.ingreso("Ingrese el nombre que quiere que tenga su foto",null).replace(" ", "");
                int sobreescribir=comprobador.comprobarExistencia(new File(rutaDispositivo + "\\"+nombreFoto + ".jpg"));
                switch(sobreescribir){
                    case 0:
                    imagenRuta = new File(rutaDispositivo + "\\"+nombreFoto + ".jpg"); 
                    break;
                    case 1:
                    imagenRuta=null;
                    break;
                    case 2:
                    imagenRuta = new File(rutaDispositivo + "\\"+nombreFoto + ".jpg");
                    break;
                }
            }while(imagenRuta==null);
        return imagenRuta;
    }
}
