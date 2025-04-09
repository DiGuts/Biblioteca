import Users.Usuari;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;

public class Reserva {
    private static final AtomicInteger generadorId = new AtomicInteger(1);
    private int id;
    private Llibre llibre;
    private Usuari usuari;
    private LocalDate dataInici;
    private LocalDate dataFi;

    public Reserva(Llibre llibre, Usuari usuari) {
        Biblioteca.getLlibreByCodi(llibre.getCodi()).setDisponible(false);
        this.id = generadorId.getAndIncrement();
        this.llibre = llibre;
        this.usuari = usuari;
        // Assignar la data actual
        this.dataInici = LocalDate.now();

        // Calcular la data de fi (3 mesos després)
        this.dataFi = dataInici.plusMonths(3);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return id + " | Llibre: " + llibre.getTitol() + "\n\t\tUsuari:" + usuari.getNom()
                + "\n\t\tData inici:" + dataInici + "\n\t\tData fi:" + dataFi + "\n";
    }

    public String consultaUser(){
        return " | Llibre: " + llibre.getTitol() + "\n\t\tData inici:" + dataInici + "\n\t\tData fi:" + dataFi + "\n";
    }

    public void modificarReserva() {
        Biblioteca.printLlibresById();
        this.llibre = Biblioteca.getLlibreByCodi(Integer.parseInt(Biblioteca.input("Id llibre: ")));
        Biblioteca.printUsuarisById();
        this.usuari = Biblioteca.getUsuariById(Biblioteca.input("Dni usuari: "));
    }
}
