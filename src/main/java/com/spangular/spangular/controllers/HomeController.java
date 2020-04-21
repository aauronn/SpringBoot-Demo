package com.spangular.spangular.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/home")
public class HomeController {
    /**
     * Get a list of bikes
     * @return
     */
    @GetMapping
    public String GetBikes(){

        return "Hello, this works!";
    }
}