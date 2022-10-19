package mesa_2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MenuVeggieTest {

    @Test
    public void validarCalcularPrecio(){
        MenuVeggie mv = new MenuVeggie(300.0);
        mv.agregarSalsa("Cesar");
        mv.agregarSalsa("Mayonesa");
        mv.agregarSalsa("Mostaza");

        Double expectedPrice = 336.0;
        assertEquals(expectedPrice, mv.calcularPrecio());
    }

}