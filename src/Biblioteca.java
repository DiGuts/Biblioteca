import java.util.ArrayList;

public class Biblioteca {

    private static ArrayList<Usuari> usuaris = new ArrayList<>();
    private static ArrayList<Llibre> llibres = new ArrayList<>();

    public static void main(String[] args) {
        Usuari usuari1 = new Usuari("2343434", "Joan", "52626323", "carrer 1");
        Usuari usuari2 = new Usuari("333432", "Maria", "384353943", "carrer 2");
        usuaris.add(usuari1);
        usuaris.add(usuari2);

        Llibre publicacio1 = new Llibre("El Quijote", "1F", "Literatura");
        Llibre publicacio2 = new Llibre("Cien Años de Soledad", "2C", "Literatura");
        llibres.add(publicacio1);
        llibres.add(publicacio2);

    }
}