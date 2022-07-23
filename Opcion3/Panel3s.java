package Opcion3;

import Conexion.MySQLComandos;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Panel3s extends javax.swing.JPanel {

    private MySQLComandos comandos = new MySQLComandos();
    Imagen img = new Imagen();
    Camara cam = new Camara();
    String opcion;

    public MySQLComandos getComandos() {
        return this.comandos;
    }

    public void setComandos(MySQLComandos comandos) {
        this.comandos = comandos;
    }

    public Panel3s() {
        initComponents();
        this.setSize(570, 350);
        this.setLocation(205, 0);
        this.removeAll();
        this.setBackground(Color.cyan);
        this.getListaCedulas().removeAllItems();
        this.getComandos().ConexionCedulas(listaCedulas);
        this.setVisible(true);
        this.getCam().getWebcam().setViewSize(this.getCam().getDimension1());
        this.getCam().getWebcampnl().setFillArea(true);
        this.getCamarapnl().setLayout(new FlowLayout());
        this.getCamarapnl().add(this.getCam().getWebcampnl());
        this.getDescripcionCamara().setText(this.getCam().getWebcam().toString());
        this.getCam().ApagarBotones(this.getApagarbtn(), this.getTomarbtn(), this.getGuardarbtn());
        this.getListaCedulas().addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                opcion = listaCedulas.getSelectedItem().toString();
            }
        });
    }

    private JToggleButton getAbrirCamara() {
        return this.AbrirCamara;
    }

    private void setAbrirCamara(JToggleButton AbrirCamara) {
        this.AbrirCamara = AbrirCamara;
    }

    private JToggleButton getApagarbtn() {
        return this.Apagarbtn;
    }

    private void setApagarbtn(JToggleButton Apagarbtn) {
        this.Apagarbtn = Apagarbtn;
    }

    private JToggleButton getGuardarbtn() {
        return this.Guardarbtn;
    }

    private void setGuardarbtn(JToggleButton Guardarbtn) {
        this.Guardarbtn = Guardarbtn;
    }

    private JToggleButton getTomarbtn() {
        return this.Tomarbtn;
    }

    private void setTomarbtn(JToggleButton Tomarbtn) {
        this.Tomarbtn = Tomarbtn;
    }

    private JLabel getCamaraTitulo() {
        return this.camaraTitulo;
    }

    private void setCamaraTitulo(JLabel camaraTitulo) {
        this.camaraTitulo = camaraTitulo;
    }

    private JPanel getCamarapnl() {
        return this.camarapnl;
    }

    private void setCamarapnl(JPanel camarapnl) {
        this.camarapnl = camarapnl;
    }

    private JLabel getCedulaTitulo() {
        return this.cedulaTitulo;
    }

    private void setCedulaTitulo(JLabel cedulaTitulo) {
        this.cedulaTitulo = cedulaTitulo;
    }

    private JLabel getDescripcionCamara() {
        return this.descripcionCamara;
    }

    private void setDescripcionCamara(JLabel descripcionCamara) {
        this.descripcionCamara = descripcionCamara;
    }

    private JLabel getFotolbl() {
        return this.fotolbl;
    }

    private void setFotolbl(JLabel fotolbl) {
        this.fotolbl = fotolbl;
    }

    private JLabel getImagenTitulo() {
        return this.imagenTitulo;
    }

    private void setImagenTitulo(JLabel imagenTitulo) {
        this.imagenTitulo = imagenTitulo;
    }

    private JComboBox<String> getListaCedulas() {
        return this.listaCedulas;
    }

    private void setListaCedulas(JComboBox<String> listaCedulas) {
        this.listaCedulas = listaCedulas;
    }

    private Camara getCam() {
        return this.cam;
    }

    private void setCam(Camara cam) {
        this.cam = cam;
    }

    private Imagen getImg() {
        return this.img;
    }

    private void setImg(Imagen img) {
        this.img = img;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cedulaTitulo = new javax.swing.JLabel();
        listaCedulas = new javax.swing.JComboBox<>();
        imagenTitulo = new javax.swing.JLabel();
        camaraTitulo = new javax.swing.JLabel();
        descripcionCamara = new javax.swing.JLabel();
        camarapnl = new javax.swing.JPanel();
        Tomarbtn = new javax.swing.JToggleButton();
        Apagarbtn = new javax.swing.JToggleButton();
        fotolbl = new javax.swing.JLabel();
        Guardarbtn = new javax.swing.JToggleButton();
        AbrirCamara = new javax.swing.JToggleButton();

        cedulaTitulo.setText("Cédula:");

        listaCedulas.setModel(
                new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        imagenTitulo.setText("Imagen:");

        camaraTitulo.setText("Cámara en uso:");

        descripcionCamara.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        descripcionCamara.setText("-");
        descripcionCamara.setToolTipText("");

        camarapnl.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout camarapnlLayout = new javax.swing.GroupLayout(camarapnl);
        camarapnl.setLayout(camarapnlLayout);
        camarapnlLayout.setHorizontalGroup(
                camarapnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 263, Short.MAX_VALUE));
        camarapnlLayout.setVerticalGroup(
                camarapnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 137, Short.MAX_VALUE));

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

        fotolbl.setText("                     ");

        Guardarbtn.setText("GUARDAR");
        Guardarbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarbtnActionPerformed(evt);
            }
        });

        AbrirCamara.setText("AbrirCamara");
        AbrirCamara.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AbrirCamaraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(cedulaTitulo)
                                                        .addComponent(imagenTitulo))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(listaCedulas,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 224,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(40, 40, 40)
                                                                .addComponent(camaraTitulo)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        Short.MAX_VALUE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(AbrirCamara)
                                                                .addGap(101, 101, 101)
                                                                .addComponent(descripcionCamara,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        Short.MAX_VALUE))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(0, 46, Short.MAX_VALUE)
                                                                .addComponent(camarapnl,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(32, 32, 32))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(86, 86, 86)
                                                                .addComponent(Tomarbtn,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 77,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(Apagarbtn,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 89,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        Short.MAX_VALUE)))
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(Guardarbtn)
                                                        .addComponent(fotolbl, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                143, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(43, 43, 43)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(27, 27, 27)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(cedulaTitulo)
                                                        .addComponent(listaCedulas,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(29, 29, 29))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                layout.createSequentialGroup()
                                                        .addContainerGap()
                                                        .addComponent(camaraTitulo)
                                                        .addGap(18, 18, 18)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(imagenTitulo)
                                                .addComponent(AbrirCamara))
                                        .addComponent(descripcionCamara))
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(camarapnl, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(Tomarbtn)
                                                        .addComponent(Apagarbtn)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(fotolbl, javax.swing.GroupLayout.PREFERRED_SIZE, 132,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(Guardarbtn)))
                                .addContainerGap(143, Short.MAX_VALUE)));
    }// </editor-fold>//GEN-END:initComponents

    private void TomarbtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_TomarbtnActionPerformed
        this.getTomarbtn().setText("OTRA");
        this.getGuardarbtn().setEnabled(true);
        this.getImg().setImg(new ImageIcon(this.getCam().getWebcam().getImage()));
        this.getImg().setIcon(new ImageIcon(this.getImg().getImg().getImage()
                .getScaledInstance(this.getFotolbl().getWidth(), this.getFotolbl().getHeight(), Image.SCALE_SMOOTH)));
        this.getFotolbl().setIcon(this.getImg().getIcon());
        this.getImg().setRuta(this.getCam().getWebcam().getImage());
    }// GEN-LAST:event_TomarbtnActionPerformed

    private void ApagarbtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_ApagarbtnActionPerformed
        this.getCam().getWebcampnl().stop();
        this.getCam().ApagarBotones(this.getApagarbtn(), this.getTomarbtn(), this.getGuardarbtn());
        this.getAbrirCamara().setEnabled(true);
        this.getFotolbl().setIcon(null);
    }// GEN-LAST:event_ApagarbtnActionPerformed

    private void GuardarbtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_GuardarbtnActionPerformed
        JOption3 datos = new JOption3();
        MySQLComandos comandos = new MySQLComandos();
        int respuesta = datos.preguntar("¿Desea guardar la foto?", "Confirmación");
        if (respuesta == 0) {
            String rutaDispositivo = datos.ingreso("Ingrese la ruta de su dispositivo para guardar la imagen", "Ruta");
            File imagenRuta = new File(rutaDispositivo + "\\Foto" + this.getCam().getNumeroFoto() + ".jpg");
            comandos.enviarImagen(imagenRuta.getAbsolutePath(), opcion);
            try {
                ImageIO.write(this.getImg().getRuta(), "jpg", imagenRuta);
                datos.mostrar("Se guardó su imagen en: " + imagenRuta.getAbsolutePath());
            } catch (Exception e) {
                datos.mostrar(e);
            }
            this.getFotolbl().setIcon(null);
            this.getGuardarbtn().setEnabled(false);
            this.getTomarbtn().setText("TOMAR");
        }
        this.getCam().setNumeroFoto(this.getCam().getNumeroFoto() + 1);
    }// GEN-LAST:event_GuardarbtnActionPerformed

    private void AbrirCamaraActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_AbrirCamaraActionPerformed
        this.getCam().CargarCamaraTexto(this.getApagarbtn(), this.getTomarbtn(), this.getAbrirCamara(),
                this.getGuardarbtn());
        Hilo h = new Hilo();
        Thread hilo = h.cargarHilo(this.getCam(), this.getApagarbtn(), this.getAbrirCamara(), this.getTomarbtn(),
                this.getGuardarbtn());
        hilo.setDaemon(true);
        hilo.start();
        this.getAbrirCamara().setEnabled(false);
    }// GEN-LAST:event_AbrirCamaraActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton AbrirCamara;
    private javax.swing.JToggleButton Apagarbtn;
    private javax.swing.JToggleButton Guardarbtn;
    private javax.swing.JToggleButton Tomarbtn;
    private javax.swing.JLabel camaraTitulo;
    private javax.swing.JPanel camarapnl;
    private javax.swing.JLabel cedulaTitulo;
    private javax.swing.JLabel descripcionCamara;
    private javax.swing.JLabel fotolbl;
    private javax.swing.JLabel imagenTitulo;
    private javax.swing.JComboBox<String> listaCedulas;
    // End of variables declaration//GEN-END:variables
}
