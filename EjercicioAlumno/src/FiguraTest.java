import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FiguraTest {

    @Test
    @DisplayName("Testeando area del cuadrado")
    void testeandoAreaCuadrado(){
        //GIVEN
        var cuadradin = new Cuadrado(4.0);
        //WHEN
        cuadradin.calcularArea();
        //THEN
        assertEquals(cuadradin.getArea(),16.0);
    }

    @Test
    @DisplayName("Testeando area del circulo")
    void testeandoAreaCirculo(){
        //GIVEN
        var circulin = new Circulo(4.0);
        //WHEN
        circulin.calcularArea();
        //THEN
        assertEquals(circulin.getArea(),(Math.PI*16.0));
    }

    @Test
    void testeandoFalloAritmeticoCuadrado(){
        //GIVEN
        var cuadradin = new Cuadrado(-1.0);
        //THEN
        //assertEquals(cuadradin.getArea(),16.0);
        assertThrows(ArithmeticException.class, ()-> cuadradin.calcularArea());
        System.out.println("El lado del cuadrado debe ser mayor a 0");
    }

    @Test
    void testeandoFalloAritmeticoCirculo(){
        //GIVEN
        var circulin = new Circulo(-1.0);
        //THEN
        //assertEquals(cuadradin.getArea(),16.0);
        assertThrows(ArithmeticException.class, ()-> circulin.calcularArea());
        System.out.println("El radio del circulo debe ser mayor a 0");
    }
}