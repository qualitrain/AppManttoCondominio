package mx.com.qtx.appmantto.ius;

import mx.com.qtx.appmantto.config.ConfiguracionApp;
import mx.com.qtx.appmantto.negocio.GestorCondominio;
import mx.com.qtx.appmantto.negocio.errores.CondominioDTOInexistenteException;
import mx.com.qtx.appmantto.util.ManejadorErrores;

import java.util.Arrays;
import java.util.List;

public class Cu_TesterCondominiosV2 {

    public static void main(String[] args) {
        ManejadorErrores mErr =  ConfiguracionApp.getManejadorErrores();
        try {
            test_consultarReglasOcupacion();
        }
        catch(Throwable ex){
            mErr.manejarError(ex);
        }
     }

    private static void test_consultarReglasOcupacion() {
        GestorCondominio gc = new GestorCondominio();
        int numDepto1 = 999;
        List<String> reglas = gc.getReglasOcupacion(2, numDepto1);
        System.out.println("reglas de ocupación del depto " + numDepto1 +
                " = " + reglas);

        numDepto1 = 201;
        reglas = gc.getReglasOcupacion(2, numDepto1);
        System.out.println("\nreglas de ocupación del depto " + numDepto1 +
                " = " + reglas);
    }
}
