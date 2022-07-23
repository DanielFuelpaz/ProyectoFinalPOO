package Conexion;

import Objetos.cargarciudad;
import Objetos.cargarprovincia;
import Ncedula.Ncedula;
import Objetos.PersonaBD;
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
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class MySQLComandos {

    private String instruccion;
    private PreparedStatement p;
    private ResultSet rs;
    private final Conexion c = new Conexion();
    JOption3 datos = new JOption3();

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
                if (rs.getString("usuario").equals(usuario.getText())
                        && rs.getString("contraseña").equals(contraseña.getText())) {
                    this.getDatos().mostrar("sesion iniciada correctamente");
                    return true;

                }
            }

            // executeUpdate cuando se hacen select
        } catch (Exception e) {
            this.getDatos().mostrar("Error en la conexion");
        } finally {
            try {
                if (rs != null) {
                    rs.close();
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

            }

            // executeUpdate cuando se hacen select
        } catch (SQLException ex) {
            this.getDatos().mostrar("El Usuario " + usuario.getText() + " ya existe");

        } finally {
            try {
                if (rs != null) {
                    rs.close();
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
        return false;
    }

    // Metodo de Traer Reportes
    public void Reportes(JTable tabla) {

        Connection co = c.getConexion();
        String[] columnas = {"Cedula", "Apellido", "Nombre", "Direccion", "Fotografia"};
        String[] registros = new String[5];
        DefaultTableModel modelo = new DefaultTableModel(null, columnas);
        try {

            this.setInstruccion("SELECT * FROM datospersonales");
            this.setP(co.prepareStatement(this.getInstruccion()));
            this.setRs(this.getP().executeQuery());
            modelo.addRow(columnas);

            while (rs.next()) {
                registros[0] = rs.getString("cedula");
                registros[1] = rs.getString("apellido");
                registros[2] = rs.getString("nombre");
                registros[3] = rs.getString("direccion");
                registros[4] = rs.getString("foto");
                modelo.addRow(registros);
            }
            tabla.setModel(modelo);
        } catch (SQLException e) {
            this.getDatos().mostrar("Error al conectar");
        } finally {
            try {
                if (rs != null) {
                    rs.close();
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

    public ArrayList Reportes() {

        Connection co = c.getConexion();
        ArrayList listP = new ArrayList();
        PersonaBD persona;
        try {

            this.setInstruccion("SELECT * FROM datospersonales");
            this.setP(co.prepareStatement(this.getInstruccion()));
            this.setRs(this.getP().executeQuery());

            while (rs.next()) {
                persona = new PersonaBD();
                persona.setCedula(Integer.parseInt(rs.getString("cedula")));
                persona.setApellido(rs.getString("apellido"));
                persona.setNombre(rs.getString("nombre"));
                persona.setDireccion(rs.getString("direccion"));
                persona.setFotos(rs.getBytes("foto"));
                listP.add(persona);
            }
        } catch (SQLException e) {
            this.getDatos().mostrar("Error al conectar");
        } finally {
            try {
                if (rs != null) {
                    rs.close();
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
        return listP;
    }

    public void cargarprovincias(JComboBox cb1) {
        Connection co = c.getConexion();
        DefaultComboBoxModel value;
        Statement st = null;
        ResultSet rs = null;
        try{
            st = co.createStatement();
            rs = st.executeQuery("SELECT * FROM provincias");
            value = new DefaultComboBoxModel();
            cb1.setModel(value);
            while(rs.next()){                
                value.addElement(new cargarprovincia(rs.getInt(1),rs.getString(2)));
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{
                st.close();
                rs.close();
            }catch(Exception ex){
            }
        }
    }
    
    public void cargarciudades(JComboBox cb2, int id) {
          
        Connection co = c.getConexion();
        DefaultComboBoxModel value;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            ps = co.prepareStatement("SELECT * FROM ciudades where prov_id = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            value = new DefaultComboBoxModel();
            cb2.setModel(value);
            while(rs.next()){
                value.addElement(new cargarciudad(rs.getInt(1), rs.getString(2)));
            }
        } catch (SQLException ex) {
            this.getDatos().mostrar(ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
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
                if (rs != null) {
                    rs.close();
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

    public void listaper(JComboBox per) {
        Connection co = c.getConexion();
        try {

            this.setInstruccion("SELECT * FROM datospersonales WHERE cedula IS NULL");
            this.setP(co.prepareStatement(this.getInstruccion()));
            this.setRs(this.getP().executeQuery(this.getInstruccion()));

            while (this.getRs().next()) {
                per.addItem(this.getRs().getString("apellido") + " " + this.getRs().getString("nombre"));

            }

        } catch (SQLException ex) {
            Logger.getLogger(Ncedula.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
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

    public void addced(JComboBox personas, JTextField Rced) {
        Connection co = c.getConexion();
        try {

            String partes[] = personas.getSelectedItem().toString().split(" ");
            this.setInstruccion(
                    "UPDATE datospersonales SET cedula = ? WHERE datospersonales.apellido = ? AND datospersonales.nombre = ? ;");
            this.setP(co.prepareStatement(this.getInstruccion()));
            this.getP().setInt(1, Integer.valueOf(Rced.getText()));
            this.getP().setString(2, partes[0]);
            this.getP().setString(3, partes[1]);
            this.getP().executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Ncedula.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
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

    public int traerced() {
        Connection co = c.getConexion();
        int pos = 0;
        try {

            Random rnd = new Random();
            pos = rnd.nextInt(7999 + 1000) + 1000;

            this.setInstruccion("SELECT cedula FROM datospersonales WHERE cedula IS NOT NULL");
            this.setP(co.prepareStatement(this.getInstruccion()));
            this.setRs(this.getP().executeQuery(this.getInstruccion()));
            while (this.getRs().next()) {
                while (this.getRs().getString("cedula").substring(6, 9).equals(Integer.toString(pos))) {
                    pos = rnd.nextInt(7999 + 1000) + 1000;
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(Ncedula.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
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

        return pos;
    }

    public void ConexionCedulas(JComboBox ListaCedulas) {
        Connection co = c.getConexion();
        this.setInstruccion("SELECT cedula FROM datospersonales");
        try {
            this.setP(co.prepareStatement(this.getInstruccion()));
            this.setRs(this.getP().executeQuery(this.getInstruccion()));
            while (this.getRs().next()) {
                ListaCedulas.addItem(this.getRs().getString("cedula"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySQLComandos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
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

    public void InsCiud(JTextField txtop2,int id) {
        Connection co = c.getConexion();
        try {
            this.setP(co.prepareStatement("INSERT INTO ciudades (ciudades,prov_id) VALUES (?,?)"));
            this.getP().setString(1, txtop2.getText());
            this.getP().setInt(2, id);
            this.getP().execute();
            this.getDatos().mostrar("Elementos guardados");
            this.getP().setString(2, txtop2.getText());
            this.getP().executeUpdate();
            JOptionPane.showMessageDialog(null, "Elementos guardados");
            txtop2.setText("");
        } catch (SQLException ex) {
            Logger.getLogger(MySQLComandos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
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
                if (rs != null) {
                    rs.close();
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
                if (rs != null) {
                    rs.close();
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

}
