package com.digitalhouse.mesas;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;

public class ArbolFactoryTest {
    @Test
    @DisplayName("WHEN we ask the factory for to create the same object twice THEN it should be the same object")
    public void test1() {
        //WHEN
        var pc1 = ArbolFactory.getTreeType("ORNAMENTALES", 200, 400, "verde");
        var pc2 = ArbolFactory.getTreeType("ORNAMENTALES", 200, 400, "verde");
        //THEN
        assertSame(pc1, pc2);
    }
}
