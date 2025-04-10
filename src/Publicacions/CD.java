package Publicacions;

public class CD extends Publicacio {
    private String artista;
    private String durada;
    private int numCancons;

    public CD(String titol, String artista, String durada, int numCancons, String seccio) {
        super(titol, seccio);
        this.artista = artista;
        this.durada = durada;
        this.numCancons = numCancons;
    }

    // Getters i setters
    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getDurada() {
        return durada;
    }

    public void setDurada(String durada) {
        this.durada = durada;
    }

    public int getNumCancons() {
        return numCancons;
    }

    public void setNumCancons(int numCancons) {
        this.numCancons = numCancons;
    }

    @Override
    public String toString() {
        return getCodi() + " | Titol: " + getTitol() + " | Artista: " + artista + " | Durada: " + durada +
                " | Núm. cançons: " + numCancons;
    }
}