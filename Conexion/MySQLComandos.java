package Conexion;

import Objetos.cargarciudad;
import Ncedula.Ncedula;
import Objetos.PersonaBD;
import Objetos.provincia;
import Opcion3.JOption3;
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
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;

public class MySQLComandos {

    private String instruccion;
    private PreparedStatement p;
    private ResultSet rs;
    private final Conexion c = new Conexion();
    JOption3 datos = new JOption3();
    ArrayList<PersonaBD> personas = this.Reportes();

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
                //primer control: Nombres de usuarios ya existentes
                if (!(rs.getString("usuario").equals(usuario.getText()))) {
                    if (contraseña.getText().matches("[A-Z]+.[a-z]*.[@$?¡\\-_].\\d[0-9]*") && confirmacion.getText().matches("[A-Z]+.[a-z]*.[@$?¡\\-_].\\d[0-9]*")) {
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
                        this.getDatos().mostrar("La contraseña debe tener todo en mayusculas y tener numeros\nEjemplo: USUARIO1234");
                        return false;
                    }
                }

                if (!(this.getRs().getString("usuario").equals(usuario.getText())) && confirmacion.getText().matches("[A-Z]{1,9}.\\d[0-9]")) {

                    this.setInstruccion("Insert into usuarios set usuario =?, contraseña =?");
                    this.setP(co.prepareStatement(this.getInstruccion()));
                    this.getP().setString(1, usuario.getText());
                    this.getP().setString(2, confirmacion.getText());
                    this.getP().executeUpdate();
                    this.getDatos().mostrar(" ==== Usuario Creado ====");
                    usuario.setText("");
                    confirmacion.setText("");
                    return true;

                } else {
                    datos.mostrar("=== ERROR DE CREACION DE USUARIO ====");

                }

            }

<<<<<<< HEAD
            // executeUpdate cuando se hacen select

        } catch (SQLException ex) {
            this.getDatos().mostrar("El Usuario " + usuario.getText() + " ya existe");

=======
        } // executeUpdate cuando se hacen select
        catch (Exception ex) {

            this.getDatos().mostrar("=== ERROR CLAVE USUARIO INCORRECTA ===");

            this.getDatos().mostrar("El Usuario ya existe");
>>>>>>> e50fd5a7c82e03aadb8171b62c17c0faae73b98a
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
        String[] columnas = {"Cedula", "Apellido", "Nombre", "Direccion", "Fotografia"};
        String[] registros = new String[5];
        DefaultTableModel modelo = new DefaultTableModel(null, columnas);
        for (int i = 0; i < personas.size(); i++) {
            PersonaBD persona = personas.get(i);
            registros[0] = String.valueOf(persona.getCedula());
            registros[1] = persona.getApellido();
            registros[2] = persona.getNombre();
            registros[3] = persona.getDireccion();
            registros[4] = persona.getRutaF();
            modelo.addRow(registros);
            tabla.setModel(modelo);
        }
    }

    public ArrayList Reportes() {
        Connection co = c.getConexion();
        ArrayList<PersonaBD> listP = new ArrayList();
        PersonaBD persona;
        try {

            this.setInstruccion("SELECT * FROM datospersonales");
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
                listP.add(persona);
            }
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
        return listP;
    }

    public void cargarprovincias(JComboBox cb1) {
        Connection co = c.getConexion();
        try {
            cb1.removeAllItems();
            this.setP(co.prepareStatement("SELECT provincias FROM provincias"));
            this.setRs(this.getP().executeQuery());
            while (this.getRs().next()) {
                cb1.addItem(this.getRs().getString("provincias"));
                DefaultComboBoxModel value;
                try {
                    
                    
                    this.setRs(this.getP().executeQuery("SELECT * FROM provincias"));
                    value = new DefaultComboBoxModel();
                    cb1.setModel(value);
                    while (this.getRs().next()) {
                        value.addElement(new provincia(rs.getInt(1), rs.getString(2)));
                    }
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                } finally {
                    try {
                        p.close();
                        rs.close();
                    } catch (Exception ex) {
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySQLComandos.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public void cargarciudades(JComboBox cb2, int id) {

        Connection co = c.getConexion();
        DefaultComboBoxModel value;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = co.prepareStatement("SELECT * FROM ciudades where prov_id = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            value = new DefaultComboBoxModel();
            cb2.setModel(value);
            while (rs.next()) {
                value.addElement(new cargarciudad(rs.getInt(1), rs.getString(2)));
            }
        } catch (SQLException ex) {
            this.getDatos().mostrar(ex);
        } finally {
            try {
                if (this.getRs() != null) {
                    this.getRs().close();
                }
                if (p != null) {
                    p.close();
                }
                if (co != null) {
                    co.close();
                }
            } catch (SQLException e) {
                this.getDatos().mostrar(e);
            }
        }

    }

    public void cargarciudades(JComboBox cb2) {
        Connection co = c.getConexion();
        try {
            cb2.removeAllItems();
            this.setP(co.prepareStatement("SELECT ciudades FROM ciudades"));
            this.setRs(this.getP().executeQuery());
            while (this.getRs().next()) {

                cb2.addItem(this.getRs().getString("ciudades"));
            }
        } catch (SQLException ex) {
            this.getDatos().mostrar(ex);
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

    public void addPer(JTextField txtnombres, JTextField txtapellidos, JTextField txtdireccion, JTextField txttelefono,
            JComboBox cb1, JComboBox cb2) {
        Connection co = c.getConexion();
        try {

            if ((txtnombres.getText().isEmpty() != true) && (txtapellidos.getText().isEmpty() != true)
                    && (txtdireccion.getText().isEmpty() != true) && (txttelefono.getText().isEmpty() != true)) {
                this.setP(co.prepareStatement("INSERT INTO datospersonales (nombre,apellido,direccion,telefono,provincia,ciudad) VALUES (?,?,?,?,?,?)"));
                this.getP().setString(1, txtnombres.getText());
                this.getP().setString(2, txtapellidos.getText());
                this.getP().setString(3, txtdireccion.getText());
                this.getP().setString(4, txttelefono.getText());
                this.getP().setString(5, cb1.getSelectedItem().toString());
                this.getP().setString(6, cb2.getSelectedItem().toString());

                this.getP().executeUpdate();
                this.getDatos().mostrar("Elementos guardados");
                txtnombres.setText("");
                txtapellidos.setText("");
                txtdireccion.setText("");
                txttelefono.setText("");
            } else {
                this.getDatos().mostrar("No se ha seleccionado ningun item");
            }

        } catch (SQLException ex) {
            this.getDatos().mostrar("Error al Guardar");
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
        for (int i = 0; i < personas.size(); i++) {

            if (personas.get(i).getCedula() == null) {
                per.addItem(personas.get(i).getApellido() + " " + personas.get(i).getNombre());
            }

        }

    }

    public void addced(JComboBox per, JTextField Rced) {
        Connection co = c.getConexion();
        try {

            String partes[] = per.getSelectedItem().toString().split(" ");
            this.setInstruccion("UPDATE datospersonales SET cedula = ? WHERE datospersonales.apellido = ? AND datospersonales.nombre = ? ;");
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

        } catch (SQLException ex) {
            Logger.getLogger(Ncedula.class.getName()).log(Level.SEVERE, null, ex);
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

        int pos = 0;

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

        for (int i = 0; i < personas.size(); i++) {
            ListaCedulas.addItem(personas.get(i).getCedula());
        }
    }

    public void InsCiud(JTextField txtop2, int id) {
        Connection co = c.getConexion();
        try {
            this.setP(co.prepareStatement("INSERT INTO ciudades (ciudades,prov_id) VALUES (?,?)"));
            this.getP().setString(1, txtop2.getText());
            this.getP().setInt(2, id);
            this.getP().execute();
            this.getDatos().mostrar("Elementos guardados");
            txtop2.setText("");
        } catch (SQLException ex) {
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

    public void InsProv(JTextField txtop2) {
        Connection co = c.getConexion();
        try {
            this.setInstruccion("INSERT INTO provincias (provincias) VALUES (?)");
            this.setP(co.prepareStatement(this.getInstruccion()));
            this.getP().setString(1, txtop2.getText());
            this.getP().executeUpdate();
            this.getDatos().mostrar("Elementos guardados");
            txtop2.setText("");
        } catch (SQLException ex) {
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

    public void enviarImagen(String img, String cedula) {
        Connection co = c.getConexion();
        this.setInstruccion("UPDATE datospersonales SET foto = ? WHERE datospersonales.cedula=?;");
        try {
            FileInputStream byteImagen = new FileInputStream(img);
            this.setP(co.prepareStatement(this.getInstruccion()));
            this.getP().setBinaryStream(1, byteImagen);
            this.getP().setString(2, cedula.replace(" ", ""));
            this.getP().executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MySQLComandos.class.getName()).log(Level.SEVERE, null, ex);
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
