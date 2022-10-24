package service;

import exceptions.PaisDenegadoException;
import exceptions.PaisNotFoundException;
import exceptions.PeliculaException;
import lombok.AllArgsConstructor;
import model.IpAddress;
import model.Pais;
import model.Pelicula;

@AllArgsConstructor
public class GrillaPeliculaProxy implements GrillaPelicula {
    private final GrillaPeliculaImpl grilla;
    private final IpAddress ip;

    private static Pais getPais(Integer codigoPais) throws PaisNotFoundException {
        if (codigoPais >= 0 && codigoPais < 50) {
            return Pais.ARGENTINA;
        } else if (codigoPais >= 50 && codigoPais < 100) {
            return Pais.BRASIL;
        } else if (codigoPais < 150) {
            return Pais.COLOMBIA;
        } else {
            throw new PaisNotFoundException("La ip no corresponde a ningun pais permitido");
        }
    }

    @Override
    public Pelicula getPelicula(String nombre) throws PeliculaException {
        final var p = grilla.getPelicula(nombre);
        var codigoPais = ip.octetos().get(0);

        var paisActual = getPais(codigoPais);

        for (Pais pais : p.paises()) {
            if (paisActual.equals(pais)) return p;
        }

        throw new PaisDenegadoException();
    }
}
