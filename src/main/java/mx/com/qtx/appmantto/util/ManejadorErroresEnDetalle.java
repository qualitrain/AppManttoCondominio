package mx.com.qtx.appmantto.util;

import java.util.Arrays;

public class ManejadorErroresEnDetalle extends ManejadorErrores{
    public ManejadorErroresEnDetalle() {
        super();
    }

    @Override
    public void mostrarError(Throwable ex) {
        super.mostrarError(ex);
        mostrarPilaEjecucion(ex);

    }

    private void mostrarPilaEjecucion(Throwable ex) {
        System.out.println();
        Arrays.stream(ex.getStackTrace())
                .filter(steI->steI.getClassName().contains("mx.com.qtx"))
                .forEach(steI->{
                    System.out.printf("Ver %-30s linea %4d en método %-35s\n",
                            steI.getFileName() + ",",
                            steI.getLineNumber(),
                            steI.getMethodName()
                    );

                });
    }
}
