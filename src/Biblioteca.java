import Users.Admin;
import Users.Usuari;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {
    private static Scanner sc = new Scanner(System.in);
    private static ArrayList<Usuari> usuaris = new ArrayList<>();
    private static ArrayList<Llibre> llibres = new ArrayList<>();
    private static ArrayList<Reserva> reserves = new ArrayList<>();
    private static Usuari actualUser;

    public static void main(String[] args) {
        demoDataLlibre();
        demoDataUser();

        while (true){
            menuLogin();
            menu();
        }
    }

    private static void demoDataLlibre() {
        Llibre llibre1 = new Llibre("El senyor dels anells", "001", "Fantasia");
        Llibre llibre2 = new Llibre("1984", "002", "Ciència-ficció");
        Llibre llibre3 = new Llibre("Don Quixot", "003", "Clàssics");
        llibres.add(llibre1);
        llibres.add(llibre2);
        llibres.add(llibre3);
    }
    private static void demoDataUser() {
        Usuari u1 = new Usuari("1", "unai", "6555", "major", "1234");
        Usuari u2 = new Usuari("2", "jan", "6523", "menor", "1234");
        Admin a1 = new Admin("3", "jaume", "343434", "mitja", "1234");
        usuaris.add(u1); usuaris.add(u2); usuaris.add(a1);
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


    private static void menu() {
        boolean menu = true;
        while (menu) {
            actualUser.menu();

            String menuOpcio = input("Escull una opció: ");
            if (actualUser.getType().equals("Admin")) {
                switch (menuOpcio) {
                    case "1":
//                        modificarReserves();
                        System.out.println("RESERVA MODIFICADA");
                        break;
                    case "2":
//                        consultarReserves();
                        System.out.println("AQUI TENS LA RESERVA...");
                        break;
                    case "3":
//                        eliminarPublicacio();
                        System.out.println("PUBLICACIO ELIMINADA");
                        break;
                    case "4":
//                        afegirPublicacio();
                        System.out.println("PUBLICACIO AFEGIDA");
                        break;
                    case "0":
                        System.out.println("TENCANT SESSIO...");
                        menu = false;
                        break;
                    default:
                        System.out.println("Opció no vàlida.");
                }
            }
            else if (actualUser.getType().equals("User")) {
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
                    case "0":
                        System.out.println("TENCANT SESSIO...");
                        menu = false;
                        break;
                }
            }
        }
    }

    public static int printLlibresDispo() {
        int i = 1;
        for (Llibre l : llibres) {
            if (l.isDisponible()){
                System.out.println(" " + i +" .- " + l.getTitol());
                i++;
            }
        }
        return Integer.parseInt(input("Quin llibre vols reservar? "));
    }

    public static void reservar() {
        int index = printLlibresDispo() - 1;
        Llibre l = llibres.get(index);
        if (l.isDisponible()) {
            Reserva n = new Reserva(l, actualUser);
            l.setDisponible(false);
            reserves.add(n);
            // Moure el llibre reservat al final de la llista
            llibres.remove(index);
            llibres.add(l);
        }
        else System.out.println("Aricle inexistent o no disponible");
    }

    public static String input(String m) {
        System.out.print(m); return sc.nextLine();
    }

}