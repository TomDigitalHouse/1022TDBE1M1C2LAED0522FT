import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CirculoTest {
    @Test

    public void areaCorrecta() throws FiguraException{
        Circulo c = new Circulo("Circulo", 2.0);
        if(c.getRadio() == 0.0){
            throw new FiguraException("El valor no debe valer 0");
        }
        Double expectedArea = 39.4384;
        Double circuloArea = c.calcularArea();
        assertEquals(expectedArea, circuloArea);
    }
}