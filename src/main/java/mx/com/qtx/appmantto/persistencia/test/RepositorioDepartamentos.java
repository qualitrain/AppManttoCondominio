package mx.com.qtx.appmantto.persistencia.test;

import mx.com.qtx.appmantto.dtos.DepartamentoDTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepositorioDepartamentos {
    private final static Map<Long, DepartamentoDTO> mapDeptos = getMapaDepartamentos();

    private static Map<Long, DepartamentoDTO> getMapaDepartamentos() {
        Map<Long, DepartamentoDTO> mapaDepartamentos = new HashMap<>();
        ProveedorDatosPrueba.getDepartamentos()
                .forEach((deptoI)->mapaDepartamentos.put(deptoI.getIdDepartamento(),deptoI));
        return mapaDepartamentos;
    }

    public List<DepartamentoDTO> leerDepartamentosXCondominio(Integer idCondominio){
        return getMapaDepartamentos().values().stream()
                .filter(deptoI->deptoI.getIdCondominio() == idCondominio)
                .toList();
    }
}
