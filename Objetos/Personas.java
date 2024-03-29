package Objetos;

import Opcion3.JOption3;
import java.io.File;

public class Personas {

    private Integer cedula;
    private String apellido;
    private String nombre;
    private String direccion;
    private String telefono;
    private byte[] fotos;
    private String rutaF;

    public byte[] getFotos() {
        return fotos;
    }

    public void setFotos(byte[] fotos) {
        this.fotos = fotos;
    }

    public Integer getCedula() {
        return this.cedula;
    }

    public void setCedula(Integer cedula) {
        this.cedula = cedula;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getRutaF() {
        return this.rutaF;
    }

    public void setRutaF(String rutaF) {
        this.rutaF = rutaF;
    }

    public Personas(String apellido, String nombre, String direccion, String telefono) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public Personas() {
    }
    
    public int comprobarExistencia(File f){
        JOption3 datos = new JOption3();
        int respuesta=0;
        int sobreescribir = 2;
        if (f.exists()) {
            respuesta = datos.preguntar("El archivo " + f.getAbsolutePath() + " ya existe. \n ¿Desea sobreescribirlo?","Advertencia");
            if (respuesta==0) {
                sobreescribir  = 0;
            }else{
                sobreescribir=1;
            }
        }
        return sobreescribir;
    }
}
