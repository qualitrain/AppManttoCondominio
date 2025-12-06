package mx.com.qtx.appmantto.negocio;

import java.util.HashMap;
import java.util.Map;

public class Inquilino extends Persona {
    private Departamento depto;
    private Map<String,Boolean> mapYaPagoMesX = new HashMap<>();


    public Inquilino(){
        this.mapYaPagoMesX.put("Ene", false);
        this.mapYaPagoMesX.put("Feb", false);
        this.mapYaPagoMesX.put("Mar", false);
        this.mapYaPagoMesX.put("Abr", false);
        this.mapYaPagoMesX.put("May", false);
        this.mapYaPagoMesX.put("Jun", false);
        this.mapYaPagoMesX.put("Jul", false);
        this.mapYaPagoMesX.put("Ago", false);
        this.mapYaPagoMesX.put("Sep", false);
        this.mapYaPagoMesX.put("Oct", false);
        this.mapYaPagoMesX.put("Nov", false);
        this.mapYaPagoMesX.put("Dic", false);
    }

     public Departamento getDepto() {
        return depto;
    }

    public void setDepto(Departamento depto) {
        this.depto = depto;
    }

    public Map<String, Boolean> getMapYaPagoMesX() {
        return mapYaPagoMesX;
    }

    public void setMapYaPagoMesX(Map<String, Boolean> mapYaPagoMesX) {
        this.mapYaPagoMesX = mapYaPagoMesX;
    }

    @Override
    public String toString() {
        return  super.toString() + " => " +
                "Inquilino{" +
                "depto=" + depto +
                ", mapYaPagoMesX=" + mapYaPagoMesX +
                '}';
    }
}
