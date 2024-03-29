package Conexion;

import Objetos.PersonaBD;
import Objetos.Render;
import Objetos.ciudades;
import Objetos.provincia;
import Opcion3.JOption3;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableColumnModel;

public class MySQLComandos {

    private String instruccion;
    private PreparedStatement p;
    private ResultSet rs;
    private final Conexion c = new Conexion();
    JOption3 datos = new JOption3();
    ArrayList<PersonaBD> personas = new ArrayList<>();

    public ArrayList<PersonaBD> getPersonas() {
        return personas;
    }

    public void setPersonas(ArrayList<PersonaBD> personas) {
        this.personas = personas;
    }

    public String getInstruccion() {
        return this.instruccion;
    }

    public void setInstruccion(String instruccion) {
        this.instruccion = instruccion;
    }

    public PreparedStatement getP() {
        return this.p;
    }

    public void setP(PreparedStatement p) {
        this.p = p;
    }

    public ResultSet getRs() {
        return this.rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }

    public JOption3 getDatos() {
        return this.datos;
    }

    public void setDatos(JOption3 datos) {
        this.datos = datos;
    }

    // Metodo de Inicio de Secion
    public boolean iniciosesion(JTextField usuario, JPasswordField contraseña) throws SQLException {
        Connection co = c.getConexion();
        try {
            this.setInstruccion("SELECT * FROM usuarios");
            this.setP(co.prepareStatement(this.getInstruccion()));
            this.setRs(this.getP().executeQuery());
            while (this.getRs().next()) {
                if (this.getRs().getString("usuario").equals(usuario.getText())
                        && this.getRs().getString("contraseña").equals(contraseña.getText())) {
                    this.getDatos().mostrar("sesion iniciada correctamente");
                    return true;

                }
            }

            // executeUpdate cuando se hacen select
        } catch (Exception e) {
            this.getDatos().mostrar("Error en la conexion");
        } finally {
            try {
                if (this.getRs() != null) {
                    this.getRs().close();
                }
                if (this.getP() != null) {
                    this.getP().close();
                }
                if (co != null) {
                    co.close();
                }
            } catch (SQLException e) {
                this.getDatos().mostrar(e);
            }
        }
        return false;
    }

    // Control Creacion de Usuario
    public boolean creacionusuario(JTextField usuario, JPasswordField confirmacion, JPasswordField contraseña) {
        Connection co = c.getConexion();
        try {

            this.setInstruccion("SELECT * FROM usuarios");
            this.setP(co.prepareStatement(this.getInstruccion()));
            this.setRs(this.getP().executeQuery());
            while (this.getRs().next()) {
                // primer control: Nombres de usuarios ya existentes
                if (!(rs.getString("usuario").equals(usuario.getText()))) {
                    if (!(contraseña.getText().contains(usuario.getText())) && !(confirmacion.getText().contains(usuario.getText()))) {

                        if (contraseña.getText().matches("[A-Z]+.[a-z]*.[@$?¡\\-\\*_].\\d[0-9]*") && confirmacion.getText().matches("[A-Z]+.[a-z]*.[@$?¡\\-\\*_].\\d[0-9]*")) {
                            this.setInstruccion("Insert into usuarios set usuario =?, contraseña =?");
                            this.setP(co.prepareStatement(this.getInstruccion()));

                            this.getP().setString(1, usuario.getText());
                            this.getP().setString(2, confirmacion.getText());

                            this.getP().executeUpdate();
                            this.getDatos().mostrar(" ==== Usuario Creado ====");
                            usuario.setText("");
                            contraseña.setText("");
                            confirmacion.setText("");
                            return true;
                        } else {
                            this.getDatos().mostrar("Formato de contraseña incorrecto\nEjemplo: Contraseña*45");
                            return false;
                        }
                    } else {
                        this.getDatos().mostrar("La contraseña contiene el nombre de usuario");
                        return false;
                    }
                }

            }

            // executeUpdate cuando se hacen select
        } catch (SQLException ex) {
            this.getDatos().mostrar("El Usuario " + usuario.getText() + " ya existe");

        } finally {
            try {
                if (this.getRs() != null) {
                    this.getRs().close();
                }
                if (this.getP() != null) {
                    this.getP().close();
                }
                if (co != null) {
                    co.close();
                }
            } catch (SQLException e) {
                this.getDatos().mostrar(e);
            }
        }
        return false;

    }

    // Metodo de Traer Reportes
    public void Reportes(JTable tabla) {
        this.CargarDatos();
        tabla.setDefaultRenderer(Object.class, new Render());
        DefaultTableModel dt = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        dt.addColumn("ID");
        dt.addColumn("Last Name");
        dt.addColumn("First Name");
        dt.addColumn("Address");
        dt.addColumn("URL");
        dt.addColumn("Selfie");
        if (getPersonas().size() > 0) {
            for (int i = 0; i < getPersonas().size(); i++) {
                Object fila[] = new Object[6];
                fila[0] = getPersonas().get(i).getCedula();
                fila[1] = getPersonas().get(i).getApellido();
                fila[2] = getPersonas().get(i).getNombre();
                fila[3] = getPersonas().get(i).getDireccion();
                fila[4] = getPersonas().get(i).getRutaF();
                try {
                    byte[] bi = getPersonas().get(i).getFotos();
                    BufferedImage image = null;
                    InputStream in = new ByteArrayInputStream(bi);
                    image = ImageIO.read(in);
                    ImageIcon imgi = new ImageIcon(image.getScaledInstance(80, 80, 0));
                    fila[5] = new JLabel(imgi);

                } catch (Exception ex) {
                    fila[5] = new JLabel("No imagen");
                }
                dt.addRow(fila);
            }
            tabla.setModel(dt);
            TableColumnModel columnModel = tabla.getColumnModel();

            columnModel.getColumn(0).setPreferredWidth(100);
            columnModel.getColumn(1).setPreferredWidth(100);
            columnModel.getColumn(2).setPreferredWidth(100);
            columnModel.getColumn(3).setPreferredWidth(100);
            columnModel.getColumn(4).setPreferredWidth(250);
            columnModel.getColumn(5).setPreferredWidth(100);
            columnModel.getColumn(0).setMaxWidth(90);
            tabla.setRowHeight(65);

        }
    }

    public void CargarDatos() {
        Connection co = c.getConexion();
        ArrayList<PersonaBD> listP = new ArrayList();
        PersonaBD persona;
        try {

            this.setInstruccion("SELECT * FROM datospersonales ORDER BY datospersonales.cedula ASC");
            this.setP(co.prepareStatement(this.getInstruccion()));
            this.setRs(this.getP().executeQuery());
            while (this.getRs().next()) {
                persona = new PersonaBD();
                if (this.getRs().getString("cedula") != null) {
                    persona.setCedula(Integer.parseInt(this.getRs().getString("cedula")));
                } else {
                    persona.setCedula(null);
                }

                persona.setApellido(this.getRs().getString("apellido"));
                persona.setNombre(this.getRs().getString("nombre"));
                persona.setDireccion(this.getRs().getString("direccion"));
                persona.setFotos(this.getRs().getBytes("foto"));
                persona.setRutaF(this.getRs().getString("rutaF"));
                listP.add(persona);
            }
            setPersonas(listP);
        } catch (SQLException e) {
            this.getDatos().mostrar("Error al conectar");
        } finally {
            try {
                if (this.getRs() != null) {
                    this.getRs().close();
                }
                if (this.getP() != null) {
                    this.getP().close();
                }
                if (co != null) {
                    co.close();
                }
            } catch (SQLException e) {
                this.getDatos().mostrar(e);
            }
        }

    }

    public void cargarprovincias(JComboBox<Object> cb1) {
        Connection co = c.getConexion();

        try {

            this.setInstruccion("SELECT * FROM provincias ORDER BY provincias.idProv ASC");
            this.setP(co.prepareStatement(this.getInstruccion()));
            this.setRs(this.getP().executeQuery());
            ResultSet Cprov = this.getRs();
            while (Cprov.next()) {
                cb1.addItem(new provincia(Cprov.getInt("idProv"), Cprov.getString("provincias")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySQLComandos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                co.close();
                p.close();
                rs.close();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
    }

    public void cargarciudades(JComboBox<Object> cb2, int id) {
        Connection co = c.getConexion();
        try {
            this.setInstruccion("SELECT * FROM ciudades where prov_id = ?");
            this.setP(co.prepareStatement(this.getInstruccion()));
            this.getP().setInt(1, id);
            this.setRs(this.getP().executeQuery());
            ResultSet Ciud = this.getRs();
            while (Ciud.next()) {
                cb2.addItem(new ciudades(Ciud.getInt("idCiud"), Ciud.getString("ciudades")));
            }
        } catch (SQLException ex) {
            this.getDatos().mostrar(ex);
        } finally {
            try {
                co.close();
                rs.close();
                p.close();

            } catch (SQLException e) {
            }
        }

    }

    public void addPer(JTextField txtnombres, JTextField txtapellidos, JTextField txtdireccion, JTextField txttelefono,
            JComboBox cb1, JComboBox cb2) {
        Connection co = c.getConexion();
        try {

            if ((txtnombres.getText().isEmpty() != true) && (txtapellidos.getText().isEmpty() != true)
                    && (txtdireccion.getText().isEmpty() != true) && (txttelefono.getText().isEmpty() != true)) {
                this.setP(co.prepareStatement(
                        "INSERT INTO datospersonales (nombre,apellido,direccion,telefono,provincia,ciudad) VALUES (?,?,?,?,?,?)"));
                this.getP().setString(1, txtnombres.getText());
                this.getP().setString(2, txtapellidos.getText());
                this.getP().setString(3, txtdireccion.getText());
                this.getP().setString(4, txttelefono.getText());
                this.getP().setString(5, cb1.getSelectedItem().toString());
                this.getP().setString(6, cb2.getSelectedItem().toString());
                this.getP().executeUpdate();
                this.getDatos().mostrar("Elementos guardados");
                this.getPersonas().add(new PersonaBD(txtapellidos.getText(), txtnombres.getText(),
                        txtdireccion.getText(), txttelefono.getText()));
                txtnombres.setText("");
                txtapellidos.setText("");
                txtdireccion.setText("");
                txttelefono.setText("");
            }

        } catch (SQLException ex) {
            this.getDatos().error("Error al Guardar");
        } finally {
            try {
                if (this.getRs() != null) {
                    this.getRs().close();
                }
                if (this.getP() != null) {
                    this.getP().close();
                }
                if (co != null) {
                    co.close();
                }
            } catch (SQLException e) {
                this.getDatos().mostrar(e);
            }
        }
    }

    public void listaper(JComboBox per) {
        this.CargarDatos();
        for (int i = 0; i < personas.size(); i++) {

            if (personas.get(i).getCedula() == null) {
                per.addItem(personas.get(i).getApellido() + " " + personas.get(i).getNombre());
            }

        }

    }

    public void addced(JComboBox per, JTextField Rced) {
        Connection co = c.getConexion();
        try {
            if (per.getSelectedItem().toString() != null) {
                String partes[] = per.getSelectedItem().toString().split(" ");
                this.setInstruccion(
                        "UPDATE datospersonales SET cedula = ? WHERE datospersonales.apellido = ? AND datospersonales.nombre = ? ;");
                this.setP(co.prepareStatement(this.getInstruccion()));
                this.getP().setInt(1, Integer.valueOf(Rced.getText()));
                this.getP().setString(2, partes[0]);
                this.getP().setString(3, partes[1]);
                this.getP().executeUpdate();
                for (int i = 0; i < personas.size(); i++) {
                    if (personas.get(i).getApellido().equals(partes[0]) && personas.get(i).getNombre().equals(partes[1])) {
                        personas.get(i).setCedula(Integer.parseInt(Rced.getText()));
                    }

                }
            }

        } catch (NumberFormatException | SQLException ex) {
        } finally {
            try {
                if (this.getRs() != null) {
                    this.getRs().close();
                }
                if (this.getP() != null) {
                    this.getP().close();
                }
                if (co != null) {
                    co.close();
                }
            } catch (SQLException e) {
                this.getDatos().mostrar(e);
            }
        }
    }

    public void traerced(JTextField Rced) {

        int pos;

        Random rnd = new Random();
        pos = rnd.nextInt(7999 + 1000) + 1000;
        for (int i = 0; i < personas.size(); i++) {
            if (personas.get(i).getCedula() != null) {
                while (personas.get(i).getCedula().toString().substring(6, 9).equals(Integer.toString(pos))) {
                    pos = rnd.nextInt(7999 + 1000) + 1000;
                }
            }
        }
        Rced.setText("180500" + pos);
    }

    public void ConexionCedulas(JComboBox ListaCedulas) {
        this.CargarDatos();
        for (int i = 0; i < getPersonas().size(); i++) {
            if (getPersonas().get(i).getRutaF() == null) {
                ListaCedulas.addItem(getPersonas().get(i).getCedula());
            }

        }
    }

    public void InsCiud(JTextField txtop2, int id) {
        Connection co = c.getConexion();
        try {
            this.setP(co.prepareStatement("INSERT INTO ciudades (ciudades,prov_id) VALUES (?,?)"));
            this.getP().setString(1, txtop2.getText());
            this.getP().setInt(2, id);
            try {
                this.getP().executeUpdate();
                this.getDatos().mostrar("Elementos guardados");
            } catch (SQLException e) {
                this.getDatos().error("La Ciudad " + txtop2.getText() + " ya existe");
                txtop2.getText();
            }

            txtop2.setText("");
        } catch (SQLException ex) {
        } finally {
            try {
                if (this.getRs() != null) {
                    this.getRs().close();
                }
                if (this.getP() != null) {
                    this.getP().close();
                }
                if (co != null) {
                    co.close();
                }
            } catch (SQLException e) {
                this.getDatos().mostrar(e);
            }
        }

    }

    public void InsProv(JTextField txtop2, JComboBox<Object> cb2) {
        Connection co = c.getConexion();
        try {
            this.setInstruccion("INSERT INTO provincias (idProv,provincias) VALUES (?,?)");
            this.setP(co.prepareStatement(this.getInstruccion()));
            this.getP().setInt(1, cb2.getItemCount() + 1);
            this.getP().setString(2, txtop2.getText());
            try {
                this.getP().executeUpdate();
                cb2.addItem(new provincia(cb2.getItemCount() + 1, txtop2.getText()));
                this.getDatos().mostrar("Elementos guardados");
            } catch (SQLException ex) {
                this.getDatos().error("La provincia " + txtop2.getText() + " ya existe");
                txtop2.setText("");
            }

            txtop2.setText("");
        } catch (SQLException ex) {

        } finally {
            try {
                if (this.getRs() != null) {
                    this.getRs().close();
                }
                if (this.getP() != null) {
                    this.getP().close();
                }
                if (co != null) {
                    co.close();
                }
            } catch (SQLException e) {
                this.getDatos().mostrar(e);
            }
        }
    }

    public void enviarImagen(String img, String cedula) {
        Connection co = c.getConexion();
        this.CargarDatos();
        this.setInstruccion("UPDATE datospersonales SET foto = ? , rutaF = ? WHERE datospersonales.cedula=?;");
        try {
            FileInputStream byteImagen = new FileInputStream(img);
            this.setP(co.prepareStatement(this.getInstruccion()));
            this.getP().setBinaryStream(1, byteImagen);
            this.getP().setString(2, img);
            this.getP().setString(3, cedula.replace(" ", ""));
            this.getP().executeUpdate();

        } catch (SQLException ex) {
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MySQLComandos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (this.getRs() != null) {
                    this.getRs().close();
                }
                if (this.getP() != null) {
                    this.getP().close();
                }
                if (co != null) {
                    co.close();
                }
            } catch (SQLException e) {
                this.getDatos().mostrar(e);
            }
        }
    }

}
