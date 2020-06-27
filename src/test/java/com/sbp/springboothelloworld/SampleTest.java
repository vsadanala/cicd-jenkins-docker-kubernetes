package com.sbp.springboothelloworld;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class SampleTest {

    @Test
    public void simpleTestTrue()
    {
        int a = 10;
        int b = 20;
        assertTrue( a + b == 30);
    }

    @Test
    public void simpleTestFalse()
    {
        int a = 10;
        int b = 20;
        assertTrue( a + b == 40);
    }
}
