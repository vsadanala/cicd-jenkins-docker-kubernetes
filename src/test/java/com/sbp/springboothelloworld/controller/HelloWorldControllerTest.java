package com.sbp.springboothelloworld.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HelloWorldControllerTest {
//
//    @Test
//    void hello() {
//        HelloWorldController helloWorldController = new HelloWorldController();
//        System.out.println(helloWorldController.hello());
//    }

    @Test
    void hello()
    {
        assertEquals(2,2);
    }


    @BeforeAll
    static void beforeAll()
    {
        System.out.println("**--- Executed once before all test methods in this class ---**");
    }

    @AfterEach
    void afterEach() {
        System.out.println("**--- Executed after each test method in this class ---**");
    }
}