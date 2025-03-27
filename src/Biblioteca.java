import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {
    private static Scanner sc = new Scanner(System.in);
    private static ArrayList<Usuari> usuaris = new ArrayList<>();
    private static ArrayList<Llibre> llibres = new ArrayList<>();
    private static Usuari actualUser;

    public static void main(String[] args) {
        menuLogin();
        menuReservar();
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
            //si es admin o bibliotecari hauria de printejar mes opcions.
            System.out.println("0. Sortir");

            String menuOpcio = input("Escull una opció: ");
            switch (menuOpcio) {
                case "1":
                    //Reservar Llibre
                    break;
                case "2":
                    //Consultar reserves fetes.
                    break;
                case "0":
                    System.exit(0);
            }
        }
    }

    private static String input(String m) {
        System.out.print(m); return sc.nextLine();
    }
}