package Opcion3;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Imagen {
    private BufferedImage ruta;
    private ImageIcon img;
    private Icon icon;
    private File archivoImg;
    protected BufferedImage getRuta() {
        return this.ruta;
    }

    protected void setRuta(BufferedImage ruta) {
        this.ruta = ruta;
    }

    protected ImageIcon getImg() {
        return this.img;
    }

    protected void setImg(ImageIcon img) {
        this.img = img;
    }

    protected Icon getIcon() {
        return this.icon;
    }

    protected void setIcon(Icon icon) {
        this.icon = icon;
    }
    public File getArchivoImg() {
        return archivoImg;
    }

    public void setArchivoImg(File archivoImg) {
        this.archivoImg = archivoImg;
    }

}
