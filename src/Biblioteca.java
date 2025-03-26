import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {
    private static Scanner sc = new Scanner(System.in);
    private static ArrayList<Usuari> usuaris = new ArrayList<>();
    private static ArrayList<Llibre> llibres = new ArrayList<>();
    private static Usuari actualUser;

    public static void main(String[] args) {

        boolean sortir = false;
        while (!sortir) {
            System.out.println("\n--- Menú Biblioteca ---");
            System.out.println("1. Registrar usuari");
            System.out.println("2. Iniciar sessió");
            System.out.println("0. Sortir");

            String opcio = input("Escull una opció: ");
            switch (opcio) {
                case "1":
                    registerUser();
                    break;
                case "2":
                    loginUser();
                    break;
                case "0":
                    System.exit(0);
            }
        }
    }
    private static void registerUser() {
        Usuari u = new Usuari(input("dni: "),input("nom: "),input("telefon: "),input("dirrecio: "), input("passwd: "));
        usuaris.add(u);
        actualUser = u;
    }

    private static void loginUser() {
        String usr = input("dni usuari: ");
        for (Usuari u : usuaris) {
            if (u.getDni().equals(usr)) {
                if (u.getPasswd().equals(input("passwd: "))) { actualUser = u; }
            }
        }
    }

    private static String input(String m) {
        System.out.print(m); return sc.nextLine();
    }
}