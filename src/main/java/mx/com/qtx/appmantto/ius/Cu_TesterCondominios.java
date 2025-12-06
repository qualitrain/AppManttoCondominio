package mx.com.qtx.appmantto.ius;

import mx.com.qtx.appmantto.negocio.GestorCondominio;

import java.util.List;

public class Cu_TesterCondominios {

    public static void main(String[] args) {
        test_consultarReglasOcupacion();
    }

    private static void test_consultarReglasOcupacion() {
        GestorCondominio gc = new GestorCondominio();
        int numDepto1 = 203;
        List<String> reglas = gc.getReglasOcupacion(2, numDepto1);
        System.out.println("reglas de ocupación del depto " + numDepto1 +
                " = " + reglas);

        numDepto1 = 201;
        reglas = gc.getReglasOcupacion(2, numDepto1);
        System.out.println("\nreglas de ocupación del depto " + numDepto1 +
                " = " + reglas);
    }
}
