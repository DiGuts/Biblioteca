package Publicacions;

public class Llibre extends Publicacio {
    private String autor;
    private String pagines;
    private String editorial;
    private String edicio;

    public Llibre(String titol, String autor, String pagines, String editorial, String edicio, String seccio) {
        super(titol, seccio);
        this.autor = autor;
        this.pagines = pagines;
        this.editorial = editorial;
        this.edicio = edicio;
    }

    // Getters i setters
    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getPagines() {
        return pagines;
    }

    public void setPagines(String pagines) {
        this.pagines = pagines;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getEdicio() {
        return edicio;
    }

    public void setEdicio(String edicio) {
        this.edicio = edicio;
    }

    @Override
    public String toString() {
        return  getCodi() + " | Titol: " +  getTitol()  +  " | Autor: " + autor + " | Pàgines: " + pagines +
                " | Editorial: " + editorial + " | Edició: " + edicio;
    }
}