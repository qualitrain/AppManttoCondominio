package mx.com.qtx.appmantto.negocio;

import jdk.jshell.spi.ExecutionControl;
import mx.com.qtx.appmantto.dtos.TipoDepartamento;

import java.math.BigDecimal;
import java.util.List;

/**
 * Responsabilidad: Administrar los datos de cada departamento
 */
public class Departamento {
    protected Long id;
    protected int numero;
    protected boolean ocupado;
    protected String nombreInquilino;
    protected double rentaMensual;

    protected Inquilino inquilino;

    public Departamento() {
    }

    public Departamento(Long id, int numero, boolean ocupado, String nombreInquilino, double rentaMensual, Inquilino inquilino) {
        this.id = id;
        this.numero = numero;
        this.ocupado = ocupado;
        this.nombreInquilino = nombreInquilino;
        this.rentaMensual = rentaMensual;
        this.inquilino = inquilino;
    }

    public Departamento(int numero, boolean ocupado, String nombreInquilino, double rentaMensual) {
        this.numero = numero;
        this.ocupado = ocupado;
        this.nombreInquilino = nombreInquilino;
        this.rentaMensual = rentaMensual;
    }

    public static Departamento crearDepartamento(Long id, int numero, boolean ocupado, String nombreInquilino, double rentaMensual,
                                                 Inquilino inquilino, BigDecimal importeDeposito, TipoDepartamento tipoDepartamento){

        return switch(tipoDepartamento){
            case GENERICO -> new Departamento(id, numero, ocupado, nombreInquilino, rentaMensual,inquilino);
            case RESIDENCIAL -> new DeptoResidencial(id,numero,ocupado,"",rentaMensual,inquilino,importeDeposito);
            default -> null;
        };
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Inquilino getInquilino() {
        return inquilino;
    }

    public void setInquilino(Inquilino inquilino) {
        this.inquilino = inquilino;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public String getNombreInquilino() {
        if(this.inquilino == null)
            return nombreInquilino;
        return this.inquilino.getNombre();
    }

    @Deprecated
    public void setNombreInquilino(String nombreInquilino) {
        this.nombreInquilino = nombreInquilino;
    }

    public double getRentaMensual() {
        return rentaMensual;
    }

    public void setRentaMensual(double rentaMensual) {
        this.rentaMensual = rentaMensual;
    }

    @Override
    public String toString() {
        return "Departamento{" +
                "numero=" + numero +
                ", ocupado=" + ocupado +
                ", nombreInquilino='" + this.getNombreInquilino() + '\'' +
                ", rentaMensual=" + rentaMensual +
                ", inquilino=" + inquilino +
                '}';
    }

    public Departamento clonar() {
    //    System.out.println("el hashcode de this es " + this.hashCode());
        Departamento clon;
        clon = new Departamento();
        clon.setNumero(this.numero);
        clon.setOcupado(this.ocupado);
        clon.setNombreInquilino(this.nombreInquilino);
        clon.setRentaMensual(this.rentaMensual);
    //    System.out.println("clon.hashCode() = " + clon.hashCode());
        return clon;

    }

    public void copiarDesde(Departamento deptoOrigen) {
        this.numero = deptoOrigen.numero;
        this.nombreInquilino = deptoOrigen.nombreInquilino;
        this.ocupado = deptoOrigen.ocupado;
        this.rentaMensual = deptoOrigen.rentaMensual;
    }

    public void copiarA(Departamento deptoDestino) {
        deptoDestino.numero = this.numero;
        deptoDestino.ocupado = this.ocupado;
        deptoDestino.nombreInquilino = this.nombreInquilino;
        deptoDestino.rentaMensual = this.rentaMensual;
    }

    public static void copiar(Departamento origen, Departamento destino) {
        destino.numero = origen.numero;
        destino.rentaMensual = origen.rentaMensual;
        destino.nombreInquilino = origen.nombreInquilino;
        destino.ocupado = origen.ocupado;
    }

    public List<String> getReglasOcupacion(){
        return List.of("No romper nada",
                        "No molestar a los vecinos");
    }

    public void alquilarA(Persona persona) {
        throw new RuntimeException("Método no implementado");
    }
}