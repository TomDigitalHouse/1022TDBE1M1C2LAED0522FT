package EjercicioMesa6;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MenuInfantilTest {

    @Test
    @DisplayName("WHEN a MenuInfantil is created THEN it should have the right precioFinal")
    public void test1() {
        // GIVEN
        var menu = new MenuInfantil(10.00,3);
        var precioFinalEsperado = 19.00;
        // WHEN
        var precioFinal = menu.getPrecioFinal();
        // THEN
        assertEquals(precioFinalEsperado, precioFinal);
    }

}