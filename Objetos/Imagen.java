package Objetos;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;

public class Imagen extends Canvas {

    private Image img;
    private String op;

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }

    public Image getImg() {
        return this.img;
    }

    public void setImg(Image img) {
        this.img = img;
    }

    public Imagen(Image i) {
        this.img = i;
    }

    @Override
    public void paint(Graphics g) {

        if (this.img != null) {
            g.drawImage(this.img, 50, 0, this.img.getWidth(null), this.img.getHeight(null), this);

        }

    }

}
