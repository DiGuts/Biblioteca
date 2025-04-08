import Users.Admin;
import Users.Usuari;

import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {
    private static Scanner sc = new Scanner(System.in);
    private static ArrayList<Usuari> usuaris = new ArrayList<>();
    private static ArrayList<Llibre> llibres = new ArrayList<>();
    private static ArrayList<Reserva> reserves = new ArrayList<>();
    private static Usuari actualUser;


    public static ArrayList<Llibre> getLlibres() {
        return llibres;
    }
    public static void setLlibres(ArrayList<Llibre> llibres) {
        Biblioteca.llibres = llibres;
    }
    public static Llibre getLlibreById(String id) {
        for (Llibre l : llibres) {
            if (l.getCodi().equals(id)) {
                return l;
            }
        }
        return null;
    }
    public static Usuari getUsuariById(String dni) {
        for (Usuari u : usuaris) {
            if (u.getDni().equals(dni)) {
                return u;
            }
        }
        return null;
    }


    public static void main(String[] args) {
        demoDataLlibre();
        demoDataUser();
        demoDataReserva();

        while (true){
            menuLogin();
            menu();
        }
    }


    private static void demoDataLlibre() {
        Llibre llibre1 = new Llibre("El senyor dels anells", "001", "Fantasia");
        Llibre llibre2 = new Llibre("1984", "002", "Ciència-ficció");
        Llibre llibre3 = new Llibre("Don Quixot", "003", "Clàssics");
        Llibre llibre4 = new Llibre("Harry Potter i la pedra filosofal", "004", "Fantasia");
        Llibre llibre5 = new Llibre("Crim i càstig", "005", "Clàssics");
        Llibre llibre6 = new Llibre("Orgull i prejudici", "006", "Romàntic");
        Llibre llibre7 = new Llibre("El codi Da Vinci", "007", "Misteri");
        Llibre llibre8 = new Llibre("Dune", "008", "Ciència-ficció");
        Llibre llibre9 = new Llibre("El Petit Príncep", "009", "Ficció");
        Llibre llibre10 = new Llibre("La sombra del viento", "010", "Drama");

        llibres.add(llibre1);
        llibres.add(llibre2);
        llibres.add(llibre3);
        llibres.add(llibre4);
        llibres.add(llibre5);
        llibres.add(llibre6);
        llibres.add(llibre7);
        llibres.add(llibre8);
        llibres.add(llibre9);
        llibres.add(llibre10);
    }
    private static void demoDataUser() {
        Usuari u1 = new Usuari("1", "unai", "6555", "major", "1234");
        Usuari u2 = new Usuari("2", "jan", "6523", "menor", "1234");
        Admin a1 = new Admin("3", "jaume", "343434", "mitja", "1234");
        usuaris.add(u1); usuaris.add(u2); usuaris.add(a1);
    }
    private static void demoDataReserva() {
        Reserva r1 = new Reserva(llibres.get(0), usuaris.get(0));
        Reserva r2 = new Reserva(llibres.get(1), usuaris.get(1));
        Reserva r3 = new Reserva(llibres.get(2), usuaris.get(0));
        reserves.add(r1); reserves.add(r2); reserves.add(r3);
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
                        modificarReserves();
                        System.out.println("RESERVA MODIFICADA");
                        break;
                    case "2":
                        for (Reserva r : reserves) {
                            System.out.println(" .- " + r.toString());
                        }
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

    public static void modificarReserves(){
        int index = printReserves() - 1;
        Reserva r = reserves.get(index);
        r.modificarReserva();
    }

    public static int printLlibresDispo() {
        int i = 1;
        for (Llibre l : llibres) {
            if (l.isDisponible()){
                System.out.println(" " + i +" .- " + l);
                i++;
            }
        }
        return Integer.parseInt(input("Quin llibre vols reservar? "));
    }
    public static void printLlibresById(){
        for (Llibre l : llibres) {
            System.out.println(l.toString());
        }
    }
    public static int printReserves() {
        int i = 1;
        for (Reserva r : reserves) {
            System.out.println(" " + i +" .- " + r.toString());
            i++;
        }
        return Integer.parseInt(input("Quina reserva vols modificar? "));
    }
    public static void printUsuarisById(){
        for (Usuari u : usuaris) {
            System.out.println(u.getNom() + " | dni: " + u.getDni());
        }
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