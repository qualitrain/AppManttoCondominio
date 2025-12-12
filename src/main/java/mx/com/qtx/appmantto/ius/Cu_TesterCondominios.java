package mx.com.qtx.appmantto.ius;

import mx.com.qtx.appmantto.negocio.GestorCondominio;
import mx.com.qtx.appmantto.negocio.errores.CondominioDTOInexistenteException;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Cu_TesterCondominios {

    public static void main(String[] args) {
        try {
            test_consultarReglasOcupacion();
        }
        catch(CondominioDTOInexistenteException cdiex){
            System.out.println("cdiex.getMessage() = " + cdiex.getMessage());
        }
        catch(RuntimeException rex){
            System.out.println("ex.getMessage() = " + rex.getMessage());
            System.out.println("ex.getClass().getName() = " + rex.getClass().getName());
        }
        catch(Exception ex){
            System.out.println("ex.getMessage() = " + ex.getMessage());
            System.out.println("ex.getClass().getName() = " + ex.getClass().getName());
            StackTraceElement[] pilaInvocacion = ex.getStackTrace();
            List<StackTraceElement> lstelementoPila = Arrays.stream(pilaInvocacion).toList();
            System.out.println("lstelementoPila.size() = " + lstelementoPila.size());
            for(StackTraceElement itemPilaI:lstelementoPila){
                System.out.println("-".repeat(10));
                System.out.println("itemPilaI.getClassName() = " + itemPilaI.getClassName());
                System.out.println("itemPilaI.getFileName() = " + itemPilaI.getFileName());
                System.out.println("itemPilaI.getMethodName() = " + itemPilaI.getMethodName());
                System.out.println("itemPilaI.getLineNumber() = " + itemPilaI.getLineNumber());
            }
        }
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
