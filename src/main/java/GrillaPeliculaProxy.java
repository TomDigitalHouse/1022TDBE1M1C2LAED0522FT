public class GrillaPeliculaProxy {

    private final GrillaPelicula grilla;

    public GrillaPeliculaProxy(GrillaPelicula grilla) {
        this.grilla = grilla;
    }

    public Pelicula validarReproduccion (IpAddress ip, String nombre) throws PeliculaNotFoundException, PaisNotFoundException, PaisDenegadoException {
        final var p = grilla.getPelicula(nombre);
        var codigoPais = ip.octetos.get(0);

        Pais paisActual = getString(codigoPais);

        for (Pais pais: p.getPaises()) {
            if (paisActual.equals(pais)) return p;
        }

        throw new PaisDenegadoException();
    }

    private static Pais getString(Integer codigoPais) throws PaisNotFoundException {
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
}
