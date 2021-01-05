package com.example.apijwt.services;

import com.example.apijwt.models.User;

/**
 * @author Walter Porfirio
 *
 */
public interface UserService {

    public User save(User user) throws Exception;

}