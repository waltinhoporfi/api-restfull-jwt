package com.example.apijwt.controllers;

import com.example.apijwt.models.User;
import com.example.apijwt.security.Credentials;
import com.example.apijwt.security.Token;
import com.example.apijwt.services.AuthenticationService;
import com.example.apijwt.services.UserService;
import com.example.apijwt.validations.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Walter Porfirio
 *
 */
@RestController
@RequestMapping(value = "/")
public class AuthenticationController {

    @Autowired
    UserService userService;

    @Autowired
    AuthenticationService authenticationService;

    //@Autowired
    //Validator validator;

    @PostMapping("/signup")
    private ResponseEntity<Object> signup(@RequestBody User user) throws Exception {

        userService.save(user);

        Token token = authenticationService.generateToken(user);

        return ResponseEntity.ok().body(token);
    }

    @PostMapping("/signin")
    private ResponseEntity<Object> signin(@RequestBody Credentials credentials) throws Exception {

        Token token = authenticationService.authenticate(credentials);

        return ResponseEntity.ok().body(token);
    }

}
