package Users;

public class Usuari {

    //Atributs
    protected String dni;
    protected String nom;
    protected String telefon;
    protected String adreca;
    protected String passwd;
    protected int type;

    //Constructor
    public Usuari(String dni, String nom, String telefon, String adreca, String passwd) {
        this.dni = dni;
        this.nom = nom;
        this.telefon = telefon;
        this.adreca = adreca;
        this.passwd = passwd;
        this.type = 2;
    }

    //Getters & setters
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getAdreca() {
        return adreca;
    }

    public void setAdreca(String adreca) {
        this.adreca = adreca;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
    //Mètodes

    public String getType() {
        if (this.type == 0) {
            return "Admin";
        }
        else if (this.type == 1) {
            return "Biblio";
        }
        else {
            return "User";
        }
    }

    public void menu() {
        System.out.println("\n--- Menú Biblioteca ---");
        System.out.println("1. Reservar llibre");
        System.out.println("2. Consultar reserves");
        //si es admin o bibliotecari hauria de printejar mes opcions.
        System.out.println("0. Tencar sessio");
    }

}