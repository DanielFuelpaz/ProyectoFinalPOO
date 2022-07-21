package Opcion3;

import java.awt.FlowLayout;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

public class Camarapnl extends javax.swing.JPanel {

    Imagen img = new Imagen();
    Camara cam = new Camara();

    public Camarapnl() {
        initComponents();
        this.setSize(550, 410);
        this.setVisible(true);
        this.setLocation(10, 140);
        this.removeAll();
        this.getCam().getWebcam().setViewSize(this.getCam().getDimension1());
        this.getCam().getWebcampnl().setFillArea(true);
        this.getCamaraPnl().setLayout(new FlowLayout());
        this.getCamaraPnl().add(this.getCam().getWebcampnl());
        this.getDescripcionCamara().setText(this.getCam().getWebcam().toString());
        this.getCam().ApagarBotones(this.getApagarbtn(), this.getTomarbtn(), this.getGuardarbtn());
    }

    public JToggleButton getApagarbtn() {
        return this.Apagarbtn;
    }

    public void setApagarbtn(JToggleButton Apagarbtn) {
        this.Apagarbtn = Apagarbtn;
    }

    public JPanel getCamaraPnl() {
        return this.CamaraPnl;
    }

    public void setCamaraPnl(JPanel CamaraPnl) {
        this.CamaraPnl = CamaraPnl;
    }

    public JLabel getCamaraTitulo() {
        return this.CamaraTitulo;
    }

    public void setCamaraTitulo(JLabel CamaraTitulo) {
        this.CamaraTitulo = CamaraTitulo;
    }

    public JToggleButton getEncenderbtn() {
        return this.Encenderbtn;
    }

    public void setEncenderbtn(JToggleButton Encenderbtn) {
        this.Encenderbtn = Encenderbtn;
    }

    public JToggleButton getGuardarbtn() {
        return this.Guardarbtn;
    }

    public void setGuardarbtn(JToggleButton Guardarbtn) {
        this.Guardarbtn = Guardarbtn;
    }

    public JToggleButton getTomarbtn() {
        return this.Tomarbtn;
    }

    public void setTomarbtn(JToggleButton Tomarbtn) {
        this.Tomarbtn = Tomarbtn;
    }

    public JLabel getDescripcionCamara() {
        return this.DescripcionCamara;
    }

    public void setDescripcionCamara(JLabel DescripcionCamara) {
        this.DescripcionCamara = DescripcionCamara;
    }

    public JLabel getFotolbl() {
        return this.fotolbl;
    }

    public void setFotolbl(JLabel fotolbl) {
        this.fotolbl = fotolbl;
    }

    public Imagen getImg() {
        return this.img;
    }

    public void setImg(Imagen img) {
        this.img = img;
    }

    public Camara getCam() {
        return this.cam;
    }

    public void setCam(Camara cam) {
        this.cam = cam;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        CamaraTitulo = new javax.swing.JLabel();
        DescripcionCamara = new javax.swing.JLabel();
        CamaraPnl = new javax.swing.JPanel();
        fotolbl = new javax.swing.JLabel();
        Tomarbtn = new javax.swing.JToggleButton();
        Apagarbtn = new javax.swing.JToggleButton();
        Guardarbtn = new javax.swing.JToggleButton();
        Encenderbtn = new javax.swing.JToggleButton();

        setBackground(new java.awt.Color(0, 0, 0));

        CamaraTitulo.setForeground(new java.awt.Color(255, 255, 255));
        CamaraTitulo.setText("Camara: ");

        DescripcionCamara.setForeground(new java.awt.Color(255, 255, 255));
        DescripcionCamara.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DescripcionCamara.setText("-");
        DescripcionCamara.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        DescripcionCamara.setVerifyInputWhenFocusTarget(false);

        CamaraPnl.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout CamaraPnlLayout = new javax.swing.GroupLayout(CamaraPnl);
        CamaraPnl.setLayout(CamaraPnlLayout);
        CamaraPnlLayout.setHorizontalGroup(
                CamaraPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 300, Short.MAX_VALUE));
        CamaraPnlLayout.setVerticalGroup(
                CamaraPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 147, Short.MAX_VALUE));

        fotolbl.setText("                     ");

        Tomarbtn.setText("TOMAR");
        Tomarbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TomarbtnActionPerformed(evt);
            }
        });

        Apagarbtn.setText("APAGAR");
        Apagarbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ApagarbtnActionPerformed(evt);
            }
        });

        Guardarbtn.setText("GUARDAR");
        Guardarbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarbtnActionPerformed(evt);
            }
        });

        Encenderbtn.setText("ENCENDER");
        Encenderbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EncenderbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(156, 156, 156)
                                .addComponent(CamaraTitulo)
                                .addGap(110, 110, 110)
                                .addComponent(DescripcionCamara, javax.swing.GroupLayout.PREFERRED_SIZE, 145,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(4, 4, 4)
                                                .addComponent(Encenderbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 104,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Tomarbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Apagarbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(CamaraPnl, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93,
                                        Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
                                                .createSequentialGroup()
                                                .addComponent(Guardarbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(67, 67, 67))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                layout.createSequentialGroup()
                                                        .addComponent(fotolbl, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(34, 34, 34)))));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(CamaraTitulo)
                                        .addComponent(DescripcionCamara))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(CamaraPnl, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(7, 7, 7)
                                                .addComponent(fotolbl, javax.swing.GroupLayout.PREFERRED_SIZE, 135,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(Tomarbtn)
                                        .addComponent(Apagarbtn)
                                        .addComponent(Guardarbtn)
                                        .addComponent(Encenderbtn))
                                .addGap(24, 24, 24)));
    }// </editor-fold>

    private void TomarbtnActionPerformed(java.awt.event.ActionEvent evt) {
        this.getTomarbtn().setText("OTRA");
        this.getGuardarbtn().setEnabled(true);
        this.getImg().setImg(new ImageIcon(this.getCam().getWebcam().getImage()));
//        this.getImg().setIcon(new ImageIcon(this.getImg().getImg().getImage().getScaledInstance(this.getFotolbl().getWidth(), this.getFotolbl().getHeight(),Image.SCALE_SMOOTH )));
        this.getImg().setIcon(new ImageIcon(this.getImg().getImg().getImage()
                .getScaledInstance(this.getFotolbl().getWidth(), this.getFotolbl().getHeight(), Image.SCALE_SMOOTH)));
        this.getFotolbl().setIcon(this.getImg().getIcon());
        this.getImg().setRuta(this.getCam().getWebcam().getImage());
    }

    private void ApagarbtnActionPerformed(java.awt.event.ActionEvent evt) {
        this.getCam().getWebcampnl().stop();
        this.getCam().ApagarBotones(this.getApagarbtn(), this.getTomarbtn(), this.getGuardarbtn());
        this.getEncenderbtn().setEnabled(true);
        this.getFotolbl().setIcon(null);
    }

    private void GuardarbtnActionPerformed(java.awt.event.ActionEvent evt) {
        JOption datos = new JOption();
        int respuesta = datos.preguntar("¿Desea guardar la foto?", "Confirmación");
        if (respuesta == 0) {
            String rutaDispositivo = datos.ingreso("Ingrese la ruta de su dispositivo para guardar la imagen", "Ruta");
            File imagenRuta = new File(rutaDispositivo + "\\Foto" + this.getCam().getNumeroFoto() + ".jpg");
            try {
                ImageIO.write(this.getImg().getRuta(), "jpg", imagenRuta);
                datos.mostar("Se guardó su imagen en: " + imagenRuta.getAbsolutePath());
            } catch (Exception e) {
                System.out.println("Error: " + e);
            }
            this.getFotolbl().setIcon(null);
            this.getGuardarbtn().setEnabled(false);
            this.getTomarbtn().setText("TOMAR");
        }
        this.getCam().setNumeroFoto(this.getCam().getNumeroFoto() + 1);
    }

    private void EncenderbtnActionPerformed(java.awt.event.ActionEvent evt) {
        this.getCam().CargarCamaraTexto(this.getApagarbtn(), this.getTomarbtn(), this.getEncenderbtn(),
                this.getGuardarbtn());
        Thread hilo = new Thread() {
            @Override
            public void run() {
                cam.getWebcampnl().start();
                cam.getWebcam().open();
                cam.EncenderBtn(Apagarbtn, Tomarbtn);
                cam.CargadaCamaraTexto(Encenderbtn, Apagarbtn, Tomarbtn, Guardarbtn);
            }

        };
        hilo.setDaemon(true);
        hilo.start();
        this.getEncenderbtn().setEnabled(false);
    }

    // Variables declaration - do not modify
    private javax.swing.JToggleButton Apagarbtn;
    private javax.swing.JPanel CamaraPnl;
    private javax.swing.JLabel CamaraTitulo;
    private javax.swing.JLabel DescripcionCamara;
    private javax.swing.JToggleButton Encenderbtn;
    private javax.swing.JToggleButton Guardarbtn;
    private javax.swing.JToggleButton Tomarbtn;
    private javax.swing.JLabel fotolbl;
    // End of variables declaration
}
