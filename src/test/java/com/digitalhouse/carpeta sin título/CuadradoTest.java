import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CuadradoTest {
    @Test

    public void areaCorrecta() throws FiguraException{
        Cuadrado c = new Cuadrado("Cuadrado", 2.0);
        if(c.getLado() == 0) {
            throw  new FiguraException("El valor no debe valer 0");
        }
        Double expectedArea = 4.0;
        Double cuadradoArea = c.calcularArea();
        assertEquals(expectedArea, cuadradoArea);
    }

}