package mx.com.qtx.appmantto.negocio.errores;

import mx.com.qtx.appmantto.dtos.CondominioDTO;

public class CondominioDTOInexistenteException extends RuntimeException{
    private CondominioDTO condominioDTO;
    private Integer idCondominio;
    private String nombreGestorPersistencia;

    public CondominioDTOInexistenteException(CondominioDTO condominioDTO, Integer idCondominio, String nombreGestorPersistencia) {
        this.condominioDTO = condominioDTO;
        this.idCondominio = idCondominio;
        this.nombreGestorPersistencia = nombreGestorPersistencia;
    }

    @Override
    public String getMessage() {
        return "El condominio usado no existe en capa de Persistencia. " + this.toString();
    }

    public CondominioDTO getCondominioDTO() {
        return condominioDTO;
    }

    public void setCondominioDTO(CondominioDTO condominioDTO) {
        this.condominioDTO = condominioDTO;
    }

    public String getNombreGestorPersistencia() {
        return nombreGestorPersistencia;
    }

    public void setNombreGestorPersistencia(String nombreGestorPersistencia) {
        this.nombreGestorPersistencia = nombreGestorPersistencia;
    }

    @Override
    public String toString() {
        return "CondominioDTOInexistenteException{" +
                "condominioDTO=" + condominioDTO +
                ", idCondominio=" + idCondominio +
                ", nombreGestorPersistencia='" + nombreGestorPersistencia + '\'' +
                '}';
    }
}
