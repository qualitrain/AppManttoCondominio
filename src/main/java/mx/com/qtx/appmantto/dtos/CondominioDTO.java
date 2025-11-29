package mx.com.qtx.appmantto.dtos;

public class CondominioDTO {
    private Integer id;
    private String direccion;
    private String idAdministrador;
    private String nombre;

    public CondominioDTO(Integer id, String direccion, String idAdministrador, String nombre) {
        this.id = id;
        this.direccion = direccion;
        this.idAdministrador = idAdministrador;
        this.nombre = nombre;
    }

    public CondominioDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(String idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "CondominioDTO{" +
                "id=" + id +
                ", direccion='" + direccion + '\'' +
                ", idAdministrador='" + idAdministrador + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
