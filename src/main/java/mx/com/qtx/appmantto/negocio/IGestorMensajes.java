package mx.com.qtx.appmantto.negocio;

public interface IGestorMensajes {
    void inicializar();
    void enviarMensajes(Persona remitente, String mensaje);
    void cerrarConexion();
}
