import Publicacions.Publicacio;
import Users.Usuari;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;

public class Reserva {
    private static final AtomicInteger generadorId = new AtomicInteger(1);
    private int id;
    private Publicacio publicacio;
    private Usuari usuari;
    private LocalDate dataInici;
    private LocalDate dataFi;

    public Reserva(Publicacio publicacio, Usuari usuari) {
        Biblioteca.getPubliacacioByCodi(publicacio.getCodi()).setDisponible(false);
        this.id = generadorId.getAndIncrement();
        this.publicacio = publicacio;
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

    public Publicacio getLlibre() {
        return publicacio;
    }

    public void setLlibre(Publicacio publicacio) {
        this.publicacio = publicacio;
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
        return id + " | Llibre: " + publicacio.getTitol() + "\n\t\tUsuari:" + usuari.getNom()
                + "\n\t\tData inici:" + dataInici + "\n\t\tData fi:" + dataFi + "\n";
    }

    public String consultaUser(){
        return " | Llibre: " + publicacio.getTitol() + "\n\t\tData inici:" + dataInici + "\n\t\tData fi:" + dataFi + "\n";
    }

    public void modificarReserva() {
        Biblioteca.printPublicacionsById();
        this.publicacio = Biblioteca.getPubliacacioByCodi(Integer.parseInt(Biblioteca.input("Id llibre: ")));
        Biblioteca.printUsuarisById();
        this.usuari = Biblioteca.getUsuariById(Biblioteca.input("Dni usuari: "));
    }
}
