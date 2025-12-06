package mx.com.qtx.appmantto.ius;

import mx.com.qtx.appmantto.negocio.GestorCondominio;

import java.util.List;

public class Cu_TesterCondominios {

    public static void main(String[] args) {
        test_consultarReglasOcupacion();
    }

    private static void test_consultarReglasOcupacion() {
        GestorCondominio gc = new GestorCondominio();
        List<String> reglas = gc.getReglasOcupacion(2, 203);
        System.out.println("reglas de ocupación = " + reglas);
    }
}
