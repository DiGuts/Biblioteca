public class Llibre {
    private String titol;
    private String codi;
    private String seccio;
    private static int stockTotal;
    private boolean disponible;

    public Llibre(String titol, String codi, String seccio) {
        this.titol = titol;
        this.codi = codi;
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

    public String getCodi() {
        return codi;
    }

    public void setCodi(String codi) {
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
        return "\nTitol: " + titol + "\nCodi: " + codi + "\nSeccio: " + seccio;
    }

}
