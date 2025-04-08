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

        for (int i = 0; i < Biblioteca.reserves.size(); i++) {
            Reserva r = Biblioteca.reserves.get(i);
            System.out.printf("%d. %s - %s (De %s a %s)\n",
                    i + 1,
                    r.getUsuari().getNom(),
                    r.getLlibre().getTitol(),
                    r.getDataInici(),
                    r.getDataFi());
        }


        try {
            int index = Integer.parseInt(Biblioteca.input("Selecciona el número de reserva a modificar: ")) - 1;
            if (index < 0 || index >= Biblioteca.reserves.size()) {
                System.out.println("Número de reserva invàlid.");
                return;
            }


            Reserva reserva = Biblioteca.reserves.get(index);


            System.out.println("\nOpcions de modificació:");
            System.out.println("1. Canviar usuari");
            System.out.println("2. Canviar llibre");
            System.out.println("3. Canviar dates");

            String opcio = Biblioteca.input("Escull què vols modificar: ");
            switch (opcio) {
                case "1":
                    canviarUsuariReserva(reserva);
                    break;
                case "2":
                    canviarLlibreReserva(reserva);
                    break;
                case "3":
                    canviarDatesReserva(reserva);
                    break;
                default:
                    System.out.println("Opció no vàlida.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Has d'introduir un número.");
        }

    }

