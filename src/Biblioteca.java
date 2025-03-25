package gestio;

import model.Usuari;
import model.Publicacio;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        Usuari usuari1 = new Usuari("Joan");
        Usuari usuari2 = new Usuari("Maria");

        Publicacio publicacio1 = new Publicacio("El Quijote");
        Publicacio publicacio2 = new Publicacio("Cien Años de Soledad");

        biblioteca.afegirUsuari(usuari1);
        biblioteca.afegirUsuari(usuari2);

        biblioteca.afegirPublicacio(publicacio1);
        biblioteca.afegirPublicacio(publicacio2);
    }
}