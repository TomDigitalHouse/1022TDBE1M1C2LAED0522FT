package service;

import exceptions.PeliculaException;
import model.Pelicula;

public interface GrillaPelicula {

    Pelicula getPelicula(String nombre) throws PeliculaException;
}
