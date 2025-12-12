package mx.com.qtx.appmantto.negocio;

import mx.com.qtx.appmantto.dtos.TipoDepartamento;
import mx.com.qtx.appmantto.negocio.errores.DeptoInexistenteException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Responsabilidad: Administrar datos de un Condominio
 */
public class Condominio {
    public static final int DEPTO_NO_DISPONIBLE = -1;

    private Integer id;
    private String direccion;

    private ArrayList<Departamento> deptos;

    private Administrador administrador;

    public Condominio(String direccion, Administrador administrador) {
        this.direccion = direccion;
        this.administrador = administrador;

        this.deptos = new ArrayList<>();

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Persona getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
//        this.administrador.setCondomonioAdministrado(this);
    }

    @Deprecated
    public void agregarDepartamento(int numDepto, boolean ocupado, String inquilino, double renta, int pos){
        Departamento nvoDepto = new Departamento(numDepto,ocupado,inquilino,renta);
        this.deptos.set(pos,nvoDepto);
     }

     @Deprecated
    public void agregarDepartamento(Long idDepto, int numDepto, boolean ocupado, double renta, Inquilino inquilino){
        Departamento nvoDepto = new Departamento();
        nvoDepto.setInquilino(inquilino);
        nvoDepto.setId(idDepto);
        nvoDepto.setNumero(numDepto);
        nvoDepto.setOcupado(ocupado);
        nvoDepto.setRentaMensual(renta);

        this.deptos.add(nvoDepto);
    }

    public void agregarDepartamento(Long idDepto, int numDepto, boolean ocupado, double renta,
                                    Inquilino inquilino, TipoDepartamento tipo, BigDecimal importeDeposito){
        Departamento nvoDepto = Departamento.crearDepartamento(idDepto,numDepto,ocupado,"",
                                                        renta,inquilino,importeDeposito,tipo);
        this.deptos.add(nvoDepto);
    }

    public Condominio() {
        this.direccion = "indefinida";
        this.administrador = null;

        this.deptos = new ArrayList<>();
        for(int i=0;i<4;i++)
         this.deptos.add(new Departamento());
      }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombreAdministrador() {
        if(this.administrador == null)
            return null;
        return this.administrador.getNombre();
    }

    public void setNombreAdministrador(String nombreAdministrador) {
        if(this.administrador == null)
            return;
        this.administrador.setNombre(nombreAdministrador);
    }

    @Override
    public String toString() {
        String nombreAdministrador = "No hay administrador";
        if(this.administrador != null) {
            nombreAdministrador = this.administrador.getNombre();
        }
        String cadCondominio = "Deptos:{" + this.deptos +
                ", nombreAdministrador='" + nombreAdministrador + '\'' +
                '}';
        return cadCondominio;
    }

    public void registrarInquilino(int numDepto, String inquilino) {
        Departamento depto =  this.buscarDepartamento(numDepto);
        if(depto == null){
            System.out.println("Ese departamento NO EXISTE");
            return;
        }
        depto.setOcupado(true);
        depto.setNombreInquilino(inquilino);
    }

    private Departamento buscarDepartamento(int numDeptoBuscado) {
        for(Departamento deptoI:this.deptos){
            if(numDeptoBuscado == deptoI.getNumero())
                return deptoI;
        }
        return null;
    }

    public int getNumDeptoDisponible() {
        for(Departamento deptoI : this.deptos){
            if(deptoI.isOcupado() == false)
                return deptoI.getNumero();
        }
        return Condominio.DEPTO_NO_DISPONIBLE;
    }

    public Condominio clonar() {
        throw new RuntimeException("Método no implementado");
    }

    public void copiarA(Condominio cndDestino) {
        cndDestino.direccion = this.direccion;
        if(this.administrador != null)
            administrador.copiarDesde(this.administrador);
        for(int i=0;i<this.deptos.size();i++){
            Departamento deptoDestino = cndDestino.deptos.get(i);
            deptoDestino.copiarDesde(this.deptos.get(i));
        }
    }

    public void alquilarDepartamento(Persona persona, int numDepto) {
        Departamento depto = this.buscarDepartamento(numDepto);
        if (depto == null){
            System.out.println("Número de departamento solicitado NO EXISTE");
            return;
        }
        depto.alquilarA(persona);

    }

    /**
     *
     * @param numDepto
     * @return
     */
    public List<String> getReglasOcupacion(int numDepto)  {
        Departamento deptoBuscado = this.buscarDepto(numDepto);
        if(deptoBuscado == null){
            throw new DeptoInexistenteException("No existe depto con numDepto = " + numDepto);
        }
        return deptoBuscado.getReglasOcupacion();
    }

    private Departamento buscarDepto(int numDepto) {
        for(Departamento deptoI:this.deptos){
            if(deptoI.getNumero() == numDepto)
                return deptoI;
        }
        return null;
    }
}