import Publicacions.*;
import Users.Admin;
import Users.Usuari;

import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {
    private static Scanner sc = new Scanner(System.in);
    private static final ArrayList<Usuari> usuaris = new ArrayList<>();
    private static final ArrayList<Publicacio> publicacions = new ArrayList<>();
    private static final ArrayList<Reserva> reserves = new ArrayList<>();
    private static Usuari actualUser;


    public static Publicacio getPubliacacioByCodi(int id) {
        for (Publicacio l : publicacions) {
            if (l.getCodi() == id) {
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
    public static Reserva getReservaById(int id) {
        for (Reserva r : reserves) {
            if (r.getId() == id) {
                return r;
            }
        }
        return null;
    }


    public static void main(String[] args) {
        demoDataPublicacions();
        demoDataUser();
        demoDataReserva();

        while (true){
            menuLogin();
            menu();
        }
    }


    private static void demoDataPublicacions() {
        // No podem crear instàncies directes de Publicacio perquè ara és abstracta

        // Llibres
        Llibre llibre1 = new Llibre("El senyor dels anells", "J.R.R. Tolkien",
                "1178", "Minotauro", "3a edició", "Fantasia");
        Llibre llibre2 = new Llibre("1984", "George Orwell",
                "326", "Debolsillo", "1a edició", "Ciència-ficció");
        Llibre llibre3 = new Llibre("Don Quixot", "Miguel de Cervantes",
                "863", "Aliança Editorial", "Edició especial", "Clàssics");
        Llibre llibre4 = new Llibre("Harry Potter i la pedra filosofal", "J.K. Rowling",
                "309", "Salamandra", "1a edició", "Fantasia");
        Llibre llibre5 = new Llibre("Crim i càstig", "Fiódor Dostoievski",
                "527", "Edicions 62", "2a edició", "Clàssics");

        // CDs
        CD cd1 = new CD("The Dark Side of the Moon", "Pink Floyd", "42:50", 10, "Rock clàssic");
        CD cd2 = new CD("Thriller", "Michael Jackson", "42:19", 9, "Pop");
        CD cd3 = new CD("Back in Black", "AC/DC", "42:11", 10, "Rock");
        CD cd4 = new CD("Rumours", "Fleetwood Mac", "40:24", 11, "Rock");

        // DVDs
        DVD dvd1 = new DVD("El Padrino", "Francis Ford Coppola", "175 min", "Drama", "Pel·lícules clàssiques");
        DVD dvd2 = new DVD("Interstellar", "Christopher Nolan", "169 min", "Ciència-ficció", "Pel·lícules modernes");
        DVD dvd3 = new DVD("El laberinto del fauno", "Guillermo del Toro", "118 min", "Fantasía", "Pel·lícules internacionals");
        DVD dvd4 = new DVD("Documental: Cosmos", "Carl Sagan", "60 min", "Documental", "Educatiu");

        // Afegir totes les publicacions a la llista
        publicacions.add(llibre1);
        publicacions.add(llibre2);
        publicacions.add(llibre3);
        publicacions.add(llibre4);
        publicacions.add(llibre5);
        publicacions.add(cd1);
        publicacions.add(cd2);
        publicacions.add(cd3);
        publicacions.add(cd4);
        publicacions.add(dvd1);
        publicacions.add(dvd2);
        publicacions.add(dvd3);
        publicacions.add(dvd4);

        // Marcar alguns com a no disponibles
        llibre1.setDisponible(false);
        cd2.setDisponible(false);
        dvd3.setDisponible(false);
    }
    private static void demoDataUser() {
        Usuari u1 = new Usuari("1", "unai", "6555", "major", "1234");
        Usuari u2 = new Usuari("2", "jan", "6523", "menor", "1234");
        Admin a1 = new Admin("3", "jaume", "343434", "mitja", "1234");
        usuaris.add(u1); usuaris.add(u2); usuaris.add(a1);
    }
    private static void demoDataReserva() {
        Reserva r1 = new Reserva(publicacions.get(0), usuaris.get(0));
        Reserva r2 = new Reserva(publicacions.get(1), usuaris.get(1));
        Reserva r3 = new Reserva(publicacions.get(2), usuaris.get(0));
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
                                System.out.println(r.consultaUser());
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
        String id = printReserves();
        Reserva r = getReservaById(Integer.parseInt(id));
        assert r != null;
        r.modificarReserva();
    }

    public static int printPublicacionsDispo() {
        for (Publicacio l : publicacions) {
            if (l.isDisponible()){
                System.out.println(l);
            }
        }
        return Integer.parseInt(input("Quin llibre vols reservar? (codi): "));
    }
    public static void printPublicacionsById(){
        for (Publicacio l : publicacions) {
            System.out.println(l.toString());
        }
    }
    public static String printReserves() {
        for (Reserva r : reserves) {
            System.out.println( r.toString());
        }
        return input("Quina reserva vols modificar? (id) ");
    }
    public static void printUsuarisById(){
        for (Usuari u : usuaris) {
            System.out.println(u.getNom() + " | dni: " + u.getDni());
        }
    }

    public static void reservar() {
        int codi = printPublicacionsDispo();
        Publicacio l = getPubliacacioByCodi(codi);
        assert l != null;
        if (l.isDisponible()) {
            Reserva n = new Reserva(l, actualUser);
            reserves.add(n);
        }
        else System.out.println("Aricle inexistent o no disponible");
    }

    public static String input(String m) {
        System.out.print(m); return sc.nextLine();
    }


}