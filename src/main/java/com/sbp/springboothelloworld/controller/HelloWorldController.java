package com.sbp.springboothelloworld.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    private String Hello = "hello";
    private String world = "world";

    @RequestMapping("/")
    public String hello()
    {
        return Hello + " " + world;
    }

    @RequestMapping("/")
    public String hello1()
    {
        return Hello + " " + world;
    }

}
