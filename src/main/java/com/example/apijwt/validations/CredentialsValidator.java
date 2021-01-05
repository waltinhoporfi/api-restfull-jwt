package com.example.apijwt.validations;

import static com.example.apijwt.validations.ValidatorUtil.isVaildString;
import static com.example.apijwt.validations.ValidatorUtil.isValidPassword;
import com.example.apijwt.exceptions.InvalidCredentialsException;
import com.example.apijwt.exceptions.MissingFieldsException;
import com.example.apijwt.models.User;
import com.example.apijwt.repositories.UserRepository;
import com.example.apijwt.security.Credentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Walter Porfirio
 *
 */
@Component
public class CredentialsValidator implements Validator<Credentials> {

    @Autowired
    UserRepository userRepository;

    @Override
    public void validate(Credentials model) throws Exception {
        Validator.super.validate(model);
        this.validateRegisteredFields(model);
    }

    @Override
    public void validateRequiredFields(Credentials model) throws Exception {

        if (!isVaildString(model.getEmail())) throw new MissingFieldsException();

        if (!isVaildString(model.getPassword())) throw new MissingFieldsException();
    }

    @Override
    public void validateFieldsValues(Credentials model) throws Exception {}

    @Override
    public void validateUniqueFields(Credentials model) throws Exception {}

    public void validateRegisteredFields(Credentials model) throws Exception {

        User user = userRepository.findByEmail(model.getEmail());

        if (user == null) throw new InvalidCredentialsException();

        if (!isValidPassword(model.getPassword(), user.getPassword())) throw new InvalidCredentialsException();
    }

}
