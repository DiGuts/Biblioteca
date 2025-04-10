package Publicacions;

public class DVD extends Publicacio {
    private String director;
    private String durada;
    private String genere;

    public DVD(String titol, String director, String durada, String genere, String seccio) {
        super(titol, seccio);
        this.director = director;
        this.durada = durada;
        this.genere = genere;
    }

    // Getters i setters
    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getDurada() {
        return durada;
    }

    public void setDurada(String durada) {
        this.durada = durada;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    @Override
    public String toString() {
        return getCodi() + " | Titol: " + getTitol() + " | Director: " + director + " | Durada: " + durada +
                " | Gènere: " + genere;
    }
}