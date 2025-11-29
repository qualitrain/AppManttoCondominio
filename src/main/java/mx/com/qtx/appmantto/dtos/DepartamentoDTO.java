package mx.com.qtx.appmantto.dtos;

public class DepartamentoDTO {
    private Long idDepartamento;
    private Integer numero;
    private boolean ocupado;
    private String nombreInquilino;
    private double rentaMensual;
    private String idInquilino;
    private Integer idCondominio;

    public DepartamentoDTO(Long idDepartamento, Integer numero, boolean ocupado, String nombreInquilino, double rentaMensual, String idInquilino, Integer idCondominio) {
        this.idDepartamento = idDepartamento;
        this.numero = numero;
        this.ocupado = ocupado;
        this.nombreInquilino = nombreInquilino;
        this.rentaMensual = rentaMensual;
        this.idInquilino = idInquilino;
        this.idCondominio = idCondominio;
    }

    public DepartamentoDTO() {
    }

    public Long getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(Long idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public String getNombreInquilino() {
        return nombreInquilino;
    }

    public void setNombreInquilino(String nombreInquilino) {
        this.nombreInquilino = nombreInquilino;
    }

    public double getRentaMensual() {
        return rentaMensual;
    }

    public void setRentaMensual(double rentaMensual) {
        this.rentaMensual = rentaMensual;
    }

    public String getIdInquilino() {
        return idInquilino;
    }

    public void setIdInquilino(String idInquilino) {
        this.idInquilino = idInquilino;
    }

    public Integer getIdCondominio() {
        return idCondominio;
    }

    public void setIdCondominio(Integer idCondominio) {
        this.idCondominio = idCondominio;
    }

    @Override
    public String toString() {
        return "DepartamentoDTO{" +
                "idDepartamento=" + idDepartamento +
                ", numero=" + numero +
                ", ocupado=" + ocupado +
                ", nombreInquilino='" + nombreInquilino + '\'' +
                ", rentaMensual=" + rentaMensual +
                ", idInquilino='" + idInquilino + '\'' +
                ", idCondominio=" + idCondominio +
                '}';
    }
}
