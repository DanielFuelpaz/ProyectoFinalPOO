package Conexion;

import Ncedula.Ncedula;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class MySQLComandos {
    
    private String instruccion;
    private PreparedStatement p;
    private ResultSet rs;
    private final Conexion c = new Conexion();
    
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

    //Metodo de Inicio de Secion
    public boolean iniciosesion(JTextField usuario, JPasswordField contraseña) throws SQLException {
        Connection co = c.getConexion();
        try {
            
            this.setInstruccion("SELECT * FROM usuarios");
            this.setP(co.prepareStatement(this.getInstruccion()));
            this.setRs(this.getP().executeQuery());
            while (this.getRs().next()) {
                if (rs.getString("usuario").equals(usuario.getText()) && rs.getString("contraseña").equals(contraseña.getText())) {
                    System.out.println("sesion iniciada correctamente");
                    return true;
                    
                }
            }

            //executeUpdate cuando se hacen select
        } catch (Exception e) {
            System.out.println("Error en la conexion");
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
                JOptionPane.showMessageDialog(null, e);
            }
        }
        return false;
    }

    //Control Creacion de Usuario
    public boolean creacionusuario(JTextField usuario, JPasswordField confirmacion) {
        Connection co = c.getConexion();
        try {
            
            this.setInstruccion("SELECT * FROM usuarios");
            this.setP(co.prepareStatement(this.getInstruccion()));
            this.setRs(this.getP().executeQuery());
            while (this.getRs().next()) {
                
                if (!(rs.getString("usuario").equals(usuario.getText()) && rs.getString("contraseña").equals(confirmacion.getText()))) {
                    this.setInstruccion("Insert into usuarios set usuario =?, contraseña =?");
                    this.setP(co.prepareStatement(this.getInstruccion()));
                    this.getP().setString(1, usuario.getText());
                    this.getP().setString(2, confirmacion.getText());
                    this.getP().executeUpdate();
                    System.out.println(" ==== Usuario Creado ====");
                    usuario.setText("");
                    confirmacion.setText("");
                    return true;
                }
                
            }

            //executeUpdate cuando se hacen select
        } catch (Exception ex) {
            System.out.println("El Usuario ya existe");
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
                JOptionPane.showMessageDialog(null, e);
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
            JOptionPane.showMessageDialog(null, "Error al conectar");
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
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }
    
    public void cargarprovincias(JComboBox cb1) {
        Connection co = c.getConexion();
        try {
            cb1.removeAllItems();
            this.setP(co.prepareStatement("SELECT provincias FROM provincias"));
            this.setRs(this.getP().executeQuery());
            while (this.getRs().next()) {
                
                cb1.addItem(rs.getString("provincias"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
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
                JOptionPane.showMessageDialog(null, e);
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
            System.out.println(ex.toString());
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
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }
    
    public void addPer(JTextField txtnombres, JTextField txtapellidos, JTextField txtdireccion, JTextField txttelefono, JComboBox cb1, JComboBox cb2) {
        Connection co = c.getConexion();
        try {
            
            if ((txtnombres.getText().isEmpty() != true) && (txtapellidos.getText().isEmpty() != true) && (txtdireccion.getText().isEmpty() != true) && (txttelefono.getText().isEmpty() != true)) {
                this.setP(co.prepareStatement("INSERT INTO datospersonales (nombre,apellido,direccion,telefono,provincia,ciudad) VALUES (?,?,?,?,?,?)"));
                this.getP().setString(1, txtnombres.getText());
                this.getP().setString(2, txtapellidos.getText());
                this.getP().setString(3, txtdireccion.getText());
                this.getP().setString(4, txttelefono.getText());
                this.getP().setString(5, cb1.getSelectedItem().toString());
                this.getP().setString(6, cb2.getSelectedItem().toString());
                this.getP().executeUpdate();
                
                JOptionPane.showMessageDialog(null, "Elementos guardados");
                txtnombres.setText("");
                txtapellidos.setText("");
                txtdireccion.setText("");
                txttelefono.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "No se ha seleccionado ningun item");
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al Guardar");
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
                JOptionPane.showMessageDialog(null, e);
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
                JOptionPane.showMessageDialog(null, e);
            }
        }
        
    }
    
    public void addced(JComboBox personas, JTextField Rced) {
        Connection co = c.getConexion();
        try {
            
            String partes[] = personas.getSelectedItem().toString().split(" ");
            this.setInstruccion("UPDATE datospersonales SET cedula = ? WHERE datospersonales.apellido = ? AND datospersonales.nombre = ? ;");
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
                JOptionPane.showMessageDialog(null, e);
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
                JOptionPane.showMessageDialog(null, e);
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
                JOptionPane.showMessageDialog(null, e);
            }
        }
        
    }
    
    public void InsCiud(JTextField txtop2) {
        Connection co = c.getConexion();
        try {
            this.setP(co.prepareStatement("INSERT INTO ciudades (ciudades) VALUES (?)"));
            this.getP().setString(1, txtop2.getText());
            this.getP().execute();
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
                JOptionPane.showMessageDialog(null, e);
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
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }
    
}
