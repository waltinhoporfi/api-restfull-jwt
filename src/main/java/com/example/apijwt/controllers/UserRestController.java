package com.example.apijwt.controllers;

import com.example.apijwt.security.JwtToken;
import com.example.apijwt.security.JwtUser;
import com.example.apijwt.services.AuthorizationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Walter Porfirio
 *
 */
@RestController
@RequestMapping(value = "/")
public class UserRestController {

    @Value("${jwt.header.authorization}")
    private String authorization;

    @Autowired
    AuthorizationService authorizationService;

    @Autowired
    JwtToken jwtToken;

    @GetMapping("/me")
    private ResponseEntity<Object> me(HttpServletRequest request)
            throws Exception {

        String token = request.getHeader(authorization);

        authorizationService.authorize(token);

        JwtUser jwtUser = jwtToken.getUserFromToken(token);

        return ResponseEntity.ok().body(jwtUser);
    }

}
