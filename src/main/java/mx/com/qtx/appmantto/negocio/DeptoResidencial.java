package mx.com.qtx.appmantto.negocio;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class DeptoResidencial extends Departamento{
    private static List<String> reglasOcupDeptoResidencial = List.of(
            "No fumar en áreas comunes",
            "Usar salón de eventos para hacer fiestas",
            "Mantener comunicación amable con vecinos"
    );

    private BigDecimal importeDeposito;

    public DeptoResidencial(Long id, int numero, boolean ocupado, String nombreInquilino, double rentaMensual, Inquilino inquilino, BigDecimal importeDeposito) {
        super(id, numero, ocupado, nombreInquilino, rentaMensual, inquilino);
        this.importeDeposito = importeDeposito;
    }

    public BigDecimal getImporteDeposito() {
        return importeDeposito;
    }

    public void setImporteDeposito(BigDecimal importeDeposito) {
        this.importeDeposito = importeDeposito;
    }

    @Override
    public String toString() {
        return "DeptoResidencial{" +
                "importeDeposito=" + importeDeposito +
                ", id=" + id +
                ", numero=" + numero +
                ", ocupado=" + ocupado +
                ", nombreInquilino='" + nombreInquilino + '\'' +
                ", rentaMensual=" + rentaMensual +
                ", inquilino=" + inquilino +
                '}';
    }

    @Override
    public List<String> getReglasOcupacion() {
        List<String> reglas = new ArrayList<>();
        reglas.addAll(super.getReglasOcupacion());
        reglas.addAll(reglasOcupDeptoResidencial);
        return reglas;
    }
}
