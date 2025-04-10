package Publicacions;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class Publicacio {
    private static final AtomicInteger generadorCodi = new AtomicInteger(1);
    private String titol;
    private int codi;
    private String seccio;
    private boolean disponible;

    public Publicacio(String titol, String seccio) {
        this.titol = titol;
        this.codi = generadorCodi.getAndIncrement();
        this.seccio = seccio;
        this.disponible = true;
    }

    public String getTitol() {
        return titol;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    public int getCodi() {
        return codi;
    }

    public void setCodi(int codi) {
        this.codi = codi;
    }

    public String getSeccio() {
        return seccio;
    }

    public void setSeccio(String seccio) {
        this.seccio = seccio;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public abstract String toString();


}
