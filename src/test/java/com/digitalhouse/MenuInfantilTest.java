package mesa_2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MenuInfantilTest {
    @Test

    public void validarCaluclarPrecio() {
        MenuInfantil mi = new MenuInfantil(150.0);
        mi.agregarJuguete("Barbie");
        mi.agregarJuguete("Max Steel");
        Double expectedPrice = 156.0;

        assertEquals(expectedPrice, mi.calcularPrecio());
    }

}