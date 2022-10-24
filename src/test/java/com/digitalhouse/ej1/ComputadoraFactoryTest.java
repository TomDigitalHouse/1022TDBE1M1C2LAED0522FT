package com.digitalhouse.ej1;

import com.digitalhouse.ej1.factory.ComputadoraFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;

public class ComputadoraFactoryTest {
    @Test
    @DisplayName("WHEN a new persona ojbect is created THEN it should have the right parameters")
    public void test1() {
        //GIVEN
        var factory = new ComputadoraFactory();
        //WHEN
        var pc1 = factory.getComputer(100, 50);
        var pc2 = factory.getComputer(100, 50);
        //THEN
        assertSame(pc1, pc2);
    }
}
