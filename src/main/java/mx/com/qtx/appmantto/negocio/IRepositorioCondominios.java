package mx.com.qtx.appmantto.negocio;

import mx.com.qtx.appmantto.dtos.CondominioDTO;

import java.util.List;

public interface IRepositorioCondominios {
    CondominioDTO leerCondominioXID(Integer id);
    int actualizarCondominio(CondominioDTO cond);
    CondominioDTO eliminar(int id);
    List<CondominioDTO> leerTodos();
    void mostrarCondominios();
}
