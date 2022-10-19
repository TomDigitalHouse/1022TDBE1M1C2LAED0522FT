import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectanguloTest {

    @Test

    public void areaCorrecta() throws FiguraException{

        Rectangulo r = new Rectangulo("Rectangulo", 2.0, 3.0);
        if(r.getAncho() == 0 || r.getLargo() == 0) {
            throw new FiguraException("Los valores no deben valer 0");
        }
        Double expectedArea = 6.0;
        Double rectanguloArea = r.calcularArea();
        assertEquals(expectedArea, rectanguloArea);
    }
}