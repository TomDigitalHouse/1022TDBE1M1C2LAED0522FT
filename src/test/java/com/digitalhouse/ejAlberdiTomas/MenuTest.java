package com.digitalhouse.ejAlberdiTomas;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MenuTest {

    @Test
    @DisplayName("WHEN a Menu is created THEN it should have the right precioBase")
    public void test1() {
        // GIVEN
        var menu = new MenuStub(10.00);
        var precioBaseEsperado = 10.00;
        // WHEN
        var precioBase = menu.getPrecioBase();
        // THEN
        assertEquals(precioBaseEsperado,precioBase);
    }
    public static class MenuStub extends Menu {
        public MenuStub(Double precioBase) {
            super(precioBase);
        }
    }

}