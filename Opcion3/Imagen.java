package Opcion3;

import java.awt.image.BufferedImage;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Imagen {
    private BufferedImage ruta;
    private ImageIcon img;
    private Icon icon;

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

}
