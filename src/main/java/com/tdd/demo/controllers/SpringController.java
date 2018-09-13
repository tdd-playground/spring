package com.tdd.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/foo")
public class SpringController {

    @GetMapping("/bar")
    public void getSomething(){

    }
}
