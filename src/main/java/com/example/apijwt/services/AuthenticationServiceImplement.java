package com.example.apijwt.services;

import com.example.apijwt.models.User;
import com.example.apijwt.repositories.UserRepository;
import com.example.apijwt.security.Credentials;
import com.example.apijwt.security.JwtToken;
import com.example.apijwt.security.JwtUser;
import com.example.apijwt.security.Token;
import com.example.apijwt.validations.CredentialsValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author Walter Porfirio
 *
 */
@Service
public class AuthenticationServiceImplement implements AuthenticationService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    JwtToken jwtToken;

    @Autowired
    CredentialsValidator credentialsValidator;

    @Override
    public Token generateToken(User user) {

        String token = jwtToken.doGenerateToken(new JwtUser(user));

        // Get login date from the token which was just generated
        Date userLastLogin = jwtToken.getUserFromToken(token).getLast_login();
        // Then update user last login date
        user.setLast_login(userLastLogin);
        userRepository.save(user);

        return new Token(token);
    }

    @Override
    public Token authenticate(Credentials credentials) throws Exception {

        credentialsValidator.validate(credentials);

        User user = userRepository.findByEmail(credentials.getEmail());

        return this.generateToken(user);
    }

}