package com.example.apijwt.services;

import com.example.apijwt.validations.TokenValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Walter Porfirio
 *
 */
@Service
public class AuthorizationServiceImplement implements AuthorizationService {

    @Autowired
    TokenValidator tokenValidator;

    @Override
    public void authorize(String token) throws Exception {
        tokenValidator.validate(token);
    }

}
