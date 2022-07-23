/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

/**
 *
 * @author g4to1
 */
public class cargarciudad {
    private int idciu;
    private String ciudad;
    private int idpro;

    public cargarciudad(int idciu, String ciudad) {
        this.idciu = idciu;
        this.ciudad = ciudad;
    }

    public int getIdciu() {
        return idciu;
    }

    public void setIdciu(int idciu) {
        this.idciu = idciu;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getIdpro() {
        return idpro;
    }

    public void setIdpro(int idpro) {
        this.idpro = idpro;
    }
    
    public String toString(){
        return this.ciudad;
    }
}
