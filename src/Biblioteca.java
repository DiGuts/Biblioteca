import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {
    private static Scanner sc = new Scanner(System.in);
    static ArrayList<Usuari> usuaris = new ArrayList<>();
    static ArrayList<Llibre> llibres = new ArrayList<>();
    static ArrayList<Reserva> reserves = new ArrayList<>();
    private static Usuari actualUser;

    public static void main(String[] args) {
        demoDataLlibre();
        demoDataUser();

        while (true){
            menuLogin();
            menuReservar();
        }
    }

    private static void demoDataLlibre() {
        Llibre llibre1 = new Llibre("El senyor dels anells", "001", "Fantasia");
        Llibre llibre2 = new Llibre("1984", "002"0'Llibre llibre3 = new Llibre("Don Quixot", "003", "Clàssics");
        llibres.add(llibre1);
        llibres.add(llibre2);
        llibres.add(llibre3);
    }
    private static void demoDataUser() {
        Usuari u1 = new Usuari("1", "unai", "6555", "major", "1234");
        Usuari u2 = new Usuari("2", "jan", "6523", "menor", "1234");
        Usuari admin = new Usuari("admin", "Administrador", "0000", "biblioteca", "admin123");
        usuaris.add(u1);
        usuaris.add(u2);
        usuaris.add(admin);
    }

    private static int registerUser() {
        try {
            Usuari u = new Usuari(input("dni: "),input("nom: "),input("telefon: "),input("dirrecio: "), input("passwd: "));
            usuaris.add(u);
            actualUser = u;
            return 1;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    private static int loginUser() {
        try {
            String usr = input("dni usuari: ");
            for (Usuari u : usuaris) {
                if (u.getDni().equals(usr)) {
                    if (u.getPasswd().equals(input("passwd: "))) { actualUser = u; }
                }
            }
            return 1;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    private static void menuLogin() {
        boolean sessioIniciada = false;
        while (!sessioIniciada) {
            System.out.println("\n--- Menú Biblioteca ---");
            System.out.println("1. Registrar usuari");
            System.out.println("2. Iniciar sessió");
            System.out.println("0. Sortir");

            String opcio = input("Escull una opció: ");
            switch (opcio) {
                case "1":
                    if (registerUser() == 1){
                        sessioIniciada = true;
                    }
                    break;
                case "2":
                    if (loginUser() == 1){
                        sessioIniciada = true;
                    }
                    break;
                case "0":
                    System.exit(0);
            }
        }
    }

    private static void menuReservar() {
        boolean menu = true;
        while (menu) {
            System.out.println("\n--- Menú Biblioteca ---");
            System.out.println("1. Reservar llibre");
            System.out.println("2. Consultar reserves");

            if (esAdmin()) {
                System.out.println("3. Menú d'administrador");
            }

            System.out.println("0. Tancar sessió");

            String menuOpcio = input("Escull una opció: ");
            switch (menuOpcio) {
                case "1":
                    reservar();
                    break;
                case "2":
                    for (Reserva r : reserves) {
                        if (r.getUsuari().equals(actualUser)) {
                            System.out.println(r.getLlibre().getTitol());
                        }
                    }
                    break;
                case "3":
                    if (esAdmin()) {
                        AdminMenu.mostrarMenuAdmin();
                    }
                    break;
                case "0":
                    menu = false;
                    break;
                default:
                    System.out.println("Opció no vàlida.");
            }
        }
    }

    public static int menuLlibresDispo() {
        int i = 1;
        for (Llibre l : llibres) {
            if (l.isDisponible()){
                System.out.println(" " + i +" .- " + l.getTitol());
                i++;
            }
        }
        return Integer.parseInt(input("Quin llibre vols reservar? "));
    }

    private static void menuReservar() {
        boolean menu = true;
        while (menu) {
            System.out.println("\n--- Menú Biblioteca ---");
            System.out.println("1. Reservar llibre");
            System.out.println("2. Consultar reserves");

            // Mostrar opcions d'admin si l'usuari és admin
            if (esAdmin()) {
                System.out.println("3. Menú d'administrador");
            }

            System.out.println("0. Tancar sessió");

            String menuOpcio = input("Escull una opció: ");
            switch (menuOpcio) {
                case "1":
                    reservar();
                    break;
                case "2":
                    for (Reserva r : reserves) {
                        if (r.getUsuari().equals(actualUser)) {
                            System.out.println(r.getLlibre().getTitol());
                        }
                    }
                    break;
                case "3":
                    if (esAdmin()) {
                        AdminMenu.mostrarMenuAdmin();
                    }
                    break;
                case "0":
                    menu = false;
                    break;
                default:
                    System.out.println("Opció no vàlida.");
            }
        }
    }

    static String input(String m) {
        System.out.print(m); return sc.nextLine();
    }

    private static boolean esAdmin() {
        return actualUser != null && actualUser.getDni().equals("admin");
    }
}