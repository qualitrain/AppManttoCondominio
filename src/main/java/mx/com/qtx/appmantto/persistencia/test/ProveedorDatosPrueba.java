package mx.com.qtx.appmantto.persistencia.test;

import mx.com.qtx.appmantto.dtos.CondominioDTO;
import mx.com.qtx.appmantto.dtos.DepartamentoDTO;
import mx.com.qtx.appmantto.dtos.PersonaDTO;
import mx.com.qtx.appmantto.dtos.TipoDepartamento;

import java.math.BigDecimal;
import java.util.List;

public class ProveedorDatosPrueba {
    
    public static List<PersonaDTO> getPersonas() {
        return List.of(
            new PersonaDTO("PER001", "Juan Pérez", "555-100-2000"),
            new PersonaDTO("PER002", "María García", "555-100-2001"),
            new PersonaDTO("PER003", "Carlos López", "555-100-2002"),
            new PersonaDTO("PER004", "Ana Martínez", "555-100-2003"),
            new PersonaDTO("PER005", "Luisa Fernández", "555-100-2004"),
            new PersonaDTO("PER006", "Roberto Díaz", "555-100-2005"),
            new PersonaDTO("PER007", "Elena Ruiz", "555-100-2006"),
            new PersonaDTO("PER008", "Jorge Gómez", "555-100-2007")
        );
    }
    
    public static List<CondominioDTO> getCondominios() {
        return List.of(
            new CondominioDTO(1, "Av. Primavera 123", "ADM001", "Las Flores"),
            new CondominioDTO(2, "Calle Verano 456", "ADM002", "Los Pinos"),
            new CondominioDTO(3, "Boulevard Invierno 789", "ADM003", "Las Águilas")
        );
    }
    
    public static List<DepartamentoDTO> getDepartamentos() {
        List<PersonaDTO> personas = getPersonas();
        
        return List.of(
            // Condominio 1 - 3 departamentos ocupados, 2 vacíos
            new DepartamentoDTO(1L, 101, true, personas.get(0).getNombre(), 4500.0, personas.get(0).getId(), 1),
            new DepartamentoDTO(2L, 102, true, personas.get(1).getNombre(), 5200.0, personas.get(1).getId(), 1),
            new DepartamentoDTO(3L, 103, false, null, 0.0, null, 1),
            new DepartamentoDTO(4L, 104, true, personas.get(2).getNombre(), 4800.0, personas.get(2).getId(), 1),
            new DepartamentoDTO(5L, 105, false, null, 0.0, null, 1),
            
            // Condominio 2 - 2 departamentos ocupados, 3 vacíos
            new DepartamentoDTO(6L, 201, true, personas.get(3).getNombre(), 5100.0, personas.get(3).getId(), 2),
            new DepartamentoDTO(7L, 202, false, null, 0.0, null, 2),
            new DepartamentoDTO(8L, 203, true, personas.get(4).getNombre(), 4900.0, personas.get(4).getId(), 2, TipoDepartamento.RESIDENCIAL, new BigDecimal("15000.00")),
            new DepartamentoDTO(9L, 204, false, null, 0.0, null, 2),
            new DepartamentoDTO(10L, 205, false, null, 0.0, null, 2),
            
            // Condominio 3 - 3 departamentos ocupados, 2 vacíos
            new DepartamentoDTO(11L, 301, true, personas.get(5).getNombre(), 5300.0, personas.get(5).getId(), 3),
            new DepartamentoDTO(12L, 302, false, null, 0.0, null, 3),
            new DepartamentoDTO(13L, 303, true, personas.get(6).getNombre(), 4700.0, personas.get(6).getId(), 3),
            new DepartamentoDTO(14L, 304, true, personas.get(7).getNombre(), 4600.0, personas.get(7).getId(), 3),
            new DepartamentoDTO(15L, 305, false, null, 0.0, null, 3)
        );
    }
}