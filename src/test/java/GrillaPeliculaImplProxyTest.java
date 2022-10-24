import exceptions.PaisDenegadoException;
import exceptions.PaisNotFoundException;
import model.IpAddress;
import model.Pais;
import model.Pelicula;
import org.junit.jupiter.api.Test;
import service.GrillaPeliculaImpl;
import service.GrillaPeliculaProxy;

import java.util.Arrays;
import java.util.EnumSet;

import static org.junit.jupiter.api.Assertions.assertThrows;

class GrillaPeliculaImplProxyTest {

    @Test
    void validarReproduccion() {
        //GIVEN
        var grilla1 = new GrillaPeliculaImpl();
        var peli = new Pelicula("Ari el regreso", EnumSet.of(Pais.ARGENTINA, Pais.COLOMBIA), "url:123456/78");
        var peli2 = new Pelicula("Salo memardo", EnumSet.of(Pais.ARGENTINA, Pais.BRASIL), "url:321654/98");
        var array1 = Arrays.asList(200, 255, 13, 3);
        var ip1 = new IpAddress(array1);
        grilla1.addPelicula(peli);
        grilla1.addPelicula(peli2);
        var proxy = new GrillaPeliculaProxy(grilla1, ip1);
        //THEN
        assertThrows(PaisNotFoundException.class, () -> proxy.getPelicula("Ari el regreso"));

    }

    @Test
    void test2() {
        //GIVEN
        var grilla2 = new GrillaPeliculaImpl();
        var peli = new Pelicula("Ari el regreso", EnumSet.of(Pais.ARGENTINA), "url:123456/78");
        grilla2.addPelicula(peli);
        var array1 = Arrays.asList(101, 255, 13, 3);
        var ip1 = new IpAddress(array1);
        var proxy = new GrillaPeliculaProxy(grilla2, ip1);
        //THEN
        assertThrows(PaisDenegadoException.class, () -> proxy.getPelicula("Ari el regreso"));
    }
}