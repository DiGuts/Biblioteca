import java.util.ArrayList;

public class Usuari {

    //Atributs
    private String dni;
    private String nom;
    private String telefon;
    private String adreca;
    private String passwd;

    //Constructor
    public Usuari(String dni, String nom, String telefon, String adreca, String passwd) {
        this.dni = dni;
        this.nom = nom;
        this.telefon = telefon;
        this.adreca = adreca;
        this.passwd = passwd;
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


}