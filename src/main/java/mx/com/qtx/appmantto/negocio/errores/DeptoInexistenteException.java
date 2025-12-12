package mx.com.qtx.appmantto.negocio.errores;

public class DeptoInexistenteException extends RuntimeException {
    public DeptoInexistenteException(String message) {
        super(message);
    }
}
