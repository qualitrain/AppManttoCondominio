package mx.com.qtx.appmantto.negocio;

import mx.com.qtx.appmantto.dtos.CondominioDTO;
import mx.com.qtx.appmantto.dtos.DepartamentoDTO;
import mx.com.qtx.appmantto.persistencia.RepositorioCondominios;
import mx.com.qtx.appmantto.persistencia.RepositorioDepartamentos;

import java.util.List;

/**
 *  Ofrecer los servicios que permiten administrar un Condominio
 */
public class GestorCondominio {

    private RepositorioCondominios repoCondominios;
    private RepositorioDepartamentos repoDepartamentos;

    public GestorCondominio() {
        this.repoCondominios = new RepositorioCondominios();
        this.repoDepartamentos = new RepositorioDepartamentos();
    }

    public List<String> getReglasOcupacion(Integer idCondominio, int numDepto){
        Condominio cond = leerCondominioXID(idCondominio);
        return cond.getReglasOcupacion(numDepto);
    }

    private Condominio leerCondominioXID(Integer idCondominio) {
        CondominioDTO condDTO = this.repoCondominios.leerCondominioXID(idCondominio);
        List<DepartamentoDTO> deptosDTO = this.repoDepartamentos.leerDepartamentosXCondominio(condDTO.getId());
        Condominio condo = new Condominio();
        condo.setId(condDTO.getId());
        condo.setDireccion(condDTO.getDireccion());
        /* ToDo
        *   Leer de Repositorio de Personas al administrador y a los inquilinos
        * */
        for(DepartamentoDTO deptoDtoI:deptosDTO) {
            condo.agregarDepartamento(deptoDtoI.getIdDepartamento(),
                                        deptoDtoI.getNumero(),
                                        deptoDtoI.isOcupado(),
                                        deptoDtoI.getRentaMensual(),
                                null);
        }
        condo.setAdministrador(null);
        return condo;
    }

    public static void main(String[] args) {
//        testFuncionesBasicas();
//        testRentarDepartamento();
//        testAsignarAdminitradorAcondominio();
        testRepositorios();
    }

    private static void testRepositorios() {
        testCrearRepositorioCondominios();
        testLeerCondominioXID();
        testInsertarCondominio();
        testActualizarCondominio();
        testEliminarCondominio();
    }

    private static void testEliminarCondominio() {
        System.out.println("\nGestorCondominio.testEliminarCondominio");
        RepositorioCondominios repoCondominios = new RepositorioCondominios();
        repoCondominios.mostrarCondominios();
        CondominioDTO condoBorrado = repoCondominios.eliminar(3);
        System.out.println("condoBorrado = " + condoBorrado);
        repoCondominios.mostrarCondominios();
    }

    private static void testActualizarCondominio() {
        System.out.println("\nGestorCondominio.testActualizarCondominio");
        RepositorioCondominios repoCondominios = new RepositorioCondominios();
        CondominioDTO condominioDTO = repoCondominios.leerCondominioXID(2);
        CondominioDTO condoNvo = new CondominioDTO(condominioDTO.getId(),"Av. Insurgentes Sur 2001, col. La Loba loca",
                "ADM002", "Las guajolotas de Coapa");
        int nUpdates = repoCondominios.actualizarCondominio(condoNvo);
        System.out.println("nUpdates = " + nUpdates);
        repoCondominios.mostrarCondominios();
    }

    private static void testInsertarCondominio() {
        System.out.println("\nGestorCondominio.testInsertarCondominio");
        RepositorioCondominios repoCondominios = new RepositorioCondominios();
        CondominioDTO condoNvo = new CondominioDTO(55,"Av. Insurgentes Sur 1999, col. La Loba loca",
                "ADM002", "Rincón del Cielo");
        int nIns = repoCondominios.insertarCondominio(condoNvo);
        System.out.println("nInserciones = " + nIns);
        repoCondominios.mostrarCondominios();
    }

    private static void testLeerCondominioXID() {
        System.out.println("\nGestorCondominio.testLeerCondominioXID");
        RepositorioCondominios repoCondominios = new RepositorioCondominios();
    //    repoCondominios.mostrarCondominios();
        String condoI = repoCondominios.leerCondominioXID(2).toString();
        System.out.println("condoI = " + condoI);
    }

    private static void testCrearRepositorioCondominios() {
        System.out.println("\nGestorCondominio.testCrearRepositorioCondominios");
        RepositorioCondominios repoCondominios = new RepositorioCondominios();
        repoCondominios.leerTodos().stream()
                .map(cndI -> cndI.getId() + " - " + cndI.getNombre())
                .forEachOrdered(System.out::println);
    }

    private static void testAsignarAdminitradorAcondominio() {
        throw new RuntimeException("Método pendiente de ajuste");
//        Condominio condAngeles = new Condominio("Av. Insurgentes Norte 255","Julio Pérez Domínguez");
//        Persona persona = new Persona("Efraín Méndez Pérez","345-2","55-1122-3245");
//        condAngeles.setAdministrador(persona);
//        System.out.println("condAngeles = " + condAngeles);
//        System.out.println("persona = " + persona);
    }

    private static void testRentarDepartamento() {
        throw new RuntimeException("Método pendiente de ajuste");
//        Condominio condAngeles = new Condominio("Av. Insurgentes Norte 255","Julio Pérez Domínguez");
//        Persona persona = new Persona("Efraín Méndez Pérez","345-2","55-1122-3245");
//        condAngeles.alquilarDepartamento(persona,1);
//
//        System.out.println("persona = " + persona);
//        System.out.println("condAngeles = " + condAngeles);
    }

    private static void testFuncionesBasicas() {
        throw new RuntimeException("Método pendiente de ajuste");

//        Condominio condAngeles = new Condominio("Av. Insurgentes Norte 255","Julio Pérez Domínguez");
//        int nDepto = condAngeles.getNumDeptoDisponible();
//        if(nDepto == Condominio.DEPTO_NO_DISPONIBLE){
//            System.out.println("Lo sentimos, de momento no hay departamentos disponibles");
//            return;
//        }
//        condAngeles.registrarInquilino(2,"Laura Fernández Mora");
//        System.out.println("condAngeles = " + condAngeles);
//
//        System.out.println("---------------------------------------");
//
//        Condominio clonCondominio = condAngeles.clonar();
//        System.out.println("clonCondominio = " + clonCondominio);
//
//
//        Condominio condCopiado = new Condominio();
//        condAngeles.copiarA(condCopiado);
//
//        System.out.println("condCopiado = " + condCopiado);
//        condAngeles.setDepartamento(2, true,"Rosario Luna Paz",8000, 0);
//
//        System.out.println("\n-------------------------------------\n");
//        System.out.println("condAngeles = " + condAngeles);
//        System.out.println("condCopiado = " + condCopiado);
    }


}