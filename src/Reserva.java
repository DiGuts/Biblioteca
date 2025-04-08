import Users.Usuari;

import java.time.LocalDate;

public class Reserva {
    private Llibre llibre;
    private Usuari usuari;
    private LocalDate dataInici;
    private LocalDate dataFi;

    public Reserva(Llibre llibre, Usuari usuari) {
        this.llibre = llibre;
        this.usuari = usuari;
        // Assignar la data actual
        this.dataInici = LocalDate.now();

        // Calcular la data de fi (3 mesos després)
        this.dataFi = dataInici.plusMonths(3);
    }

    public Llibre getLlibre() {
        return llibre;
    }

    public void setLlibre(Llibre llibre) {
        this.llibre = llibre;
    }

    public Usuari getUsuari() {
        return usuari;
    }

    public void setUsuari(Usuari usuari) {
        this.usuari = usuari;
    }

    public LocalDate getDataInici() {
        return dataInici;
    }

    public void setDataInici(LocalDate dataInici) {
        this.dataInici = dataInici;
    }

    public LocalDate getDataFi() {
        return dataFi;
    }

    public void setDataFi(LocalDate dataFi) {
        this.dataFi = dataFi;
    }
}
