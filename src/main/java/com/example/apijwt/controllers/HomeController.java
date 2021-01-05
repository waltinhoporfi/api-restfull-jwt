package com.example.apijwt.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Walter Porfirio
 *
 */
@RestController
@RequestMapping(value = "/")
public class HomeController {

    @GetMapping
    private ResponseEntity<Object> home() {
        return ResponseEntity.ok().body("API RESTful for user authentication.");
    }

}