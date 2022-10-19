package mesa_2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MenuClasicoTest {
    @Test
    public void validarCalcularPrecio(){
        MenuClasico mc = new MenuClasico(200.0);

        Double expectedPrice = 200.0;

        assertEquals(expectedPrice, mc.calcularPrecio());
    }

}