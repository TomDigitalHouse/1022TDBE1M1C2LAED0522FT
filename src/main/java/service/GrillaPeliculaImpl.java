package service;

import exceptions.PeliculaNotFoundException;
import model.Pelicula;

import java.util.ArrayList;

public class GrillaPeliculaImpl implements GrillaPelicula {

    ArrayList<Pelicula> peliculas = new ArrayList<>();

    public void addPelicula(Pelicula p) {
        this.peliculas.add(p);
    }


    @Override
    public Pelicula getPelicula(String nombre) throws PeliculaNotFoundException {
        for (Pelicula p: this.peliculas) {
            if (p.nombre().equals(nombre)) return p;
        }
        throw new PeliculaNotFoundException("No se encontro la pelicula en el catalogo.");
    }
}
