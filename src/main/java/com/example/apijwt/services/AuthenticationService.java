package com.example.apijwt.services;

import com.example.apijwt.models.User;
import com.example.apijwt.security.Credentials;
import com.example.apijwt.security.Token;

/**
 * @author Walter Porfirio
 *
 */
public interface AuthenticationService {

    public Token generateToken(User user);

    public Token authenticate(Credentials credentials) throws Exception;

}
