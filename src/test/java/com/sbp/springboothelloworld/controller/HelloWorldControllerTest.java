package com.sbp.springboothelloworld.controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HelloWorldControllerTest {

    @Test
    void hello() {
        HelloWorldController helloWorldController = new HelloWorldController();
        System.out.println(helloWorldController.hello());
    }
}