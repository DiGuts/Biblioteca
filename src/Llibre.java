import java.util.concurrent.atomic.AtomicInteger;

public class Llibre {
    private static final AtomicInteger generadorCodi = new AtomicInteger(1);
    private String titol;
    private int codi;
    private String seccio;
    private static int stockTotal;
    private boolean disponible;

    public Llibre(String titol, String seccio) {
        this.titol = titol;
        this.codi = generadorCodi.getAndIncrement();
        this.seccio = seccio;
        stockTotal = stockTotal + 1;
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

    public int getStockTotal() {
        return stockTotal;
    }

    public void setStockTotal(int stockTotal) {
        this.stockTotal = stockTotal;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return "\nCodi: " + codi + " | Titol: " + titol +  " | Seccio: " + seccio;
    }

}
