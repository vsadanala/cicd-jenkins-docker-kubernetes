package com.sbp.springboothelloworld;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class SampleTest {

    @Test
    public void simpleTest()
    {
        int a = 10;
        int b = 20;
        assertTrue( a + b == 30);
    }
}
