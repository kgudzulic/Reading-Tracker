package com.example.WebProjekat.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeRestController {

    @GetMapping("/")
    public String getHome(){
        return "redirect:/knjige.html";

    }
}
