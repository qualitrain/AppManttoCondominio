package mx.com.qtx.appmantto.persistencia.dbPostgreSQL;

import mx.com.qtx.appmantto.dtos.CondominioDTO;
import mx.com.qtx.appmantto.negocio.IRepositorioCondominios;

import java.util.List;

public class RepositorioCondominiosPostgres implements IRepositorioCondominios {
    @Override
    public CondominioDTO leerCondominioXID(Integer id) {
        return null;
    }

    @Override
    public int actualizarCondominio(CondominioDTO cond) {
        return 0;
    }

    @Override
    public CondominioDTO eliminar(int id) {
        return null;
    }

    @Override
    public List<CondominioDTO> leerTodos() {
        return List.of();
    }

    @Override
    public void mostrarCondominios() {

    }
}
