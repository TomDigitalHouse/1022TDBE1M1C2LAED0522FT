package com.digitalhouse.ej1;

import com.digitalhouse.ej1.model.Computadora;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComputadoraTest {
    @Test
    @DisplayName("WHEN a new persona ojbect is created THEN it should have the right parameters")
    public void test1() {
        //GIVEN
        var ram = 16;
        var disco = 1000;
        //WHEN
        var pc = new Computadora(ram, disco);
        //THEN
        assertEquals(pc.ram(), ram);
        assertEquals(pc.disco(), disco);
    }
}
