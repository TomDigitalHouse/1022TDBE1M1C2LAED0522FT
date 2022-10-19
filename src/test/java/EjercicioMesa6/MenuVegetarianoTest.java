package EjercicioMesa6;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MenuVegetarianoTest {

    @Test
    @DisplayName("WHEN a MenuVegetariano is created THEN it should have the right precioFinal")
    public void test1() {
        // GIVEN
        var menu = new MenuVegetariano(10.00,2);
        var precioFinalEsperado = 14.10;
        // WHEN
        var precioFinal = menu.getPrecioFinal();
        // THEN
        assertEquals(precioFinalEsperado,precioFinal);
    }

}