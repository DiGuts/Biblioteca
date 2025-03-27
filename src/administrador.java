import java.time.LocalDate;
import java.util.Scanner;

public class AdminMenu {
    private static Scanner sc = new Scanner(System.in);

    public static void mostrarMenuAdmin() {
        boolean menu = true;
        while (menu) {
            System.out.println("\n--- Menú d'Administrador ---");
            System.out.println("1. Modificar reserves usuaris");
            System.out.println("2. Consultar reserves usuaris");
            System.out.println("3. Eliminar publicació");
            System.out.println("4. Afegir publicació");
            System.out.println("0. Tornar al menú principal");

            String opcio = Biblioteca.input("Escull una opció: ");
            switch (opcio) {
                case "1":
                    modificarReserves();
                    break;
                case "2":
                    consultarReserves();
                    break;
                case "3":
                    eliminarPublicacio();
                    break;
                case "4":
                    afegirPublicacio();
                    break;
                case "0":
                    menu = false;
                    break;
                default:
                    System.out.println("Opció no vàlida.");
            }
        }
    }

    private static void modificarReserves() {
        System.out.println("\n--- Modificar Reserves ---");
        if (Biblioteca.reserves.isEmpty()) {
            System.out.println("No hi ha reserves registrades.");
            return;
        }

