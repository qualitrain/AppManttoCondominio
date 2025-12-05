package mx.com.qtx.appmantto.persistencia;

import mx.com.qtx.appmantto.dtos.CondominioDTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepositorioCondominios {
    private final static Map<Integer,CondominioDTO> mapCondominios = getMapaCondominios();

    private static Map<Integer, CondominioDTO> getMapaCondominios() {
        Map<Integer, CondominioDTO> mapaCondominios = new HashMap<>();
        ProveedorDatosPrueba.getCondominios()
                .forEach((condI)->mapaCondominios.put(condI.getId(),condI));
        return mapaCondominios;
    }

    public RepositorioCondominios() {
    }

    public CondominioDTO leerCondominioXID(Integer id){
        return mapCondominios.get(id);
    }

    public int insertarCondominio(CondominioDTO cond){
    //    System.out.println("RepositorioCondominios.insertarCondominio");
        CondominioDTO condAnterior= mapCondominios.put(cond.getId(),cond); //Devuelve el valor PREVIO de v si lo hay o null si no existía
    //    System.out.println("condAnterior = " + condAnterior);
        if(condAnterior == null) // No existia previamente
            return 1;
        else
            return 0;
    }

    public int actualizarCondominio(CondominioDTO cond){
 //       System.out.println("RepositorioCondominios.actualizarCondominio");

        CondominioDTO condAnt = mapCondominios.put(cond.getId(), cond);
        System.out.println("condAnt = " + condAnt);
        if(condAnt == null) // No existia previamente
            return 0;
        else
            return 1;
    }

    public CondominioDTO eliminar(int id){
        if(mapCondominios.get(id) == null){
            return null;
        }
        final CondominioDTO condEliminado = mapCondominios.remove(id);
        return condEliminado;
    }

    public List<CondominioDTO> leerTodos(){
        return mapCondominios.values().stream().toList();
    }

    public void mostrarCondominios(){
        mapCondominios.forEach((k,v)-> System.out.println("k + v = " + k + " => " + v));
    }
}
