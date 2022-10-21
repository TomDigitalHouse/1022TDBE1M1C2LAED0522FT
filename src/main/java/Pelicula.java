import java.util.ArrayList;

public class Pelicula {

    private String nombre;

    private ArrayList<Pais> paises = new ArrayList<>();
    private String link;

    public Pelicula(String nombre, String link) {
        this.nombre = nombre;
        this.link = link;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Pais> getPaises() {
        return paises;
    }

    public void setPaises(ArrayList<Pais> paises) {
        this.paises = paises;
    }

    public void addPais(Pais pais) {
        this.paises.add(pais);
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
