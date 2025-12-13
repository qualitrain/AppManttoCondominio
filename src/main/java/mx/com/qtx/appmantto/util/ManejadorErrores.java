package mx.com.qtx.appmantto.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hp835
 * @version 1.0
 * @created 12-dic.-2025 06:59:08 p. m.
 */
public class ManejadorErrores {

	private List<Throwable> excepciones;

	public ManejadorErrores(){
        this.excepciones = new ArrayList<>();
	}

	/**
	 * 
	 * @param ex
	 */
	public void mostrarError(Throwable ex){
        System.out.println("Error = " + ex.getMessage());
        System.out.println("Tipo:" + ex.getClass().getName());
        if(ex.getCause() == null)
            return;
        System.out.println("Causa subyacente:" + ex.getCause().getClass().getName());
        System.out.println("Mensaje subyacente:" + ex.getCause().getMessage());
	}

	/**
	 * 
	 * @param ex
	 */
	final public void guardarError(Throwable ex){
        this.excepciones.add(ex);
	}

	/**
	 * 
	 * @param ex
	 */
	public void manejarError(Throwable ex){
        this.guardarError(ex);
        this.mostrarError(ex);
	}

	public void generarReporte(){
        this.excepciones.stream()
                        .map(ex->ex.getMessage())
                        .forEach(System.out::println);
	}

}