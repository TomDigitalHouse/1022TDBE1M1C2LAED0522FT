import java.util.ArrayList;

public class GrillaPelicula implements IGrillaPelicula{

    ArrayList<Pelicula> peliculas = new ArrayList<>();

    public void addPelicula(Pelicula p) {
        this.peliculas.add(p);
    }


    @Override
    public Pelicula getPelicula(String nombre) throws PeliculaNotFoundException{
        for (Pelicula p: this.peliculas) {
            if (p.getNombre() == nombre) return p;
        }
        throw new PeliculaNotFoundException("No se encontro la pelicula en el catalogo.");
    }
}
