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
public class cargarprovincia {
    private  int idpro;
    private String provincia;

    public cargarprovincia(int idpro, String provincia) {
        this.idpro = idpro;
        this.provincia = provincia;
    }

    public int getIdpro() {
        return idpro;
    }

    public void setIdpro(int idpro) {
        this.idpro = idpro;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
    
    public String toString(){
        return this.provincia;
    }
}
