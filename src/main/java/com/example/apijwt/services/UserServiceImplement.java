package com.example.apijwt.services;

import com.example.apijwt.models.User;
import com.example.apijwt.repositories.UserRepository;
import com.example.apijwt.validations.UserValidator;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Walter Porfirio
 *
 */
@Service
public class UserServiceImplement implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserValidator userValidator;

    @Override
    public User save(User user) throws Exception {

        userValidator.validate(user);

        this.encryptPassword(user);

        return userRepository.save(user);
    }

    private void encryptPassword(User user) {
        String encryptedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(12));
        user.setPassword(encryptedPassword);
    }

}