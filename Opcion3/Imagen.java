package Opcion3;

import java.awt.image.BufferedImage;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Imagen {
    private BufferedImage ruta;
    private ImageIcon img;
    private Icon icon;

    public BufferedImage getRuta() {
        return this.ruta;
    }

    public void setRuta(BufferedImage ruta) {
        this.ruta = ruta;
    }

    public ImageIcon getImg() {
        return this.img;
    }

    public void setImg(ImageIcon img) {
        this.img = img;
    }

    public Icon getIcon() {
        return this.icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

}
