package mx.com.qtx.appmantto.config;

import mx.com.qtx.appmantto.util.ManejadorErrores;
import mx.com.qtx.appmantto.util.ManejadorErroresEnDetalle;

/**
 * @author hp835
 * @version 1.0
 * @created 12-dic.-2025 07:11:57 p. m.
 */
public class ConfiguracionApp {

	private static ManejadorErrores manejadorErrores;

    static {
        configurarApp();
    }

	public static void configurarApp(){
        manejadorErrores = new ManejadorErroresEnDetalle();
	}

	public static ManejadorErrores getManejadorErrores(){

        return ConfiguracionApp.manejadorErrores;
	}

}