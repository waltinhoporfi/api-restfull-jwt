package com.example.apijwt.services;

/**
 * @author Walter Porfirio
 *
 */
public interface AuthorizationService {

    public void authorize(String token) throws Exception;

}