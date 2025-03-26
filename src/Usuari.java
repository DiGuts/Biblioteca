import java.util.ArrayList;

public class Usuari {

    //Atributs
    private String dni;
    private String nom;
    private String telefon;
    private String adreca;
    private ArrayList<Llibre> articlesEnPropietat;

    //Constructor
    public Usuari(String dni, String nom, String telefon, String adreca){
        this.dni = dni;
        this.nom = nom;
        this.telefon = telefon;
        this.adreca = adreca;
        this.articlesEnPropietat = new ArrayList<>();
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

    public ArrayList<Llibre> getArticlesEnPropietat() {
        return articlesEnPropietat;
    }

    public void setArticlesEnPropietat(ArrayList<Llibre> articlesEnPropietat) {
        this.articlesEnPropietat = articlesEnPropietat;
    }

    //Mètodes


}