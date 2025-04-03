package Users;

public class Admin extends Usuari {

    public Admin(String dni, String nom, String telefon, String adreca, String passwd) {
        super(dni, nom, telefon, adreca, passwd);
        this.type = 0;
    }

    @Override
    public void menu() {
        System.out.println("\n--- Menú d'Administrador ---");
        System.out.println("1. Modificar reserves usuaris");
        System.out.println("2. Consultar reserves usuaris");
        System.out.println("3. Eliminar publicació");
        System.out.println("4. Afegir publicació");
        System.out.println("0. Tencar sessio");
    }
}
