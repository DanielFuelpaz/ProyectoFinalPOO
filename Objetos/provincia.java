package Objetos;

public class provincia {
    private  int idpro;
    private String provincia;

    public provincia(int idpro, String provincia) {
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
    
    @Override
    public String toString() {
       return this.provincia;
    }
    
}
