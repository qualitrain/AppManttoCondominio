package mx.com.qtx.appmantto.negocio;

import java.util.ArrayList;
import java.util.List;

public class GestorPersonas {
    public static void main(String[] args) {
        Persona juan = new Persona();
        juan.setId("P100");
        juan.setNombre("Juan Román Hernández");
        juan.setTelefono("55-1121-4455");
        
        Administrador pedro = new Administrador();
        pedro.setId("AD001");
        pedro.setNombre("Pedro Rojas García");
        pedro.setTelefono("77-2309-7866");
        
        Persona pedro2 = pedro;

        Persona olga = new Inquilino();
        olga.setId("I003");
        olga.setNombre("Olga Muñoz Cepeda");
        olga.setTelefono("65-7766-4532");

        
        List<Persona> personas = new ArrayList<>();
        personas.add(juan);
        personas.add(pedro);
        personas.add(olga);

        System.out.println("\nPersonas:");
        personas.forEach(pI -> System.out.println("pI = " + pI.toString()));
        System.out.println();

//        List<Administrador> administradores = new ArrayList<>();
//        administradores.add((Administrador) pedro2);
    //    administradores.add((Administrador) juan);

//        administradores.forEach(pI -> System.out.println("pI = " + pI));

        List<Object> objetos = new ArrayList<>();
        objetos.add("Cadena");
        objetos.add(pedro);
        objetos.add(juan);

        objetos.forEach(objI -> System.out.println("objI = " + objI));
    }
}
