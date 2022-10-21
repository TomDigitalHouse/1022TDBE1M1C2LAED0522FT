import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class GrillaPeliculaProxyTest {

    @Test
    @DisplayName("que pasa si la peticion es de un pais no habilitado")
    void validarReproduccion() throws PaisDenegadoException, PaisNotFoundException, PeliculaNotFoundException {
        //GIVEN
        var grilla1 = new GrillaPelicula();
        var peli = new Pelicula("Ari el regreso", "url:123456/78");
        peli.addPais(Pais.ARGENTINA);
        peli.addPais(Pais.COLOMBIA);
        var peli2 = new Pelicula("Salo memardo", "url:321654/98");
        peli2.addPais(Pais.BRASIL);
        peli2.addPais(Pais.ARGENTINA);
        var array1 = Arrays.asList(200,255,13,3);
        var ip1 = new IpAddress(array1);
        var proxy = new GrillaPeliculaProxy(grilla1);
        grilla1.addPelicula(peli);
        grilla1.addPelicula(peli2);
        //GWEN

//        proxy.validarReproduccion(ip1,"Ari el regreso");



        //THEN

        assertThrows(PaisNotFoundException.class, () -> proxy.validarReproduccion(ip1,"Ari el regreso"));

    }

    @Test
    @DisplayName("test 2 ya fue no salito?")
    void test2(){
        //GIVEN
        var grilla2 = new GrillaPelicula();
        var peli = new Pelicula("Ari el regreso", "url:123456/78");
        peli.addPais(Pais.ARGENTINA);
        grilla2.addPelicula(peli);
        var array1 = Arrays.asList(101,255,13,3);
        var ip1 = new IpAddress(array1);
        var proxy = new GrillaPeliculaProxy(grilla2);
        //THEN

        assertThrows(PaisDenegadoException.class, () -> proxy.validarReproduccion(ip1,"Ari el regreso"));
    }
}