package mx.com.qtx.appmantto.negocio;

public class Administrador extends Persona{
    private Condominio condomonioAdministrado;

    public Condominio getCondomonioAdministrado() {
        return condomonioAdministrado;
    }

    public void setCondomonioAdministrado(Condominio condomonioAdministrado) {
        this.condomonioAdministrado = condomonioAdministrado;
    }

    @Override
    public String toString() {
        String cadAdministrador = "Administrador{" +
                "condomonioAdministrado=" + condomonioAdministrado + ", " +
                "idPersona=" + this.getId() + ", " +
                "nombre Administrador=" + this.getNombre() +
                '}';

        return cadAdministrador;
    }
}
